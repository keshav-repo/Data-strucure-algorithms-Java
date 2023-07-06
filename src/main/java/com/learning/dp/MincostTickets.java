package com.learning.dp;

public class MincostTickets {

    public int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[366]; // dynamic programming array
        boolean[] travelDays = new boolean[366]; // days on which we will travel

        for (int day : days) {
            travelDays[day] = true;
        }

        for (int i = 1; i <= 365; i++) {
            if (!travelDays[i]) {
                // if we're not traveling on this day, we don't need to buy a ticket
                dp[i] = dp[i - 1];
                continue;
            }

            // if we're traveling on this day, we need to decide which ticket to buy
            dp[i] = Math.min(dp[i - 1] + costs[0], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }

        return dp[365]; // return the cost of traveling every day in the year
    }


    public static int minCostTicketsRec(int[] days, int[] cost, int day) {

        if (day >= days.length)
            return 0;
        int oneDayPass = minCostTicketsRec(days, cost, day + 1) + cost[0];

        int i;
        for (i = day; i < days.length; i++) {
            if (days[i] >= days[day] + 7)
                break;
        }
        int secondDayPass = minCostTicketsRec(days, cost, i) + cost[1];

        for (i = day; i < days.length; i++) {
            if (days[i] >= days[day] + 30)
                break;
        }
        int thirdDayPass = minCostTicketsRec(days, cost, i) + cost[2];

        return Math.min(oneDayPass, Math.min(secondDayPass, thirdDayPass));
    }


    static Integer[] dp;

    public static int minCostTicketsDp(int[] days, int[] cost, int day) {

        if (day >= days.length)
            return 0;

        if (dp[day] != null)
            return dp[day];

        int oneDayPass = minCostTicketsDp(days, cost, day + 1) + cost[0];

        int i;
        for (i = day; i < days.length; i++) {
            if (days[i] >= days[day] + 7)
                break;
        }
        int secondDayPass = minCostTicketsDp(days, cost, i) + cost[1];

        for (i = day; i < days.length; i++) {
            if (days[i] >= days[day] + 30)
                break;
        }
        int thirdDayPass = minCostTicketsDp(days, cost, i) + cost[2];

        return dp[day] = Math.min(oneDayPass, Math.min(secondDayPass, thirdDayPass));
    }

    public static void main(String[] args) {
        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}; //{1,4,6,7,8,20};
        int[] costs = {2, 7, 15};

        int ans = minCostTicketsRec(days, costs, 0);
        System.out.println(ans);

        dp = new Integer[days.length];

        int res = minCostTicketsDp(days, costs, 0);
        System.out.println(res);
    }
}
