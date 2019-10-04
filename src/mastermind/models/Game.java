package mastermind.models;

import mastermind.*;
import santaTecla.utils.YesNoDialog;

import java.util.*;

public class Game {

    private static final int MAX_LONG = 10;
    private SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
    }

    private boolean isFinished() {
        if (this.results.get(this.getAttemps() - 1).isWinner()) {
            Message.WINNER.writeln();
            return true;
        }
        if (this.getAttemps() == Game.MAX_LONG) {
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
}
