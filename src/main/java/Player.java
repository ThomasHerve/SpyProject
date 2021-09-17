public class Player {
    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void addPoint() {
        score += 1;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }
}
