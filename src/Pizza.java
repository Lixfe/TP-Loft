public class Pizza extends Nourriture, Nourriture {
	
	
	
	//constructeur
	
	/**constructeur par d�faut : 
	*  cr�e une pizza unitaire de valeur �nerg�tique pr�d�finie
	*/
  public void Pizza() {
	  Object p = Nourriture;
	  p.quantite = 1;
	  p.energie = 5 ;
  }

  /**contructeur cr�ant une pizza de quantite q et de valeur e 
   * 
   */
  public void ajouter(int q,int e) {
  }

}