class Solution {
    public boolean isValidSerialization(String preorder) {
        /*String[] stringArray = preorder.split(",");
        
        int dif = 0;

        for (String s : stringArray)
        {
            if (dif < 0)
                return false;
            if (!s.equals("#")) {
                dif += 1;
            } else {
                dif--;
            }
        }
        return dif == 0;*/
        return selfIsValidSerialization(preorder);
   }

   private boolean selfIsValidSerialization(String preorder) {
        String[] str = preorder.split(",");
        Stack<String> stack = new Stack<>();

        int i = 0;
        for (i = 0; i < str.length; i++) {
            if (stack.isEmpty() && str[i].equals("#")) {
                break;
            }
            if (!str[i].equals("#")) {
                stack.push(str[i]);
            } else {
                stack.pop();
            }
        }

        if (i != str.length - 1) {
            return false;
        } else {
            return true;
        }
   }
}
