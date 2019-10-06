package mastermind.view.console;

import mastermind.controller.*;
import mastermind.view.View;
import santaTecla.utils.YesNoDialog;

public class ConsoleView implements View {

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
        new SecretCombinationView(startController).writeln();
    }

    public void visit(ResumeController resumeController) {
        new ResumeView(resumeController).writeln();
        resumeController.resume(new YesNoDialog().read());
    }

    @Override
    public void visit(ProposedController proposedController) {
        new ProposedCombinationView(proposedController).read();
        proposedController.checkResult();
        new ResultCombinationView(proposedController).writeAttepmts();
        new SecretCombinationView(proposedController).writeln();
        new ResultCombinationView(proposedController).writeln();
        proposedController.isFinish();

    }
}
