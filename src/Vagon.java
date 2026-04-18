public class Vagon extends Fiare {

    public Vagon(String nume, Integer tonaj, Float pret, Cuplaj cuplaj) {
        super(nume, tonaj, pret, cuplaj);
    }
    public Vagon(Vagon altVagon) {
        super(altVagon.getNume(), altVagon.getTonaj(), altVagon.getPret(), altVagon.getCuplaj());
    }


    public Vagon copiaza() {
        return new Vagon(this);
    }
}
