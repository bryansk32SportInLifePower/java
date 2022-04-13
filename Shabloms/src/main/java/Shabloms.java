public class Shabloms {
    public static void main(String[] args) {
     DevelFactory develFactory=createDevels("oo");
     Devel devel= develFactory.createNewSlave();
     devel.writeSomething();
    }
    static DevelFactory createDevels(String specialoty){
if (specialoty.equalsIgnoreCase("j")){
    return new JavaDev();
}else if(specialoty.equalsIgnoreCase("c")){
    return new CCCDev();
        }else {
    throw new  RuntimeException(specialoty+" hren");
        }
    }
}
