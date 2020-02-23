package com.leetcode.JJMiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberScores {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int number= in.nextInt();
        System.out.println(compute_number_score(number));


    }
    public static int compute_number_score(int number) {
        return getDigitWiseScore(number) + countConsecutiveFives(number) + get(number);
    }
    public static int getDigitWiseScore(int num) {
        int score = 0;
        if (num % 3 == 0) score += 2;
        while (num > 0) {
            int d = num % 10;
            if (d == 7) score += 1;
            if (d % 2 == 0) score += 4;
            num = num / 10;
        }
        return score;
    }
    public static int countConsecutiveFives(int num) {
        int score = 0;
        int currentOnes = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            if (d != 5 && currentOnes > 1) {
                score += 3;
                score += (currentOnes - 2) * 3;
                currentOnes = 0;
            }
            if (d != 5 && currentOnes == 1) {
                currentOnes = 0;
            }
            if (d == 5) {
                currentOnes++;
            }
        }
        if (currentOnes > 1) {
            score += 3;
            score += (currentOnes - 2) * 3;
        }
        return score;
    }
    public static int get(int num) {
        int x = 0, count = 1;
        List< Integer > store = new ArrayList< >();
        String s = Integer.toString(num);
        while (x < s.length() - 1) {
            if (s.charAt(x) == s.charAt(x + 1) + 1) {
                count++;
                x++;
            } else {
                x++;
                store.add(count);
                count = 1;
            }
        }
        store.add(count);
        int score = 0;
        for (Integer i: store) {
            score += i * i;
        }
        return score;
    }
}

