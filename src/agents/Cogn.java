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

public class Cogn extends Agent {
	Vehicule vehicule;
	
	/**
	 * case que l agent peut passe par
	 */
	ArrayList<Case> caseAccessible = new ArrayList<Case>();
	
	ArrayList<Case> CaseExplore = new ArrayList<Case>();
	
	/**
	 * liste qui va contenir les cases blanches
	 */
	public static ArrayList<Case> trace = new ArrayList<Case>();
	int k =0;
			
	
/**
 * 
 * @param vehicule agent à recuperer
 */
	public Cogn(Vehicule vehicule) {
		super();
		this.vehicule = vehicule;
		k = (int) (Math.random()*4);
	}
	
	/**
	 * 
	 * @param case1
	 * @return renvoi si la case est dans le voisinage de l'agent ou non
	 */
	public boolean isInVoisinage(Case case1) {
		for (Case case2 : vehicule.getVoisinage()) {
			if (case2.getX() == case1.getX() && case2.getY() == case1.getY()) {
				return true;
			}

		}
		return false;
	}

	
	/**
	 * 
	 * @param case1
	 * @param listCase
	 * @return si la case se trouve dans la liste
	 */
	
	public boolean contain(Case case1, List<Case> listCase) {
		for (Case case2 : listCase) {
			if (case2.getX() == case1.getX() && case2.getY() == case1.getY()) {
				return true;
			}

		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	
	
	
	
	
	public void quickExplore1() {
		vehicule.avancer(0, -1);

	}

	public void quickExplore2() {
		vehicule.avancer(1, 0);
	}

	public void quickExplore3() {
		vehicule.avancer(0, 1);
	}

	public void quickExplore4() {
		vehicule.avancer(-1, 0);
	}
	
	
	
	
	
	public void choix1() {
		
		Case case1 = new Case(vehicule.getXCourant(), vehicule.getYCourant() - 1);
		Case case2 = new Case(vehicule.getXCourant() + 1, vehicule.getYCourant());

		Case case3 = new Case(vehicule.getXCourant(), vehicule.getYCourant() + 1);
		Case case4 = new Case(vehicule.getXCourant() - 1, vehicule.getYCourant());
		caseAccessible.clear();
		CaseExplore.clear();
		

			
			
		
			if (isInVoisinage(case1) && !case1.isDecouverte() && !contain(case1,trace) && !case1.isOccupee()) {
				System.out.println("1 ");
				quickExplore1();
				trace.add(case1);
				
				
			}
			
			else if (isInVoisinage(case2)  && !case2.isDecouverte() && !contain(case2,trace) && !case2.isOccupee() ) {
				System.out.println("2 ");
				quickExplore2();
				trace.add(case2);
				
				 
				
			}
				
			else if (isInVoisinage(case3) && !case3.isDecouverte() && !contain(case3,trace) && !case3.isOccupee())
					{
				System.out.println("3 ");
			
				
				quickExplore3();
				trace.add(case3);
				
				
			}
			
			else if (isInVoisinage(case4) && !case4.isDecouverte() && !contain(case4,trace) && !case4.isOccupee() )
			{
				System.out.println("4");
	
		
		quickExplore4();
		trace.add(case4);
		
		
	}
		
			else if(contain( new Case(vehicule.getXCourant(), vehicule.getYCourant()), trace)) {
			
				
				 vehicule.avancer(-1, 0);
				
				
				}
			
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	

	
	

	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				
				
				 choix1();
				
			
				
			

			
				
			}
			
			
		
			
			
			
			
				
			
		});

	}
}
