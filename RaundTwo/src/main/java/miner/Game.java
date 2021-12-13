package miner;

public class Game {//класс для связи меьодов из других классов
 private Bomb bomb;
 public void start(){
   bomb.start();
 }

    public    Game(int cols,int rows,int bombs){
        CoordsMake.setSize(new Coordinats(cols,rows));
   bomb=new Bomb(bombs);
    }
    public Box getBox(Coordinats coordinats){// заполнение поля картинкамит
     return bomb.get(coordinats);
    }
}
