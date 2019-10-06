package mastermind.view.console;

import mastermind.models.Message;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.controller.Controller;

import java.util.List;

public class ResultCombinationView {

    private final Controller controller;

    public ResultCombinationView(Controller controller) {
        this.controller = controller;
    }

    public void writeln(){
        List<ProposedCombination> list = controller.getProposedCombinations();
        List<Result> resultList = controller.getResults();
        for(int x=0; x<list.size();x++){
            ProposedCombination proposedCombination = list.get(x);
            Result result = resultList.get(x);
            proposedCombination.write();
            Message.RESULT.writeln(result.getBlacks(),result.getWhites());
        }
    }

    public void writeAttepmts(){
        Message.ATTEMPTS.writeln(controller.getAttempts());
    }

}
