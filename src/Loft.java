import java.util.*;


//CONSTRUCTEURS
public class Loft {

  protected LinkedList<Neuneu> Population;
  protected  Cases[][] Plateau; //matrice de cases contenant chacune de la nourriture

  /**Constructeur du Loft par defaut
   * Cree un Loft de 10*10 cases
   * Il n'y a pas d'habitant
   * les cases sont initialisees avec leur constructeur par defaut, donc sont vierge de nourriture
   * 
   */
  public Loft() {
	  this.Population = new LinkedList<Neuneu>();
	  this.Plateau = new Cases[10][10] ;
	  for (int i = 0; i < 10; i++) {
		  for (int j = 0; j < 10; j++) {
			  this.Plateau[i][j]=new Cases();
			
		}
		
	}
  }

  public void afficher() {
	  //Affichage des Neuneus
	  for (Neuneu n : this.Population) {
		System.out.println(n.nom+" est a la position "+n.positionx+" , "+n.positiony);
	  }
	  
	  //Affichage de la nourriture (pour laquelle la quantite est 1) en parcourant le tableau des cases, puis la liste des nourritures sur chacune de ces cases
	  for (int i = 0; i < this.Plateau.length; i++) {
		  for (int j = 0; j < this.Plateau[0].length; j++) {
			  for (Nourriture bouffe : this.Plateau[i][j].reserve){
				  if (bouffe.quantite>0){
				  	System.out.println("nourriture sur la case x="+j+" , y="+i+" : "+ bouffe.getClass().getName());
				  }
			  }
		}
		
	}
	  
  }  

  
  /**Methode Naissance
   * Ajoute un nouveau Neuneu a la population du Loft
   */
  public void naissance( Neuneu bebe ) {
	  this.Population.add(0, bebe);	  
  }

}	