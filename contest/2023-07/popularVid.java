import java.util.*;;
public class popularVid {
	public static class Content{
		int total;
		int popView;
		String popId;
		
		public Content(int t, int view, String id) {
			total = t;
			popView = view;
			popId = id;
		}
		
	}
	public static void main(String[] args) {
		String[] creators = {"alice","alice","alice"};
		String[] ids = {"a","b","c"};
		int[] views = {1,2,2};
		List<List<String>> ls = mostPopularCreator(creators, ids, views);
		for(List<String> row: ls) {
			for(String r: row) {
				System.out.println(r + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        LinkedList<List<String>> ls = new LinkedList<List<String>>();
        HashMap<String, Content> hm = new HashMap<String, Content>();
        for(int i = 0; i < creators.length; i++) {
        	String key = creators[i];
        	if(hm.containsKey(creators[i])) {
        		Content c = hm.get(key);
        		c.total += views[i];
        		if(c.popView < views[i]) {
        			c.popView = views[i];
        			c.popId = ids[i];
        		}else if (c.popView == views[i]) {
        			if(c.popId.compareTo(ids[i]) > 0) {
        				c.popId = ids[i];
        			}
        		}
        	}else {
        		hm.put(key, new Content(views[i], views[i], ids[i]));
        	}
        }
        int max = -1;
        for(String key: hm.keySet()) {
        	Content c = hm.get(key);
        	if(c.total > max) {
        		ls.clear();
        		LinkedList<String> entry = new LinkedList<String>();
        		entry.add(key);
        		entry.add(c.popId);
        		ls.add(entry);
        		max = c.total;
        	}else if (c.total == max) {
        		LinkedList<String> entry = new LinkedList<String>();
        		entry.add(key);
        		entry.add(c.popId);
        		ls.add(entry);
        	}
        }
        return ls;
    }

}
