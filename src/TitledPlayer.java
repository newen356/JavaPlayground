public class TitledPlayer extends Player {
    String title;

    public TitledPlayer(int id, String username, int rating, String title) {
        super(id, username, rating);
        this.title = title;
    }

    @Override
    public String toString() {
        return "Name: " + username + ", Rating: " + rating + ", Title: " + title;
    }

    @Override
    public void printStats() {
        System.out.println(toString());
    }
}
