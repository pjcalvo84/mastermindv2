package mastermind.controller;

public interface ControllerVisitor {

    void visit(StartController startController);

    void visit(MoveController moveController);

    void visit(ResumeController resumeController);
}

