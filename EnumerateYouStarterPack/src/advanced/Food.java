package advanced;

enum Food {
	Lettuce(5), Patty(10), WaterCrackers(20);
	
	int sustainance;
	
	Food(int sustainance){
		this.sustainance = sustainance;
	}
	
	int getValue(){
		return this.sustainance;
	}
	
}