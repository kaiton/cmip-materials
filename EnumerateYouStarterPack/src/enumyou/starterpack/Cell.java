package enumyou.starterpack;
import java.util.Random;

class Cell {
	
	// A cell has a background location. This background location 
	// should influence how a battle is fought. Certain Monsters 
	// could get a boost or deficit in particular locations
	// Some Weapons might not be as effective: like a Halberd in a cave
	// TODO: Implement Location effects for weapons and monsters
	// TODO: Change locations as you see fit to match your weapons & monsters
	enum Location {
		Mountain("An arid rugged precipice"),
		Mangrove("A putrid marshy and difficult terrain"),
		Forest("A densely wooded area. Visibility is limited"),
		Cave("A dark, dank cave with low ceilings"),
		Farm("A surprisingly pleasant dell");
		
		public String description;
		Location(String desc){
			this.description = desc;
		}
		
		// get a random location from our list of constant possibles
		public static Location getRandomItem(){
			Random randomGenerator = new Random();
			return values()[randomGenerator.nextInt(values().length)];
		}
	}
	
	// by default, cells are empty
	boolean isOccupied = false;
	
	// a cell exists within its container in a row and column, like a chess board
	// in this simple example, only a single column will be used.
	private int row, col;
	
	// A location as described above
	public Location location;
	
	// a cell has some contents that implements the Encounterable interface
	private Encounterable contents;
	
	
	Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	// a shorthand method for showing what's inside this cell
	public String display(){
		if(!isOccupied){
			return "    ";
		} else {
			return contents.display();	
		}
	}

	// set a cell's location
	void setLocation(Location loc){
		this.location = loc;
	}

	
	// set the contents of the cell to some Encounterable object
	// flip isOccupied to true
	void setContents(Encounterable content){
		this.contents = content;
		this.isOccupied = true;
	}
	
	Encounterable getContents(){
		return this.contents;
	}
	
	Encounterable takeContents() throws ImpossibleAction {
		if(this.contents.canBePickedUp()){
			Encounterable contents = this.contents;
			this.contents = null;
			this.isOccupied = false;
			return contents;
		} else {
			throw new ImpossibleAction(this.contents + " cannot be taken from this cell");
		}
	}
	
	// expose whether our cell has anything in it
	public boolean isOccupied() {
		return this.isOccupied;
	}
}