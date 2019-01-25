/* Функционал взаимодействия котов/кошек с миской реализован через консольное
* управление. Взаимодействие базируется на постепенном "откусывании" порций еды
* с каждым приемом пищи пока значение сытости не достигнет минимум 95%.
*
* Для более наглядного представления состояния насыщенности животных реализован
* метод запроса, выводящий значения как в количественном, так и процентном
* соотношении.
*/

package animals;

import java.util.Scanner;

public class MainAnimalPlayground {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Cat[] arrayOfCats = new Cat[4];
        arrayOfCats[0] = new Cat("Лев", 100, 20);
        arrayOfCats[1] = new Cat("Мао", 40, 13);
        arrayOfCats[2] = new Cat("Дейв", 200, 30);
        arrayOfCats[3] = new Cat("Лайми", 78, 12);

        Bowl catBowl = new Bowl(300);
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Выберите желаемое действие:\n"
                    + "F - покормить животных\n"
                    + "S - посмотреть сытость животных\n"
                    + "A - наполнить миску\n"
                    + "O - посмотреть сколько осталось еды в миске\n"
                    + "G - посмотреть сводную информацию\n"
                    + "Q - закончить сеанс\n"
                    + "Введите свой ответ: ");

            String answerValue = scan.nextLine();
            /*
            Поглощение количества еды в зависимости от значение переменной
            "укуса за один раз"
             */
            if (answerValue.equals("F") || answerValue.equals("f")) {
                System.out.println();
                for (Cat cat : arrayOfCats) {
                    cat.eat(catBowl.provideFood(cat.getFoodPerBite()));
                    System.out.println();
                }
                /*
                // 7 Задание
                if (catBowl.getFoodRemainigs() == 0) {
                    System.out.println("Миска опустела. Еда будет добавлена.");
                    catBowl.addFood(catBowl.getBowlCapacity());
                }
                */
                pressEnter();
            /*
            Показывает показатели насыщенности животных
             */
            } else if (answerValue.equals("S") || answerValue.equals("s")) {
                for (Cat cat : arrayOfCats) {
                    cat.getSatietyIndex();
                    System.out.println();
                }
                pressEnter();
            /*
            Добавляет указанное количество пищи в миску
             */
            } else if (answerValue.equals("A") || answerValue.equals("a")) {
                int foodAmount;

                System.out.print("Введите желаемое количество "
                        + "(не должно превышать вместимость миски "
                        + "(" + catBowl.getBowlCapacity() + ")): ");
                foodAmount = scan.nextInt();
                catBowl.addFood(foodAmount);
                System.out.println();
                pressEnter();
            /*
            Выводит значение оставшейся еды в миске
             */
            } else if (answerValue.equals("O") || answerValue.equals("o")) {
                System.out.println();
                catBowl.printFoodRemainigs();
                System.out.println();
                pressEnter();
            /*
            Выводит сводную информацию о насыщенности животных
            и заполненности миски
             */
            } else if (answerValue.equals("G") || answerValue.equals("g")) {
                for (Cat cat : arrayOfCats) {
                    cat.getSatietyIndex();
                    System.out.println();
                }
                System.out.println("-----------------");

                System.out.println();
                catBowl.printFoodRemainigs();
                System.out.println();
                pressEnter();
            /*
            Прерывает закрывает сканер и прерывает сессию
             */
            } else if (answerValue.equals("Q") || answerValue.equals("q")) {
                scan.close();
                break;
            /*
            Зацикливает цикл, если введено некорректное значение
             */
            } else {
                System.out.println("\nВведите еще раз\n");
            }
        }
    }

    /**
     * Выводит пустую строку для большей удобочитаемости
     */
        private static void pressEnter() {
            System.out.print("Нажмите ENTER чтобы продолжить\n");
            scan.nextLine();
        }
    }

