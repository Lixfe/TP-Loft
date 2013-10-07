import java.util.*;


//CONSTRUCTEURS
public class Loft {

  protected LinkedList<Neuneu> Population;
  protected  Cases[][] Plateau; //matrice de cases contenant chacune de la nourriture

  /**Constructeur du Loft par défaut
   * Crée un Loft de 10*10 cases
   * Il n'y a pas d'habitant
   * les cases sont initialisées avec leur constructeur par défaut, donc sont vierge de nourriture
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
		System.out.println(n.nom+" est à la position "+n.positionx+" , "+n.positiony);
	  }
	  
	  //Affichage de la nourriture
	  
  }  

  
  /**Méthode Naissance
   * Ajoute un nouveau Neuneu à la population du Loft
   */
  public void naissance( Neuneu bébé ) {
	  this.Population.add(0, bébé);	  
  }

}	