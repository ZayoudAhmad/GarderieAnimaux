package Models;

public final class Admin extends Personne {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(String password, int CIN, String nom, String adresse, String telephone) {
        super(CIN, nom, adresse, telephone);
        this.password = password;
    }

}
