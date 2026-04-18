enum Cuplaj {
    Presa,
    Crab
}

public class Fiare {
    private String nume;
    private Integer tonaj;
    private Float pret;
    private Cuplaj cuplaj;

    public Fiare(String nume, Integer tonaj, Float pret, Cuplaj cuplaj) {
        this.nume = nume;
        this.tonaj = tonaj;
        this.pret = pret;
        this.cuplaj = cuplaj;
    }

    public String getNume() {
        return nume;
    }

    public Integer getTonaj() {
        return tonaj;
    }

    public Float getPret() {
        return pret;
    }

    public Cuplaj getCuplaj() {
        return cuplaj;
    }

    @Override
    public String toString() {
        return nume + "\n -> cuplaj: " + cuplaj + "\n -> pret: " + pret+ "\n -> tonaj: " + tonaj ;
    }
}
