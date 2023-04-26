package Objects;

public class Dog extends Animal {
    private int limitRun;

    public Dog() {
        this.limitRun = 500;
    }

    public Dog(int limitRun) {
        this.limitRun = limitRun;
    }

    @Override
    public void run(int distance) {
        System.out.println("run: " + (distance < this.limitRun));
    }

    @Override
    public void jump(float height) {
        System.out.println("jump: " + (height < 0.5));
    }

    public void swim(int distance) {
        System.out.println("swim: " + (distance < 10));
    }
}
