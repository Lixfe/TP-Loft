import java.util.*;

public abstract class Neuneu implements Mangeable {

  protected int positionx;
  protected int positiony;
  protected int energie;
  protected String nom;
  protected int alcoolemie;
  protected Loft maison;

  public abstract void sedeplacer(int x, int y);
  public abstract void manger(Mangeable nourriture);
  public abstract Neuneu sereproduire(Neuneu partenaire);
  public abstract void dormir();
  
  public void etremange(){
	  this.energie = 0;
			  for (Neuneu neu : this.maison.Population) {
				
				
			}
				
			}
  }

}