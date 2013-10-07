
public class TPLoft {

	public static void main(String[] args) {
		// SCENARIO DE TEST POUR LE LOFT
		
		//ETAPE1 création du Loft
		Loft loft = new Loft() ;
		
		//ETAPE2 ajout de nourriture
		Legume poireau=new Legume();
		Legume patate=new Legume();
		Pizza margherita = new Pizza();
		
		loft.Plateau[1][6].reserve.add(margherita);
		loft.Plateau[5][9].reserve.add(poireau);
		loft.Plateau[8][2].reserve.add(patate);
		
		//ETAPE3 ajout d'un Neuneu
		Erratique luc = new Erratique("Luc", loft);
		
		//ETAPE4 affichage du loft
		loft.afficher();
		
		
		
	
	}

}
