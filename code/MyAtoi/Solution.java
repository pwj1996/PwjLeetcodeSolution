class Solution {
    public int myAtoi(String str) {
        return selfmyAtoi(str);
    }

    //通过画状态转换图的方式，更加容易判断清楚所有的情况
    private int selfmyAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean positiveFlag = true;
        boolean startFlag = false;
        int res = 0;

        for (int i = 0; i < chars.length; i++) {

            if (startFlag == false && chars[i] == ' ') {
                //开头的空格合法
                continue;
            } else if (startFlag == false && (chars[i] == '+' || chars[i] == '-')) {
                //开头的-+合法
                if (chars[i] != '+') {
                    positiveFlag = false;
                } 
                startFlag = true;
            } else if (chars[i]>='0' && chars[i] <= '9') {
                startFlag = true;
                int digit = chars[i] - '0';
                if ((Integer.MAX_VALUE - digit) / 10 < res) {
                    //发生越界的情况时，如果为整数则正常计算，如果为负数发生越界时概述要么是最小负数，要么更小但返回的结果都是最小负数
                    System.out.println(res);
                    return positiveFlag == true ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + digit;
                
            } else {
                //遇到非法字符直接退出
                break;
            }
        }

        if (!positiveFlag) {
            return -res;
        }
        return res;
    }
}
