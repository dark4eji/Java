package animals;

public class Bowl {
    private int bowlCapacity = 40;
    private String name = "Миска";
    private int remainings;


    public Bowl(){
    }

    public Bowl(int bowlCapacity) {
        this.bowlCapacity = bowlCapacity;
        this.remainings = bowlCapacity;
    }

    public Bowl(String name) {
        this.name = name;
    }

    public Bowl(String name, int bowlCapacity) {
        this.name = name;
        this.bowlCapacity = bowlCapacity;
        this.remainings = bowlCapacity;
    }

    public void addFood(int foodAmount){
        if (remainings + foodAmount > bowlCapacity) {
            System.out.println("Сейчас в миске " + remainings
                    + " единиц еды. Указанное количество в неё не поместится");
        } else if (remainings + foodAmount <= bowlCapacity) {
            remainings += foodAmount;
            System.out.println("Вы пополнили миску на " + foodAmount
                    + " единиц\n" +
                    "Миска наполнена на " + remainings + " единиц из "
                    + bowlCapacity);
        }
    }

    public boolean provideFood(int foodAmount) {
        boolean result = false;
        if (remainings - foodAmount < 0) {
            result = false;
        } else {
            remainings -= foodAmount;
            result = true;
        }
        return result;
    }

    public void getFoodRemainigs() {
        System.out.println("Cейчас в миске " + remainings + " единиц еды");
    }
}
