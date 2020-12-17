package p;

public class Client {
    private String nom;
    private String mail;
    private TypeClient type;

    public Client(String nom, String mail, TypeClient type) {
        this.nom = nom;
        this.mail = mail;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client : [" + mail + ", nom=" + nom + ", type=" + type + "]";
    }
}