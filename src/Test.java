import java.util.*;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.out.flush();
		
		//ETAPE1 creation du Loft
		Loft loft = new Loft() ;
		
		//ETAPE2 ajout de nourriture
		Legume poireau=new Legume();
		Legume patate=new Legume();
		Pizza margherita = new Pizza();
		
		loft.Plateau[1][4].reserve.add(margherita);
		loft.Plateau[3][2].reserve.add(poireau);
		loft.Plateau[8][2].reserve.add(patate);
		
		//ETAPE3 ajout d'un Neuneu
		Vorace luc = new Vorace("Luc", loft);
		loft.naissance(luc);

		
		//ETAPE4 affichage du loft
		loft.afficher();

		
		//ETAPE5 faire jouer les joueurs : tant qu'il y a des joueurs, ils font chacun leur tour l'enchainement se d�placer - manger - se reproduire
		
		System.out.println("debut du jeu");
		
		while (loft.Population.isEmpty()==false) {
			
			// On cree une liste contenant les neuneus qui se sont nes pendant un tour, et qui apparaitront a la fin du tour sur le plateau
			LinkedList<Neuneu> listeNaissance = new LinkedList<Neuneu>();
			
			//utilisation listiterator pour pouvoir ajouter les neuneus qui naissent au fur et a mesure
			ListIterator<Neuneu> litr = loft.Population.listIterator();
			
			while (litr.hasNext()) 
			{
				Neuneu joueur = litr.next();
				

				
				// tour de jeu d'un neuneu
				if (joueur.energie>0)
				{
				joueur.sedeplacer();
				joueur.manger();
				listeNaissance.addAll(joueur.sereproduire());
				}
			}
			
			//On ajoute les neuneus nee pendant le tour sur le plateau
			loft.Population.addAll(listeNaissance);
				
			
			//suppression des neuneus qui n'ont plus d'energie : on parcourt la liste et on verifie pour chacun qu'ils ont assez d'energie
			for (int i=0 ; i<loft.Population.size() ; i++){
				Neuneu joueuri = loft.Population.get(i); //joueur est le joueur d'index i dans la liste
				if (joueuri.energie<=0) {				
					System.out.println(joueuri.nom+" est mort !");	
					loft.Population.remove(i);

				}
			}
			
		}	
		
		//ETAPE6 affichage du loft � la fin du jeu
		loft.afficher();
		
		
	}

}
