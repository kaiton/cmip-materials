public class ThreadWait {
    public static void main(String[] args){
    	ComplexTaskRunnerWithNotify ctrwn = new ComplexTaskRunnerWithNotify();
    	ctrwn.start();
 
        synchronized(ctrwn){
            try{
                System.out.println("Waiting for task runner to signal completion");
                ctrwn.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + ctrwn.result);
        }
    }
}
 

class ComplexTaskRunnerWithNotify extends Thread {
	int result;
    public void run(){
        synchronized(this){
            for(int i=1; i<10017; i+=2){
                result += i;
            }
            notify();
        }
    }
}