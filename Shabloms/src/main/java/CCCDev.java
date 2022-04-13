public class CCCDev implements DevelFactory{
    @Override
    public Devel createNewSlave() {
        return new DeveloperCC();
    }
}
