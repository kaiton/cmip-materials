public class DeadlockedGreeting {
	static class Friend {
		public final String name;
		public Friend(String name) {
			this.name = name;
		}

		public synchronized void sayHello(Friend other) {
			System.out.format("%s: %s has said hello to me!%n", this.name, other.name);
			other.returnHello(this);
		}
		public synchronized void returnHello(Friend greeter) {
			System.out.format("%s: %s has said hello back to me!%n", this.name, greeter.name);
		}
	}

	public static void main(String[] args) {
		final Friend MrCat = new Friend("Mr. Cat");
		final Friend MrDog = new Friend("Mr. Dog");
		new Thread(
			new Runnable() {
				public void run() { 
					MrCat.sayHello(MrDog); 
				}
		}).start();
		
		new Thread(
			new Runnable() {
				public void run() { 
					MrDog.sayHello(MrCat); 
				}
		}).start();
	}
}
