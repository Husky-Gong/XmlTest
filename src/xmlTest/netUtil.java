package xmlTest;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class netUtil {
	private static Document document;
	
	private static Map<String, String> socketCache = new HashMap<>();
	
	static {
		try(
				InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("netSettings.xml");
				){
			if(in == null) throw new RuntimeException("loading failed...");
			SAXReader sr = new SAXReader();
			document = sr.read(in);
			System.out.println(";;;;;;");
			loadCache();
			
		}catch(Exception e) 
		{
					e.printStackTrace();
		}
	}
	
	private static void loadCache() throws Exception{
		@SuppressWarnings("unchecked")
		List<Node> list = document.selectNodes("config//property");
		
		for(Node node: list) {
			
			String key = node.valueOf("@key");
			String value = node.valueOf("@data");
			System.out.println(key);
			System.out.println(value);
			socketCache.put(key, value);
		}
	}
	
	public static String getStringByKey(String key) {
		return socketCache.get(key);
	}
	
	public static int getPortByKey(String key) {
		String value = socketCache.get(key);
		return Integer.parseInt(value);
	}
}
