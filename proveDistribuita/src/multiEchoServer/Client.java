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

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sk = new Socket("localhost", 9090);
		BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sk.getOutputStream())), true);
		Scanner sc = new Scanner(System.in);
		name = in.readLine();
		System.out.println("connected to server " + name);
		while (true) {
			System.out.print("input: ");
			String str = sc.nextLine();
			out.println(str);
			if (str.toLowerCase().equals("quit")) {
				System.out.println("closing...");
				System.exit(0);
			}
			System.out.println("server: " + in.readLine());

		}
	}

}
