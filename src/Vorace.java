public class Vorace extends Neuneu {

	//CONSTRUCTEURS
	/**
	 * Constructeur du Neuneu Vorace : 
	 * Sa position de départ est à l'origine, il a 20 d'energie.
	 * 
	 * Ce constructeur contient l'argument Loft pour donner un lien au Loft.
	 */
 
  public Vorace(String n, Loft L) {
	  this.nom = n ;
	  this.positionx = 0;
	  this.positiony = 0;
	  this.energie=20 ;
	  this.maison = L;
  }

}