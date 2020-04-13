package question355;

import java.util.*;

public class Twitter {
    //全局时间戳，每条博文发送前自增1
    private static int timestamp = 0;

    //推文实体
    private class Tweet {
        public int id;
        public int timestamp;
        public Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    //用户和推文列表的关系
    HashMap<Integer, Tweet> twitter;

    //用户和关注列表的关系
    HashMap<Integer, HashSet<Integer>> followed;

    //返回最近动态要用的数据结构，优先队列默认是小顶堆，需要传一个Comparator接口实现大顶堆
    PriorityQueue<Tweet> maxHeap;

    /**
     * 初始化
     */
    public Twitter() {
        twitter = new HashMap<>();
        followed = new HashMap<>();
        maxHeap = new PriorityQueue<>((e1,e2)->e2.timestamp-e1.timestamp);
    }

    /**
     * user 发表一条 tweet 动态
     * 时间复杂度：O(1)
     */
    public void postTweet(int userId, int tweetId) {
        //全局时间自增
        timestamp++;
        //用户和推文列表映射存在则新增一条推文
        if (twitter.containsKey(userId)) {
            //头插法
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        } else {
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    /**
     * 返回该 user 关注的人（包括他自己）最近的动态 id，
     * 最多 10 条，而且这些动态必须按从新到旧的时间线顺序排列。
     * 时间复杂度：O(nlogn)   n是参数用户的关注数量
     */
    public List<Integer> getNewsFeed(int userId) {
        //因为堆是全局适用的，用之前要进行clear
        maxHeap.clear();
        //自己的推文也要记录
        if (twitter.containsKey(userId)) maxHeap.offer(twitter.get(userId));
        //将关注列表所有用户的推文列表头节点入堆
        HashSet<Integer> followedList = followed.get(userId);
        if (followedList != null && followedList.size() > 0) {
            for (Integer followedId : followedList) {
                Tweet tweet = twitter.get(followedId);
                if (tweet != null) {
                    maxHeap.offer(tweet);
                }
            }
        }
        //取出十条最新的放入结果集
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet tweet = maxHeap.poll();
            res.add(tweet.id);
            count++;
            if (tweet.next != null) maxHeap.offer(tweet.next);
        }
        return res;
    }

    /**
     * follower 关注 followee，如果 Id 不存在则新建
     * 时间复杂度：O(1)
     */
    public void follow(int followerId, int followeeId) {
        //不能关注自己
        if (followeeId == followerId) return;
        HashSet<Integer> set = followed.get(followerId);
        if (set == null) {
            HashSet init = new HashSet();
            init.add(followeeId);
            followed.put(followerId, init);
        } else {
            //已关注过
            if (set.contains(followeeId)) return;
            set.add(followeeId);
        }
    }

    /**
     * follower 取关 followee，如果 Id 不存在则什么都不做
     * 时间复杂度：O(1)
     */
    public void unfollow(int followerId, int followeeId) {
        //不能取关自己
        if (followeeId == followerId) return;
        HashSet<Integer> set = followed.get(followerId);
        if (set == null) {
            return;
        }
        set.remove(followeeId);
    }
}
