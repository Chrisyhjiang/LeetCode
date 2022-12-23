import java.util.*;
public class RandomizedSet {
	HashMap<Integer, Integer> hm;
	ArrayList<Integer> ls;
	public RandomizedSet() {
        hm = new HashMap<Integer, Integer>();
        ls = new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if(!hm.containsKey(val)) {
        	ls.add(val);
        	hm.put(val, ls.size() - 1);
        	return true;
        }else {
        	return false;
        }
    }
    
    public boolean remove(int val) {
    	if(!hm.containsKey(val)) {
    		return false;
    	}else {
    		int newIdx = hm.get(val);
    		hm.replace(ls.get(ls.size() - 1), newIdx);
            ls.set(newIdx, ls.get(ls.size() - 1));
            ls.remove(ls.size() - 1);
            hm.remove(val);
            return true;
    	}
        
    }
    
    public int getRandom() {
    	return ls.get((int) (Math.random() * ls.size()));
    }
	
	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
		System.out.println(rs.insert(0));
		System.out.println(rs.insert(1));
		System.out.println(rs.remove(0));
		System.out.println(rs.insert(2));
		System.out.println(rs.remove(1));
		System.out.println(rs.getRandom());
		

	}

}
