package Windows;

import Windows.VentanaMenu;
import SpaceEvaders.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class VentanaJuego extends JFrame {

    public VentanaJuego(Player jugador1){
        setTitle("SpaceEvaders game");
        setDefaultCloseOperation(VentanaMenu.EXIT_ON_CLOSE);
        setBounds(256, 64,1512,1012);
        setResizable(false);

        JPanel gameWindow = new JPanel();
        gameWindow.setBackground(Color.BLACK);
        gameWindow.setBounds(0,0,1512,1012);
        gameWindow.setLayout(null);
        add(gameWindow);

        JLabel background = new JLabel();
        background.setBounds(0,0,1512,1012);

        ImageIcon humanIcon = null;
        ImageIcon alienIcon = null;
        ImageIcon robotIcon = null;
        ImageIcon spaceHumanIcon = null;
        ImageIcon spaceAlienIcon = null;
        ImageIcon spaceRobotIcon = null;

        try {
            robotIcon = new ImageIcon(Images("/Human.png"));
            alienIcon = new ImageIcon(Images("/Alien.png"));
            humanIcon = new ImageIcon(Images("/Robot.png"));
            spaceHumanIcon = new ImageIcon(Images("/espacio1.jpg"));
            spaceAlienIcon = new ImageIcon(Images("/alienPlanet.jpg"));
            spaceRobotIcon = new ImageIcon(Images("/robotPlanet.jpg"));

        }
        catch(IOException e) {
            System.err.println(e.getCause());
        }
        JLabel SpaceShip = new JLabel();

        if(jugador1.getClass()== Humano.class){
            ImageIcon humanScaled = new ImageIcon(humanIcon.getImage().getScaledInstance(Humano.getHumanoWidth(), Humano.getHumanoHeight(),0));
            SpaceShip.setBounds(656,506,Humano.getHumanoWidth(),Humano.getHumanoHeight());
            SpaceShip.setIcon(humanScaled);
            gameWindow.add(SpaceShip);
            ImageIcon scaledSpaceBack = new ImageIcon(spaceAlienIcon.getImage().getScaledInstance(background.getWidth(), background.getHeight(),0));
            background.setIcon(scaledSpaceBack);
        }
        else if (jugador1.getClass()== Alien.class) {
            ImageIcon alienScaled = new ImageIcon(alienIcon.getImage().getScaledInstance(Alien.getAlienWidth(), Alien.getAlienHeigh(),0));
            SpaceShip.setBounds(656,506,Humano.getHumanoWidth(),Humano.getHumanoHeight());
            SpaceShip.setIcon(alienScaled);
            gameWindow.add(SpaceShip);
            ImageIcon scaledSpaceBack = new ImageIcon(spaceHumanIcon.getImage().getScaledInstance(background.getWidth(), background.getHeight(),0));
            background.setIcon(scaledSpaceBack);
        }
        else {
            ImageIcon robotScaled = new ImageIcon(robotIcon.getImage().getScaledInstance(Robot.getRobotWidth(), Robot.getRobotHeight(),0));
            SpaceShip.setBounds(656,506,Humano.getHumanoWidth(),Humano.getHumanoHeight());
            SpaceShip.setIcon(robotScaled);
            gameWindow.add(SpaceShip);
            ImageIcon scaledSpaceBack = new ImageIcon(spaceRobotIcon.getImage().getScaledInstance(background.getWidth(), background.getHeight(),0));
            background.setIcon(scaledSpaceBack);
        }
        jugador1.characterStory();


        gameWindow.add(background);

        setVisible(true);
    }

    public BufferedImage Images(String path) throws IOException {
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(path));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

}
