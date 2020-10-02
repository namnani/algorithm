//2020. 10. 02. 12:11 Friday
//created by nani for study leetcode
//https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/

public class LongestPalindromicSubstringWithDynamicProgramming {

    // Driver program to test above functions
    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println("Length is: " + longestPalSubstr(str));
    }

    // This function prints the longest
    // palindrome substring of str[].
    // it also returns the length of the
    // longest palindrome
    private static int longestPalSubstr(String str) {
        // get length of input string
        int n = str.length();

        // table[i][j] will be false if
        // substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
        boolean table[][] = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for lengths greater than 2.
        // k is length of substring
        for (int k = 3; k <= n; ++k) {

            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str charAt(j-1) is a palindrome
                if (table[i + 1][j - 1]
                        && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println("Longest palindrome substring is: ");
        printSubStr(str, start, start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }

    // A utility function to pritn
    // a substring str[low..high]
    private static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }
}
