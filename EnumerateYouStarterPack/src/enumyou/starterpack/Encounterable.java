package enumyou.starterpack;

/* 
 * The interface that all objects in cells must implement so that:
 *  - the dungeon  can place them in cells, 
 *  - the player to encounter & interact them
 */
public interface Encounterable {
	String display();
	boolean canBePickedUp();
}
