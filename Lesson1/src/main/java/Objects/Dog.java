package Objects;

public class Dog extends Animal {

    public Dog() {
        this.limitRun = 500;
        this.limitJump = 0.5f;
        this.limitSwim = 10;
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
        System.out.println("jump: " + (height < this.limitJump));
    }

    @Override
    public void swim(int distance) {
        System.out.println("swim: " + (distance < this.limitSwim));
    }
}
