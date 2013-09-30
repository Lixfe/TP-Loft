import java.util.*;

public abstract class Neuneu {

  protected int positionx;
  protected int positiony;
  protected int energie;
  protected String nom;
  protected int alcoolemie;
  protected Loft maison;

  public abstract void sedeplacer(int x, int y);
  public abstract void manger(Mangeable nourriture);
  public abstract LinkedList<Neuneu> sereproduire(LinkedList<Neuneu> partenaires);
  public abstract void dormir();

}