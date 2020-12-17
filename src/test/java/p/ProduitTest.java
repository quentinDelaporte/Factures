package p;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class ProduitTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testCalculPrixTTC() {
        Produit p=new Produit(44, 120, "pomme", new TypeProduit(120, "alimentaire"));
  
        assertEquals(p.calculPrixTTC()/100, 120*1.20);
    }
    
}
