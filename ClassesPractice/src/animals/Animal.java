package animals;

import java.sql.SQLOutput;
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

    protected boolean canRun = true;
    protected boolean canSwim = true;
    protected boolean canJump = true;

    protected int satietyIndex = 100;
    protected int foodPerBite = 20;
    protected int hungerMeter = 0;
    protected boolean isFull = false;
    /**
     * Конструктор без аргументов
     */
    public Animal() {
        this.name = "Животное";
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
    }

    /**
     * Конструктор, принимающий в качестве аргументов только имя, остальные значения генерирутся случайно
     */
    public Animal(String name) {
        this.name = name;
        this.runDistanceMax = rand.nextInt(700);
        this.swimDistanceMax = rand.nextInt(15);
        this.jumpHeightMax = 0.1 + (1 - 0.1) * rand.nextDouble();
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
    public void eat(boolean canEat) {
        if (canEat && !isFull) {
            hungerMeter += foodPerBite;
           System.out.println(name + " поел(а) из миски");
        } else if (!canEat) {
            System.out.println("Для " + name + " нужно больше еды в миске");
            checkSatiety(canEat);
        }

        if (hungerMeter < satietyIndex) {
            System.out.println(name + " всё еще хочет есть");
        } else if (hungerMeter >= satietyIndex) {
            isFull = true;
            System.out.println(name + " больше не хочет есть");
        }
    }

    private void checkSatiety(boolean canEat) {
        int value = 0;
        for (int i = 0; i <= 100; i++) {
            value = satietyIndex / 100 * i;
            if ( value == hungerMeter ) {
                value = i;
                break;
            }
        }
        System.out.println(name + " сыт на " + value + " процентов");
    }

    public int getFoodPerBite() {
        return foodPerBite;
    }

    public void getSatietyIndex() {
        System.out.println("Статус сытости " + name + ": " + hungerMeter
                + " из " + satietyIndex);
        if (!isFull) {
            System.out.println(name + " всё еще хочет есть");
        } else {
            System.out.println(name + " больше не хочет есть");
        }
    }

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
