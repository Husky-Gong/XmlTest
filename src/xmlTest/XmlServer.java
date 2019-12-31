package xmlTest;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class XmlServer {
	public static void main(String[] args) {
		int port = netUtil.getPortByKey("port");
		
		try(
				ServerSocket ss = new ServerSocket(port);
				
				Socket socket = ss.accept();
				OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
				BufferedWriter bufWriter = new BufferedWriter(out);
				
				
				){
			bufWriter.write("message...");
			bufWriter.newLine();
			bufWriter.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
