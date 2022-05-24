package multiEchoServer;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

	public static void main(String[] args) throws IOException {
		try (ServerSocket ssk = new ServerSocket(9090)) {
			int id = 0;
			System.out.println("waiting for clients...");
			while (true) {
				new Slave(ssk.accept(), id++);
				System.out.println("accepted client " + id);
			}
		}
	}
}
