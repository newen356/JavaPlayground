public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1, "Alpha", 1500);
        Player p2 = new Player(2, "Beta", 1400);
        TitledPlayer p3 = new TitledPlayer(3, "Magnus", 2839, "GM");

        Tournament t1 = new Tournament(1, "Friday Blitz Arena");
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);

        t1.listPlayers();
        t1.removePlayerById(2);

        System.out.println("\nAfter removing Beta:\n");
        t1.listPlayers();
    }
}