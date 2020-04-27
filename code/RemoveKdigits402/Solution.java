class Solution {
    public String removeKdigits(String num, int k) {
        return selfRemoveKdigits(num, k);
    }

    private String selfRemoveKdigits(String num, int k) {
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = num.toCharArray();

        //保证list是有序的
        for(char c: chars) {
            //确保栈顶是最大的
            while (list.size() != 0 && list.peekLast() > c && k > 0) {
                list.removeLast();
                k--;
            }
            list.add(c);
        }

        //k可能不为零，此时list是升序，从末尾去除
        while(k > 0) {
            list.removeLast();
            k--;
        }

        //拼接出答案
        StringBuilder builder = new StringBuilder();
        int startFlag = 0;
        for (Character c: list) {
            if ( startFlag == 0 && !c.equals('0')) {
                startFlag = 1;
            }
            if (startFlag == 1)
                builder.append(c);
        }
        if (builder.length() == 0)
            builder.append('0');
        return builder.toString();
    }
}
