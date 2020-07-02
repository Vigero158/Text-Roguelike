import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Gets the characters name by importing the scanner. Also imports random.
        Scanner scanner = new Scanner(System.in);
        Random randomizer = new Random();
        System.out.print("Enter your characters name: ");
        Player player = new Player("Vigero");
        System.out.printf("Welcome %s, this is the tavern and this is where you " +
                "pick up quests and choose your class.\n", player);


        int enemiesDefeatedCounter = 0;
        // Functionality of the game.
        while (player.health > 0) {
            // Enemies within the game.
            Enemy[] enemies = {new Enemy(50, 35, "Skeleton"),
                    new Enemy(125, 30, "Warrior"),
                    new Enemy(75, 40, "Assassin"),
                    new Enemy(50, 30, "Zombie")};
            Enemy enemyToFight = enemies[randomizer.nextInt(4)];

            while (enemyToFight.health > 0) {
                if (player.health <= 0) {
                    break;
                }
                System.out.println("\n===========================================");
                System.out.println("A. Attack");
                System.out.printf("B. (%s) Potion (50 hp)\n", player.potionCount);
                System.out.println("C. Run");
                System.out.printf("\nYour health is: %d\n", player.health);
                System.out.printf("The %s's health is: %d\n", enemyToFight, enemyToFight.health);
                System.out.println("Total enemies defeated: " + enemiesDefeatedCounter);
                System.out.println("===========================================");
                char option = scanner.next().charAt(0);
                System.out.println("Combat log: \n");

                switch (option) {
                    case 'A':
                        enemyToFight.takeDamage(player.attackDamage);
                        if (enemyToFight.health > 0) {
                            player.takeDamage(enemyToFight.attackDamage);
                            System.out.printf("You took %s damage. You how have %s health. \n",
                                    enemyToFight.attackDamage, player.health);
                        } else {
                            if (player.healthPotionDrop()) {
                                System.out.println("You obtained a potion from the enemy!");
                                player.potionCount++;
                            }
                        }
                        enemiesDefeatedCounter++;
                        break;
                    case 'B':
                        if (player.potionCount > 0) {
                            player.drinkPotion();
                            System.out.println("You drink a potion.");
                            System.out.println("The monster sees you sipping a strange liquid and patiently waits.");
                        } else {
                            System.out.printf("The monster sees you trying to drink air and gets angry." +
                                    "The monster hits you for double damage (%d)\n", enemyToFight.attackDamage * 2);
                            player.takeDamage(enemyToFight.attackDamage * 2);
                        }

                        break;

                    case 'C':
                        System.out.println("You ran away. Right into another enemy. There is no escape.");
                        enemyToFight.health = 0;
                        break;
                }
            }
        }
        System.out.printf("You have been defeated. The total number of enemies you managed to slay is %d", enemiesDefeatedCounter);

    }
}
