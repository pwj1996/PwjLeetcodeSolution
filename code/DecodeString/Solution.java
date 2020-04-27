class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;

        //抽象：字符 + 数字 + [字符]
        //对于[：将前面的字符 + 数字入栈
        //对于]：数字出栈，拼接字符，字符出栈res拼接，
        //始终保持res
        //栈的深度 和 括号的深度
        LinkedList<Integer> stackMulti = new LinkedList<>();
        LinkedList<String> stackRes = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                //维护栈顶的元素是 "[" 之前的数组和字符串
                stackMulti.addLast(multi);
                stackRes.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                //进行一次拼接
                StringBuilder tmp = new StringBuilder();
                int curMulti = stackMulti.removeLast();
                for(int i = 0; i < curMulti; i++) tmp.append(res);
                res = new StringBuilder(stackRes.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}
