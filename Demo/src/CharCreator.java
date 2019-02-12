import race.Human;
import race.Orc;

import java.util.ArrayList;
import java.util.Scanner;

public class CharCreator {
    Scanner scan = new Scanner(System.in);
    public CharCreator(){

    }

    public void placeAction(ArrayList list){
        Human Jake = new Human("Jake");
        Orc Khar = new Orc("Khar");

        boolean result = true;
            while(result){
                System.out.println("Введите команду: ");
                String x = scan.nextLine();
                if (x.equals("h")){
                    Khar.getDamage(Jake.hitEnemy());
                } else if (x.equals("t")) {
                    System.out.println("Сегодня сражаются: ");
                    Khar.getName();
                    Jake.getName();
                }

            else {
                result = false;
            }
        }
    }

    public Orc[] createChar(){
        boolean result = true;

        Orc[] orcs = new Orc[2];

        while(result){
            System.out.println("Кого создаём?\n" +
                    "O — орк\n" +
                    "H — чулавек\n" +
                    "Q — выйти из режима создания");
            String in = scan.nextLine();
            if (in.equals("Q") || in.equals("q")) {
                result = false;
            } else if (in.equals("O") || in.equals("o")) {
                System.out.println("Введите имя");
                String name = scan.nextLine();

                Orc orc = new Orc(name);
                orcs[0] = orc;
            }
        }
        return orcs;
    }

}
