
package projekakhir;

import projekakhir.controller.Controller;
import projekakhir.model.PenyebaranCovid;
import projekakhir.view.View;

public class ProjekAkhir {

    public static void main(String[] args) {
        PenyebaranCovid pcovid = new PenyebaranCovid();
        View v = new View();
        Controller controller = new Controller(pcovid, v);
    }
}
