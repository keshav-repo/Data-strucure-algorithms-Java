package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
   /* List<String> ans = new LinkedList<>();
    public List<String> restoreIpAddresses2(String s) {
        List<Character> digits = new ArrayList<>();
        for (char c : s.toCharArray()) {
            digits.add(c);
        }
        System.out.println(digits);
        return null;
    }
    public boolean isvalid(List<Character> subnet) {
        boolean initialZero = false;
        int num = 0;
        for (char c : subnet) {
            num = num * 10 + (int) (c - '0');
            if (num == 0 && c == '0') {
                return false;
            }
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public void restore(List<Character> digits, int idx, List<Character> subnet, List<Character> ip) {
        for (int i = idx; i < (idx + 2); i++) {
            subnet.add(digits.get(i));
            if (isvalid(subnet)) {

            }
        }
    }*/

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        recurse(s, ans, 0, "", 0);
        return ans;
    }

    private void recurse(String curr, List<String> ans, int index, String temp, int count) {
        if (count > 4)
            return;
        if (count == 4 && index == curr.length())
            ans.add(temp);
        for (int i = 1; i < 4; i++) {
            if (index + i > curr.length()) {
                break;
            }
            String s = curr.substring(index, index + i);
            if ((s.startsWith("0") && s.length() > 1) || (i == 3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            recurse(curr, ans, index + i, temp + s + (count == 3 ? "" : "."), count + 1);
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIpAddress ipAddress = new RestoreIpAddress();
        List<String> address = ipAddress.restoreIpAddresses(s);
        System.out.println(address);
    }
}

