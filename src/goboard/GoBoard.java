package goboard;

public class GoBoard implements IBoard,TypeS {
	int xdim;
	int ydim;
	private SPieceGrid pieces;
	Bnode oob=new Bnode(0,0,this,st_empty,null);
	
	public GoBoard(int xdim,int ydim) {
		this.xdim=xdim;
		this.ydim=ydim;
		this.pieces=new SPieceGrid(xdim,ydim);
	}

	@Override
	public boolean isvalid(int x, int y) {
		return x>=0&&x<xdim&&y>=0&&y<ydim;
	}

	@Override
	public boolean validplace(int x, int y, int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean place(int x, int y, int type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bnode getstoneat(int x, int y) {
		if(!isvalid(x,y)) {return oob;}
		return pieces.getstone(x,y);
	}

	@Override
	public StoneType gettypeat(int x, int y) {
		if(!isvalid(x,y)) {return types[st_empty];}
		return types[itypeat(x,y)];
	}

	private int itypeat(int x,int y) {
		return pieces.gettype(x,y);
	}

}
