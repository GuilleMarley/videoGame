package SpaceEvaders;

public abstract class Player {

    protected String name;
    String movement = new String();

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void characterStory() {
        storyLine();

    }
    abstract void storyLine();

}
