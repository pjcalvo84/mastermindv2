package mastermind.models;

import santaTecla.utils.Console;

public enum Error {
	DUPLICATED("Repeated colors"),
	WRONG_CHARACTERS("Wrong colors, they must be: " + Color.allInitials()),
	WRONG_LENGTH("Wrong proposed combination length");

	private String message;

	private Error(String message) {
		this.message = message;
	}

	public void writeln() {
		new Console().writeln(this.message);		
	}
	
}
