/*
 */
abstract class Nourriture implements Mangeable {

//ATTRIBUTS	
	
  public int quantite; //quantite toujours �gale � 1 ou 0, selon qu'il en retse ou non

  public int energie;

  
//METHODES  
  public void etremange(){
	  this.quantite=0 ;
  }

}