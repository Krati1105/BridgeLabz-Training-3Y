package com.bridgelabz.oops.levelone;

class PalindromeChecker {
    private String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public boolean isPalindrome() {
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = cleanedText.length() - 1;

        while (left < right) {
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is not a palindrome.");
        }
    }
}

public class PalindromeCheckerMain {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("Madam");
        PalindromeChecker p2 = new PalindromeChecker("Hello");

        p1.displayResult();
        p2.displayResult();
    }
}
