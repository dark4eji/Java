package classes.practice;

public class Employee {
    private String name;
    private String occupation;
    private String email;

    private long number;
    private int salary;
    private int age;

    public Employee(String name, String occupation, String email,
                    long number, int salary, int age) {
        this.name = name;
        this.occupation = occupation;
        this.email = email;

        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("Name: " + this.name + "\n" +
                "Occupation: " + this.occupation + "\n" +
                "Ebox: " + this.email + "\n" +
                "Number: " + this.number + "\n" +
                "Salary: " + this.salary + "\n" +
                "Age: " + this.age);
        System.out.println();
    }

    public int getAge(){
        return this.age;
    }

}
