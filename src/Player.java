public class Player {
    int id;
    String username;
    int rating;

    public Player(int id, String username, int rating) {
        this.id = id;
        this.username = username;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player other = (Player) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Name: " + username + ", Rating: " + rating;
    }

    public void printStats() {
        System.out.println(toString());
    }
}