package goboard;

public interface IBoard {
	/**
	 * Returns false if the provided coordinates are out of bounds
	 * @param x
	 * @param y
	 * @return
	 */
	public Boolean valid(int x,int y);
	/**
	 * Returns false if placing the specified stone would create an invalid group
	 * (All groups should have at least one tributary)
	 * @param x
	 * @param y
	 * @param type
	 * @return
	 */
	public Boolean validplace(int x,int y,int type);
}
