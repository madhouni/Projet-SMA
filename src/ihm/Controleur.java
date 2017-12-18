/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import exploration.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * Représente le Controleur dans l'architecture MVC, qui relie le modèle
 * ({@link Carte}) à l'IHM ({@link Visualiseur})
 *
 * @author riviere
 */
public class Controleur {

    private final Visualiseur ihm;
    private final Carte carte;

    // Attibuts concernant la fenêtre principale qui va contenir l'IHM 
    private final JFrame frame;
    private int largeurPanel = 400;
    private int hauteurPanel = 400;
    private final int preferredRatio=8;
    
    
    // Temps de départ de l'exploration
    private final long start;

    // Utilisé pour le test : contrôle de véhicules "à la main"
    private int vehiculeControlledByUser = 0;

    /**
     * Initialise et lance l'IHM ({@link Visualiseur}), et la relie à la
     * {@link Carte} selon le modèle MVC, grâce à l'interface
     * {@link CarteListener} Lance le chronomètre.
     *
     * @param carte la {@link Carte} créée par la classe {@link Exploration}
     */
    public Controleur(Carte carte) {
        reSizeFrame(carte.getX(), carte.getY());
        ihm = new Visualiseur(this, largeurPanel, hauteurPanel, carte.getX(), carte.getY());
        this.carte = carte;
        carte.addListener(ihm);

        frame = new JFrame();
        frame.add(ihm);
        frame.setSize(largeurPanel + 50, hauteurPanel + 50);
        frame.setResizable(false);
        frame.setTitle("Carte");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        start = System.currentTimeMillis();
        deplacer();
    }

    /**
     * Méthode utilisée pour le contrôle de véhicules "à la main". Le SMA n'aura
     * pas à utiliser cette méthode.
     *
     */
    private void deplacer() {
        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_NUMPAD0:
                        vehiculeControlledByUser = 0;
                        break;
                    case KeyEvent.VK_NUMPAD1:
                        vehiculeControlledByUser = 1;
                        break;
                    case KeyEvent.VK_NUMPAD2:
                        vehiculeControlledByUser = 2;
                        break;
                    case KeyEvent.VK_NUMPAD3:
                        vehiculeControlledByUser = 3;
                        break;
                    case KeyEvent.VK_DOWN:
                        carte.avancer(vehiculeControlledByUser, 0, 1);
                        break;
                    case KeyEvent.VK_UP:
                        carte.avancer(vehiculeControlledByUser, 0, -1);
                        break;
                    case KeyEvent.VK_LEFT:
                        carte.avancer(vehiculeControlledByUser, -1, 0);
                        break;
                    case KeyEvent.VK_RIGHT:
                        carte.avancer(vehiculeControlledByUser, 1, 0);
                        break;

                }
            }
        });
    }

    /**
     * Méthode appelée par {@link Visualiseur} lorsque la {@link Carte} lui a
     * signifié que toutes les {@link Case} ont été découvertes. Affiche le
     * temps passé et l'efficacité du SMA utilisé
     * ({@link Carte#calculEfficacite()})
     *
     * @param efficacite le nombre de fois qu'un {@link Vehicule} est passé sur
     * une {@link Case}
     */
    public void success(Double efficacite) {
        long time = (System.currentTimeMillis() - start);
        JOptionPane.showMessageDialog(frame, "Bien joué ! Temps total : " + time + " millisecondes \n Efficacité : " + efficacite + "%", "Carte découverte !", JOptionPane.ERROR_MESSAGE);
        close();
    }
    
    private void close(){
        System.exit(0);
    }
    
    private void reSizeFrame(int xsize, int ysize){
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        
        if((xsize * preferredRatio > width)||(ysize * preferredRatio > height)){
            largeurPanel=new Double(width).intValue();
            hauteurPanel=new Double(height).intValue();
        }
        else{
            largeurPanel = xsize * preferredRatio;
            hauteurPanel = ysize * preferredRatio;
        }       
    }

}
