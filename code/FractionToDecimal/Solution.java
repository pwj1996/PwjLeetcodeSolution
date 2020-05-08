class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        return selfFractionToDecimal(numerator, denominator);
    }

    private String selfFractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder fraction = new StringBuilder();

        //判断符号是否相同
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }

        //获得整数部分
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));

        //没有小数直接返回
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }

        //负责小数部分
        fraction.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while(remainder != 0) {
            System.out.println(remainder);
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            //添加<key, value>，value代表添加位置
            map.put(remainder, fraction.length());
            //如果后面有数则进位，没有则进0
            remainder *= 10;
            //对于结果每一位的运算，如果小于除数，则为0
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }

        return fraction.toString();

    }
}
