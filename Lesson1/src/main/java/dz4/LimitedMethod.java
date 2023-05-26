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
        if (callCount >= maxCallsPerMinute) {
            if (currentTime - lastCallTime > 60000) {
                lastCallTime = currentTime;
                callCount = 1;
                method.call();
            } else {
                System.out.println("Method is called too often, skipping call");
            }
        } else {
            callCount++;
            method.call();
        }

    }
}
