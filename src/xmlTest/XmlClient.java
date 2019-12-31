package xmlTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class XmlClient {
	public static void main(String[] args) {
		int port = netUtil.getPortByKey("port");
		String address = netUtil.getStringByKey("address");
		try(
				Socket socket = new Socket(address,port);
				InputStreamReader in = new InputStreamReader(socket.getInputStream());
				BufferedReader bufRead = new BufferedReader(in);
				){
			String message = bufRead.readLine();
			bufRead.readLine();
			System.out.println(message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
