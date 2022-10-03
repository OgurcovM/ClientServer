import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner server = new Scanner(System.in);
        Socket serverClient = new Socket("192.168.0.12", 1111);
        DataInputStream dis = new DataInputStream(serverClient.getInputStream());
        DataOutputStream dos = new DataOutputStream(serverClient.getOutputStream());

        while (true) {
            String inp = server.nextLine();
            dos.writeUTF(inp);
            String otvet = dis.readUTF();
            System.out.println(otvet);
        }
    }
}
