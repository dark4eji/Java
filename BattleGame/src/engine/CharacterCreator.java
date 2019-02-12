package engine;

import race.Human;
import race.Orc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterCreator {
    Scanner scan = new Scanner(System.in);
    private List<Object> charList = new ArrayList<>();

    public CharacterCreator() {

    }

    public void createChar() {
        boolean check = true;
        int counter = 0;
        do {
            System.out.println("Создайте 2 персонажей: \n"
                    + "O - добавить орка\n"
                    + "H - добавить человека\n"
                    + "Q - выйти");
            String input = scan.nextLine();

            if (input.equals("q")) {
                check = false;
            } else if (input.equals("h") || input.equals("H")) {
                counter++;
                System.out.print("Введите имя: ");
                String name = scan.nextLine();
                charList.add(new Human(name));
            } else if (input.equals("o") || input.equals("O")) {
                System.out.print("Введите имя: ");
                String name = scan.nextLine();
                counter++;
                charList.add(new Orc(name));
            } else {
                System.out.println("Again");
            }
        } while (counter < 2);
    }


    public List<Object> getCharList(){
        return charList;
    }
}