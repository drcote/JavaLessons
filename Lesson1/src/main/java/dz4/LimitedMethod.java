package dz4;

import java.util.*;

public class LimitedMethod implements Method {
    private final Method method;
    private final int maxCallsPerMinute;
    private Queue<Date> queue;
    private int callCount = 0;
    private long lastCallTime = 0;

    long timeToQueue;

    public LimitedMethod(Method method, int maxCallsPerMinute, long timeToQueue) {
        this.method = method;
        this.maxCallsPerMinute = maxCallsPerMinute;
        this.queue =  new LinkedList<>();
        this.timeToQueue = timeToQueue;

    }

    @Override
    public void call() {
        if(queue.size() >= maxCallsPerMinute){
            Date currentTime = new Date();
            if ((currentTime.getTime() - queue.peek().getTime()) > timeToQueue) {
                queue.remove();
                queue.offer(currentTime);
                method.call();
            } else{
                System.out.println("Method is called too often, skipping call");
            }
        } else {
            queue.offer(new Date());
            method.call();
        }

    }
}
