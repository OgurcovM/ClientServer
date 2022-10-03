import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1111);
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        while (true){
            String input = in.readUTF();
            System.out.println(input);
            int result = 0;

            StringTokenizer st = new StringTokenizer(input);
            int one = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int two = Integer.parseInt(st.nextToken());
            if (operation.equals("+")) {
                result = one + two;
            }
            out.writeUTF(Integer.toString(result));
        }
    }
}
