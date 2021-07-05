
package projekakhir;

import projekakhir.controller.Controller;
import projekakhir.model.PenyebaranCovid;
import projekakhir.view.View;

public class ProjekAkhir {

    public static void main(String[] args) {
        PenyebaranCovid m = new PenyebaranCovid();
        View v = new View();
        Controller controller = new Controller(m, v);
    }
}
