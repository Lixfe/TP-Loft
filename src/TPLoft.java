
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
		loft.naissance(luc);
		
		//ETAPE4 affichage du loft
		loft.afficher();
		
		//ETAPE5 faire jouer les joueurs : tant qu'il y a des joueurs, ils font chacun leur tour l'enchainement se déplace - manger - se reproduire
		
		System.out.println("début du jeu");
		while (loft.Population.isEmpty()==false) {
			
			for (Neuneu joueur : loft.Population){
				joueur.sedeplacer(x, y)
			}
			
		}
		
		
		
	
	}

}
