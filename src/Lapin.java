public class Lapin extends Neuneu {

	//CONSTRUCTEURS
	/**
	 * Constructeur du Neuneu Lapin : 
	 * Sa position de d�part est � l'origine, il a 20 d'energie.
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

}