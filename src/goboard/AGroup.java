package goboard;

import java.util.ArrayList;

/**
 * Abstract half-implementation of node groups.
 * Both the abstractness and implementations are subject to change.
 * @author reverse
 *
 */
public /*abstract*/ class AGroup {
	ArrayList<Bnode> members;
	int neyes;
	//HashSet<Bnode> eyes;
	int fedges;
	public int eblock=0;//blocked edges, for checking
	public int enc=0;//encounters, for checking
	//public int rmedge=0;
	public boolean pending;
	
	public AGroup(Bnode member) {
		this.members=new ArrayList<Bnode>();
		members.add(member);
	}
	public void add(Bnode node) {
		members.add(node);
	}
	public void merge(AGroup group) {
		//think carefully about if this is sufficient
		for(Bnode node:group.members) {
			node.group=this;}
		members.addAll(group.members);
	}
	public void remove(int type,Adjacencylist adj) {
		//think carefully about if this is sufficient
		for(Bnode node:this.members) {
			node.capturereplace(type,adj);}
	}
}
