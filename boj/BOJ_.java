package boj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class BOJ_ {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socket = new Socket("quietjun.asuscomm.com", 9876);
		ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
		oout.writeObject("아놔 왜 안되지");
		Object result=oin.readObject();
		System.out.println(result);
		socket.close();
		
//		try(ServerSocket ss = new ServerSocket(9876)){
//			while(true) {
//				Socket socket = new Socket("quietjun.asuscomm.com", 9876);
//				new Client(socket).start();
//			}
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
	}
}