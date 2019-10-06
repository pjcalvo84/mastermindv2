package mastermind.models;

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

    public int getAttempts(){
        return proposedCombinations.size();
    }
    public boolean isFinished() {
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

    public boolean isResumed() {
        boolean resumed;
        Message.RESUME.write();
        resumed = new YesNoDialog().read();
        if (resumed) {
            this.clear();
        }
        return resumed;
    }

    public SecretCombination getSecretCombination(){
        return secretCombination;
    }

    public List<ProposedCombination> getProposedCombinations(){
        return proposedCombinations;
    }

    public void addProposedCombination(ProposedCombination proposedCombination){
        proposedCombinations.add(proposedCombination);
    }

    public void setResult(Result result){
        results.add(result);
    }

    public List<Result> getResults(){
        return this.results;
    }

    public ProposedCombination getLastProposedCombination(){
        return proposedCombinations.get(proposedCombinations.size()-1);
    }
}
