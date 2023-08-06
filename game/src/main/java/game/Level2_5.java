package game;

public class Level2_5 implements GameState{
    Game game;

    public Level2_5(Game game) {
        this.game = game;
    }
    @Override
    public void addPoints(int newPoints) {
        Level3 level3 = new Level3(game);
        int totalPoints = game.getTotalPoints() + newPoints;
        if(totalPoints >= 20){
            totalPoints = totalPoints+2; //bonus
            game.setGameState(level3);
        }
        game.setTotalPoints(totalPoints);
        System.out.println(game);
    }
}
