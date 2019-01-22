package animals;

import java.util.Scanner;

public class AnimalPlayground {
    public static void main(String[] args) {
        Cat leo = new Cat("Лев", 100, 20);
        Cat mao = new Cat("Мао", 40, 13);
        Bowl catBowl = new Bowl(30);
        Scanner scan = new Scanner(System.in);

        catBowl.getFoodRemainigs();

        mao.eat(catBowl.provideFood(mao.getFoodPerBite()));
        mao.eat(catBowl.provideFood(mao.getFoodPerBite()));
        mao.eat(catBowl.provideFood(mao.getFoodPerBite()));

        mao.getSatietyIndex();
        catBowl.getFoodRemainigs();
        mao.getSatietyIndex();

    }
}

