package algorithms.random_congr;

public class Simulation {
    public static void main(String[] args) {
        Actor dragon = new Actor("Dragon", 30, 25, 75);
        Actor hero = new Actor("Hero", 20, 50, 50);

        Fight fight = new Fight(hero, dragon);
        fight.fight();
    }

    static class Actor {
        String name;
        int damage;
        int dodgeChance;
        int hitPoints;

        public Actor(String name, int damage, int dodgeChance, int hitPoints) {
            this.name = name;
            this.damage = damage;
            this.dodgeChance = dodgeChance;
            this.hitPoints = hitPoints;
        }
    }

    static class Fight {
        Actor actor1;
        Actor actor2;

        MainRandom.Random random = new MainRandom.Random((int)System.nanoTime() % 256, 31, 71, 256);

        public Fight(Actor actor1, Actor actor2) {
            this.actor1 = actor1;
            this.actor2 = actor2;
        }

        public void fight() {
            while (fightTurn(actor1, actor2)) {
                Actor tmp = actor1;
                actor1 = actor2;
                actor2 = tmp;
            }
        }

        boolean fightTurn(Actor actor1, Actor actor2) {
            int dodgeThrow = random.get() % 100;
            if (dodgeThrow < actor2.dodgeChance) {
                System.out.println(actor2.name + " увернулся");
                return true;
            }

            int damage = 1 + random.get() % actor1.damage;
            System.out.println(actor1.name + " нанес " + damage + " урона " + actor2.name);
            actor2.hitPoints -= damage;

            if (actor2.hitPoints <= 0) {
                System.out.println(actor2.name + " убит");
                return false;
            }
            return true;
        }
    }
}
