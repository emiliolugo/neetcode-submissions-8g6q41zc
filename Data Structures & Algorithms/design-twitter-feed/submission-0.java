class Twitter {
    Map<Integer, Set<Integer>> follows;
    List<Integer> userIds;
    List<Integer> tweetIds;

    public Twitter() {
        follows = new HashMap<>();
        userIds = new ArrayList<>();
        tweetIds = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userIds.add(userId);
        tweetIds.add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        for(int i = tweetIds.size()-1; i >= 0;i--){
            if(follows.getOrDefault(userId, new HashSet<>()).contains(userIds.get(i)) || userIds.get(i)==userId){
                news.add(tweetIds.get(i));
            }
            if(news.size()==10){
                return news;
            }
        }
        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId)){
            Set<Integer> tmp = new HashSet<>();
            tmp.add(followeeId);
            follows.put(followerId,tmp);
        }
        else{
            follows.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.getOrDefault(followerId, new HashSet<>()).contains(followeeId))
        {
        follows.get(followerId).remove(followeeId);}
    }
}
