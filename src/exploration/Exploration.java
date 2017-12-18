/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exploration;

import ihm.Controleur;
import ihm.Visualiseur;
import jade.domain.introspection.GetValue;
import launcher.Launcher;

import java.util.ArrayList;
import java.util.HashMap;

import agents.Reactif;

/**
 * Classe principale qui lance l'application. - Crée une nouvelle {@link Carte}
 * de taille 50*50 par défaut, avec 4 {@link Vehicule} - Lance le
 * {@link Controleur} qui s'occupe de mettre en place le lien entre l'IHM
 * ({@link Visualiseur}) et la carte - Initialise les 4 véhicules sur la carte
 *
 * @author riviere
 */
public class Exploration {

    private final Carte carte;
    private static boolean RANDOM_SIZE = false;
    private final int VEHICULE_NBR = 4;
  
    /**
     *
     * @param xSize la taille en x de la carte
     * @param ySize la taille en y de la carte
     */
    public Exploration(int xSize, int ySize) {
        carte = new Carte(xSize, ySize);
        new Controleur(carte);
        carte.initVehicules(VEHICULE_NBR);
        Vehicule v = getVehicules().get(1);
       
        //new Launcher(getVehicules(),"reactif");
       new Launcher(getVehicules(),"cognitif");
        
    }
    
   
    
  
    /**
     * Récupérer la liste des véhicules présents sur la carte
     *
     * @return une hashMap contenant la liste des véhicules classée par
     * identifiants (pour 4 véhicules : 0 1 2 3)
     */
    public HashMap<Integer, Vehicule> getVehicules() {
        return carte.getVehicules();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case "-random":
                    RANDOM_SIZE = true;
                    i++;
                    break;
            }
        }

        int xsize;
        int ysize;

        if (RANDOM_SIZE) {
            xsize = new Double(Math.random() * 100 + 50).intValue();
            ysize = new Double(Math.random() * 50 + 50).intValue();
        } else {
            xsize = 50;
            ysize = 50;
        }

        new Exploration(xsize, ysize);
        
        
    }

}
