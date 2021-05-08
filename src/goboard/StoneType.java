package goboard;

public class StoneType {
	private boolean empty;
	private boolean replaceable;
//	private boolean killable;
	private boolean connecting;
	
	public StoneType(boolean empty,boolean replaceable,/*boolean killable,*/boolean connecting) {
		this.empty=empty;
		this.replaceable=replaceable;
//		this.killable=killable;
		this.connecting=connecting;
	}
	public boolean isempty() {
		return empty;
	}
	public boolean isreplaceable() {
		return replaceable;
	}
	// only groups can have tributaries, hacking this together anyway would only be useful for experimentation
//	/**
//	 * 
//	 * @return
//	 */
//	public boolean iskillable() {
//		return killable;
//	}
	/**
	 * returns true if the stone is connecting, eg. should create groups with stones of the same type
	 * @return
	 */
	public boolean isconnecting() {
		return connecting;
	}
}
