package goboard;

/**
 * A position on the board.
 * My instinct is to do this more efficiently, but I can't be bothered.
 *  //Correction: I just had an idea, I may end up doing that.
 * @author reverse
 *
 */
public class Bnode {
	public static Bnode dnode = new Bnode(0,0,null);
	private int x;
	private int y;
	int type;
	AGroup group;
	private IBoard board;
	
	public Bnode(int x,int y,IBoard board) {
		this.x=x;
		this.y=y;
		this.board=board;
	}
	public Bnode(int x,int y,IBoard board,int type,AGroup group) {
		this.x=x;
		this.y=y;
		this.board=board;
		this.type=type;
		this.group=group;
	}
	public static Bnode falsenode(int x,int y,IBoard board) {
		dnode.x=x;
		dnode.y=y;
		dnode.board=board;
		return dnode;
	}
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public IBoard board() {
		return board;
	}
	public Bnode getoffs(int x,int y,Adjacencylist list,int entry) {
		return board.getstoneat(x+list.getx(entry),y+list.gety(entry));
	}
}
