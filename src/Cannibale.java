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
  
  
}