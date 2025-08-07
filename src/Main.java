//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player(1, "Alpha", 1500);
        Player p2 = new Player(2, "Beta", 1400);

        p1.printStats();
        p2.printStats();
    }
}