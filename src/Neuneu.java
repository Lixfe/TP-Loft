public abstract class Neuneu {

  protected Integer Positionx;

  protected Integer Energie;

  protected Integer Possitiony;

  protected String Nom;

  public int Alcoolémie;

  protected Loft Maison;

  public abstract void sedeplacer(int x, int y);

  public abstract void manger(mangeable nourriture);

  public abstract Array<neuneu> sereproduire(Array<neuneu> partenaires);

  public abstract void dormir();

}