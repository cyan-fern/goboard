package goboard;

public class GoBoard implements IBoard,TypeS {
	int fedgetokill=0;
	
	int xdim;
	int ydim;
	private SPieceGrid pieces;
	Bnode oob=new Bnode(0,0,this,st_full,null);
	
	public GoBoard(int xdim,int ydim) {
		this.xdim=xdim;
		this.ydim=ydim;
		this.pieces=new SPieceGrid(xdim,ydim,this,0);
	}

	@Override
	public boolean isvalid(int x, int y) {
		return x>=0&&x<xdim&&y>=0&&y<ydim;
	}

	@Override
	public boolean validplace(int x, int y, int type) {
		//TODO: if any connecting stones are replaceable, this will break. fix this.
		if(!gettypeat(x,y).isreplaceable()) {return false;}
		if(!types[type].isconnecting()) {return true;}//not connecting=no groups=no tributaries=no invalidity
		int rempty=gettypeat(x,y).isempty()?0:1;
		int tfedge=0;
		int fedge=0;
		Bnode ptarget=getstoneat(x,y),look;
		for(int i=0;i<adj.dim;i++) {
			look=ptarget.getoffs(adj,i);
			if(look.gettype().isempty()) {tfedge++;}
			if(look.type==type) {
				if(look.group.enc>0) {fedge-=rempty;}
				else {fedge+=look.group.fedges-rempty;look.group.enc++;}
			}
			else if(look.gettype().isconnecting()&&rempty==1) {
				look.group.eblock++;
				look.group.enc++;
				//this might not make sense, as mental fatigue of doing this for hours is starting to get to me
				//check here for bugs first when encountering weird behaviour
				//shut up eclipse that's a valid spelling
				if(look.group.fedges-look.group.eblock==fedgetokill) {tfedge+=look.group.enc;}
				else if(look.group.fedges-look.group.eblock<fedgetokill) {tfedge++;}
			}
			
			
			if(tfedge>fedgetokill) {ptarget.resetsthrough(adj,i+1);return true;}
		}
		ptarget.resetsthrough(adj,adj.dim);
		if(fedge+tfedge>fedgetokill) {return true;}
		return false;
	}

	@Override
	public void place(int x, int y, int type) {
		//assume placement is valid, and thus that live editing is permissible
		Bnode ptarget=getstoneat(x,y),look;
		ptarget.type=type;
		ptarget.group=null;
		ptarget.pending=true;
		int fedges=0;
		for(int i=0;i<adj.dim;i++) {
			look=ptarget.getoffs(adj,i);
			if(look.gettype().isempty()) {fedges++;}
			if(look.type==type&&types[type].isconnecting()) {
				//TODO: breaks if replacing a connecting stone, fix this
				if(ptarget.group==null) {
					ptarget.group=look.group;
					look.group.add(ptarget);
					ptarget.group.fedges-=1;
				}
				else if(ptarget.group!=look.group) {
					ptarget.group.fedges+=look.group.fedges-1;
					ptarget.group.merge(look.group);
				}
				else {
				}
			}
			else if(look.gettype().isconnecting()) {
				look.group.fedges-=1;
				look.group.enc++;
				if(look.group.fedges<=fedgetokill) {
					ptarget.group.fedges+=look.group.enc;
					look.group.remove(empty,adj);
				}
			}
		}
		ptarget.resetsthrough(adj,adj.dim);
		ptarget.pending=false;
	}

//	@Override
//	public void simpleplace(int x, int y, int type) {
//	}

	@Override
	public Bnode getstoneat(int x, int y) {
		if(!isvalid(x,y)) {return oob;}
		return pieces.getstone(x,y);
	}

	@Override
	public StoneType gettypeat(int x, int y) {
		if(!isvalid(x,y)) {return types[st_empty];}
		return types[pieces.gettype(x,y)];
	}

}
