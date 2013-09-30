public class Pizza extends Nourriture, Nourriture {
	
	
	
	//constructeur
	
	/**constructeur par défaut : 
	*  crée une pizza unitaire de valeur énergétique prédéfinie
	*/
  public void Pizza() {
	  Object p = Nourriture;
	  p.quantite = 1;
	  p.energie = 5 ;
  }

  /**contructeur créant une pizza de quantite q et de valeur e 
   * 
   */
  public void ajouter(int q,int e) {
  }

}