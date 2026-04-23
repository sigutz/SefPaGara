import java.util.ArrayList;
import java.util.List;

public class Tren {
    private String nume;
    private Locomotiva locomotiva;
    private List<Vagon> vagoane = new ArrayList<>();
    private List<Angajat> angajati = new ArrayList<>();

    public Tren(String nume, Locomotiva locomotiva) {
        this.nume = nume;
        this.locomotiva = locomotiva;
        this.locomotiva.setOcupat(true);
    }

    public void add_vagon(Vagon vagon){
        vagon.setOcupat(true);
        this.vagoane.add(vagon);
    }

    public void add_angajat(Angajat angajat){
        angajat.setOcupat(true);
        this.angajati.add(angajat);
    }

    public void dezmembreaza() {
        if (locomotiva != null) {
            locomotiva.setOcupat(false);
        }
        for (Vagon v : vagoane) {
            v.setOcupat(false);
        }
        for (Angajat a : angajati) {
            a.setOcupat(false);
        }
    }

    @Override
    public String toString() {
        return "Tren: " + nume + " | Loc: " + locomotiva.getNume() + " | Vagoane: " + vagoane.size() + " | Echipaj: " + angajati.size();
    }
}