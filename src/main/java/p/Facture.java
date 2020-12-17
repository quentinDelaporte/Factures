package p;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Facture {
    private int montantTTC;
    private HashMap<Produit, Integer> produits;
    private int montantHT;
    private int id;
    private Date date;
    private Client client;

    public Facture(int id, Date date, Client client) {
        this.id = id;
        this.date = date;
        this.client = client;
        produits = new HashMap<Produit, Integer>();
    }

    public void ajouterProduit(Produit p, int qte) {
        if (produits.containsKey(p)) {
            int quantite = produits.get(p);
            produits.remove(p);
            produits.put(p, quantite + qte);
        } else
            produits.put(p, qte);
    }

    public void retirerProduit(Produit p, int qte) {
        if (produits.containsKey(p)) {
            int quantite = produits.get(p);
            produits.remove(p);
            if (quantite > qte)
                produits.put(p, quantite - qte);
        }
    }

    public int PrixGlobalHT(){
        int i=0;
        for (Entry<Produit, Integer> entry : produits.entrySet()) 
            i+=entry.getValue() * entry.getKey().getPrixHT();
        return i;
    }

    public int PrixGlobalTTC(){
        int i=0;
        for (Entry<Produit, Integer> entry : produits.entrySet()) 
            i+=entry.getValue() * (entry.getKey().getPrixHT() * entry.getKey().getTypeProduit().getTva())/100;
        return i;
    }

    public String toString() {
        String s = client.toString();
        for (Entry<Produit, Integer> entry : produits.entrySet()) {
            s+= "\n"+ entry.getKey().toString();
            s+= "     quantite: " + entry.getValue() +"\n";
            s+= "     prix HT: " + prixHT(entry.getKey(),entry.getValue())+ "\n";
            s+= "     prix TTC: " + prixTTC(entry.getKey(),entry.getValue())+ "\n";
        }
        s+= "\n\n Prix global HT :" + PrixGlobalHT();
        s+= "\n Prix global TTC :" + PrixGlobalTTC();
        s+= "\n quantité de produit globale: " + quantiteGlobale();
              
        return s;
    }


    public double prixHT(Produit p, Integer q) {
        return p.getPrixHT() * q ;
    }

    public double prixTTC(Produit p, Integer q) {
        return p.getPrixHT() * q*(p.getTypeProduit().getTva())/100;
    }

    public HashMap<Produit, Integer> getProduits() {
        return produits;
    }

    public int quantiteGlobale(){
        int i=0;
        for (Entry<Produit, Integer> entry : produits.entrySet()) 
            i+=entry.getValue();
        return i;
    }






}