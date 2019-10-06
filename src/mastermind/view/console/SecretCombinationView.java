package mastermind.view.console;

import mastermind.models.Combination;
import mastermind.models.Message;
import mastermind.controller.Controller;

public class SecretCombinationView {
    private final Controller controller;

    public SecretCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(){
        for(int x = 0 ; x< Combination.getWidth(); x++)
            Message.SECRET.write();
    }
}
