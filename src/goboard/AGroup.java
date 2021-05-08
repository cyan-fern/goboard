package goboard;

import java.util.Collection;
import java.util.HashSet;

/**
 * Abstract half-implementation of node groups.
 * Both the abstractness and implementations are subject to change.
 * @author reverse
 *
 */
public abstract class AGroup {
	Collection<Bnode> members;
	int neyes;
	HashSet<Bnode> eyes;
	int fedges;
	
}
