// https://www.acmicpc.net/problem/
// 
// 
package boj;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {
	// User and Launcher Information
		static final String NICKNAME = "DAEJEON02_KIMJAVA";
		static final String HOST = "127.0.0.1";

		// Static Value(Do not modify)
		static final int PORT = 1447;
		static final int CODE_SEND = 9901;
		static final int CODE_REQUEST = 9902;
		static final int SIGNAL_ORDER = 9908;
		static final int SIGNAL_CLOSE = 9909;

		// Predefined Variables(Do not modify)
		static final int TABLE_WIDTH = 254;
		static final int TABLE_HEIGHT = 127;
		static final int NUMBER_OF_BALLS = 6;
		static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

		public static void main(String[] args) {

			Socket socket = null;
			String recv_data = null;
			byte[] bytes = new byte[1024];
			int[][] balls = new int[NUMBER_OF_BALLS][2];
			int order = 0;

			try {
				socket = new Socket();
				System.out.println("Trying Connect: " + HOST + ":" + PORT);
				socket.connect(new InetSocketAddress(HOST, PORT));
				System.out.println("Connected: " + HOST + ":" + PORT);

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				String send_data = CODE_SEND + "/" + NICKNAME + "/";
				bytes = send_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Ready to play!\n--------------------");

				while (socket != null) {

					// Receive Data
					bytes = new byte[1024];
					int count_byte = is.read(bytes);
					recv_data = new String(bytes, 0, count_byte, "UTF-8");
					System.out.println("Data Received: " + recv_data);

					// Read Game Data
					String[] split_data = recv_data.split("/");
					int idx = 0;
					try {
						for (int i = 0; i < NUMBER_OF_BALLS; i++) {
							for (int j = 0; j < 2; j++) {
								balls[i][j] = Integer.parseInt(split_data[idx++]);
							}
						}
					} catch (Exception e) {
						bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
						os.write(bytes);
						os.flush();
						System.out.println("Received Data has been currupted, Resend Requested.");
						continue;
					}

					// Check Signal for Player Order or Close Connection
					if (balls[0][0] == SIGNAL_ORDER) {
						order = balls[0][1];
						System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
						continue;
					} else if (balls[0][0] == SIGNAL_CLOSE) {
						break;
					}

					// Show Balls' Position
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
					}

					float angle = 0.0f;
					float power = 0.0f;

					angle = 90;

					power = 26;
					// You can clear Stage 1 with the pre-written code above.
					// Those will help you to figure out how to clear other Stages.
					// Good luck!!
					// ENd of Your Code
					//////////////////////////////

					// Play(Send Data)
					String merged_data = angle + "/" + power + "/";
					bytes = merged_data.getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Data Sent: " + merged_data);
				}

				os.close();
				is.close();
				socket.close();
				System.out.println("Connection Closed.\n--------------------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}