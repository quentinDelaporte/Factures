package p;

import java.util.Date;

public final class App {
    public static void main(String[] args) {
        Client c=new Client("roger","william.roger@laposte.net", TypeClient.PARTICULIER);
        Produit p1= new Produit(849, 150 , "Pomme rouge", new TypeProduit(120, "fruits & legumes"));
        Produit p2= new Produit(859, 130 , "Pomme verte", new TypeProduit(120, "fruits & legumes"));
        Produit p3= new Produit(209, 120 , "Pomme D'or", new TypeProduit(120, "fruits & legumes"));
        Facture f= new Facture(435445, new Date() , c);
        f.ajouterProduit(p1, 3);
        f.ajouterProduit(p2, 8);
        f.ajouterProduit(p3, 4);
        f.ajouterProduit(p1, 1);
        f.retirerProduit(p1, 3);
        System.out.println(f);
    }
}
