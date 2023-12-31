/** Reverse the maximum subsequence of a string for a given pattern */

import java.util.Scanner;

public class MaxSubsequenceReversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the original string
        System.out.print("Enter the original string: ");
        String originalString = scanner.nextLine();

        // Input the pattern
        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        // Find the maximum subsequence for the given pattern
        String maxSubsequence = findMaxSubsequence(originalString, pattern);

        // Reverse the maximum subsequence
        String reversedMaxSubsequence = reverseString(maxSubsequence);

        // Output the result
        System.out.println("Original String: " + originalString);
        System.out.println("Pattern: " + pattern);
        System.out.println("Maximum Subsequence: " + maxSubsequence);
        System.out.println("Reversed Maximum Subsequence: " + reversedMaxSubsequence);

        scanner.close();
    }

    private static String findMaxSubsequence(String originalString, String pattern) {
        // Logic to find the maximum subsequence for the given pattern
        // Some logic here

        // the maximum subsequence is the longest common subsequence
        return longestCommonSubsequence(originalString, pattern);
    }

    private static String longestCommonSubsequence(String str1, String str2) {
        // Logic to find the longest common subsequence
        // Longest common subsequence is the characters common to both strings
        StringBuilder result = new StringBuilder();

        for (char ch : str1.toCharArray()) {
            if (str2.contains(String.valueOf(ch))) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    private static String reverseString(String str) {
        // Logic to reverse a string
        return new StringBuilder(str).reverse().toString();
    }
}
