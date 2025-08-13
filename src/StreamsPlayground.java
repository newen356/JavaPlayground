import java.util.*;
import java.util.stream.*;

public class StreamsPlayground {

    static List<Player> players = List.of(
            new Player(1, "Alpha", 1500),
            new Player(2, "Beta", 1400),
            new Player(3, "Gamma", 1720),
            new Player(4, "Delta", 2010),
            new Player(5, "Omega", 1990),
            new Player(6, "Sigma", 1520),
            new Player(7, "Alpha2", 1500)
    );

    public static void main(String[] args) {
        header("1) map + filter");
        demo1_map_filter();

        header("2) flatMap");
        demo2_flatMap();

        header("3) distinct + sorted");
        demo3_distinct_sorted();

        header("4) limit + skip (pagination-ish)");
        demo4_limit_skip();

        header("5) groupingBy + mapping");
        demo5_collect_groupingBy();

        header("6) findFirst / anyMatch / allMatch");
        demo6_find_match();

        header("7) reduce (basic)");
        demo7_reduce();

        header("8) toMap with merge (collision-safe)");
        demo8_toMap();
    }

    static void demo1_map_filter() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> squaresOfEvens = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();
        System.out.println(squaresOfEvens); // [4, 16, 36]
    }

    static void demo2_flatMap() {
        List<String> sentences = List.of("alpha beta", "beta gamma", "ALPHA");
        List<String> uniqueSortedWords = sentences.stream()
                .map(s -> s.toLowerCase().split("\\s+"))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .toList();
        System.out.println(uniqueSortedWords); // [alpha, beta, gamma]
    }

    static void demo3_distinct_sorted() {
        List<Integer> ratingsDescUnique = players.stream()
                .map(Player::getRating)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(ratingsDescUnique); // [2010, 1990, 1720, 1520, 1500, 1400]
    }

    static void demo4_limit_skip() {
        // Top by rating, skip first 2, then take next 3
        List<String> midTop3 = players.stream()
                .sorted(Comparator.comparingInt(Player::getRating).reversed())
                .skip(2)
                .limit(3)
                .map(Player::getUsername)
                .toList();
        System.out.println(midTop3); // [Gamma, Sigma, Alpha]
    }

    static void demo5_collect_groupingBy() {
        // Bucket by hundreds (1500s, 1600s, etc), value as usernames
        Map<Integer, List<String>> buckets = players.stream()
                .collect(Collectors.groupingBy(
                        p -> (p.getRating() / 100) * 100,
                        Collectors.mapping(Player::getUsername, Collectors.toList())
                ));

        new TreeMap<>(buckets).forEach((k, v) -> System.out.println(k + " -> " + v));
        // 1400 -> [Beta]
        // 1500 -> [Alpha, Sigma, Alpha2]
        // 1700 -> [Gamma]
        // 1900 -> [Omega]
        // 2000 -> [Delta]
    }

    static void demo6_find_match() {
        boolean anyContainsDoubleM = players.stream()
                .anyMatch(p -> p.getUsername().toLowerCase().contains("mm"));
        boolean allAbove1000 = players.stream().allMatch(p -> p.getRating() >= 1000);
        Optional<Player> firstOver2000 = players.stream()
                .filter(p -> p.getRating() > 2000)
                .findFirst();

        System.out.println(anyContainsDoubleM); // true (Gamma)
        System.out.println(allAbove1000);       // true
        System.out.println(firstOver2000.map(Player::getUsername)); // Optional[Delta]
    }

    static void demo7_reduce() {
        int sum = players.stream().map(Player::getRating).reduce(0, Integer::sum);
        System.out.println(sum); // 11640
    }

    static void demo8_toMap() {
        // Key collision on first letter: resolve by keeping max rating
        Map<String, Integer> bestByFirstLetter = players.stream()
                .collect(Collectors.toMap(
                        p -> p.getUsername().substring(0, 1),
                        Player::getRating,
                        Integer::max
                ));
        new TreeMap<>(bestByFirstLetter).forEach((k, v) -> System.out.println(k + " -> " + v));
        // A -> 1500, B -> 1400, D -> 2010, G -> 1720, O -> 1990, S -> 1520
    }

    static void header(String title) {
        System.out.println("\n==== " + title + " ====");
    }
}
