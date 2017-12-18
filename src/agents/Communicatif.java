package agents;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import exploration.Carte;
import exploration.Case;
import exploration.Vehicule;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import sun.java2d.xr.XcbRequestCounter;
import sun.text.normalizer.NormalizerBase.QuickCheckResult;

public class Communicatif extends Agent {
	Vehicule vehicule ;
	
	
/**
 * 
 * @param vehicule agent quand récupere depuis la class exploration
 */

	public Communicatif(Vehicule vehicule) {
		super();
		this.vehicule = vehicule;
	}




	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				
				
				 vehicule.avancer(1, 1);
			
				
			

			
				
			}
			
			
		
			
			
			
			
				
			
		});

	}
}
