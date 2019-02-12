package creature_type;

public abstract class Humanoid {
    protected String name = "Гуманоид";
    protected int strength = 5;
    protected int dexterity = 5;
    protected int vitality = 5;
    protected int health = strength * vitality;
    protected int hitPower = strength * 2;

    public int getHealth(){
        return health;
    }

    public void getDamage(int enemyHitPower){
        health -= enemyHitPower;
        System.out.println(name + " потерял " + enemyHitPower + " здоровья\n" +
                "Осталось " + health);
        if (health <= 0) {
            System.out.println(name + " убит");
        }

    }

    public int hitEnemy(){
        return hitPower;
    }

    public void getName() {
        System.out.println(name);
    }

}
