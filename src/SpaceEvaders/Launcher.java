package SpaceEvaders;

import Windows.Threads;
import Windows.VentanaMenu;

import javax.swing.JFrame;
import java.io.IOException;


public class Launcher {
    public static void main(String[] args) {

        Threads myThread = new Threads();
        myThread.start();
        try {
            VentanaMenu principalMenu = new VentanaMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}