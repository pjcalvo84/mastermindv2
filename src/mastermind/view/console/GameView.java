package mastermind.view.console;

import mastermind.models.Message;
import mastermind.controller.Controller;

public class GameView {

    private final Controller controller;

    public GameView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(){
        Message.TITLE.writeln();
    }
}
