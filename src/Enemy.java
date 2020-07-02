public class Enemy {
    public int health;
    public int attackDamage;
    public String enemyName;

    public Enemy (int initialHealth, int attackDamage, String enemyName) {
        this.health = initialHealth;
        this.attackDamage = attackDamage;
        this.enemyName = enemyName;
    }

    @Override
    public String toString() {
        return enemyName;
    }

    public void takeDamage(int playerAttackDamage) {
        health -= playerAttackDamage;
        }

}
