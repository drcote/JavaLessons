package Objects;

public abstract class Animal {
    protected int limitRun;
    protected int limitSwim;
    protected float limitJump;

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public abstract void jump(float height);
}
