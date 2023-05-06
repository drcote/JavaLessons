package objects;

public class Dog extends Animal {
    private static final String CONST = printAndGetStringConst();

    static {
        System.out.println("Child static code block");
    }

    {
        System.out.println("Child non static code block");
    }

    public Dog() {
        this.limitRun = 500;
        this.limitJump = 0.5f;
        this.limitSwim = 10;
    }

    public Dog(int limitRun, float limitJump, int limitSwim) {

        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
        System.out.println("Child constructor");
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

    private static String printAndGetStringConst() {
        System.out.println("CONST initialization");
        return "CONST";
    }
}
