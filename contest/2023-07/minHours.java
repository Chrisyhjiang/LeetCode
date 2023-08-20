
public class minHours {

	public static void main(String[] args) {
		int[] energ = {1};
		int[] exp = {3};
		int ien = 2;
		int ixp = 4;
		int res = minNumberOfHours(ien, ixp, energ, exp);
		System.out.println(res);
	}
	
	public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		int hours = 0;
		int totalEnergy = 0;
		for(int i = 0; i < energy.length; i++) {
			totalEnergy += energy[i];
		}
		
		hours += Math.max((totalEnergy + 1 - initialEnergy),0);
		for(int i = 0; i < experience.length; i++) {
			if(initialExperience <= experience[i]) {
				hours += experience[i] - initialExperience + 1;
				initialExperience = experience[i] + 1;
			}
			
			initialExperience += experience[i];
			
		}
		return hours;
    }
	
}
