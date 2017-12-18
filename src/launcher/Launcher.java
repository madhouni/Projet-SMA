/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;


import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.domain.introspection.GetValue;
import jade.tools.rma.rma;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import agents.Cogn;
import agents.Cognitif;

import agents.Communicatif;
import agents.Reactif;
import exploration.Exploration;
import exploration.Vehicule;

/**
 *
 * @author riviere
 */
public class Launcher {
	private HashMap<Integer, Vehicule> vehicule;

    private final ContainerController container;

    public Launcher(HashMap<Integer, Vehicule> vehicule,String typeAgent) {
    	this.vehicule = vehicule;
        // Get a hold on JADE runtime
        jade.core.Runtime rt = jade.core.Runtime.instance();
        // Create a default profile
//        Profile p = new ProfileImpl("172.19.28.10", 1099, "172.19.28.10:1099/JADE", true);
        Profile p = new ProfileImpl();
        // Create a new main container by default (i.e. on this host, port 1099)
        container = rt.createMainContainer(p); 
        initAndRun(typeAgent);
    
      
      
              

    }

    private void initAndRun(String typeAgent) {
        try {
        	Agent agent = null ;
        	
            //Affectation d'un nouvel agent dans le container.
        	for(int i=0;i<vehicule.size();i++) {
        		
        		if(typeAgent=="reactif") 
        			agent = new Reactif(vehicule.get(i));
        		else if(typeAgent == "cognitif") 
        			agent = new Cogn(vehicule.get(i));
        		
        		AgentController controller = container.acceptNewAgent ("me voila"+  vehicule.get(i).getID()+"", agent);
           
        		//Lancement de l'agent
        		controller.start();
        	}
        } catch (StaleProxyException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
