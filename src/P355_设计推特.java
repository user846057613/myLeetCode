import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class P355_设计推特 {
    AtomicLong index ;
    HashMap<Integer,User> map;
    /** Initialize your data structure here. */
    public P355_设计推特() {
        map = new HashMap<>();
        index = new AtomicLong(1);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        map.putIfAbsent(userId, new User(userId));
        User user = map.get(userId);
        user.postTweet(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        map.putIfAbsent(userId, new User(userId));
        User user = map.get(userId);
        List<Integer> ans = new ArrayList<>();
        TreeSet<NewsFeed> newsFeeds = new TreeSet<>((o1 , o2) -> {
            return o2.currentTime < o1.currentTime ? -1 :
                    (o2.currentTime == o1.currentTime ? 0 : 1);
        });
        newsFeeds.addAll(user.myNews);
        for (User user1 : user.follow) {
            newsFeeds.addAll(user1.myNews);
        }
        int counter = 1;
        for (NewsFeed feed : newsFeeds) {
            ans.add(feed.tweetId);
            counter++;
            if(counter > 10) {
                break;
            }
        }
        return ans;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new User(followerId));
        map.putIfAbsent(followeeId, new User(followeeId));
        User follower = map.get(followerId);
        User followee = map.get(followeeId);
        follower.follow(followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        map.putIfAbsent(followerId, new User(followerId));
        map.putIfAbsent(followeeId, new User(followeeId));
        User follower = map.get(followerId);
        User followee = map.get(followeeId);
        follower.unfollow(followee);
    }

    class User{
        private int userId;
        private HashSet<User> follow;
        private TreeSet<NewsFeed> myNews;
        User(int userId) {
            follow = new HashSet<>();
            myNews = new TreeSet<>((o1 , o2) -> {
                return o2.currentTime < o1.currentTime ? -1 :
                        (o2.currentTime == o1.currentTime ? 0 : 1);
            });
            this.userId = userId;
        }

        public void postTweet(int tweetId) {
            NewsFeed news = new NewsFeed(tweetId, userId, index.getAndIncrement());
            myNews.add(news);
        }

        public void follow(User user) {
            follow.add(user);
        }

        public void unfollow(User user) {
            if(follow.contains(user)) {
                follow.remove(user);
            }
        }
    }

    class NewsFeed {
        int tweetId;
        int userId;
        long currentTime;
        NewsFeed(int tweetId, int userId, long currentTime) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.currentTime = currentTime;
        }
    }

    @Test
    public void test() {
        P355_设计推特 p = new P355_设计推特();
        p.postTweet(1,5);
        p.postTweet(1,3);
        List<Integer> i = p.getNewsFeed(1);
        System.out.println(Arrays.toString(i.toArray()));
    }
}


/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
