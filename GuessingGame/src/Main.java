import java.util.Scanner;

public class Main {
    private static int counter = 0;
    private static int tries = 10;
    private static boolean check = true;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Наша задача угадать число за " + tries + " попыток");
        for (int i = 10; i <= 30; i += 10) {
            System.out.println(i);
            playLevel(i);
            if (!check) break;
        }
        input.close();
    }

    public static void playLevel(int range) {
        int number = (int) (Math.random() * range);
        while (check) {
            counter += 1;
            tries -= 1;
            System.out.println("Угадайте число от 0 до " + range +
                    "\nПопытка номер " + counter + " (осталось " + tries + ")\n"
                    + "Введите число: ");
            int input_number = input.nextInt();

            if (input_number == number) {
                System.out.println("Вы угадали!");

                finalAnswer();
            } else if (input_number < number) {
                System.out.println("Введённое число меньше");
            } else if (input_number > number)
                System.out.println("Введённое число больше");

            if (tries == 0) {
                System.out.println("У вас закончились попытки. Загаданное число = "
                        + number + ".");
                finalAnswer();
            }
        }
    }

    private static void finalAnswer() {
        while (true) {
            System.out.println("Продолжаем?\n" +
                    "Введите свой ответ (Y/N): ");
            String retry = input.next();
            if (retry.equals("Y") || retry.equals("y")) {
                tries += counter;
                counter = 0;
                break;
            } else if (retry.equals("N") || retry.equals("n")) {
                System.out.println("До встречи!");
                check = false;
                break;
            } else {
                System.out.println("Некорректный ввод, попробуйте еще раз.");
            }
        }
    }
}


