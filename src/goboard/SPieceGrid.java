package goboard;

public class SPieceGrid {
	int xdim;
	Bnode[] pieces;
	
	public SPieceGrid(int x,int y,GoBoard board,int empty) {
		xdim=x;
		int size=x*y;
		pieces=new Bnode[size];
		int i=0;
		for(int iy=0;iy<y;iy++) {
			for(int ix=0;ix<x;ix++) {
				pieces[i]=new Bnode(ix,iy,board,empty,null);
				i++;
			}
		}
	}
	public Bnode getstone(int x,int y) {
		return pieces[xdim*y+x];
	}
	public AGroup getgrp(int x,int y) {
		return pieces[xdim*y+x].group;
	}
	public int gettype(int x,int y) {
		return pieces[xdim*y+x].type;
	}
	public void setgrp(int x,int y,AGroup group) {
		pieces[xdim*y+x].group=group;
	}
	public void settype(int x,int y,int val) {
		pieces[xdim*y+x].type=val;
	}
}
