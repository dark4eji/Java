package animals;

public class AnimalPlayground {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog gabeTheDog = new Dog("Пёсик Гейб", 200, 5, 1);
        Dog sharikTheDog = new Dog("Шарик");
        Cat cat1 = new Cat();
        Cat murzikTheCat = new Cat("Мурзик");

        dog1.run(40.5);
        dog1.swim(5);
        cat1.swim(2);
        cat1.jump(1);
        gabeTheDog.run(40);
        gabeTheDog.voice();
        gabeTheDog.tellStats();
        sharikTheDog.voice();
        murzikTheCat.run(40);
        }
    }

