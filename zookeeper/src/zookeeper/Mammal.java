package zookeeper;

public class Mammal {
	private Integer energyLevel = 100;
	
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
