package com.company.model.units;

import java.util.List;

public class Army {

	List<Leader> leaders;
	List<Fighter> fighters;

	public Army(List<Leader> leader, List<Fighter> fighters){
		this.leaders = leader;
		this.fighters = fighters;
	}

	public List getFighters(){
		return this.fighters;
	}
	public List getLeader(){
		return this.leaders;
	}

	public void addUnit(Fighter fighter){
		this.fighters.add(fighter);
	}

	public void addLeader(Leader leader){
		this.leaders.add(leader);
	}

	public Boolean removeUnit(Fighter unit){
		return fighters.contains(unit) && this.fighters.remove(unit);
	}

	public Boolean removeLeader(Leader leader){
		return leaders.contains(leader) && this.leaders.remove(leader);
	}

	public int getMissileValue(){
		int count = 0;
		for(Fighter fighter: this.fighters){
			count += fighter.getMissileValue();
		}
		return count;
	}

	public int getMeleeValue(){
		int count = 0;
		for(Fighter fighter: this.fighters){
			count += fighter.getMeleeValue();
		}
		return count;
	}

	public int getArmorValue(){
		int count = 0;
		for(Fighter fighter: this.fighters){
			count += fighter.getArmor();
		}
		return count;
	}

	public void decreaseMoral(int attackValue){
		this.fighters.stream().forEach(fighter -> {
			fighter.setMP(0);
		});
	}
}
