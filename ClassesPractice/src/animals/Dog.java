package animals;

public class Dog extends Animal {
    public Dog(){
        this.runDistanceMax = 500;
        this.swimDistanceMax = 10;
        this.jumpHeightMax = 0.5;
        this.name = "Собака";
    }

    public Dog(String name,
               double runDistanceMax,
               double swimDistanceMax,
               double jumpHeightMax){
        super(name, runDistanceMax, swimDistanceMax, jumpHeightMax);
    }

    public Dog(String name){
        super(name);
    }

    @Override
    public void voice(){
        System.out.println(this.name + " гавкает");
    }
}
