package goboard;

public interface IBoard {
	/**
	 * Returns false if the provided coordinates are out of bounds
	 * TODO: rename method
	 * @param x
	 * @param y
	 * @return validity
	 */
	public boolean valid(int x,int y);
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
	 * @return
	 */
	public boolean place(int x,int y,int type);
}
