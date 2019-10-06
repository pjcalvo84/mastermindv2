package mastermind.controller;

import mastermind.models.SecretCombination;
import mastermind.models.Game;
import mastermind.models.State;

public class ProposedController extends Controller {

    public ProposedController(Game game, State state) {
        super(game, state);
    }

    public void checkResult(){
        SecretCombination secretCombination = game.getSecretCombination();
        game.setResult(secretCombination.getResult(game.getLastProposedCombination()));
    }

    public void isFinish(){
        if(game.isFinished())
            this.state.next();
    }
    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
}
