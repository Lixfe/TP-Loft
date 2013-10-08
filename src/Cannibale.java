import java.util.LinkedList;

public class Cannibale extends Neuneu {

	//CONSTRUCTEURS
	/**
	 * Constructeur du Neuneu Cannibale : 
	 * Sa position de départ est à l'origine, il a 20 d'energie.
	 * 
	 * Ce constructeur contient l'argument Loft pour donner un lien au Loft.
	 */
 
  public Cannibale(String n, Loft L) {
	  this.nom = n ;
	  this.positionx = 0;
	  this.positiony = 0;
	  this.energie=20 ;
	  this.maison = L;
  }
  
  /**
   * Constructeur Cannibale avec position donnee : on cree un nouveau neuneu cannibale ayant une position donnee
   * @param n : Nom du neuneu
   * @param L : Loft dans lequel il se trouve
   * @param x : abscisse du neuneu
   * @param y : ordonnee du neuneu
   */
  public Cannibale(String n, Loft L, int x, int y) {
	  this.nom = n ;
	  this.positionx = x;
	  this.positiony = y;
	  this.energie=20 ;
	  this.maison = L;
  }
  
  
  //METHODES
  
  /**
   * Methode sedeplacer() : deplace le neuneu de type cannibale sur une case adjacente.
   * 
   * Le neuneu Cannibale possede une strategie de deplacement :  il va se diriger vers le neuneu le plus proche.
   */
  public void sedeplacer(){
	  //On cherche le neuneu le plus proche
	  
	  //Correspond a la position du neuneu le plus proche dans la liste de neuneu
	  int index;
	  index = -1;
	 
	  //distance entre un neuneu et le neuneu cannibale considere. On prendra comme definition de distance la distance euclidienne au carre
	  double distance;
	  distance =  Double.POSITIVE_INFINITY; 
	  
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
				 this.positionx = this.positionx + (int) (this.maison.Population.get(index).positionx - this.positionx)/Math.abs(this.maison.Population.get(index).positionx - this.positionx);
			 }
			 if (this.maison.Population.get(index).positiony - this.positiony != 0)
			 {
				 this.positiony = this.positiony + (int) (this.maison.Population.get(index).positiony - this.positiony)/Math.abs(this.maison.Population.get(index).positiony - this.positiony);
			 }
		 }
		 
		  /* A chaque deplacement on faire perdre 1 point d'energie*/
		  this.energie = this.energie - 1;
		  
		  System.out.println("Le neuneu "+this.nom+" s'est deplace. Nouvelle energie : "+this.energie);
		  System.out.println("Sa nouvelle position est : x="+this.positionx+" ; y="+this.positiony);
		  			  
  }
		  
		  
  public void manger(){
	  //Si un autre neuneu d'un autre type que cannibale, le cannibale va le manger
	  for (Neuneu neu : this.maison.Population)
	  {
		  if (neu.positionx == this.positionx && neu.positiony == this.positiony && this != neu && neu.getClass().getName()!="Cannibale")
		  {
			  //Le cannibale va manger le neuneu et gagner son energie
			  this.energie = this.energie + neu.energie;
			  neu.etremange();
			  System.out.println("Le neuneu "+this.nom+" a mange le neuneu "+neu.nom+".");
			  System.out.println("Son energie est maintenant"+this.energie);
			  break;
		  }
	  }
	    
  }
  
  /**
   * Methode sereproduire() : Le neuneu identifie si un autre neuneu cannibale est present sur la meme case que lui.
   * Si oui, il se reproduit avec ce neuneu et cree un neuneu fils.
   * Le neuneu cannibale ne se reproduit qu'avec des cannibales
   */
  public LinkedList<Neuneu> sereproduire(){
	  LinkedList<Neuneu> listeFils = new LinkedList<Neuneu>();
	  for (Neuneu neu : this.maison.Population)
	  {
		  if (neu.positionx == this.positionx && neu.positiony == this.positiony && this != neu && neu.getClass().getName() == "Cannibale")
		  {
			  //On cree un fils de type Cannibale 
			  Neuneu fils = new Cannibale(this.nom+neu.nom, this.maison, this.positionx, this.positiony);
			  System.out.println("Le neuneu "+this.nom+" et le neuneu "+neu.nom+" se sont reproduits. Il en resulte la naissance du neuneu "+fils.nom+", de type Cannibale");
			  listeFils.add(fils);
			  break;
		  }

	  }
	  return listeFils;

  }
  
  
  public void dormir() {
	  
  }

/**
* Lorsque le neuneu se fait manger par un cannibale, son energie est reduite a 0.
*/
public void etremange(){
  this.energie = 0;

}
}
  
  
  