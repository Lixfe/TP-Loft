import java.math.*;

public class Erratique extends Neuneu {

	/**
	 * Constructeur du Neuneu Erratique : 
	 * Sa position de depart est a l'origine, il a 20 d'energie.
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
   * Constructeur Erratique avec position donnee : on cree un nouveau neuneu erratique ayant une position donnee
   * @param n : Nom du neuneu
   * @param L : Loft dans lequel il se trouve
   * @param x : abscisse du neuneu
   * @param y : ordonnee du neuneu
   */
  public Erratique(String n, Loft L, int x, int y) {
	  this.nom = n ;
	  this.positionx = x;
	  this.positiony = y;
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
		  a = (int)(Math.random()*2 - 1);
	  } while (this.positionx + a < this.maison.Plateau[0].length && this.positionx + a >= 0);
	  do
	  {
		  b = (int)(Math.random()*2 - 1);
	  } while (this.positiony + b < this.maison.Plateau.length && this.positiony + b >= 0);
	  
	  this.positionx = this.positionx+a;
	  this.positiony = this.positiony+b;
	  
	  /* A chaque deplacement on faire perdre 1 point d'energie*/
	  this.energie = this.energie - 1;
	  
	  System.out.println("Le neuneu "+this.nom+" s'est deplace.");
	  System.out.println("Sa nouvelle position est : x="+this.positionx+" ; y="+this.positiony);
  }

  /**
   * Methode manger : si de la nourriture est presente sur la case, il la mange.
   * Manger une nourriture augmente l'energie du neuneu de l'energie contenue dans la nourriture.
   * La nourriture est ensuite enlevee de la case
   */
  public void manger(){
/*
 * On regarde si de la nourriture est presente sur la case sur laquelle le neuneu est situe.
 * Si une nourriture est presente, on l'enleve de la liste -> la methode etremange n'est pas utile dans ce cas.
 */
	  if (this.maison.Plateau[this.positiony][this.positionx].reserve.size()>=1 )
	  {
		this.energie = this.maison.Plateau[this.positiony][this.positionx].reserve.removeFirst().energie;
	  }
  }

  /**
   * Methode sereproduire() : Le neuneu identifie si un autre neuneu est present sur la meme case que lui.
   * Si oui, il se reproduit avec ce neuneu et cree un neuneu fils.
   * Le type du neuneu est indifferent pour la reproduction
   */
  public Neuneu sereproduire(){
	  for (Neuneu neu : this.maison.Population)
		  if (neu.positionx == this.positionx && neu.positiony == this.positiony && this != neu)
		  {
			  Neuneu fils = new Erratique
		  }
  }
  
  public void dormir(){
	  
  }
  
 /**
  * Lorsque le neuneu se fait manger par un cannibale, son energie est reduite a 0.
  */
  public void etremange(){
	  this.energie = 0;
  }
  
}
