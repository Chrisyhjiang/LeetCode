// https://leetcode.com/problems/palindrome-number/
public class Palindrome {
	public boolean isPalindrome(int x) {
        // negative numbers of all not palindromic
        // 0 is a palindrome
        // multiples of 10 is not palindrome. 
        if (x == 0){
            return true;
        }
        // case x = 100 would error if basecase x % 10 is not included. 
        if (x < 0 || x % 10 == 0){
            return false;
        }
        else{
            int count = (int)(Math.log10(x)); 
            int reverse = 0;
            while(x > reverse){
				// reverse half the number. Once reversed being incremented is greater than the orignal number, 
				//exactly half the number has been reversed. Do not need to keep track of multiples of 10,
				//just multiply itself and add the last digit. 
                int digit = x % 10;
                reverse = reverse * 10 + digit;
                x /= 10;
            }
            if(count %2 == 0){
                return (reverse /= 10) == x;
            }else{
                return x == reverse;
            }
        }
    }
}
