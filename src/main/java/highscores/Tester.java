package highscores;

public class Tester {
    public static void main(String[] args) {
        System.out.println(xpForLevel(99));
        System.out.println(progressToLevel(400000, 99));
    }

    public static double xpForLevel(int level) {
        double total = 0;
        for (int i = 1; i < level; i++)
        {
            total += Math.floor(i + 300 * Math.pow(2, i / 7.0));
        }

        return Math.floor(total / 4);
    }

    public static double progressToLevel(double currentXP, int level) {
        return (currentXP/ xpForLevel(level)) * 100;
    }

}
