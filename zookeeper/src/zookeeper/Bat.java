package zookeeper;


public class Bat extends Mammal {
	public Bat() {
		super();
		this.energyLevel = 300;
	}
	public Bat(int e) {
		super();
		this.energyLevel = e;
	}
	public void fly() {
		System.out.println("Bat taking off!");
		this.energyLevel -=50;
	}
	public void eatHumans() {
		this.energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("Town is on fire");
		this.energyLevel -= 100;
	}
}
