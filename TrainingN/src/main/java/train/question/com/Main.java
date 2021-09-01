package train.question.com;

import java.util.*;
public class Main {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        Arrays.fill(memo, - 1);
        return helper(days, costs, 0, memo);
    }

    private int helper(int[] days, int[] costs, int i, int[] memo){
        if(i >= days.length){
            return 0;
        }

        if(memo[i] != -1) return memo[i];

        int day1 = days[i] + 1;
        int x1 = findUpper(days, day1);

        int day2 = days[i] + 7;
        int x2 = findUpper(days, day2);

        int day3 = days[i] + 30;
        int x3 = findUpper(days, day3);

        int a = helper(days, costs, x1, memo) + costs[0];
        int b = helper(days, costs, x2, memo) + costs[1];
        int c = helper(days, costs, x3, memo) + costs[2];

        int res = Integer.min(a, Integer.min(b, c));
        memo[i] = res;
        return res;
    }

    private int findUpper(int[] days, int t){
        int l = 0;
        int h = days.length;

        while(l < h){
            int m = l + (h - l) / 2;
            if(days[m] < t){
                l = m + 1;
            } else {
                h = m;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        }
}

