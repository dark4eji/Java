package creature_type;

public abstract class Humanoid {

    protected String name = "Humanoid";

    protected int strength = 7;
    protected int vitality = 7;

    protected int baseHealth = strength * vitality;
    protected int baseAttack = strength;

    protected int currentHealth = baseHealth;

    public int attack(){
        return baseAttack;
    }

    public void getDamage(int enemyDamage){
        if (!checkDeath()) {
            reduceCurrentHealth(enemyDamage);
        }

        if (checkDeath()) {
            System.out.println(name + " мёртв");
        }
    }

    public void getCurrentHealth(){
        System.out.println("Здоровье " + name + " - " + currentHealth);
    }

    public void getName(){
        System.out.println(name);
    }

    private void reduceCurrentHealth(int enemyDamage){
            currentHealth -= enemyDamage;
            System.out.println(name + " теряет " + enemyDamage + " здоровья."); }


    private boolean checkDeath(){
        boolean isDead = false;
        if (currentHealth <= 0) {
            isDead = true;
        }
        return isDead;
    }


}
