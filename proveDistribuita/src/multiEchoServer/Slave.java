package multiEchoServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Slave extends Thread {
	Socket sk;

	public Slave(Socket sk, int id) {
		this.setName("s" + id);
		this.sk = sk;
		this.start();
	}

	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(sk.getOutputStream())), true);
			out.println(getName());
			while (true) {
				System.out.println(getName() + " waiting for input...");
				String str = in.readLine();
				if (str.toLowerCase().equals("quit")) {
					System.out.println("quitting " + getName());
					break;
				}
				System.out.println(getName() + " received " + str);
				out.println(str);
			}
		} catch (IOException e) {
		}
	}

}
