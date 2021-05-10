package goboard;

public interface IBoard {
	/**
	 * Returns false if the provided coordinates are out of bounds
	 * TODO: rename method
	 * @param x
	 * @param y
	 * @return validity
	 */
	public boolean isvalid(int x,int y);
	/**
	 * Returns false if placing the specified stone would create an invalid group
	 * (All groups should have at least one tributary)
	 * TODO: rename method
	 * @param x
	 * @param y
	 * @param type
	 * @return validity
	 */
	public boolean validplace(int x,int y,int type);
	/**
	 * Place and/or try to place the specified stone
	 * Somebody punch me later for being so vague
	 * @param x
	 * @param y
	 * @param type
	 * @return success
	 */
	public void place(int x,int y,int type);
//	/**
//	 * minimal placement method for removing stones
//	 * @param x
//	 * @param y
//	 * @param type
//	 * @return success
//	 */
//	public void captureplace(Bnode ptarget,int type);
//	/**
//	 * minimal placement method
//	 * @param x
//	 * @param y
//	 * @param type
//	 * @return success
//	 */
//	public void simpleplace(int x,int y,int type);
	/**
	 * Returns the stone at the specified location
	 * @param x
	 * @param y
	 * @return
	 */
	public Bnode getstoneat(int x,int y);
	/**
	 * Returns the type of the stone at the specified location
	 * @param x
	 * @param y
	 * @return
	 */
	public StoneType gettypeat(int x,int y);
}
