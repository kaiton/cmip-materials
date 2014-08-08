package enumyou.starterpack;


// An ImpossibleAction represents something our player
// cannot do in the present situation
class ImpossibleAction extends Exception {
	
	ImpossibleAction(){
		super();
	}		
	
	ImpossibleAction(String msg){
		super(msg);
	}
}	