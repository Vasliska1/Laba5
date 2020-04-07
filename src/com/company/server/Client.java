
package com.company.server;

import com.company.basis.*;
import com.company.commands.*;
import com.company.exception.IncorrectValue;
import com.company.exception.NoArgument;
import com.company.input.FileInput;
import com.company.input.IOInterface;
import com.company.input.TerminalInput;

import java.io.*;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;


public class Client {

    TerminalInput terminalInput = new TerminalInput();

     void startWork() {

        try {
            Selector selector = Selector.open();
            SocketChannel connectionClient = SocketChannel.open();
            connectionClient.configureBlocking(false);
            connectionClient.connect(new InetSocketAddress("127.0.0.1", 8000));
            connectionClient.register(selector, SelectionKey.OP_CONNECT);
            while (true) {
                selector.select();
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = (SelectionKey) iterator.next();
                    iterator.remove();
                    SocketChannel client = (SocketChannel) key.channel();
                    if (key.isConnectable()) {
                        if (client.isConnectionPending()) {
                            try {
                                client.finishConnect();

                            } catch (ConnectException e) {
                                System.out.println("serverok nedostypen");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        client.register(selector, SelectionKey.OP_READ);
                        continue;
                    }
                    if (key.isWritable()) {
                        terminalInput.getNextInput();
                        sendSocketObject(client, selector, terminalInput);

                    }
                    if (key.isReadable()) {
                        System.out.println(getReader(client));
                        client.register(selector, SelectionKey.OP_WRITE);
                    }
                }
            }
        } catch (ClosedChannelException e) {
            System.out.println("problems");
        } catch (IOException e) {
            System.err.println("Serverok otclyshilsa");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * читает строки из файли или с терминала
     * @param input
     * @return
     */
    private String[] readInput(IOInterface input) {

        return input.getCurrentInput().trim().split(" ", 2);

    }

    /**
     * отправляет объекты серверу, проверяет объект на Execute_script, if True -> go to readScript
     * @param client
     * @param selector
     * @param inputCommand
     * @throws IOException
     * @throws NoArgument
     */
    private void sendSocketObject(SocketChannel client, Selector selector, IOInterface inputCommand) throws IOException, NoArgument {

        AbstractCommands getObject = getObjectCommand(inputCommand);

        if (getObject instanceof ExecuteScript) {
            readScript(((ExecuteScript) getObject).getFileName(), client, selector);
            client.register(selector, SelectionKey.OP_WRITE);
            selector.select();
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);

            if (getObject != null) {
                objectOutputStream.writeObject(getObject);
                objectOutputStream.flush();
                client.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                client.register(selector, SelectionKey.OP_READ);
                selector.select();
            } else client.register(selector, SelectionKey.OP_WRITE);
        }

    }

    /**
     * Read server response
     * @param client
     * @return
     * @throws IOException
     */
    private String getReader(SocketChannel client) throws IOException {
        ByteBuffer data = ByteBuffer.allocate(102400);
        client.read(data);
        return new String(data.array()).trim().concat("\n");


    }

    /**
     * Read script
     * send and read object from Server
     * @param fileName
     * @param client
     * @param selector
     * @throws FileNotFoundException
     */
    private void readScript(String fileName, SocketChannel client, Selector selector) throws FileNotFoundException {
        FileInput input = new FileInput(fileName);
        try {
            while (input.getNextInput() != null) {
                if (input.getCurrentInput().equals("execute_script " + fileName))
                    throw new IncorrectValue("Не зацикливай меня(((");
                this.sendSocketObject(client, selector, input);
                System.out.println(getReader(client));
                client.register(selector, SelectionKey.OP_WRITE);
                selector.select();

            }
        } catch (IncorrectValue | IOException | NoArgument e) {
            e.getMessage();
        }

    }

    /**
     * Преобразует строки в объекты
     * @param input
     * @return
     * @throws IOException
     * @throws NoArgument
     */
    private AbstractCommands getObjectCommand(IOInterface input) throws IOException, NoArgument {
        String[] rightCommand = readInput(input);
        AbstractCommands objectCommands = null;
        TerminalInput terminalInput = new TerminalInput();

        switch (rightCommand[0]) {
            case "help":
                objectCommands = new Help();
                break;
            case "info":
                objectCommands = new Info();
                break;
            case "show":
                objectCommands = new Show();
                break;
            case "add":
                objectCommands = new Add(readElement(input));
                break;
            case "update":
                try {
                    if (rightCommand.length < 2)
                        throw new NoArgument("Вы должны ввести id");
                    if (rightCommand.length == 2)
                        objectCommands = new Update(Integer.parseInt(rightCommand[1]), readElement(input));
                } catch (NoArgument e) {
                    e.getMessage();
                } catch (NumberFormatException e) {
                    System.out.println("Мэн, введи число");
                }

                break;
            case "remove_by_id":
                try {
                    if (rightCommand.length < 2)
                        throw new NoArgument("Вы должны ввести айди");
                    if (rightCommand.length == 2)
                        objectCommands = new RemoveById(Integer.parseInt(rightCommand[1]));
                } catch (NoArgument e) {
                    e.getMessage();
                } catch (NumberFormatException e) {
                    System.out.println("Мэн, введи число");
                }
                break;
            case "clear":
                objectCommands = new Clear();
                break;
            case "sc":
                try {
                    if (rightCommand.length < 2)
                        throw new NoArgument("Вы должны ввести имя файла");
                    if (rightCommand.length == 2)
                        objectCommands = new ExecuteScript(rightCommand[1]);
                } catch (NoArgument e) {
                    e.getMessage();
                }
                break;
            case "remove_lower":
                objectCommands = new RemoveLower(readElement(input));
                break;
            case "reorder":
                objectCommands = new Reorder();
                break;
            case "sort":
                objectCommands = new Sort();
                break;
            case "sum_of_impact_speed":
                objectCommands = new SumOfImpactSpeed();
                break;
            case "filter_starts_with_name":
                try {
                    if (rightCommand.length < 2)
                        throw new NoArgument("Вы должны ввести начало имени");
                    if (rightCommand.length == 2)
                        objectCommands = new FilterStartsWithName(rightCommand[1]);
                } catch (NoArgument e) {
                    e.getMessage();
                }

                break;
            case "print_field_descending_weapon_type":
                objectCommands = new PrintFieldDescendingWeaponType();
                break;
            case "exit":
                System.out.println("chao");
                System.exit(0);
                break;

            default:
                objectCommands = new NonCommands();
        }
        return objectCommands;

    }

    /**
     * Создает объект
     * @param command
     * @return
     */
    private HumanBeing readElement(IOInterface command) {
        HumanBeing h = null;
        Boolean realHero;
        Boolean hasToothpick;
        WeaponType weapon = null;
        Mood mood = null;
        String name;
        try {
            do {
                command.output("Введите имя:");
                name = command.getNextInput().trim();
            } while (name.equals(""));

            String x1;
            long x = 0;
            do {
                try {


                    command.output("Введите координаты, x:");
                    x1 = command.getNextInput().trim();

                    if (x1.matches("[-+]?\\d+")) {
                        x = Long.parseLong(x1);

                        if (x < -671) {
                            x = 0;
                            System.out.println("Поле должно быть больше -671, нуб");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("нуб");
                }
            } while (x == 0);
            float y = 0;
            String y1;
            do {
                try {
                    command.output("y:");
                    y1 = command.getNextInput();
                    if (y1.matches("((-|\\\\+)?[0-9]+(\\\\.[0-9]+)?)+")) {
                        y = Float.parseFloat(y1);
                        if (y > 649) {
                            y = 0;
                            System.out.println("Максимальное значение y - 649, нуб");

                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("нуб");
                }
            } while (y == 0);

            String answer;
            do {
                command.output("Человек реальный герой? Введите yes/no");
                answer = command.getNextInput();
                if (answer.equals("yes")) {
                    realHero = true;
                } else if (answer.equals("no")) {
                    realHero = false;
                } else {
                    realHero = null;
                }
            } while (!answer.equals("yes") && !answer.equals("no"));

            String answer1;
            do {
                command.output("У человека есть зубочистка? Введите yes/no");
                answer1 = command.getNextInput().trim();
                if (answer1.equals("yes")) {
                    hasToothpick = true;
                } else if (answer1.equals("no")) {
                    hasToothpick = false;
                } else {
                    hasToothpick = null;
                }
            } while (!answer1.equals("yes") && !answer1.equals("no"));

            String speed1;
            long speed = -1;
            do {
                command.output("Введите скорость удара:");
                speed1 = command.getNextInput();
                if (speed1.matches("[-+]?\\d+")) {
                    speed = Long.parseLong(speed1);
                }
            } while (speed == -1);

            String answer2;
            do {
                command.output("Выберите и введите оружие: HAMMER, RIFLE, MACHINE GUN, BAT");
                answer2 = command.getNextInput().trim().toLowerCase();
                switch (answer2) {
                    case "hammer":
                        weapon = WeaponType.HAMMER;
                        break;
                    case "rifle":
                        weapon = WeaponType.RIFLE;
                        break;
                    case "machine gun":
                        weapon = WeaponType.MACHINE_GUN;
                        break;
                    case "bat":
                        weapon = WeaponType.BAT;
                        break;
                    case "":
                        weapon = null;
                        break;
                    default:
                        command.output("Такого варианта нет");
                        break;
                }
            } while (!answer2.toLowerCase().equals("bat") && !answer2.toLowerCase().equals("machine gun") &&
                    !answer2.toLowerCase().equals("hammer") &&
                    !answer2.toLowerCase().equals("rifle") && !answer2.equals(""));

            String answer3;
            do {
                command.output("Выберите и введите настроение: SADNESS, APATHY, CALM, FRENZY");
                answer3 = command.getNextInput().trim().toLowerCase();
                switch (answer3) {
                    case "sadness":
                        mood = Mood.SADNESS;
                        break;
                    case "apathy":
                        mood = Mood.APATHY;
                        break;
                    case "calm":
                        mood = Mood.CALM;
                        break;
                    case "frenzy":
                        mood = Mood.FRENZY;
                        break;
                    case "":
                        mood = null;
                        break;
                    default:
                        command.output("Такого варианта нет");
                        break;
                }
            }
            while (!answer3.toLowerCase().equals("calm") && !answer3.toLowerCase().equals("frenzy")
                    && !answer3.toLowerCase().equals("sadness")
                    && !answer3.toLowerCase().equals("apathy") && !answer3.equals(""));

            command.output("Введите название машины:");
            String nameOfCar = command.getNextInput().trim();

            h = new HumanBeing(name, new Coordinates(x, y), realHero,
                    hasToothpick, speed, weapon, mood, new Car(nameOfCar));

        } catch (NullPointerException e) {
            System.out.println("Ошибки в скрипте");
        }

        return h;
    }
}