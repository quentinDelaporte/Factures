package p;

public class Produit {
    private int code;
    private int prixHT;
    private String libelle;
    private TypeProduit type;

    public Produit(int code, int prixHT, String libelle, TypeProduit type) {
        this.code = code;
        this.prixHT = prixHT;
        this.libelle = libelle;
        this.type = type;
    }

    public int calculPrixTTC(){
        return prixHT*(type.getTva());
    }

    @Override
    public String toString() {
        return libelle+" :\n     Code : "+code+"\n     Prix HT unitaire: "+ prixHT +" € \n     Prix TTC unitaire: "+ calculPrixTTC() +" €\n";
    }

    public int getPrixHT(){
        return prixHT;
    }

    public TypeProduit getTypeProduit(){
        return type;
    }
}