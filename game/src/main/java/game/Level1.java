package game;

public class Level1 implements GameState{
    Game game;

    public Level1(Game game) {
        this.game = game;
    }

    @Override
    public void addPoints(int newPoints) {
        Level2 level2 = new Level2(game);
        int totalPoints = game.getTotalPoints() + newPoints;
        if(totalPoints > 10){
            totalPoints++; //bonus
            game.setGameState(level2);
        }
        game.setTotalPoints(totalPoints);
        System.out.println(game);
    }
}
