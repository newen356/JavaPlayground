public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1, "Alpha", 1500);
        Player p2 = new Player(2, "Beta", 1400);
        TitledPlayer p3 = new TitledPlayer(3, "Magnus", 2839, "GM");

        p1.printStats();
        p2.printStats();
        p3.printStats();
    }
}