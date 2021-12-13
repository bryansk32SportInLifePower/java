package miner;

 class Bomb {
  private Matrix bombMap;
  private int totalBomb;

  Bomb(int totalBomb){
   this.totalBomb=totalBomb;

  }
  void start(){
   bombMap=new Matrix(Box.zero);
   for (int i=0;i<totalBomb;i++)
    placeBomb();
  }

  private void placeBomb() {
   while (true)
   {
    Coordinats coordinats=CoordsMake.getRandomCoor();
    if (Box.bomb==bombMap.getCoord(coordinats))
continue;
   bombMap.setCoord(new Coordinats(coordinats.x,coordinats.y),Box.bomb);
   isNumberAround (coordinats);
   break;
   }
  }
Box  get(Coordinats coordinats){
      return bombMap.getCoord(coordinats);
}
  private void isNumberAround(Coordinats coordinats) {
  }

 }
