enum TipVagonPasager {
    Restaurant,
    Clasa1,
    Clasa2,
    Cuseta1,
    Cuseta2
}

public class VagonPasager extends Vagon{
    private Integer capacitate;
    private TipVagonPasager tipVagonPasager;

    public VagonPasager(String nume, Integer tonaj, Float pret, Cuplaj cuplaj, Integer capacitate, TipVagonPasager tipVagonPasager) {
        super(nume, tonaj, pret, cuplaj);
        this.capacitate = capacitate;
        this.tipVagonPasager = tipVagonPasager;
    }

    public VagonPasager(VagonPasager altVagon) {
        super(altVagon);
        this.capacitate = altVagon.capacitate;
        this.tipVagonPasager = altVagon.tipVagonPasager;
    }

    @Override
    public Vagon copiaza() {
        return new VagonPasager(this);
    }
}
