import java.util.*;

public class Loft {

  protected LinkedList<Neuneu> Population;

  protected Plateau Cases ;

  /**Constructeur du Loft par d�faut
   * Cr�e un Loft de 10*10 cases
   * Il n'y a pas d'habitant
   * il n'y a pas de nourriture
   * 
   */
  public Loft() {
	  this.Population = new LinkedList<Neuneu>();
	  this.Plateau = new Cases ;
  }

  public void afficher() {
  }

  public void naissance( Neuneu ) {
  }

}