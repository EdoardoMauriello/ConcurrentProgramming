package multiEchoServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	private static String name;
	private static final int PORT = 9090;

	public static void main(String[] args) throws UnknownHostException, IOException {
		// client side socket initialization on port 9090
		Socket sk = new Socket("localhost", PORT);
		// client side buffered reader for receiving strings
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		// client side printwriter for sending communications
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sk.getOutputStream())), true);
		Scanner sc = new Scanner(System.in); // scanner for reading standard inputs (keyboard)
		// optional: first string received by clients is the name of the server thread
		// it's connected to
		name = in.readLine();
		System.out.println("connected to server thread " + name + " on port " + PORT);
		while (true) { // main while cycle
			System.out.print("input: ");
			String str = sc.nextLine();
			out.println(str);
			if (str.toLowerCase().equals("quit")) { // client closing command sequence
				System.out.println("closing...");
				System.exit(0);
			}
			System.out.println("server: " + in.readLine());

		}
	}

}
