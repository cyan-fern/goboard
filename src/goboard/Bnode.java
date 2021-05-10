package goboard;

/**
 * A position on the board.
 * My instinct is to do this more efficiently, but I can't be bothered.
 *  //Correction: I just had an idea, I may end up doing that.
 * @author reverse
 *
 */
public class Bnode {
	private int x;
	private int y;
	int type;
	AGroup group;
	private IBoard board;
	public boolean pending;
	
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
	public int x() {
		return x;
	}
	public int y() {
		return y;
	}
	public StoneType gettype() {
		return GoBoard.types[type];
	}
	public IBoard board() {
		return board;
	}
	public Bnode getoffs(Adjacencylist list,int entry) {
		return board.getstoneat(x+list.getx(entry),y+list.gety(entry));
	}
	public void resetsthrough(Adjacencylist list,int through) {
		Bnode target;
		for(int i=0;i<through;i++) {
			target=this.getoffs(list,i);
			if(target.gettype().isconnecting()) {
				//finish this as you finish AGroup
				target.group.eblock=0;
				target.group.enc=0;
			}
		}
	}
	public void capturereplace(int type,Adjacencylist adj) {
		//note: do not use on empty nodes
		//Bnode ptarget=getstoneat(x,y),look;
		Bnode look;
		this.type=type;
		AGroup origroup=this.group;
		this.group=null;
		//TODO: make types an instance variable
		if(!GoBoard.types[type].isempty()) {return;}//no need to update
		for(int i=0;i<adj.dim;i++) {
			look=this.getoffs(adj,i);
			//see if you can make this more efficient perhaps
			//look.group!=origroup&&!look.gettype().isempty()&&!look.pending&&!look.group.pending
			//aa this whole thing is a mess
			if(look.group!=origroup&&look.group!=null&&!look.pending) {
				look.group.fedges++;
			}
		}
	}
	
}
