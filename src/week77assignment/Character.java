package week77assignment;

class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // start full
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0; // clamp at 0
        System.out.println("Health after damage: " + health);
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth; // clamp at max
        System.out.println("Health after healing: " + health);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);
    }
}
