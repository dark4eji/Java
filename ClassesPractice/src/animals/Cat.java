package animals;

public class Cat extends Animal {
    public Cat(){
        this.canSwim = false;
        this.runDistanceMax = 200;
        this.jumpHeightMax = 2;
        this.name = "Кот";
    }

    public Cat(String name,
               double runDistanceMax,
               double swimDistanceMax,
               double jumpHeightMax){
        super(name, runDistanceMax, swimDistanceMax, jumpHeightMax);
        this.canSwim = false;
    }

    public Cat(String name){
        super(name);
        this.runDistanceMax = rand.nextInt(300);
        this.canSwim = false;
    }

    @Override
    public void voice(){
        System.out.println(this.name + " мяукает");
    }
}
