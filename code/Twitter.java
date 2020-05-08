class Twitter {

    //发送推文，检索推文；
    private Map<Integer, LinkedList<Message>> messageList;
    //维护用户follow关系
    private Map<Integer, Set<Integer>> userList;

    private int time;

    /** Initialize your data structure here. */
    public Twitter() {
        messageList = new HashMap<>();
        userList = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        System.out.println("postTweet");
        Message message = new Message(tweetId);
        if (messageList.containsKey(userId)) {
            LinkedList<Message> temp = messageList.get(userId);
            temp.addFirst(message);
        } else {
            LinkedList<Message> temp = new LinkedList<>();
            temp.addFirst(message);
            messageList.put(userId, temp);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        
        //为每一个用户建立一个堆维护最近十条tweet
        //PriorityQueue默认最小堆，在此设置为最大堆
        PriorityQueue<Message> heap = new PriorityQueue<>((m1, m2) -> m2.getTimeId() - m1.getTimeId());
        int count = 0;

        if (messageList.containsKey(userId)) {
            //先初始化堆
            LinkedList<Message>  = messageList.get(userId);
            //System.out.println(userIdMessageList.size());
            for (Message message: userIdMessageList) {
                if (count >= 10) {
                    break;
                } 
                heap.add(message);
                count++;
            }
        }
        
        System.out.println("getNewFeed");
        //所有的follow user
        if (userList.containsKey(userId)) {
            Set<Integer> allUser = userList.get(userId);
            //排除自己关注自己的情况
            if (allUser.contains(userId)) {
                allUser.remove(userId);
            }
            for (int uid: allUser) {
                System.out.println(uid);
                count = 0;
                
                //uid用户可能没有发言
                LinkedList<Message> iterQueue = messageList.get(uid);
                if (iterQueue != null) {
                    for (Message message: iterQueue) {
                        if (count >= 10) {
                            break;
                        }
                        heap.add(message);
                        count++;
                    }
                }
                
            }
        }
        
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            if (heap.isEmpty()) {
                break;
            }
            Message temp = heap.poll();
            res.add(temp.getmId());
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        System.out.println("follow");
        if (userList.containsKey(followerId)) {
            Set<Integer> temp = userList.get(followerId);
            temp.add(followeeId);
        } else {
            Set<Integer> temp = new HashSet<>();
            temp.add(followeeId);            
            userList.put(followerId, temp);
        }
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        System.out.println("unFollow");
        if (userList.containsKey(followerId)) {
            Set<Integer> temp = userList.get(followerId);
            if (temp.contains(followeeId)) {
                temp.remove(followeeId);
            } else {
                return;
            }
        } else {
            //没有
            return;
        }
    }
}

class Message{
    Message(int mId) {
        time++;
        this.mId = mId;
        this.timeId = time;
    }
    private int mId;
    private int timeId;

    public int getmId() {
        return this.mId;
    }
    public int getTimeId() {
        return this.timeId;
    }

    static int time = 0;
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
