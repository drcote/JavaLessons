package Objects;

import java.util.Objects;

public abstract class Animal {

    private static final String PCONST = printAndGetStringConst();
    protected int limitRun;
    protected int limitSwim;
    protected float limitJump;

    static {
        System.out.println("Parent static code block");
    }

    {
        System.out.println("Parent non static code block");
    }

    public Animal() {
        System.out.println("Parent constructor");
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public abstract void jump(float height);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return limitRun == animal.limitRun && limitSwim == animal.limitSwim && Float.compare(animal.limitJump, limitJump) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limitRun, limitSwim, limitJump);
    }

    private static String printAndGetStringConst() {
        System.out.println("Parent_CONST initialization");
        return "Parent_CONST";
    }
}
