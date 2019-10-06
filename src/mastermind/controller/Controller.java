package mastermind.controller;

import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.models.SecretCombination;
import mastermind.models.Game;
import mastermind.models.State;

import java.util.List;

public abstract class Controller {

    protected Game game;

    protected State state;

    Controller(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    public int getAttempts(){
        return this.game.getAttempts();
    }
    public void clear (){
        this.game.clear();
    }

    public boolean isFinished() {
        return this.game.isFinished();
    }

    private boolean isResumed() {
        return this.game.isResumed();
    }

    public SecretCombination getSecretCombination(){
        return this.game.getSecretCombination();
    }

    public List<ProposedCombination> getProposedCombinations(){
        return this.game.getProposedCombinations();
    }

    public void addProposedCombination(ProposedCombination proposedCombination){
        this.game.addProposedCombination(proposedCombination);
    }

    public List<Result> getResults(){
        return this.game.getResults();
    }

    public abstract void accept(ControllerVisitor controllerVisitor);

}
