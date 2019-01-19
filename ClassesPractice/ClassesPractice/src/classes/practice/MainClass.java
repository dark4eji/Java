package classes.practice;

public class MainClass {
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Ivanov Sergey Petrovich",
                "Programmer", "ipivanov@box.com",
                845453322, 400, 21);
        employeeArray[1] = new Employee("Mikhaylov Mikhail Mikhailovich",
                "Plumber", "newage@mailbox.com",
                922343443, 100, 45);
        employeeArray[2] = new Employee("Petrov Alex Adamovich",
                "Architect", "townbuild@emailbox.com",
                454534355, 800, 55);
        employeeArray[3] = new Employee("Azizov Rachick Gegamovich",
                "Surgeon", "startrrek@newbox.com",
                544567433, 500, 27);
        employeeArray[4] = new Employee("Stankyavichene Maria Romanovna",
                "Psychiatrist", "luckystar@mail.com",
                834545432, 250, 32);

        for (int i = 0; i < employeeArray.length; i++) {
           if (employeeArray[i].getAge() > 40) {
               employeeArray[i].getInfo();
           }
        }
    }
}
