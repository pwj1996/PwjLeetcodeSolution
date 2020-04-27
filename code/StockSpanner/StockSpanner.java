class StockSpanner {

    private Stack<Integer> stackTempe, stackRes;
    public StockSpanner() {
        stackTempe = new Stack<>();
        stackRes = new Stack<>();
    }
    
    public int next(int price) {
        int res = 0;
        while (!stackTempe.isEmpty() && price >= stackTempe.peek() ) {
            stackTempe.pop();
            res += stackRes.pop();
        } 

        res++;
        stackTempe.push(price);
        stackRes.push(res);
               
        return res;        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
