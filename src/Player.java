import java.util.Random;

public class Player {
    public Random random = new Random();
    public int health;
    public int attackDamage;
    public String playerName;
    public int potionCount;

    public Player (String playerName) {
        health = 100;
        attackDamage = 50;
        this.playerName = playerName;
        potionCount = 3;
    }

    public void takeDamage(int playerAttackDamage) {
        health -= playerAttackDamage;
    }

    public int dealDamage() {
        return attackDamage;
    }

    public boolean healthPotionDrop () {
        return random.nextInt(2) == 0;
    }

    public void drinkPotion() {
        health += 50;
        potionCount --;
    }

}
