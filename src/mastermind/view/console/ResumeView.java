package mastermind.view.console;

import mastermind.models.Message;
import mastermind.controller.Controller;

public class ResumeView {

    private final Controller controller;

    public ResumeView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(){
        Message.RESUME.write();
    }
}
