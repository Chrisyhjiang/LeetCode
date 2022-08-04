// https://leetcode.com/problems/longest-palindromic-substring/
import java.util.*;
public class LongestPalindromicSubstring {
	 public static String longestPalindrome(String s) {
		 // using DP memoization to store the previous palindromes. Complexity of O(N^2)
		 // the x axis of matrix is from y axis is to. 
		 int bestLength = 0;
		 String res = s.substring(0,1);
		 boolean[][] mat = new boolean[s.length()][s.length()];
		 for(int i = 0; i < s.length(); i++) {
		 	mat[i][i] = true;
		 }
			
		 for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == s.charAt(i + 1)) {
				mat[i][i+1] = true;
				res = s.substring(i,i+2);
			}
		}
			
		 for(int i = 3; i <= s.length(); i++) {
			 for(int j = 0; j <= s.length() - i; j++) {
				if(s.charAt(j) == s.charAt(j + i - 1) && mat[j+1][j + i - 2]) {
					if(i >= bestLength) {
						res = s.substring(j, j + i);;
						bestLength = i;
						mat[j][j + i - 1] = true;
					}
				}
			}
		}
			
		return res;
	}
	public static String longestPalindrome2(String s) {
		// expand from the center of palindrome Complexity of O(N^2)
		// 2N - 1 complexity
        char[] arr = s.toCharArray();
        int bestLength = 0;
        String longestString = "";
        for(int i = 0; i < arr.length; i++){
            // odd palindrome
            int left = i; 
            int right = i;
            
            while(left >= 0 && right < arr.length && arr[left] == arr[right]){
                if(right - left + 1 > bestLength){
                    longestString = s.substring(left, right + 1);
                    bestLength = right - left + 1;
                }
                left--;
                right ++;
            }
            // even palindrome 
            left = i; 
            right = i + 1;
             while(left >= 0 && right < arr.length && arr[left] == arr[right]){
                if(right - left + 1 > bestLength){
                    longestString = s.substring(left, right + 1);
                    bestLength = right - left + 1;
                }
                left--;
                right ++;
            }
        }
        return longestString;
    }
	public static String longestPalindrome3(String s) {
		// brute force generate all substrs and check. Break when 1 length is finished 
		// and only generate if new substr is longer than the current bestLength
        String longest = "";
        int length = 0;
        for(int i = 0; i <s.length(); i++){
            for(int j = s.length(); j >= i ; j--){
            	if((j - i + 1) > length) {
            		String k = s.substring(i,j);
                    if(isPalindrome(k) && k.length() > length){
                        longest = k;
                        length = k.length();
                        break;
                    }
            	}   
            }
        }
        return longest;
    }
    
    public static boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		String res = longest("cbbd");
		System.out.println(res);
	}

	
	public static String longest(String s) {
		int max = Integer.MIN_VALUE;
		String maxString = "";
		for(int i = 0; i < s.length(); i++) {
			int left = i;
			int right = i;
			while(left >= 0 && right <s.length()) {
				if(s.charAt(right) == s.charAt(left)) {
					if(right - left + 1 > max) {
						max = right - left + 1;
						maxString = s.substring(left, right + 1);
					}
				}else {
					break;
				}
				right++;
				left--;
			}
		}
		
		for(int i = 0; i < s.length() - 1; i++) {
			int left = i;
			int right = i + 1;
			while(left >= 0 && right <s.length()) {
				if(s.charAt(right) == s.charAt(left)) {
					if(right - left + 1 > max) {
						max = right - left + 1;
						maxString = s.substring(left, right + 1);
					}
				}else {
					break;
				}
				right++;
				left--;
			}
			
		}
		return maxString;
	}
	
}
