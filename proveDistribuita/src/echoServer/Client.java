package echoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket sk = new Socket("localhost", 9090);
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(sk.getOutputStream()), true);

		while (true) {
			String str = sc.nextLine();
			pw.println(str);
			System.out.println(br.readLine());
		}
	}

}
