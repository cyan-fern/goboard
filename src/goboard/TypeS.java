package goboard;

/**
 * This is an interface that I created to basically just write in for now. Check for various specifications.
 * @author reverse
 *
 */
public interface TypeS {
	/**
	 * Types: (as of now)
	 * 0:empty
	 * 1:static empty (acts empty, unfillable)
	 * 2:static full (acts as full, unkillable and unconnecting)
	 * 3+:user
	 */
	int empty=0;
	int st_empty=1;
	int st_full=2;
	int stone_1=3;
	int stone_2=4;
	int stone_3=5;//primarily for experimentation purposes
	int stone_4=6;
	/*additional ideas:
	 * unconnecting, killable stones
	 * making a class to draft specific type ideas, replacing this specification
	 */
}
