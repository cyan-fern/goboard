package goboard;

/**
 * A position on the board.
 * My instinct is to do this more efficiently, but I can't be bothered.
 *  //Correction: I just had an idea, I may end up doing that.
 * @author reverse
 *
 */
public class Bnode {
	public static Bnode dnode = new Bnode(0,0);
	private int x;
	private int y;
	private int type;
	private AGroup group;
	private IBoard board;
	
	public Bnode(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public Bnode falsenode(int x,int y) {
		dnode.x=x;
		dnode.y=y;
		return dnode;
	}
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public int type() {
		return type;
	}
	public AGroup group() {
		return group;
	}
	public IBoard board() {
		return board;
	}
}
