package zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla g = new Gorilla();
		Mammal m = new Mammal();
		
		System.out.println(m.displayEnergy());
		
		g.throwSomething();
		System.out.println(g.displayEnergy());
	}

}
