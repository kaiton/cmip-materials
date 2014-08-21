public class ThreadNoWait {
	public static void main(String[] args) {
		ComplexTaskRunner taskRunner = new ComplexTaskRunner();
		taskRunner.start();
 
		System.out.println("Result = : " + taskRunner.result);
 
	}
}
 
class ComplexTaskRunner extends Thread {
	int result;
	public void run() {
        for(int i=1; i<10017; i+=2){
			result += i;
		}
	}
}