import java.util.*;
public class findMedSortedArray {

	public static void main(String[] args) {
		int[] nums1 = {1,3};
		int[] nums2 = {2};
		double d = findMedianSortedArrays(nums1, nums2);
		System.out.println(d);
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int totalLength = nums1.length + nums2.length;
		int left = 0;
		int right = nums1.length - 1;
		int leftPart= 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			leftPart = Math.max(totalLength / 2 - mid, 0);
			if(nums1[mid] < nums2[Math.max(leftPart-1, 0)]) {
				right = mid - 1;
			}else if (nums1[mid] > nums2[Math.min(leftPart + 1, nums2.length - 1)]) {
				left = mid + 1;
			}else {
				break;
			}	
		}
		
		if(totalLength % 2 == 1) {
			return Math.min(nums1[left + 1], nums2[leftPart]);
		}else {
			return nums1[left] + Math.min(nums2[leftPart + 1], nums1[left + 1]); 
		}
    }
	
	
}
