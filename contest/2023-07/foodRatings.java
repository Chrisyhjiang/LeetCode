import java.util.*;
class foodRatings {
    
	static HashMap<String, TreeMap<Integer, TreeSet<String>>> cuisineRatings;
	static HashMap<String, Integer> foodRatings;
	static HashMap<String, String> foodCuisine;
	
	public static void main(String[] args) {
		String[] foods = {"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"};
		String[] cuisines = {"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"};
		int[] ratings = {2,6,18,6,5};
		foodRatings fr = new foodRatings(foods, cuisines, ratings);
		fr.changeRating("qnvseohnoe",11);
		String k = fr.highestRated("fajbervsj");
		fr.changeRating("emgqdbo",3);
		fr.changeRating("jmvfxjohq",9);
		fr.changeRating("jmvfxjohq",9);
		fr.changeRating("emgqdbo",14);
		String m = fr.highestRated("fajbervsj");
		String n = fr.highestRated("snaxol");
		
	}
	
    public foodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatings = new HashMap<String, Integer>();
        foodCuisine = new HashMap<String, String>();
        cuisineRatings = new HashMap<String, TreeMap<Integer, TreeSet<String>>>();
        for(int i = 0; i < foods.length; i++) {
        	foodCuisine.put(foods[i], cuisines[i]);
        	foodRatings.put(foods[i], ratings[i]);
        	if(cuisineRatings.containsKey(cuisines[i])) {
        		TreeMap<Integer, TreeSet<String>> map = cuisineRatings.get(cuisines[i]);
        		TreeSet<String> set;
        		if(map.containsKey(ratings[i])) {
        			set = map.get(ratings[i]);
        		}else {
        			set = new TreeSet<String>();
        		}
        		set.add(foods[i]);
    			map.put(ratings[i], set);
        	}else {
        		TreeMap<Integer, TreeSet<String>> map = new TreeMap<Integer, TreeSet<String>>();
        		TreeSet<String> set = new TreeSet<String>();
        		set.add(foods[i]);
        		map.put(ratings[i], set);
        		cuisineRatings.put(cuisines[i],map);
        	}
        }
        
    }
    
    public static void changeRating(String food, int newRating) {
    	String c = foodCuisine.get(food);
    	TreeMap<Integer, TreeSet<String>> map = cuisineRatings.get(c);
    	TreeSet<String> set = map.get(foodRatings.get(food));
    	set.remove(food);
    	if(set.size() != 0) {
    		map.put(foodRatings.get(food), set);
    	}else {
    		map.remove(foodRatings.get(food), set);
    	}
    	set = map.get(newRating);
    	if(set != null) {
    		set.add(food);
    	}else {
    		set = new TreeSet<String>();
    		set.add(food);
    	}
    	map.put(newRating, set);
    	cuisineRatings.put(c, map);
    	foodRatings.put(food, newRating);
    }
    
    public static String highestRated(String cuisine) {
    	TreeMap<Integer, TreeSet<String>> map = cuisineRatings.get(cuisine);
    	TreeSet<String> set = map.lastEntry().getValue();
    	return set.first();
    }
}