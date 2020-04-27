class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        return selfAsteroidCollision(asteroids);
    }

    private int[] selfAsteroidCollision(int[] asteroids) {
        //栈中维持的是不会发生的
        Stack<Integer> stack = new Stack<>();
        //stack.push(asteroids[0]);

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0 || stack.peek() < 0) {
                //new向右，或stack.top向左则不会发生碰撞
                stack.push(asteroids[i]);
            } else {
                if (Math.abs(asteroids[i]) < Math.abs(stack.peek())) {
                    continue;
                } else if (Math.abs(asteroids[i]) == Math.abs(stack.peek())) {
                    stack.pop();
                } else {
                    do {
                        //asteroids[i]可以继续发生碰撞
                        stack.pop();
                    } while(!stack.isEmpty() && !(asteroids[i] > 0 || stack.peek() < 0) && (Math.abs(asteroids[i]) > Math.abs(stack.peek())));
                    
                    if (stack.isEmpty() || (stack.peek().intValue() ^ asteroids[i]) >>> 31 == 0) {
                        //System.out.println(stack.peek());
                        stack.push(asteroids[i]);
                    } else if (!stack.isEmpty() && (Math.abs(stack.peek().intValue()) == Math.abs(asteroids[i]))) {
                        System.out.println("eq");
                        stack.pop();
                        continue;
                    } 
                }
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;

    }
}
