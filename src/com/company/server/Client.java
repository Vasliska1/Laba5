
package com.company.server;

import com.company.basis.*;
import com.company.commands.*;
import com.company.input.IOInterface;
import com.company.input.TerminalInput;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class Client {
    //public static final String file = "C:\\Users\\Владислава\\Desktop\\Laba5-master\\out\\production\\Laba5\\com\\company\\file.xml";

    public void startWork() throws IOException, ClassNotFoundException {
      /*  Scanner scanner = new Scanner(System.in);

        Socket clientSocket = new Socket("127.0.0.1", 8000);

        while (true) {
            System.out.println(3);

            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println(4);
            System.out.println((String) reader.readObject());
            Scanner sc = new Scanner(System.in);
            String[] rightCommand = sc.nextLine().trim().split(" ", 2);
            //  ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());


            while (!rightCommand[0].equals("exit")) {
                this.getObjectCommand(rightCommand, clientSocket);
                //  this.getObjectCommand(rightCommand,clientSocket);
                // writer.writeObject(this.getObjectCommand(rightCommand));
                System.out.println((String) reader.readObject());
                rightCommand = sc.nextLine().trim().split(" ", 2);

            }
            //writer.close();
            reader.close();
            clientSocket.close();

        }

    }
*/

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
                                System.out.println(00);
                                client.finishConnect();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        client.register(selector, SelectionKey.OP_WRITE);
                        continue;
                    }

                    if (key.isWritable()) {
                        SendSocketObject(client);
                        client.close();
                        return;
                    }
                    if (key.isReadable()) {
                        System.out.println(23);
                        SocketChannel channel = (SocketChannel) key.channel();
                        getReader(channel);
                        channel.close();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void SendSocketObject(SocketChannel client) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        String[] rightCommand = sc.nextLine().trim().split(" ", 2);



            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(getObjectCommand(rightCommand));
            objectOutputStream.flush();
            client.write(ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));

            //rightCommand = sc.nextLine().trim().split(" ", 2);
           // System.out.println((String) objectInputStream.readObject());

    }

    public void getReader(SocketChannel client) throws IOException, ClassNotFoundException {
        ByteBuffer data = ByteBuffer.allocate(1024);
        client.read(data);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data.array());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        System.out.println(objectInputStream.readObject().toString());
    }



       /* try {

            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 1999));

            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_CONNECT);



        }








            InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
            SocketChannel clientChannel = SocketChannel.open(hostAddress);

            Selector selector = Selector.open();
            clientChannel.configureBlocking(false);
            SelectionKey key = clientChannel.register(selector, SelectionKey.OP_READ)

                Buffer buffer = Buffer.allocate();
                buffer.put(msg.getBytes());
                buffer.flip();
                int bytesWritten = clientChannel.write(buffer);
                System.out.println(String.format("Sending Message: %s\nbufforBytes: %d", msg, bytesWritten));

            clientChannel.close();
            System.out.println("Client connection closed");


        Scanner scanner = new Scanner(System.in);

        //Socket clientSocket = new Socket("127.0.0.1", 8000);

        while (true) {


            ObjectInputStream reader = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println((String) reader.readObject());
            Scanner sc = new Scanner(System.in);
            String[] rightCommand = sc.nextLine().trim().split(" ", 2);
            //  ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());


            while (!rightCommand[0].equals("exit")) {
                this.getObjectCommand(rightCommand, clientSocket);

                byte [] message = new String(messages [i]).getBytes();
                ByteBuffer buffer = ByteBuffer.wrap(message);
                client.write(buffer);
                //  this.getObjectCommand(rightCommand,clientSocket);
                // writer.writeObject(this.getObjectCommand(rightCommand));
                System.out.println((String) reader.readObject());
                rightCommand = sc.nextLine().trim().split(" ", 2);

            }
            //writer.close();
            reader.close();
            clientSocket.close();

        }*/


    public AbstractCommands getObjectCommand(String[] rightCommand) throws IOException {
        //ObjectOutputStream writer = new ObjectOutputStream(clientSocket.getOutputStream());
        AbstractCommands objectCommands = new AbstractCommands();
        TerminalInput terminalInput = new TerminalInput();
        System.out.println(rightCommand[0]);
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

                objectCommands = new Add(readElement(terminalInput));

                break;
            case "update":
                objectCommands = new Update(rightCommand[1], readElement(terminalInput));
                break;
            case "remove_by_id":
                objectCommands = new RemoveById(Integer.parseInt(rightCommand[1]));

                break;
            case "clear":
                objectCommands = new Clear();
                break;

            case "save":
                objectCommands = new Save();
                break;
            case "execute_script":
                objectCommands = new ExecuteScript(rightCommand[1]);
                break;
            case "remove_lower":
                objectCommands = new RemoveLower(readElement(terminalInput));
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
                objectCommands = new FilterStartsWithName(rightCommand[1]);
                break;
            case "print_field_descending_weapon_type":
                objectCommands = new PrintFieldDescendingWeaponType();
                break;

        }
        return objectCommands;

        //writer.writeObject(objectCommands);

        // return objectCommands;
    }

    public HumanBeing readElement(IOInterface command) {
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
        System.out.println(h);
        return h;
    }
}