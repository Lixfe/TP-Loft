public class Lapin extends Neuneu {

	//CONSTRUCTEURS
	/**
	 * Constructeur du Neuneu Lapin : 
	 * Sa position de depart est a l'origine, il a 20 d'energie.
	 * 
	 * Ce constructeur contient l'argument Loft pour donner un lien au Loft.
	 */
 
  public Lapin(String n, Loft L) {
	  this.nom = n ;
	  this.positionx = 0;
	  this.positiony = 0;
	  this.energie=20 ;
	  this.maison = L;
  }

  /**
   * Constructeur Lapin avec position donnee : on cree un nouveau neuneu lapin ayant une position donnee
   * @param n : Nom du neuneu
   * @param L : Loft dans lequel il se trouve
   * @param x : abscisse du neuneu
   * @param y : ordonnee du neuneu
   */
  public Lapin(String n, Loft L, int x, int y) {
	  this.nom = n ;
	  this.positionx = x;
	  this.positiony = y;
	  this.energie=20 ;
	  this.maison = L;
  }
  
  
  /**
   * Methode sedeplacer() : deplace le neuneu Lapin.
   * 
   * Le neuneu lapin possède une strategie de deplacement : il cherche le neuneu le plus proche puis se deplace dans sa direction.
   * 
   */
  public void sedeplacer() {
	  //on parcourt d'abord la liste de neuneus presents sur le plateau pour trouver le plus proche
	  
	  //Correspond a la position du neuneu le plus proche dans la liste de neuneu
	  int index;
	 index = -1;
	 //correspond a la distance entre un neuneu et le neuneu lapin considere. On prendra comme definition de distance la distance euclidienne au carre
	 int distance;
	 distance = 0;
	 
	 //on va chercher le neuneu le plus proche, i.e. ayant la distance minimale tout en etant sur une case differente
	  for (Neuneu neu : this.maison.Population)
	  {
		  if (distance > (neu.positionx - this.positionx)*(neu.positionx - this.positionx)+(neu.positiony - this.positiony)*(neu.positiony - this.positiony) && neu != this && (neu.positionx - this.positionx)*(neu.positionx - this.positionx)+(neu.positiony - this.positiony)*(neu.positiony - this.positiony)>0)
		  {
			  distance = (neu.positionx - this.positionx)*(neu.positionx - this.positionx)+(neu.positiony - this.positiony)*(neu.positiony - this.positiony);
			  index = this.maison.Population.indexOf(neu);					  
		  }
	  }
	 
	  //Si le neuneu lapin est tout seul dans le loft, il se deplace aleatoirement
	 if (index == -1)
	 {
		  int a,b;
		  		  do
		  {
			  a = (int)((Math.random()*3.)) - 1;	  
			  b = (int)((Math.random()*3.)) - 1;
			  /*Nombres aleatoires entre -1 et 1*/		
		  } while (((this.positionx + a >= this.maison.Plateau[0].length) || (this.positionx + a < 0)) || (this.positiony + b >= this.maison.Plateau.length || this.positiony + b < 0) ||(a==0 && b==0));
		  
		  this.positionx = this.positionx+a;
		  this.positiony = this.positiony+b;
		  
	 }
	 else //si on a trouve un neuneu dans le loft on se deplace vers lui
	 {
		 if (this.maison.Population.get(index).positionx - this.positionx != 0)
		 {
			 this.positionx = (this.maison.Population.get(index).positionx - this.positionx)/Math.abs(this.maison.Population.get(index).positionx - this.positionx);
		 }
		 if (this.maison.Population.get(index).positiony - this.positiony != 0)
		 {
			 this.positiony = (this.maison.Population.get(index).positiony - this.positiony)/Math.abs(this.maison.Population.get(index).positiony - this.positiony);
		 }
	 }
	 
	  /* A chaque deplacement on faire perdre 1 point d'energie*/
	  this.energie = this.energie - 1;
	  
	  System.out.println("Le neuneu "+this.nom+" s'est deplace. Nouvelle energie : "+this.energie);
	  System.out.println("Sa nouvelle position est : x="+this.positionx+" ; y="+this.positiony);
	  
  }
  
  
  
}