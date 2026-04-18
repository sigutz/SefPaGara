import java.util.ArrayList;
import java.util.List;

public class Tren {
    private String nume;
    private Locomotiva locomotiva;
    private List<Vagon> vagoane = new ArrayList<>();

    public Tren(String nume, Locomotiva locomotiva) {
        this.nume = nume;
        this.locomotiva = locomotiva;
    }

    public void add_vagon(Vagon vagonTip){
        Vagon vagonNou= vagonTip.copiaza();
        this.vagoane.add(vagonNou);

    }
}
