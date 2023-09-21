class Solution {
    
    static class CustomComparator implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {
        // Compare first elements
        	int compareFirst = Integer.compare(a.get(0), b.get(0));
        	if (compareFirst != 0) {
        		return compareFirst;
        	} else {
        		return Integer.compare(a.get(1), b.get(1));
        	}
        }
    }
    
		public static int binsearch(int start, List<List<Integer>> coords, List<Integer> target) {
		int end = coords.size() - 1;
    	int res = -1;
    	while (start <= end) {
    		int mid = (start + end) / 2;
    		List<Integer> cur = coords.get(mid);
    		int comp = Integer.compare(cur.get(0), target.get(0));
    		comp = (comp == 0) ? Integer.compare(cur.get(1), target.get(1)) : comp;
    		if (comp == 0) {
    			res = mid;
    			break;
    		} else if (comp < 0) {
    			start = mid + 1;
    		} else {
    			end = mid - 1;
    		}
    	}
    	if (res == -1) {
    		return 0;
    	}
    	int l = res;
    	int r = res;
    	
    	while (l >= start) {
    		if (compare(coords.get(l), target)) {
    			l--;
    		} else {
    			break;
    		}
    	}
    	
    	while (r < coords.size()) {
    		if (compare(coords.get(r), target)) {
    			r++;
    		} else {
    			break;
    		}
    	}
    	return r - l - 1;
		
	}
	
    public static boolean compare(List<Integer> ls1, List<Integer> ls2) {
    	return ls1.get(0) == ls2.get(0) && ls1.get(1) == ls2.get(1);
    }
    
    public static int countPairs(List<List<Integer>> coordinates, int k) {
    	Collections.sort(coordinates, new CustomComparator());
    	int res = 0;
    	
    	for (int i = 0; i < coordinates.size(); i++) {
    		int x1 = coordinates.get(i).get(0);
    		int y1 = coordinates.get(i).get(1);
    		for (int tx = 0; tx <= k; tx++) {
    			int ty = k - tx;
    			int x2 = tx ^ x1;
    			int y2 = ty ^ y1;
    			List<Integer> ls = new ArrayList<>();
    			ls.add(x2);
    			ls.add(y2);
    			res += binsearch(i + 1, coordinates, ls);
    		}
    		
    	}    	
    	return res;
    }

}

