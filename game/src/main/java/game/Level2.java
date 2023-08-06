package game;

public class Level2 implements GameState{
    Game game;

    public Level2(Game game) {
        this.game = game;
    }
    @Override
    public void  addPoints(int newPoints) {
        int totalPoints = game.getTotalPoints() + 2*newPoints;
        if(totalPoints >= 20){
            Level3 level3= new Level3(game);
            totalPoints = totalPoints+2; //bonus
            game.setGameState(level3);
        }else if(totalPoints> 15){
            Level2_5 level2_5 = new Level2_5(game);
            game.setGameState(level2_5);
        }
        game.setTotalPoints(totalPoints);
        System.out.println(game);
    }
}
