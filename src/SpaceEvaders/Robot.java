package SpaceEvaders;

import javax.swing.*;
import java.util.Scanner;

public class Robot extends Player implements Speak{
    private static int RobotWidth = 110;
    private static int RobotHeight = 110;


    public static int getRobotHeight() {
        return RobotHeight;
    }

    public static int getRobotWidth() {
        return RobotWidth;
    }

    public void storyLine(){
        JOptionPane.showMessageDialog(null, "Hello you have been chosen to take the spaceship and runaway,\n" +
                "years of wars in your planet have caused it to decay and make it inhabitable.\nTake your knowledge to every " +
                "corner of the galaxy.\nGodspeed, everyone is counting on you.", "StoryTime!",JOptionPane.INFORMATION_MESSAGE,null);
    }

    @Override
    public void Talk(){
        System.out.println("Sistema dañado.");
    }
}
