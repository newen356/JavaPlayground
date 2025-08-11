import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderboardService {
    public static final Comparator<Player> RATING_DESC =
            Comparator.comparingInt((Player p) -> p.rating).reversed()
                    .thenComparing(p -> p.username, Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER))
                    .thenComparingInt(p -> p.id);

    public List<Player> getTopN(Collection<Player> players, int n) {
        if (players == null || players.isEmpty() || n <= 0) return Collections.emptyList();
        return players.stream()
                .sorted(RATING_DESC)
                .limit(n)
                .collect(Collectors.toList());
    }
}
