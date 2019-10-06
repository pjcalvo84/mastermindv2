package mastermind;

import java.util.List;
import java.util.ArrayList;

import mastermind.controller.Controller;
import mastermind.controller.Logic;
import mastermind.models.Message;
import mastermind.models.ProposedCombination;
import mastermind.models.Result;
import mastermind.models.SecretCombination;
import mastermind.view.View;
import mastermind.view.console.ConsoleView;
import santaTecla.utils.WithConsoleModel;
import santaTecla.utils.YesNoDialog;

public class Mastermind extends WithConsoleModel {

	private static final int MAX_LONG = 10;
	private SecretCombination secretCombination;
	private List<ProposedCombination> proposedCombinations;
	private List<Result> results;

	private Logic logic;
	private View view;

	private Mastermind() {
		this.logic = new Logic();
		this.view = new ConsoleView();
		//this.clear();
	}

	private void clear() {
		this.secretCombination = new SecretCombination();
		this.proposedCombinations = new ArrayList<ProposedCombination>();
		this.results = new ArrayList<Result>();
	}

	public void play() {
		Controller controller;
		do {
			controller = this.logic.getController();
			this.view.interact(controller);
		} while (controller != null);
	}

	/*
	private void play() {
		Message.TITLE.writeln();
		this.secretCombination.writeln();
		do {
			do {
				ProposedCombination proposedCombination = new ProposedCombination();
				proposedCombination.rerybad();
				this.proposedCombinations.add(proposedCombination);
				this.results.add(this.secretCombination.getResult(proposedCombination));
				this.writeln();
			} while (!isFinished());
		} while (this.isResumed());
	}
    */
	private void writeln() {
		this.console.writeln();
		Message.ATTEMPTS.writeln(this.getAttemps());
		this.secretCombination.writeln();
		for (int i = 0; i < this.getAttemps(); i++) {
			this.proposedCombinations.get(i).write();
			this.results.get(i).writeln();
		}
	}

	private boolean isFinished() {
		if (this.results.get(this.getAttemps() - 1).isWinner()) {
			Message.WINNER.writeln();
			return true;
		}
		if (this.getAttemps() == Mastermind.MAX_LONG) {
			Message.LOOSER.writeln();
			return true;
		}
		return false;
	}

	private int getAttemps() {
		return this.proposedCombinations.size();
	}

	private boolean isResumed() {
		boolean resumed;
		Message.RESUME.write();
		resumed = new YesNoDialog().read();
		if (resumed) {
			this.clear();
		}
		return resumed;
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
