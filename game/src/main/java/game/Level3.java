package game;

public class Level3 implements GameState{
    Game game;

    public Level3(Game game) {
        this.game = game;
    }
    @Override
    public void addPoints(int newPoints) {
        int totalPoints = game.getTotalPoints() + newPoints;
        game.setTotalPoints(totalPoints);
        System.out.println(game);
    }
}
