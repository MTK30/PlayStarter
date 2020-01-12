package controllers;

import play.libs.Json;
import play.mvc.*;

import java.util.ArrayList;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        ArrayList<String> myArrayList = new ArrayList<>();
        myArrayList.add("MTK");
        myArrayList.add("OM");
        myArrayList.add("Seal");
        return ok(Json.toJson(myArrayList));
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

}
