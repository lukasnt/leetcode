package design_twitter

import java.util.TreeMap

class Twitter() {

    val following: MutableMap<Int, MutableSet<Int>> = HashMap()
    val tweets: MutableMap<Int, ArrayDeque<Pair<Int, Int>>> = HashMap()
    var time = 0

    fun postTweet(userId: Int, tweetId: Int) {
        if (tweets.containsKey(userId)) {
            tweets[userId]!!.addFirst(Pair(time++, tweetId))
        } else {
            val init = ArrayDeque<Pair<Int, Int>>()
            init.add(Pair(time++, tweetId))
            tweets[userId] = init
        }
        if (!following.containsKey(userId)) {
            val init = HashSet<Int>()
            init.add(userId)
            following[userId] = init
        }
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val followingSet = following[userId]?.toMutableSet() ?: return emptyList()
        val sorted = TreeMap<Int, Int>{ a, b -> b - a }
        for (i in 0 until 10) {
            val removedFollowers = HashSet<Int>()
            for (followee in followingSet) {
                if (tweets.containsKey(followee) && i < tweets[followee]!!.size) {
                    val tweet = tweets[followee]!![i]
                    if (sorted.size < 10 || tweet.first > sorted.lastKey()) {
                        sorted[tweet.first] = tweet.second
                        if (sorted.size > 10) sorted.remove(sorted.lastKey())
                    } else {
                        removedFollowers.add(followee)
                    }
                } else {
                    removedFollowers.add(followee)
                }
            }
            followingSet.removeAll(removedFollowers)
            if (followingSet.isEmpty()) break
        }
        return sorted.values.toList()
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (following.containsKey(followerId)) {
            following[followerId]!!.add(followeeId)
        } else {
            val init = HashSet<Int>()
            init.add(followerId)
            init.add(followeeId)
            following[followerId] = init
        }
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (following.containsKey(followerId)) {
            following[followerId]!!.remove(followeeId)
        }
    }

}

fun main() {
    var twitter = Twitter()
    println(twitter.getNewsFeed(1))
    println(twitter.getNewsFeed(2))
    twitter.postTweet(1, 5)
    println(twitter.getNewsFeed(1))
    twitter.follow(1, 2)
    twitter.postTweet(2, 6)
    println(twitter.getNewsFeed(1))
    twitter.unfollow(1, 2)
    println(twitter.getNewsFeed(1))
    twitter.postTweet(2, 10)
    twitter.postTweet(2, 11)
    twitter.postTweet(2, 12)
    twitter.postTweet(2, 13)
    twitter.postTweet(2, 14)
    twitter.postTweet(2, 15)
    twitter.postTweet(2, 16)
    twitter.postTweet(2, 17)
    twitter.postTweet(2, 18)
    println(twitter.getNewsFeed(2))
    twitter.postTweet(2, 19)
    println(twitter.getNewsFeed(2))
    twitter.follow(1, 2)
    println(twitter.getNewsFeed(1))
    twitter.postTweet(1, 50)
    println(twitter.getNewsFeed(1))
    println(twitter.getNewsFeed(2))


    twitter = Twitter()
    twitter.postTweet(1, 5)
    twitter.follow(1, 2)
    twitter.follow(2, 1)
    println(twitter.getNewsFeed(2))
    twitter.postTweet(2, 6)
    println(twitter.getNewsFeed(1))
    println(twitter.getNewsFeed(2))
}