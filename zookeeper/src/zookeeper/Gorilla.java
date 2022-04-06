package zookeeper;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Gorilla throw something");
//		this.energyLevel -= 5;
		this.setEnergyLevel(this.getEnergyLevel() -5); 
	}
	public void eatBanana() {
		System.out.println("Gorilla just ate a banana!");
//		this.energyLevel += 10;
	}
	public void climb() {
		System.out.println("Gorilla climbing");
//		this.energyLevel -= 10;
	}
}
