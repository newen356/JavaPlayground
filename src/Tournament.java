import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tournament {
    int id;
    String name;
    ArrayList<Player> players;
    private final LeaderboardService leaderboard = new LeaderboardService();

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
            System.out.println(p);
        }
    }

    public List<Player> getTopN(int n) {
        return leaderboard.getTopN(players, n);
    }

    public void printTopN(int n) {
        List<Player> top = getTopN(n);
        System.out.println("=== Top " + n + " - " + name + " ===");
        int rank = 1;
        for (Player p : top) {
            System.out.println(rank++ + ". " + p.username + " - " + p.rating);
        }
    }
}
