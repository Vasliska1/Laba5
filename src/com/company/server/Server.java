package com.company.server;

import com.company.basis.HumanBeing;

import com.company.collection.HumanBeingCollection;
import com.company.commands.AbstractCommands;
import com.company.commands.*;
import com.company.exception.NoCorrectValue;
import com.company.exception.NullValueException;
import com.company.input.TerminalInput;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Server {
    private HumanBeingCollection serverCollection = buildCollection();
    private Socket incoming;
    private HashMap<String, AbstractCommands> allCommands;
    //private static CommandHandler handler;
    public static final String file = "C:\\Users\\Vasilisa\\Laba5\\src\\com\\company\\file.xml";


    Server(Socket incoming) throws NoCorrectValue, NullValueException, JAXBException {

        this.incoming = incoming;

    }

    public void runProgram() throws IOException, ClassNotFoundException, NoCorrectValue, NullValueException, JAXBException {
        System.out.println(2);
        try {
            ObjectOutputStream writer = new ObjectOutputStream(
                    incoming.getOutputStream());

            writer.writeObject("\nЗдарова, православные. Введите help.");
            writer.flush();
            TerminalInput terminalInput = new TerminalInput();

            while (true) {
                ObjectInputStream reader = new ObjectInputStream(
                        incoming.getInputStream());
                System.out.println(12);
                AbstractCommands inputCommands = (AbstractCommands) reader.readObject();
                System.out.println(123);
                writer.writeObject(inputCommands.execute(serverCollection, terminalInput));
            }

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }


    public static HumanBeingCollection buildCollection() throws JAXBException, NullValueException, NoCorrectValue {
        System.out.println(222);
        File f = new File(file);
        if (!f.canRead() && !f.canWrite() && !f.canExecute())
            throw new SecurityException();

        Scanner in = new Scanner(file);
        StringBuffer data = new StringBuffer();
        while (in.hasNext())
            data.append(in.nextLine());
        JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
        Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
        HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));

        for (HumanBeing hb : humanBeingCollection.getHumanBeings()) {


            if (hb.getName().trim().equals("")) throw new NullValueException("name"); //работает
            if (hb.getCoordinates().getX() == null) throw new NullValueException("x"); //работает
            if (hb.getCoordinates().getY() == null) throw new NullValueException("y"); //работает
            if (hb.getCoordinates().getY() > 649)
                throw new NoCorrectValue("Максимальное значение поля y - 649");
            if (hb.getCoordinates().getX() < -671)
                throw new NoCorrectValue("X должен быть больше -671"); //работает
            if (hb.getCreationDate() == null) throw new NullValueException("date"); //работает
            if (hb.getRealHero() == null) throw new NullValueException("RealHero"); //работает
            if (hb.getId() <= 0) throw new NoCorrectValue("Id should be > 0"); //работает
        }

        humanBeingCollection.setDate(new Date());
        for (HumanBeing humanBeing : humanBeingCollection.getHumanBeings()) {
            System.out.println(humanBeing);

        }
        return humanBeingCollection;
        //  handler = new CommandHandler(humanBeingCollection, file.toString());
    }
//TerminalInput terminal = new TerminalInput();

    // App app = new App();
// app.begin(f);
    public HashMap<String, AbstractCommands> getCommands() {
        return this.allCommands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Server)) return false;
        Server that = (Server) o;
        return Objects.equals(serverCollection, that.serverCollection) &&
                Objects.equals(allCommands, that.allCommands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverCollection, allCommands);
    }


}





/*

    public class Server {
        public static final String file = "C:\\Users\\Владислава\\Desktop\\Laba5-master\\out\\production\\Laba5\\com\\company\\file.xml";
        static private CommandHandler handler;

        public static void main(String[] args) throws NullValueException, IOException, NoCorrectValue, NoArgument, IncorrectValue, JAXBException {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился к серверу.");

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                        clientSocket.getOutputStream()));
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                writer.write("Клиент подключился к серверу.");
                writer.newLine();
                String request = reader.readLine();
                String response = "I can execute " + request;

                writer.write(response);
                writer.newLine();
                writer.flush();


                try {
// String file = Paths.get(args[0]).toAbsolutePath().toString();
                    File f = new File(file);
                    if (!f.canRead() && !f.canWrite() && !f.canExecute())
                        throw new SecurityException();

                    Scanner in = new Scanner(file);
                    StringBuffer data = new StringBuffer();
                    while (in.hasNext())
                        data.append(in.nextLine());
                    JAXBContext context1 = JAXBContext.newInstance(HumanBeingCollection.class);
                    Unmarshaller jaxbUnmarshaller = context1.createUnmarshaller();
                    HumanBeingCollection humanBeingCollection = (HumanBeingCollection) jaxbUnmarshaller.unmarshal(new File(file));

                    for (HumanBeing hb : humanBeingCollection.getHumanBeings()) {


                        if (hb.getName().trim().equals("")) throw new NullValueException("name"); //работает
                        if (hb.getCoordinates().getX() == null) throw new NullValueException("x"); //работает
                        if (hb.getCoordinates().getY() == null) throw new NullValueException("y"); //работает
                        if (hb.getCoordinates().getY() > 649)
                            throw new NoCorrectValue("Максимальное значение поля y - 649");
                        if (hb.getCoordinates().getX() < -671)
                            throw new NoCorrectValue("X должен быть больше -671"); //работает
                        if (hb.getCreationDate() == null) throw new NullValueException("date"); //работает
                        if (hb.getRealHero() == null) throw new NullValueException("RealHero"); //работает
                        if (hb.getId() <= 0) throw new NoCorrectValue("Id should be > 0"); //работает
                    }

                    humanBeingCollection.setDate(new Date());
                    handler = new CommandHandler(humanBeingCollection, file.toString());
//TerminalInput terminal = new TerminalInput();

// App app = new App();
// app.begin(f);

                } catch (SecurityException e) {
                    System.out.println("vi nub");
// } catch (FileNotFoundException e) {
                    System.out.println("vii nub");
                } catch (NoSuchElementException e) {
                    System.exit(0);
                }


                reader.close();
                writer.close();
                clientSocket.close();
            }
        }
    } catch (IOException e) {
            e.printStackTrace();
        }


 */