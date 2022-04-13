public class JavaDev implements DevelFactory{
    @Override
    public Devel createNewSlave() {
        return new DeveloperJava();
    }
}
