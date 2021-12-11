package miner;

public class Game {
 public    Game(int cols,int rows){
        CoordsMake.setSize(new Coordinats(cols,rows));
    }
    public Box getBox(Coordinats coordinats){
     return Box.values()[(coordinats.x+coordinats.y)%Box.values().length];
    }
}
