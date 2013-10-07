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
   * Le neuneu lapin possède une strategie de deplacement : si un neuneu se trouve sur une case adjacente, il va le rejoindre pour se reproduire avec lui.
   * 
   */
  public void sedeplacer() {
	  //on cherche d'abord la presence d'un autre neuneu sur une case adjacente, et on s'y deplace si on en trouve un
	  boolean pasdeplace = true; // permet de savoir si il y a eu un break
	  for (Neuneu neu : this.maison.Population)
	  {
		  if ((neu.positionx <= this.positionx + 1) && (neu.positionx >= this.positionx -1) && (neu.positiony <= this.positiony + 1) && (neu.positiony >= this.positiony -1))
		  {
			  this.positionx = neu.positionx;
			  this.positiony = neu.positiony;
			  pasdeplace = false;
			  break;

		  }
	  }
	 
	  //Si on n'a pas trouve de neuneu a proximite on se deplace de maniere aleatoire
	 if (pasdeplace)
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
	 
	  /* A chaque deplacement on faire perdre 1 point d'energie*/
	  this.energie = this.energie - 1;
	  
	  System.out.println("Le neuneu "+this.nom+" s'est deplace. Nouvelle energie : "+this.energie);
	  System.out.println("Sa nouvelle position est : x="+this.positionx+" ; y="+this.positiony);
	  
  }
  
  
  
}