package p;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

/**
 * Unit test for simple App.
 */
class FactureTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testCalculPrixTTC() {
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 2);

        
        assertEquals(f.PrixGlobalTTC(), (2*120*200)/100);
    }
    
    @Test
    void testPrixHT(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 2);
        assertEquals(f.prixTTC(p, 2), (200*2*120)/100);
    }

    @Test
    void testPrixGlobalTTC(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 2);
        Produit p2 = new Produit(2, 200, "chaise", new TypeProduit(120, "z"));
        f.ajouterProduit(p2, 1);
        assertEquals(f.PrixGlobalTTC(), (200*120*2+200*120*1)/100 );
    }

    @Test
    void testPrixGlobalHC(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 2);
        Produit p2 = new Produit(2, 200, "chaise", new TypeProduit(120, "z"));
        f.ajouterProduit(p2, 1);
        assertEquals(f.PrixGlobalHT(), 200*2+200*1 );
    }

    @Test
    void testAjouterProduitExistant(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 2);
        f.ajouterProduit(p, 1);
        f.ajouterProduit(p, 4);
        assertEquals(f.getProduits().get(p), 7);
    }

    @Test
    void testAjouterProduitInexistant(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 2);
        assertEquals(f.getProduits().get(p), 2);
    }

    @Test
    void testRetirerProduitExistant(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 7);
        f.retirerProduit(p, 1);
        f.retirerProduit(p, 4);
        System.out.println(f.getProduits().get(p));
        assertEquals(f.getProduits().get(p), 2);
    }

    @Test
    void testRetirerProduitInexistant(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        Produit p2 = new Produit(1, 2010, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p, 7);
        f.retirerProduit(p2, 1);
      
        System.out.println(f.getProduits().get(p));
        assertEquals(f.getProduits().containsKey(p2), false);
    }

    @Test
    void testRetirerProduitEnTotalite(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        Produit p2 = new Produit(1, 2010, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p2, 7);
        f.retirerProduit(p2, 7);
      
        assertEquals(f.getProduits().containsKey(p2), false);
    }

    @Test
    void testRetirerPlusDeProduitQuilNyEnA(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        Produit p2 = new Produit(1, 2010, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p2, 7);
        f.retirerProduit(p2, 8);
      
        assertEquals(f.getProduits().containsKey(p2), false);
    }

    @Test
    void testQuantiteGlobale(){
        Facture f = new Facture(12, new Date(), new Client("john", "johnCena@outlook.fr", TypeClient.PARTICULIER));
        Produit p = new Produit(1, 200, "table", new TypeProduit(120, "z"));
        Produit p2 = new Produit(1, 2010, "table", new TypeProduit(120, "z"));
        f.ajouterProduit(p2, 1);
        f.ajouterProduit(p, 2);
        assertEquals(f.quantiteGlobale(),3);
    }
}
