class Solution {
     public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int k = m + n;
        if (k % 2 == 1) {
            return binSearch(A, B, k / 2, 0, m - 1, 0, n - 1);
        } else {
            return (double)
            (binSearch(A, B, k / 2, 0, m - 1, 0, n - 1) + 
            binSearch(A, B, k / 2 - 1, 0, m - 1, 0, n - 1)) / 2;
        }
    }

    public int binSearch(int[] A, int[] B, int k, int aStart, int aEnd, int bStart, int bEnd) {
        // if aEnd > aStart, then the answer can only be in B. 
        // from 0 to aStart means all the things in A that was used. 
        if (aEnd < aStart) {
            return B[k - aStart];
        }
        // sa,e logic as above. 
        if (bEnd < bStart) {
            return A[k - bStart];
        }
        
        // index for binary search. 
        int aIndex = (aStart + aEnd) / 2;
        int bIndex = (bStart + bEnd) / 2;
        int aValue = A[aIndex];
        int bValue = B[bIndex];
        
        // if these index add together is smaller than k that means the thing is on the right.
        // so we need to remove the left half of 1 specific portion. 
        if (aIndex + bIndex < k) { 
            // if a value bigger than b value, then the smaller half needs to be removed. 
            if (aValue > bValue) {
                return binSearch(A, B, k, aStart, aEnd, bIndex + 1, bEnd);
            } else {
                return binSearch(A, B, k, aIndex + 1, aEnd, bStart, bEnd);
            }
        }
        // same logic as above. 
        else { 
            if (aValue > bValue) {
                return binSearch(A, B, k, aStart, aIndex - 1, bStart, bEnd);
            } else {
                return binSearch(A, B, k, aStart, aEnd, bStart, bIndex - 1);       
            }
        }
    }
}