package agents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import exploration.Carte;
import exploration.Case;
import exploration.Exploration;
import exploration.Vehicule;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import sun.management.resources.agent;

public class Reactif extends Agent{
	
	private ArrayList<Case> voisinage ;
	
	
	
	
	private Vehicule vehicule;
	 
	
	 public Vehicule getVehicule() {
		return vehicule;
	}


	public Reactif(Vehicule vehicule) {
		super();
		this.vehicule = vehicule;
		System.out.println("creation agent n " + this.vehicule.getID()) ;
		System.out.println("[" +vehicule.getXCourant()+","+vehicule.getYCourant() +"]");
		System.out.println("****************************************") ;
	}

	protected void setup() {
	
		  addBehaviour(new CyclicBehaviour(this) {
			  public void action() {   
				 
				
					 try {
						
						 
							  voisinage=vehicule.getVoisinage();
							 
							  int random =(int) (Math.random()*voisinage.size());
							  System.out.println(random);
							  System.out.println(voisinage.size());
							  Case case1 = vehicule.getVoisinage().get(random);
							  int x = 0,y=0 ;
							  
							if(case1.getX()>vehicule.getXCourant()) x=1;
							if(case1.getY()>vehicule.getYCourant()) y=1;
							
							if(case1.getX()<vehicule.getXCourant()) x=-1;
							if(case1.getY()<vehicule.getYCourant()) y=-1;
							
							vehicule.avancer(x, y);
							
						
						Thread.sleep(0);
						  
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
					 
					 
				/*	
				 * 
				 *  version 2 :)
				 *  int x=0,y=0;
					 int k = (int) (Math.random()*4);
					  if(k==0) {x=1 ; y=1;}
					  if(k==1) {x=-1 ; y=-1;}
					  if(k==2) {x=1 ; y=-1;}
					  if(k==3) {x=-1 ; y=1;}
					  vehicule.avancer(x, y);
					  */
					  
					 
					 
					
		
					  
					  
				  }
			
			  
		  });

	

	  }
}
