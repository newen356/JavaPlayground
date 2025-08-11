public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1, "Alpha", 1500);
        Player p2 = new Player(2, "Beta", 1400);
        TitledPlayer p3 = new TitledPlayer(3, "Magnus", 2839, "GM");
        TitledPlayer p4 = new TitledPlayer(4, "Alireza", 2804, "GM");
        TitledPlayer p5 = new TitledPlayer(5, "Hikaru", 2789, "GM");

        Tournament t1 = new Tournament(1, "Freestyle Friday");
        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);
        t1.addPlayer(p4);
        t1.addPlayer(p5);

        t1.listPlayers();
        System.out.println();
        t1.printTopN(3);
    }
}
