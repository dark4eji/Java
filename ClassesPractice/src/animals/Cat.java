package animals;

public class Cat extends Animal {
    public Cat(){
        this.canSwim = false;  // Переопределяется родительское поле т.к. кот не может плавать
        this.runDistanceMax = 200;
        this.jumpHeightMax = 2;
        this.name = "Кот";
    }

    public Cat(String name,
               double runDistanceMax,
               double jumpHeightMax){
        this.name = name;
        this.runDistanceMax = runDistanceMax;
        this.jumpHeightMax = jumpHeightMax;
        this.canSwim = false;
    }

    public Cat(String name){
        super(name);
        this.runDistanceMax = rand.nextInt(300);
        this.canSwim = false;
    }

    public Cat(String name, int satietyIndex, int foodPerBite) {
        super(name);
        this.satietyIndex = satietyIndex;
        this.foodPerBite = foodPerBite;
    }

    @Override
    public void voice(){
        System.out.println(this.name + " мяукает");
    }
}
