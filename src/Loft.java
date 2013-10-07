import java.util.*;

public class Loft {

  protected LinkedList<Neuneu> Population;
  protected Plateau Cases[][] ; //matrice de cases contenant chacune de la nourriture

  /**Constructeur du Loft par d�faut
   * Cr�e un Loft de 10*10 cases
   * Il n'y a pas d'habitant
   * les cases sont initialis�es avec leur constructeur par d�faut, donc sont vierge de nourriture
   * 
   */
  public Loft() {
	  this.Population = new LinkedList<Neuneu>();
	  this.Plateau = new Cases[10][10] ;
	  for (int i = 0; i < 10; i++) {
		  for (int j = 0; j < 10; j++) {
			  this.Plateau[i][j]=Cases();
			
		}
		
	}
  }

  public void afficher() {}  

  public void naissance( Neuneu ) {
  }

}