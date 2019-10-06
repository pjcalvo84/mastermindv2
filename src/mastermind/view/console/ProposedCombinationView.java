package mastermind.view.console;

import mastermind.models.*;
import mastermind.controller.Controller;
import mastermind.models.Error;
import mastermind.utils.IO;

import java.util.ArrayList;
import java.util.List;

public class ProposedCombinationView {

    private final Controller controller;

    public ProposedCombinationView(Controller controller) {
        this.controller = controller;
    }

    //public void

    public void read() {
        List<Color> colors = new ArrayList<>();
        Error error;
        do {
            error = null;
            Message.PROPOSED_COMBINATION.write();
            String characters = IO.readString();
            if (characters.length() != Combination.getWidth()) {
                error = Error.WRONG_LENGTH;
            } else {
                for (int i = 0; i < characters.length(); i++) {
                    Color color = Color.getInstance(characters.charAt(i));
                    if (color == null) {
                        error = Error.WRONG_CHARACTERS;
                    } else {
                        for(int j=0; j< colors.size(); j++){
                            if (color == colors.get(j)){
                                error = Error.DUPLICATED;
                            }
                        }
                        colors.add(color);
                    }
                }
            }
            if (error != null) {
                error.writeln();
                while (!colors.isEmpty()){
                    colors.remove(0);
                }
            }
        } while (error != null);
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.setColor(colors);
        controller.addProposedCombination(proposedCombination);
    }
}
