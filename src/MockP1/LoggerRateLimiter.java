package MockP1;

import java.util.HashMap;
import java.util.Map;

class LoggerRateLimiter {
    Map<String, Integer> messages;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        messages = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (messages.containsKey(message) && timestamp - messages.get(message) < 10) return false;
        messages.put(message, timestamp);
        return true;
    }

    public static void main(String[] args) {

        LoggerRateLimiter logger = new LoggerRateLimiter();

// logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo"));

// logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar"));

// logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo"));

// logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar"));

// logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo"));

// logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}

/**
 * Your LoggerRateLimiter object will be instantiated and called as such:
 * LoggerRateLimiter obj = new LoggerRateLimiter();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */