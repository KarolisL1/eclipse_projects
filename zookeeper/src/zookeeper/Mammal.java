package zookeeper;

public class Mammal {
	protected Integer energyLevel = 100;
	
	public Integer displayEnergy() {
		return energyLevel;
	}

	public Integer getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Integer energyLevel) {
		this.energyLevel = energyLevel;
	}
}
