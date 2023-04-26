package Objects;

public class Cat extends Animal {
    @Override
    public void run(int distance) {
        System.out.println("run: " + (distance < 200));
    }

    @Override
    public void jump(float height) {
        System.out.println("jump: " + (height < 2));
    }
}
