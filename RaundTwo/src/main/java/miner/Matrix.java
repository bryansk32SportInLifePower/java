package miner;

 class Matrix {//кдасс размещения бомб двухуровневый
     private Box [][] matr;
     Matrix(Box single){//
         matr=new Box[CoordsMake.getSize().x][CoordsMake.getSize().y];//заполняем массив- на каждую координату ч соответственно куча игреков- 0.0 0.1 и т.д.
         for (Coordinats coordinats:CoordsMake.getAllCoords())//создаем обьекты равные числу координат
             matr[coordinats.x][coordinats.y]=single;//присваем значение каждому обьекту класса бокс
     }
     Box getCoord(Coordinats coordinats)
     {
         if (CoordsMake.inBorder(coordinats))
         return matr[coordinats.x][coordinats.y];
   return null;
     }
     void setCoord(Coordinats coord,Box box){
         if (CoordsMake.inBorder(coord))
         matr[coord.x][coord.y]=box;
     }
 }
