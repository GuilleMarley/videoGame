package SpaceEvaders;

import javax.swing.*;

public class Alien extends Player{
    private static int AlienWidth = 90;
    private static int AlienHeigh = 130;


    public static int getAlienHeigh() {
        return AlienHeigh;
    }

    public static int getAlienWidth() {
        return AlienWidth;
    }

    public void storyLine(){
        JOptionPane.showMessageDialog(null, "Hello you have been chosen to take the spaceship with all your squadron\n" +
                "away from the battle. It was an ambuse.\nGodspeed, everyone is counting on you.", "StoryTime!",JOptionPane.INFORMATION_MESSAGE,null);
    }
}
