import java.util.*;

public class Erratique extends Neuneu {

	/**
	 * Constructeur du Neuneu Erratique : 
	 * Sa position de départ est à l'origine, il a 20 d'energie.
	 * 
	 * Ce constructeur contient l'argument Loft pour donner un lien au Loft.
	 */
 
  public Erratique(String n, Loft L) {
	  this.nom = n ;
	  this.positionx = 0;
	  this.positiony = 0;
	  this.energie=20 ;
	  this.maison = L;
  }
  
  public void sedeplacer(int x, int y){
	  
  }

  public void manger(Mangeable bouffe){
	  
  }

  public Neuneu sereproduire(Neuneu partenaire){
	  
  }
  
  public void dormir(){
	  
  }
  
 
}
