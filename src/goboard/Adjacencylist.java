package goboard;

public class Adjacencylist {
	static Adjacencylist normal;
	static {
		normal=new Adjacencylist(4);
		normal.set(0,-1,0);
		normal.set(1,0,-1);
		normal.set(2,1,0);
		normal.set(3,0,1);
	}
	
	int dim;
	int[] list;
	
	public Adjacencylist(int num) {
		dim=num;
		this.list=new int[dim*2];
	}
	public void set(int pos,int x,int y) {
		list[pos*2]=x;
		list[pos*2+1]=y;
	}
	public int getx(int pos) {
		return list[pos*2];
	}
	public int gety(int pos) {
		return list[pos*2+1];
	}
}
