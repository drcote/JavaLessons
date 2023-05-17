package dz4;

public class LimitedMethod implements Method {
    private final Method method;
    private final int maxCallsPerMinute;
    private int callCount = 0;
    private long lastCallTime = 0;

    public LimitedMethod(Method method, int maxCallsPerMinute) {
        this.method = method;
        this.maxCallsPerMinute = maxCallsPerMinute;
    }
    @Override
    public void call() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - lastCallTime < 60000) && (callCount >= maxCallsPerMinute)) {
            System.out.println("Method is called too often, skipping call");
            return;
        }
        lastCallTime = currentTime;
        callCount++;
        method.call();
    }
}
