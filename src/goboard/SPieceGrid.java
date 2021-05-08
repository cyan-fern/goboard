package goboard;

public class SPieceGrid {
	int xdim;
	int[] groups;
	int[] types;
	
	public SPieceGrid(int x,int y) {
		xdim=x;
		int size=x*y;
		groups=new int[size];
		types=new int[size];
	}
	public int getgrp(int x,int y) {
		return groups[xdim*y+x];
	}
	public int gettype(int x,int y) {
		return types[xdim*y+x];
	}
	public void setgrp(int x,int y,int val) {
		groups[xdim*y+x]=val;
	}
	public void settype(int x,int y,int val) {
		types[xdim*y+x]=val;
	}
}
