enum TipMarfa {
    Conbustibil,
    Cereale,
    MaterialeConstructii,
    Militar,
    Transportor
}

public class VagonMarfar extends Vagon{
    private Float capacitate;
    private TipMarfa tipMarfa;

    public VagonMarfar(String nume, Integer tonaj, Float pret, Cuplaj cuplaj, Float capacitate, TipMarfa tipMarfa) {
        super(nume, tonaj, pret, cuplaj);
        this.capacitate = capacitate;
        this.tipMarfa = tipMarfa;
    }

    public VagonMarfar(VagonMarfar altVagon) {
        super(altVagon);
        this.capacitate = altVagon.capacitate;
        this.tipMarfa = altVagon.tipMarfa;
    }

    @Override
    public Vagon copiaza() {
        return new VagonMarfar(this);
    }
}
