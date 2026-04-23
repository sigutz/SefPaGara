enum Cuplaj {
    Presa,
    Crab
}

public class Fiare {
    private String nume;
    private Integer tonaj;
    private Float pret;
    private Cuplaj cuplaj;
    private boolean ocupat;

    public Fiare(String nume, Integer tonaj, Float pret, Cuplaj cuplaj) {
        this.nume = nume;
        this.tonaj = tonaj;
        this.pret = pret;
        this.cuplaj = cuplaj;
        this.ocupat = false;
    }

    public boolean isOcupat() {
        return ocupat;
    }

    public void setOcupat(boolean ocupat) {
        this.ocupat = ocupat;
    }

    public String getNume() { return nume; }
    public Integer getTonaj() { return tonaj; }
    public Float getPret() { return pret; }
    public Cuplaj getCuplaj() { return cuplaj; }
    public void setNume(String nume) { this.nume = nume; }

    @Override
    public String toString() {
        String stare = ocupat ? "[OCUPAT]" : "[LIBER ]";
        return stare + " " + nume + " | Cuplaj: " + cuplaj + " | Pret: " + pret + " | Tonaj: " + tonaj;
    }
}