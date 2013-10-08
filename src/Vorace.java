import java.util.LinkedList;

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

  /**
   * Constructeur Vorace avec position donnee : on cree un nouveau neuneu vorace ayant une position donnee
   * @param n : Nom du neuneu
   * @param L : Loft dans lequel il se trouve
   * @param x : abscisse du neuneu
   * @param y : ordonnee du neuneu
   */
  public Vorace(String n, Loft L, int x, int y) {
	  this.nom = n ;
	  this.positionx = x;
	  this.positiony = y;
	  this.energie=20 ;
	  this.maison = L;
  }
  
  //METHODES
  
  /**
   * Methode sedeplacer() : deplace le neuneu de type vorace sur une case adjacente.
   * 
   * Le neuneu Vorace possede une strategie de deplacement :  il va se diriger vers la case contenant de la nourriture la plus proche.
   */
  public void sedeplacer(){
	  //On cherche la case la plus proche avec de la nourriture
	  //distance entre une et le neuneu vorace considere. On prendra comme definition de distance la distance euclidienne au carre
	  double distance;
	  distance =  Double.POSITIVE_INFINITY; 
	  //Position de la nourriture la plus proche
	  int x,y;
	  x=-1;
	  y=-1;
	  //On est place du point de vue d'une matrice : les abscisses x correspondent aux colonnes, les ordonnees y aux numeros de ligne.
	  //On a donc Plateau[y][x]
	  for (int i=0 ; i<this.maison.Plateau.length ; i++){
		  for (int j=0; j<this.maison.Plateau[i].length ; j++){
			  if (!this.maison.Plateau[i][j].reserve.isEmpty() && distance >(j - this.positionx)*(j-this.positionx)+(i-this.positiony)*(i-this.positiony)) 
			  {
				  y = i;
				  x = j;
				  distance = (j - this.positionx)*(j-this.positionx)+(i-this.positiony)*(i-this.positiony); 
			  }
		  }
	  }
	  
		//Si il n'y a plus de nourriture, le neuneu se deplace aleatoirement
		 if (x == -1)
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
		 else //si on a trouve de la nourriture dans le loft on se deplace vers la case la contenant
		 {
			 if (x - this.positionx != 0)
			 {
				 this.positionx = this.positionx + (int) (x - this.positionx)/Math.abs(x - this.positionx);
			 }
			 if (y - this.positiony != 0)
			 {
				 this.positiony = this.positiony + (int) (y - this.positiony)/Math.abs(y - this.positiony);
			 }
		 }
		 
		  /* A chaque deplacement on faire perdre 1 point d'energie*/
		  this.energie = this.energie - 1;
		  
		  System.out.println("Le neuneu "+this.nom+" s'est deplace. Nouvelle energie : "+this.energie);
		  System.out.println("Sa nouvelle position est : x="+this.positionx+" ; y="+this.positiony);
  }		  
	
  
  public void manger(){
/*
 * On regarde si de la nourriture est presente sur la case sur laquelle le neuneu est situe.
 * Si une nourriture est presente, on l'enleve de la liste -> la methode etremange n'est pas utile dans ce cas.
 */
	  if (!this.maison.Plateau[this.positiony][this.positionx].reserve.isEmpty() )
	  {
		Nourriture amanger = this.maison.Plateau[this.positiony][this.positionx].reserve.removeFirst();
		
		this.energie = this.energie+amanger.energie;
		
		System.out.println("Le neuneu "+this.nom+" a mange la nourriture "+amanger.getClass().getName()+" et a gagne de l'energie.");
		
	  }
  }

  /**
   * Methode sereproduire() : Le neuneu identifie si un autre neuneu est present sur la meme case que lui.
   * Si oui, il se reproduit avec ce neuneu et cree un neuneu fils.
   * Le type du neuneu est indifferent pour la reproduction
   */
  public LinkedList<Neuneu> sereproduire(){
	  LinkedList<Neuneu> listeFils = new LinkedList<Neuneu>();
	  for (Neuneu neu : this.maison.Population)
	  {
		  if (neu.positionx == this.positionx && neu.positiony == this.positiony && this != neu)
		  {
			  //On cree un fils de type Erratique pour ne pas que la population augmente de maniere exponentielle
			  Neuneu fils = new Erratique(this.nom+neu.nom, this.maison, this.positionx, this.positiony);
			  System.out.println("Le neuneu "+this.nom+" et le neuneu "+neu.nom+" se sont reproduits. Il en resulte la naissance du neuneu "+fils.nom+", de type " +fils.getClass().getName());
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
			  
