package mastermind.models;

import java.util.List;

public class ProposedCombination extends Combination {

	public void write() {
		for (Color color : this.colors) {
			color.write();
		}
	}


	public void setColor(List<Color> colors){
		this.colors = colors;
	}

	boolean contains(Color color, int position) {
		return this.colors.get(position) == color;
	}

	boolean contains(Color color) {
		for (int i = 0; i < this.colors.size(); i++) {
			if (this.colors.get(i) == color) {
				return true;
			}
		}
		return false;
	}

}
