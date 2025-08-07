public class Player {
    int id;
    String username;
    int rating;

    public Player(int id, String username, int rating) {
        this.id = id;
        this.username = username;
        this.rating = rating;
    }

    public void printStats() {
        System.out.println("Name: " + username + ", Rating: " + rating);
    }
}