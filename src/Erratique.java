import java.util.*;

public class Erratique extends Neuneu {

	
	/**
	 * Constructeur par défaut du Neuneu Erratique : 
	 * Sa position est generee aleatoirement, il a 20 d'energie.
	 * 
	 * Ce constructeur contient l'argument Loft pour donner un lien au Loft.
	 */
  public void Erratique(Loft leLoft) {
	  this.nom = "erratique";
	  this.positionx = Random.nextInt(10);
	  this.positiony = Random.nextInt(10);
	  this.energie = 20;
	  this.maison = leLoft;
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
