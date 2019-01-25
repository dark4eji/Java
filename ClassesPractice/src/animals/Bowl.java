package animals;

public class Bowl {
    private int bowlCapacity = 40;  // Вместимость миски
    private String name = "Миска";
    private int remainings;  // Переменная-буфер, хранящая текущее значение еды

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

    /**
     * Добавляет в миску указанное количество еды.
     * Выполняет проверку на превышение вместимости.
     *
     * @param foodAmount
     */
    public void addFood(int foodAmount){
        if (remainings + foodAmount > bowlCapacity) {
            System.out.println("Сейчас в миске " + remainings
                    + " единиц еды. Указанное количество в неё не поместится");
        } else if (remainings + foodAmount <= bowlCapacity) {
            remainings += foodAmount;
            System.out.println("Вы пополнили миску на " + foodAmount
                    + " единиц\n" + "Миска наполнена на "
                    + remainings + " единиц из "
                    + bowlCapacity);
        }
    }

    /**
     * Обрабатывает запрос на предоставление еды.
     * Вернет false, если запрошенное значение приведет к отрицательному
     * количеству еды в миске.
     *
     * @param foodAmount
     * @return
     */
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

    /**
     * Выводит количество оставшейся еды в миске.
     * Выполняет информативную роль.
     */
    public void printFoodRemainigs() {
        System.out.println("Cейчас в миске " + remainings + " единиц еды");
    }

    /**
     * Возвращает оставшейся еды в миске в виде целочисленного значения.
     *
     * @return
     */
    public int getFoodRemainigs(){
        return remainings;
    }

    /**
     * Возвращает общую вместимость миски в виде целочисленного значения.
     *
     * @return
     */
    public int getBowlCapacity() {
        return bowlCapacity;
    }
}
