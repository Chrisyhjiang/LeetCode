
public class HIndexII {

	public static void main(String[] args) {
		int[] citations = {100};
		int res = hIndex(citations);
		System.out.println(res);
	}
	public static int hIndex(int[] citations) {
		int start = 0;
		int end = citations.length - 1;
		while (start <= end) {
            int mid = start + (end - start) / 2;

            // There's (n - mid) papers with an equal or higher citation count than citations[mid]
            // If (citations[mid] == n - mid) it's the optimal result and can be returned right away
            if (citations[mid] == citations.length - mid) {
            	return citations[mid];
            }
            if (citations[mid] < citations.length - mid) {
            	start = mid + 1;
            }else {
            	end = mid - 1;
            }
                
        }
		return citations.length - start;
    }
	public static int hIndex2(int[] citations) {
		// binary search
		// if array length - current index = citations[currentIndex] true
		// if it is true search on the right. 
		// if it is false search left. 
		return citations[binSearch(0, citations.length - 1, citations, citations.length)];
    }
	
	public static int binSearch(int start, int end, int[] arr, int length) {
		if(start > end) {
			return 0;
		}else {
			int mid = (start + end) / 2;
			if(arr[mid] > length) {
				return 0;
			}else {
				if(length - mid >= arr[mid]) {
					return Math.max(mid, binSearch(mid + 1, end, arr, length));
				}else {
					return binSearch(start, mid - 1, arr, length);
				}
			}
		}
	}

}
