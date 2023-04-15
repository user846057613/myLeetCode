import java.util.*;

public class P355_设计推特2 {
    HashMap<Integer, HashSet<Integer>> follow;
    HashMap<Integer, News> user;
    private int index;

    /** Initialize your data structure here. */
    public P355_设计推特2() {
        follow = new HashMap<>();
        user = new HashMap<>();
        index = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        News newNews = new News(userId, tweetId, ++index);
        if(user.containsKey(userId)) {
            News userNews = user.get(userId);
            newNews.next = userNews;
        }
        user.put(userId, newNews);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<News> queue = new PriorityQueue<>(((o1, o2) -> o2.timeStamp - o1.timeStamp));
        List<Integer> ans = new ArrayList<>();
        News news = user.getOrDefault(userId, null);
        if(news != null) queue.offer(news);
        Set<Integer> followee = follow.getOrDefault(userId, null);
        if(followee != null) {
            for (Integer integer : followee) {
                if(user.containsKey(integer) && user.get(integer) != null) {
                    queue.offer(user.get(integer));
                }
            }
        }
        int count = 1;
        while (!queue.isEmpty() && count <= 10) {
            News now = queue.poll();
            ans.add(now.tweetId);
            now = now.next;
            if(now != null) {
                queue.offer(now);
            }
            count++;
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) {
            return;
        }
        follow.putIfAbsent(followerId, new HashSet<>());
        HashSet<Integer> follower = follow.get(followerId);
        follower.add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId) {
            return;
        }
        follow.putIfAbsent(followerId, new HashSet<>());
        HashSet<Integer> follower = follow.get(followerId);
        if(follower.contains(followeeId)) {
            follower.remove(followeeId);
        }
    }

    class News{
        int userId;
        int tweetId;
        int timeStamp;
        News next;

        public News(int userId, int tweetId, int timeStamp) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.timeStamp = timeStamp;
        }
    }

}
