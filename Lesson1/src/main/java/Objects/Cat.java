package Objects;

public class Cat extends Animal {

    public Cat() {
        this.limitRun = 200;
        this.limitJump = 2;
    }


    @Override
    public void run(int distance) {
        System.out.println("run: " + (distance < this.limitRun));
    }

    @Override
    public void swim(int distance) {
        System.out.println("swim: кот не умеет плавать");
    }

    @Override
    public void jump(float height) {
        System.out.println("jump: " + (height < this.limitJump));
    }

}
