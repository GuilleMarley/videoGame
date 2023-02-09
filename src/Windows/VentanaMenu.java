package Windows;

import SpaceEvaders.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class VentanaMenu extends JFrame {
    Player jugador1;

    public VentanaMenu() throws IOException {

        setTitle("SpaceEvaders menu");
        setDefaultCloseOperation(VentanaMenu.EXIT_ON_CLOSE);
        setBounds(512, 128,756,756);
        setResizable(false);

        JPanel menuButtons = new JPanel();
        menuButtons.setBackground(Color.WHITE);
        menuButtons.setBounds(0, 0,756,756);
        menuButtons.setLayout(null);
        add(menuButtons);

        ImageIcon humanIcon = new ImageIcon(Images("/robot.png"));
        JButton humanButton = buttonGeneral(128,303,100,150,humanIcon,"HUMAN");
        menuButtons.add(humanButton);
        humanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NombreJugador(1);
            }
        });

        ImageIcon alienIcon = new ImageIcon(Images("/Alien.png"));
        JButton alienButton = buttonGeneral(328,303,100,150,alienIcon,"ALIEN");
        menuButtons.add(alienButton);
        alienButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                NombreJugador(2);
            }
        });

        ImageIcon robotIcon = new ImageIcon(Images("/Human.png"));
        JButton robotButton = buttonGeneral(528,303,100,150,robotIcon,"ROBOT");
        menuButtons.add(robotButton);
        robotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent buttonEvent) {
                NombreJugador(3);
            }
        });

        JLabel textChoose = new JLabel("CHOOSE YOUR CHARACTER");
        textChoose.setForeground(Color.green);
        textChoose.setBounds(290,189,350,150);
        menuButtons.add(textChoose);

        JLabel background = new JLabel();
        background.setBounds(0,0,756,756);
        ImageIcon spaceIcon = new ImageIcon(Images("/espacio5.jpg"));
        ImageIcon scaledSpaceBack = new ImageIcon(spaceIcon.getImage().getScaledInstance(background.getWidth(), background.getHeight(),0));
        background.setIcon(scaledSpaceBack);
        menuButtons.add(background);

        setVisible(true);


    }

    public JButton buttonGeneral(int xPos, int yPos, int height, int width, ImageIcon image, String txtLabel){
        JButton genericButton = new JButton();
        genericButton.setBounds(xPos,yPos,height,width);
        genericButton.setLayout(null);
        ImageIcon scaledImage = new ImageIcon(image.getImage().getScaledInstance(genericButton.getWidth(), genericButton.getHeight(),0));
        genericButton.setIcon(scaledImage);
        JLabel genericLabel = new JLabel(txtLabel);
        genericLabel.setForeground(Color.black);
        genericLabel.setBounds(30,65,90,150);
        genericButton.add(genericLabel);
        return genericButton;
    }

    public void NombreJugador(int opt){
        ImageIcon humanIcon = null;
        ImageIcon alienIcon = null;
        ImageIcon robotIcon = null;
        try {
            humanIcon = new ImageIcon(Images("/humanIcon.png"));
            alienIcon = new ImageIcon(Images("/alienIcon.png"));
            robotIcon = new ImageIcon(Images("/robotIcon2.png"));
        }
        catch(IOException e){
            System.err.println(e.getCause());
        }
        String name = JOptionPane.showInputDialog("Escribe tu nombre jugador: ");
        crearArchivo(name);
        if(opt == 1){
            JOptionPane.showMessageDialog(null, "Hello " + name + " you will be playing as human.","Enjoy!", JOptionPane.INFORMATION_MESSAGE, humanIcon);
            jugador1 = new Humano();
            AbrirVentana();
            this.dispose();
        }
        else
        if(opt == 2){
            JOptionPane.showMessageDialog(null, "Hello " + name + " you will be playing as alien.","Enjoy!", JOptionPane.INFORMATION_MESSAGE, alienIcon);
            jugador1 = new Alien();
            AbrirVentana();
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Hello " + name + " you will be playing as robot.","Enjoy!", JOptionPane.INFORMATION_MESSAGE, robotIcon);
            jugador1 = new Robot();
            AbrirVentana();
            this.dispose();
        }

    }

    public void crearArchivo(String linea) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("gfx/NombreJugador.txt");
            pw = new PrintWriter(fichero);
                pw.println(linea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public BufferedImage Images(String path) throws IOException{
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(path));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public void AbrirVentana(){
        VentanaJuego miJuego = new VentanaJuego(jugador1);
    }


}
