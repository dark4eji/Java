package animals;

import java.util.Random;

/**
 * Абстрактный класс, выступающий в качестве родительского для
 всех классов животных
 */
public abstract class Animal {
    Random rand = new Random();

    protected double runDistanceMax;
    protected double swimDistanceMax;
    protected double jumpHeightMax;

    protected String name;

    protected boolean canRun;  // Может ли животное бегать. По умолчанию true
    protected boolean canSwim; // Может ли животное плавать. По умолчанию true
    protected boolean canJump; // Может ли животное прыгать. По умолчанию true

    /**
     * Конструктор без аргументов
     */
    public Animal() {
        this.name = "Животное";
        this.canRun = true;
        this.canSwim = true;
        this.canJump = true;
    }

    /**
     * Конструктор, принимающий в качестве аргументов имя, и максимальные значения для действий
     */
    public Animal(String name,
                  double runDistanceMax,
                  double swimDistanceMax,
                  double jumpHeightMax) {
        this.name = name;
        this.runDistanceMax = runDistanceMax;
        this.swimDistanceMax = swimDistanceMax;
        this.jumpHeightMax = jumpHeightMax;
        this.canRun = true;
        this.canSwim = true;
        this.canJump = true;
    }

    /**
     * Конструктор, принимающий в качестве аргументов только имя, остальные значения генерирутся случайно
     */
    public Animal(String name) {
        this.name = name;
        this.runDistanceMax = rand.nextInt(700);
        this.swimDistanceMax = rand.nextInt(15);
        this.jumpHeightMax = 0.1 + (1 - 0.1) * rand.nextDouble();
        this.canRun = true;
        this.canSwim = true;
        this.canJump = true;
    }

    /**
     * Метод, отвечающий за возможность бега.
     */
    public boolean run(double runDistance){
        boolean result = false;
        if (this.canRun && runDistance <= runDistanceMax && runDistance > 0) {
            result = true;
            runDistanceMax -= runDistance;
            System.out.println("(run: true) " + this.name + " пробегает " + runDistance +
                    " м. и может бежать еще " + runDistanceMax);
        } else if (!this.canRun) {
            System.out.println("(run: false) " + this.name + " не умеет бегать");
        } else {
            System.out.println("(run: false) " + this.name + " не может столько пробежать");
        }
        return result;
    }

    /**
     * Метод, отвечающий за возможность прыжка.
     */
    public boolean jump(double height) {
        boolean result = false;
        if (this.canJump && height <= jumpHeightMax && height > 0) {
            result = true;
            System.out.println("(jump: true) " + this.name + " подпрыгивает на " + height +
                    " м");
        } else if (!this.canJump) {
            System.out.println("(jump: false) " + this.name + " не умеет прыгать");
        } else {
            System.out.println("(jump: false) " + this.name + " не может подпрыгнуть на такую высоту");
        }
        return result;
    }

    /**
     * Метод, отвечающий за возможность плавания.
     */
    public boolean swim(double swimDistance) {
        boolean result = false;
        if (this.canSwim && swimDistance <= swimDistanceMax
                && swimDistance > 0 ) {
            result = true;
            swimDistanceMax -= swimDistance;
            System.out.println("(swim: true) " + this.name + " проплывает "
                    + swimDistance + " м. и может плыть еще " + swimDistanceMax);
        } else if (!this.canSwim) {
            System.out.println("(swim: false) " + this.name + " не умеет плавать");
        } else {
            System.out.println("(swim: false) " + this.name + " не может столько плыть");
        }
        return result;
    }

    /**
     * Абстрактный метод, отвечающий за голосовые сигналы животного
     */
    public abstract void voice();

    /**
     * Метод, выводящий список текущих значений-характеристик животного.
     */
    public void tellStats() {

        System.out.println("| " + this.name + " может: ");
        if (canRun) {
            System.out.println("| " + " - Бежать " + runDistanceMax + " м.");
        }

        if (canJump) {
            System.out.println("| " + " - Прыгать на " + jumpHeightMax + " м.");
        }

        if (canSwim) {
            System.out.println("| " + " - Заплывать на " + swimDistanceMax + " м.");
        }
    }
}
