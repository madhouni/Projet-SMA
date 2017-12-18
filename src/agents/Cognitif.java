package agents;

import java.util.ArrayList;

import exploration.Carte;
import exploration.Case;
import exploration.Vehicule;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import sun.java2d.xr.XcbRequestCounter;

public class Cognitif extends Agent {
	
	private  ArrayList<Case> list;
	private  ArrayList<Case> champ1 ;
	private  ArrayList<Case> champ2 ;
	private  ArrayList<Case> champ3 ;
	private  ArrayList<Case> champ4 ;
	private Vehicule vehicule ;
	private ArrayList<Case> voisinage ;
	private Carte carte;
	private int xCarte , yCarte , nbrVoitures;
	int cpt=0;
	int cpt1=0;
	int cpt2=0;
	int limite1 = 50/2;
	int limite2 = 50/2;
	boolean ok ;
	boolean ok1 = true;
	boolean ok2 = true;
	boolean ok3 = true;
	boolean ok4 = true;
	int x = 0,y=0 ;
	int index=0;
	int xcor=0,ycor=0 , xcor1=49,ycor1=0 , xcor2=0,ycor2=49 , xcor3 = 49,ycor3=49;
	int xCorIinital , yCorIinital , xCorIinital2 , yCorIinital2 ;
	int xcarte =49;
	int ycarte =49;
	
	
	public Cognitif(Vehicule vehicule ) {
		super();
		this.vehicule = vehicule;
		champ4 = new ArrayList<>();
		champ3 = new ArrayList<>();
		champ2 = new ArrayList<>();
		champ1 = new ArrayList<>();
		list = new ArrayList<>();
		
		for(int i=0;i<limite1;i++) {
			for(int j=0;j<limite2;j++) {
				champ1.add(new Case(i, j));
			}
		}
		xCorIinital = vehicule.getXCourant();
		yCorIinital = vehicule.getYCourant();
		xCorIinital2 = vehicule.getXCourant();
		yCorIinital2 = vehicule.getYCourant();
		
	}


	public ArrayList<Case> getList() {
		return list;
	}


	public Vehicule getVehicule() {
		return vehicule;
	}
	
	
	private  boolean  notFindCase(ArrayList<Case> cases , Case casesVehicule) {
		
		for(Case list :cases) {
			if(list.getX() == casesVehicule.getX() 
					&& list.getY() == casesVehicule.getY())
				return false;
		}
		
		return true;
	}
	

	protected void setup() {
		
		
		
	
		  addBehaviour(new CyclicBehaviour(this) {
			  public void action() {
				  
			voisinage=new ArrayList<>();
			voisinage = vehicule.getVoisinage();
			int random = (int) (Math.random()*voisinage.size());
		
			
			 
			 
			
			    Case caseDestination = vehicule.getVoisinage().get(random);
			 	if(caseDestination.getX()>vehicule.getXCourant()) x=1;
				if(caseDestination.getY()>vehicule.getYCourant()) y=1;
				
				if(caseDestination.getX()<vehicule.getXCourant()) x=-1;
				if(caseDestination.getY()<vehicule.getYCourant()) y=-1;
				//vehicule.avancer(x, y);
				list.add(new Case(vehicule.getXCourant(), vehicule.getYCourant()));
				/*if(notFindCase(list, new Case(x, y))) { 
					vehicule.avancer(x, y);
					list.add(new Case(vehicule.getXCourant()+x,vehicule.getYCourant()+ y));
				}*/
				
				/*	int random1 = (int) (Math.random()*4) ; 
					if(random1 == 0 ) vehicule.avancer(1, 1);
					if(random1 == 1 ) vehicule.avancer(-1, -1);
					if(random1 == 2 ) vehicule.avancer(1, -1);
					if(random1 == 3 ) vehicule.avancer(-1, 1);
					*/
				
			/*	if(index<100) {
				
				
				if(vehicule.getID()==2) {
					
					if(cpt<26)vehicule.avancer(0, 1);
					cpt++;
					if(cpt>=26 && cpt < 52) vehicule.avancer(1, 0);
					if(cpt>=52 && cpt<76) vehicule.avancer(0, -1);
					if(cpt>=76 && cpt <100 ) vehicule.avancer (-1,0);
					ok1 =false;
					
					
					}
				
				if(vehicule.getID()==3) {
					
					if(cpt1<26)vehicule.avancer(-1, 0);
					cpt1++;
					if(cpt1>=26 && cpt1 < 52) vehicule.avancer(0, 1);
					if(cpt1>=52 && cpt1<76) vehicule.avancer(1, 0);
					if(cpt1>=76 && cpt1 <100 ) vehicule.avancer (0,-1);
					
					ok3 =false;
					}
				
				if(vehicule.getID()==0) {
					
					if(cpt2<26)vehicule.avancer(0, -1);
					cpt2++;
					if(cpt2>=26 && cpt2 < 52) vehicule.avancer(-1, 0);
					if(cpt2>=52 && cpt2<76) vehicule.avancer(0, 1);
					if(cpt2>=76 && cpt2 <100 ) vehicule.avancer (1,0);
					
					ok2 =false;
					}
				

				if(vehicule.getID()==1) {
					
					if(cpt2<26)vehicule.avancer(1, 0);
					cpt2++;
					if(cpt2>=26 && cpt2 < 52) vehicule.avancer(0, -1);
					if(cpt2>=52 && cpt2<76) vehicule.avancer(-1, 0);
					if(cpt2>=76 && cpt2 <100 ) vehicule.avancer (0,1);
					ok4 =false;
					}
				index++;
				System.out.println(index);
				
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				*/
		/*		else {
					
					if(vehicule.getID()==0) {
						
						
					//	vehicule.avancer(-1, -1);
						
						
					/* int random1 =(int) (Math.random()*champ1.size());
					  
					  Case case1 = champ1.get(random1);
					 
					  
					if(case1.getX()>vehicule.getXCourant()) x=1;
					if(case1.getY()>vehicule.getYCourant()) y=1;
					
					if(case1.getX()<vehicule.getXCourant()) x=-1;
					if(case1.getY()<vehicule.getYCourant()) y=-1;
					
					vehicule.avancer(x, y);
					
					
					System.out.println(1);
					}
						if(vehicule.getYCourant()>3) vehicule.avancer(-1, -1);
						
						
					}
						
						
					
				}
				*/
				
				if(vehicule.getID()==0) {
					
					
					if(vehicule.getYCourant()>ycor
							&& vehicule.getXCourant()>xcor && cpt==0) {
						
						vehicule.avancer(-1, 0);
						
					  if(vehicule.getXCourant()==xcor 
							 && vehicule.getYCourant()==yCorIinital)
						 cpt=1;
					  
					  try {
						  System.out.println(vehicule.getXCourant());
						Thread.sleep(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					
					
					
					
					
					 if(vehicule.getYCourant() <=yCorIinital
							&& vehicule.getXCourant()==xcor && cpt==1 ) {
						vehicule.avancer(0, -1);
						
						if(vehicule.getXCourant()==xcor 
								 && vehicule.getYCourant()==ycor)
							 cpt=2;
						try {System.out.println(2);
							Thread.sleep(0);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					 if(vehicule.getYCourant()== ycor
							&& vehicule.getXCourant()< xCorIinital && cpt==2) {
						
						vehicule.avancer(1, 0);
						
					if(vehicule.getXCourant()==xCorIinital
							 && vehicule.getYCourant()==ycor)
						 cpt=3;
					try {
						System.out.println(3);
						Thread.sleep(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
					
				
					
					
					 if(cpt == 3 
							&& vehicule.getXCourant() == xCorIinital
							&& vehicule.getYCourant() < yCorIinital-2)
						
						{
						 vehicule.avancer(0, 1);
						 System.out.println(vehicule.getYCourant());
						 System.out.println(yCorIinital);
						if(vehicule.getXCourant() == xCorIinital
								&& vehicule.getYCourant() == yCorIinital-2)
							{cpt=0;
						xcor++;ycor++;
						yCorIinital=yCorIinital-2;
						xCorIinital=xCorIinital-2;
						
						System.out.println(4);
						}
						
							}
						
						}
					
				
				
				//**********************************************************
				
			
				
if(vehicule.getID()==1) {
					
					
					if(vehicule.getYCourant()>ycor1
							&& vehicule.getXCourant()<xcor1 && cpt1 == 0) {
						
						vehicule.avancer(0, -1);
						
					  if(vehicule.getXCourant()==xCorIinital 
							 && vehicule.getYCourant()==ycor1)
						 cpt1=1;
					  
					  try {
						  System.out.println(vehicule.getXCourant());
						Thread.sleep(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					
					
					
					
					
					 if(vehicule.getYCourant() ==ycor1
							&& vehicule.getXCourant()<=xcor1 && cpt1==1 ) {
						vehicule.avancer(1, 0);
						
						if(vehicule.getXCourant()==xcor1 
								 && vehicule.getYCourant()==ycor1)
							 cpt1=2;
						try {System.out.println(2);
							Thread.sleep(0);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
					 if(vehicule.getYCourant() < yCorIinital -2
							&& vehicule.getXCourant()> xCorIinital && cpt1==2) {
						
						vehicule.avancer(0, 1);
						
					if(vehicule.getYCourant()==yCorIinital-2
							 && vehicule.getXCourant()>xCorIinital)
						 cpt1=3;
					try {
						System.out.println(3);
						Thread.sleep(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
					
				
					
					
					 if(cpt1 == 3 
							&& vehicule.getXCourant() > xCorIinital+2
							&& vehicule.getYCourant() == yCorIinital-2)
						
						{
						 vehicule.avancer(-1, 0);
						 System.out.println(vehicule.getYCourant());
						 System.out.println(yCorIinital);
						if(vehicule.getXCourant() == xCorIinital+2
								&& vehicule.getYCourant() == yCorIinital-2)
							{cpt1=0;
						xcor1--;ycor1++;
						yCorIinital=yCorIinital-2;
						xCorIinital=xCorIinital+2;
						
						System.out.println(4);
						}
						
							}
						
						}
					
				
				
				
				
			
					
					
					
					
				
				//************************************************************	








if(vehicule.getID()==2) {
	
	
	if(vehicule.getYCourant()<ycor2
			&& vehicule.getXCourant() == xCorIinital && cpt1 == 0) {
		
		vehicule.avancer(0, 1);
		
	  if(vehicule.getXCourant()==xCorIinital
			 && vehicule.getYCourant()==ycor2)
		 cpt1=1;
	  
	  try {
		  System.out.println(vehicule.getXCourant());
		Thread.sleep(0);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	
	
	 if(vehicule.getYCourant() <= ycor2
			&& vehicule.getXCourant()> xcor2 && cpt1==1 ) {
		vehicule.avancer(-1, 0);
		
		if(vehicule.getXCourant()==xcor2 
				 && vehicule.getYCourant()>yCorIinital)
			 cpt1=2;
		try {System.out.println(2);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 if(vehicule.getYCourant()> yCorIinital+2
			&& vehicule.getXCourant()== xcor2 && cpt1==2) {
		
		vehicule.avancer(0, -1);
		
	if(vehicule.getXCourant() <= xCorIinital
			 && vehicule.getYCourant()==yCorIinital+2)
		 cpt1=3;
	try {
		System.out.println(3);
		Thread.sleep(0);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	

	
	
	 if(cpt1 == 3 
			&& vehicule.getXCourant() < xCorIinital-2
			&& vehicule.getYCourant() == yCorIinital+2)
		
		{
		 vehicule.avancer(1, 0);
		 System.out.println(vehicule.getYCourant());
		 System.out.println(yCorIinital);
		if(vehicule.getXCourant() == xCorIinital-2
				&& vehicule.getYCourant() == yCorIinital+2)
			{cpt1=0;
		xcor2++;ycor2--;
		yCorIinital=yCorIinital+2;
		xCorIinital=xCorIinital-2;
		
		System.out.println(4);
		}
		
			}
		
		}
	







			//**************************************************************

	


if(vehicule.getID()==3) {
	
	
	if(vehicule.getYCourant()<ycor3
			&& vehicule.getXCourant() < xcor3 && cpt1 == 0) {
		
		vehicule.avancer(1, 0);
		
	  if(vehicule.getXCourant()==xcor3
			 && vehicule.getYCourant()==yCorIinital)
		 cpt1=1;
	  
	  try {
		  System.out.println(vehicule.getXCourant());
		Thread.sleep(0);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	
	
	
	 if(vehicule.getYCourant() >= yCorIinital
			&& vehicule.getXCourant() == xcor3 && cpt1==1 ) {
		vehicule.avancer(0, 1);
		
		if(vehicule.getXCourant()==xcor3 
				 && vehicule.getYCourant()==ycor3)
			 cpt1=2;
		try {System.out.println(2);
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	 if(vehicule.getYCourant() == ycor3
			&& vehicule.getXCourant() > xCorIinital+2 && cpt1==2) {
		
		vehicule.avancer(-1, 0);
		
	if(vehicule.getXCourant() == xCorIinital+2
			 && vehicule.getYCourant()==ycor3)
		 cpt1=3;
	try {
		System.out.println(3);
		Thread.sleep(00);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	

	
	
	 if(cpt1 == 3 
			&& vehicule.getXCourant() == xCorIinital+2
			&& vehicule.getYCourant() > yCorIinital+2)
		
		{
		 vehicule.avancer(0, -1);
		 System.out.println(vehicule.getYCourant());
		 System.out.println(yCorIinital);
		if(vehicule.getXCourant() == xCorIinital+2
				&& vehicule.getYCourant() == yCorIinital+2)
			{cpt1=0;
		xcor3--;ycor--;
		yCorIinital=yCorIinital+2;
		xCorIinital=xCorIinital+2;
		
		System.out.println(4);
		}
		
			}
		
		}
	





			//**************************************************************

else if(vehicule.getID()!= 1 && vehicule.getID()!= 2 && vehicule.getID()!= 0 && 
vehicule.getID()!= 3  ) {
	
	
	 int x=0,y=0;
	 int k = (int) (Math.random()*4);
	  if(k==0) {x=1 ; y=1;}
	  if(k==1) {x=-1 ; y=-1;}
	  if(k==2) {x=1 ; y=-1;}
	  if(k==3) {x=-1 ; y=1;}
	  
	  if(!new Case(x, y).isOccupee())
	  vehicule.avancer(x, y);
}
try {
	Thread.sleep(10);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

				}
					
					
					
					
					
				
				
				
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
				
				
				
			  
			  });
	
	
	
	
	
	
	
	
	

	}}
