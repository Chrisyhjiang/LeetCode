import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] computer = new String[2605];
		String[] commands = new String[2605];
		
		for(int i = 0; i < computer.length; i++) {
			computer[i] =  br.readLine();
		}
		for(int i = 0; i < computer.length; i++) {
			commands[i] =  br.readLine();
		}
		HashMap<String, HashSet<String>> hm = new HashMap<String, HashSet<String>>();
		for(int i = 0; i < computer.length; i++) {
			String key = computer[i];
			String command = commands[i];
			if(hm.containsKey(key)) {
				HashSet<String> hs = hm.get(key);
				if(!hs.contains(command)) {
					hs.add(command);
				}
				hm.put(key, hs);
			}else {
				HashSet<String> hs = new HashSet<String>();
				hs.add(command);
				hm.put(key, hs);
			}
		}
		for(int i = 0; i < 963; i++) {
			String name = br.readLine();
			if(hm.containsKey(name)) {
				System.out.println(name);
				hm.remove(name);
			}
		}
//		for(String key: hm.keySet()) {
//			HashSet<String> hs = hm.get(key);
//			String res = "";
//			for(String e: hs) {
//				res += e + " ";
//			}
//			System.out.println(res);
//		}
		
	}

}
