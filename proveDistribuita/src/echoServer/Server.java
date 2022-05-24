package echoServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

	public static Socket sk;

	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket ssk = new ServerSocket(9090);
		System.out.println("Waiting for client...");
		sk = ssk.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sk.getOutputStream())), true);
		System.out.println("Server running...");
		while (true) {
			String str = br.readLine();
			if (str.toLowerCase().equals("quit"))
				break;
			System.out.println("echo " + str);
			pw.println(str);
		}

	}

}
