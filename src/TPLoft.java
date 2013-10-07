
public class TPLoft {

	/**Main : met en jeu un scénario simple, avec un individu et quelques en-cas
	 * 
	 */
	public static void main(String[] args) {
		// SCENARIO DE TEST POUR LE LOFT
		
		System.out.flush();
		
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

		
		//ETAPE5 faire jouer les joueurs : tant qu'il y a des joueurs, ils font chacun leur tour l'enchainement se déplacer - manger - se reproduire
		
		System.out.println("début du jeu");
		
		while (loft.Population.isEmpty()==false) {
			
			for (Neuneu joueur : loft.Population){
				//tour de jeu d'un neuneu
				joueur.sedeplacer();
				joueur.manger();
				joueur.sereproduire();
			}
			
			//suppression des neuneus qui n'ont plus d'énergie : on parcourt la liste et on verifie pour chacun qu'ils ont assez d'energie
			for (int i=0 ; i<loft.Population.size() ; i++){
				Neuneu joueuri = loft.Population.get(i); //joueur est le joueur d'index i dans la liste
				if (joueuri.energie<=0) {				
					System.out.println(joueuri.nom+" est mort !");	
					loft.Population.remove(i);

				}
			}
			
		}	
		
		//ETAPE6 affichage du loft à la fin du jeu
		loft.afficher();
		
	}
}
