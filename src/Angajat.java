import java.util.Date;

public class Angajat extends Persoana {
    private Float salariu;
    private Date data_ang;
    private Float stare;
    private boolean ocupat; // Noua stare

    public Angajat(String nume, Float salariu, Date data_ang, Float stare) {
        super(nume);
        this.salariu = salariu;
        this.data_ang = data_ang;
        this.stare = stare;
        this.ocupat = false;
    }

    public boolean isOcupat() { return ocupat; }
    public void setOcupat(boolean ocupat) { this.ocupat = ocupat; }

    public Angajat copiaza() {
        return new Angajat(this.getNume(), this.salariu, this.data_ang, this.stare);
    }

    public Float getSalariu() {
        return salariu;
    }

    public Date getData_ang() {
        return data_ang;
    }

    public Float getStare() {
        return stare;
    }

    @Override
    public String toString() {
        String status = ocupat ? "[IN CURSA]" : "[IN GARA ]";
        return status + " Angajat: " + getNume() + " | Salariu: " + salariu + " | Energie: " + stare + "%";
    }
}