//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player();
        p1.id = 1;
        p1.username = "Alpha";
        p1.rating = 1500;

        Player p2 = new Player();
        p2.id = 2;
        p2.username = "Beta";
        p2.rating = 1400;

        System.out.println(p1.username + " (" + p1.rating + ")");
        System.out.println(p2.username + " (" + p2.rating + ")");
    }
}