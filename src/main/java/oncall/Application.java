package oncall;

import oncall.controller.Controller;
import oncall.service.Service;
import oncall.view.View;

public class Application {
    public static void main(String[] args) {
        View inputView = new View();
        Service service = new Service();
        Controller controller = new Controller(inputView, service);

        controller.run();
    }
}
