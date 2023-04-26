package Objects;

public abstract class Animal {
    public abstract void run(int distance);
    public void swim(){
        System.out.println("swim: false");
    };
    public abstract void jump(float height);
}
