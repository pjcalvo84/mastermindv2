package mastermind.view;

import mastermind.controller.Controller;
import mastermind.controller.ControllerVisitor;

public interface View extends ControllerVisitor {

    void interact(Controller controller);
}
