import java.util.ArrayList;

public class Tournament {
    int id;
    String name;
    ArrayList<Player> players;

    public Tournament(int id, String name) {
        this.id = id;
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayerById(int playerId) {
        players.removeIf(player -> player.id == playerId);
    }

    public void listPlayers() {
        System.out.println("Tournament: " + name);
        for (Player p : players) {
            p.printStats();
        }
    }
}
