package mastermind.controller;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(ResumeController resumeController);

    void visit(ProposedController proposedController);
}

