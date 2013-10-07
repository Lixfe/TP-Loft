import java.util.*;

public class Erratique extends Neuneu {

	/**
	 * Constructeur du Neuneu Erratique : 
	 * Sa position de d�part est � l'origine, il a 20 d'energie.
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
  
  /**
   * Methode pour le deplacement du neuneu erratique.
   * 
   * Ce neuneu ne possède pas de stratégie de déplacement, il va de manière aléatoire dans une case adjacente.
   * (Les déplacements diagonaux sont autorisés)
   */
  public void sedeplacer(){
	  int a,b;
	  do
	  {
		  /*Nombre aleatoire entre -1 et 1*/
		  a = Random.nextInt(3)-1;
	  } while (this.positionx + a < this.maison.Plateau[0].length && this.positionx + a >= 0);
	  do
	  {
		  b = Random.nextInt(3)-1;
	  } while (this.positiony + b < this.maison.Plateau.length && this.positiony + b >= 0);
	  
	  this.positionx = this.positionx+a;
	  this.positiony = this.positiony+b;
	  
	  /* A chaque deplacement on faire perdre 1 point d'energie*/
	  this.energie = this.energie - 1;
	  
	  System.out.println("Le neuneu "+this.nom+" s'est deplace.");
	  System.out.println("Sa nouvelle position est : x="+this.positionx+" ; y="+this.positiony);
  }

  public void manger(Mangeable bouffe){
	  
  }

  public Neuneu sereproduire(Neuneu partenaire){
	  
  }
  
  public void dormir(){
	  
  }
  
 
}
