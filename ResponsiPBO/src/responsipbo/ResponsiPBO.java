
package responsipbo;

import responsipbo.controller.Controller;
import responsipbo.model.Movie;
import responsipbo.view.View;

public class ResponsiPBO {

    public static void main(String[] args) {
        Movie m = new Movie();
        View v = new View();
        Controller controller = new Controller(m, v);
    }
}
