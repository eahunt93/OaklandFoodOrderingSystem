package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {

    /**
     * The port that the server listens on.
     */
    private static final int PORT = 2222;

    private static final ArrayList<String> names = new ArrayList<String>();

    private static ArrayList<String> clients = new ArrayList<String>();

    private static final HashMap<String, DataOutputStream> writers = new HashMap<>();

    private static final HashMap<String, Socket> clientinfo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                Socket socket = listener.accept();
                new Handler(socket).start(); //The essence of the program
            }
        } finally {
            listener.close();
            System.out.println("\nclient closed connection");
        }
    }
// Handler was created on http://cs.lmu.edu/~ray/notes/javanetexamples/

    private static class Handler extends Thread {

        private String name;
        private final Socket socket;
        private DataInputStream din;
        private DataOutputStream dout;

        /**
         * Constructs a handler thread, squirreling away the socket. All the
         * interesting work is done in the run method.
         */
        // this was done onhttp://cs.lmu.edu/~ray/notes/javanetexamples/
        public Handler(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {

                // Create character streams for the socket.
                din = new DataInputStream(socket.getInputStream());
                dout = new DataOutputStream(socket.getOutputStream());

                // Request a name from this client.  Keep requesting until
                // a name is submitted that is not already used.  Note that
                // checking for the existence of a name and adding the name
                // must be done while locking the set of names.
                // part of this was on http://cs.lmu.edu/~ray/notes/javanetexamples/
                while (true) {
                    dout.writeUTF("please submit name");
                    name = din.readUTF();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) { //Safe access of the the names list
                        if (!names.contains(name)) {
                            names.add(name);
                            clients.add(name);
                            break;
                        }
                    }
                }

                //says hello to the new clients and adds them to the writers hash map
                if (name.equals("Chick Fila") || name.equals("Moes")) {
                    dout.writeUTF("Hello: " + name + " wait for orders to come in");
                } else {
                    dout.writeUTF("Hello " + name + "you can order now");
                }
                dout.flush();
                //Storing the client's info 
                writers.put(name, dout);
                clientinfo.put(name, socket);
                System.out.println(name + " is connected to " + clientinfo.get(name));

                //this accepts input from the client and then send the message to the correct clients
                while (true) {
                    String input = din.readUTF();
                    if (input == null) {
                        return;
                    }
                    //handling the messages and sending them off to the correct clients
                    for (int i = 0; i < clients.size(); i++) {
                        if (input.startsWith(clients.get(i))
                                && !(input.contains(" your order is ready for pickup"))
                                && !(input.contains(clients.get(i) + " hey"))) {
                            input = input.replace(clients.get(i), "");
                            System.out.println("\nMessage from " + name + " at " + clientinfo.get(name));
                            System.out.println("Sending to  " + clients.get(i) + " at  " + clientinfo.get(clients.get(i)));
                            writers.get(clients.get(i)).writeUTF(name + ":" + input);
                        } else if (input.contains(clients.get(i) + " hey")) {
                            writers.get(clients.get(i)).writeUTF(input);
                        } else if (input.equals(clients.get(i) + " your order is ready for pickup")) {
                            System.out.println("\nMessage from " + name + " at " + clientinfo.get(clients.get(i)));
                            System.out.println("Sending to  " + clients.get(i) + " at  " + clientinfo.get(clients.get(i)));
                            writers.get(clients.get(i)).writeUTF(input);
                        } else {
                            System.out.println("");
                        }
                    }
                }

                // this was based on code from http://cs.lmu.edu/~ray/notes/javanetexamples/
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // This client is going down!  Remove its name and its print
                // writer from the sets, and close its socket.
                if (name != null) {
                    names.remove(name);
                    clients.remove(name);
                }
                if (dout != null) {
                    writers.remove(name);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
