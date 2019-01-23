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

    protected boolean canRun = true;
    protected boolean canSwim = true;
    protected boolean canJump = true;

    protected float satietyIndex = 100;  // Максимальное значение насыщенности животного
    protected int foodPerBite = 20;  // Количество пищи, потребляемое за один цикл
    protected float hungerMeter = 0; // Уровень голода: минимум = 0; максимум = индексу насыщения
    protected boolean isFull = false;  // Голодно животное или нет. По умолчанию голодно

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
     * Метод, отвечающий за потребление пищи животным и проверку его насыщенности
     * На вход получает булевое значение о возможности потребления пищи из
     * конкретной ёмкости.
     * Для определения насыщенности животного высчитывается процентное соотношение
     * уже съеденной пищи к максимальному значению насыщенности (4 состояния).
     *
     * @param canEat
     */
    public void eat(boolean canEat) {
        if (canEat && !isFull) {
            hungerMeter += foodPerBite;
            System.out.println(name + " отъел(а) " + foodPerBite
                    + " единиц еды из миски");
        } else if (!canEat && !isFull) {
            System.out.println("Для " + name + " нужно больше еды в миске");
        }
        float fullnesPercentage = (hungerMeter / (satietyIndex / 100));

        if (fullnesPercentage < 50) {
            System.out.println(name + " всё еще голодный");
        } else if (fullnesPercentage >= 50 && fullnesPercentage < 85) {
            System.out.println(name + " подъел, но не отказался бы еще");
        } else if (fullnesPercentage >= 85 && fullnesPercentage < 95) {
            System.out.println(name + " неплохо покушал");
        } else if (fullnesPercentage >= 95) {
            System.out.println(name + " наелся до отвала");
            isFull = true;
        }
    }

    /**
     * Возвращает количество пищи, съедаемое за один цикл, в виде
     * целочисленного значения.
     *
     * @return
     * */
    public int getFoodPerBite() {
        return foodPerBite;
    }

    /**
     * Выводит информацию о насыщенности животного и возвращает соответствующее
     * булевое значение.
     * @return
     */
    public boolean getSatietyIndex() {
        boolean result = false;
        System.out.println("Статус сытости " + name + ": " + hungerMeter
                + " из " + satietyIndex
                + " (" + hungerMeter / (satietyIndex / 100) + "%)");
        if (!isFull) {
            System.out.println(name + " всё еще что-нибудь бы съел");
        } else {
            System.out.println(name + " больше не хочет есть");
            result = true;
        }
        return result;
    }

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
