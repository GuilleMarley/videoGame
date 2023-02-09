package SpaceEvaders;

import javax.swing.*;

public class Humano extends Player implements Speak{
    private static int HumanoWidth = 130;
    private static int HumanoHeight = 90;

    public static int getHumanoHeight() {
        return HumanoHeight;
    }

    public static int getHumanoWidth() {
        return HumanoWidth;
    }

    public void storyLine(){
        JOptionPane.showMessageDialog(null, "Hello you have been chosen to take the spaceship with all\nthe survivors " +
                "away from the explosion radious the destruction\nthat the planet is going to cause.\nGodspeed, everyone is counting on you.", "StoryTime!",JOptionPane.INFORMATION_MESSAGE,null);
    }


    @Override
    public void Talk(){
        System.out.println("Aaaah me han dado!!");
    }

}
