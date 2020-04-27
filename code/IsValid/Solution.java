class Solution {
    public boolean isValid(String S) {
        return selfIsValid(S);
    }

    //use stack
    private boolean selfIsValid(String S) {
        List<Character> listStack = new ArrayList<>();

        char[] chars = S.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            //尾部添加
            builder.delete(0, builder.length());
            listStack.add(chars[i]);
            
            //获得listStack末尾的三个元素
            for (int j = listStack.size() - 3; j < listStack.size() && j >= 0; j++) {
                builder.append(listStack.get(j));
            }

            //判断栈顶三个元素
            if (builder.toString().equals("abc")) {
                System.out.println(builder.toString());
                listStack.remove(listStack.size() - 1);
                listStack.remove(listStack.size() - 1);
                listStack.remove(listStack.size() - 1);
            }
        }

        if (listStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //no stack
    public boolean noStackIsValid(String S) {
        while (S.contains("abc")) {
            S = S.replaceAll("abc", "");
        }
        if (S.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}
