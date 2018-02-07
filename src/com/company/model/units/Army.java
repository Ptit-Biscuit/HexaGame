package com.company.model.units;

import com.company.model.Tile;

import java.util.List;

public class Army {

	List<Leader> leaders;
	List<Fighter> fighters;

	/**
	 * A tile that represents the position of the army
	 */
	private Tile position;

	/**
	 * A tile that represents the ghost position of the army
	 */
	private Tile ghostPosition;

	/**
	 * Number of movement point of the unit
	 */
	private int MP;

	/**
	 * Number of ghost movement point of the unit
	 */
	private int ghostMP;

	/**
	 * Constructor of the amry
	 *
	 * @param leaders The list of leaders
	 * @param fighters The list of fighters
	 * @param position The tile of the fight
	 */
	public Army(List<Leader> leaders, List<Fighter> fighters, Tile position){
		this.leaders = leaders;
		this.fighters = fighters;
		this.MP = 10;
		this.ghostMP = 10;
		this.position = position;
		this.ghostPosition = position;
	}

	/**
	 * Getter of the fighter list
	 *
	 * @return The fighter list
	 */
	public List<Fighter> getFighters(){
		return this.fighters;
	}

	/**
	 * Getter of the leader list
	 *
	 * @return The leader list
	 */
	public List<Leader> getLeader(){
		return this.leaders;
	}

	/**
	 * Method used to add a fighter
	 */
	public void addUnit(Fighter fighter){
		this.fighters.add(fighter);
	}

	/**
	 * Method used to add a leader
	 */
	public void addLeader(Leader leader){
		this.leaders.add(leader);
	}

	/**
	 * Method used to remove an unit
	 *
	 * @return The state of removal
	 */
	public Boolean removeUnit(Fighter unit){
		return fighters.contains(unit) && this.fighters.remove(unit);
	}

	/**
	 * Method used to remove a leader
	 *
	 * @return The state of removal
	 */
	public Boolean removeLeader(Leader leader){
		return leaders.contains(leader) && this.leaders.remove(leader);
	}

	/**
	 * Getter of the missile value
	 *
	 * @return Themissile value
	 */
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

	/**
	 * Getter of the armor value
	 *
	 * @return The armor value
	 */
	public int getArmorValue(){
		int count = 0;
		for(Fighter fighter: this.fighters){
			count += fighter.getArmor();
		}
		return count;
	}

	/**
	 * Method used to decrease an unit moral
	 *
	 */
	public void decreaseMoral(int attackValue){
		this.fighters.stream().forEach(fighter -> {
			fighter.setMP(fighter.getMP() + getTrueLeader().getMoralModifier());
			fighter.setMP(0);
		});
	}

	/**
	 * Getter of the acting leader
	 *
	 * @return The acting leader
	 */
	public Leader getTrueLeader(){
		final int[] maxCommand = {0};
		final Leader[] topLeader = {null};
		this.leaders.forEach(leader -> {
			if(leader.getCommandLimit() > maxCommand[0]){
				maxCommand[0] = leader.getCommandLimit();
				topLeader[0] = leader;
			}
		});
		return topLeader[0];
	}

    /**
     * Getter of MP
     * @return The movement point
     */
    public  int getMP() {
        return MP;
    }

    /**
     * Setter of the MP
     * @param MP The new value of MP
     */
    public  void setMP(int MP) {
        this.MP = MP;
    }

    /**
     * Getter of ghostMP
     * @return The ghost movement point
     */
    public  int getGhostMP() {
        return ghostMP;
    }

    /**
     * Setter of the ghostMP
     * @param ghostMP The new value of ghostMP
     */
    public  void setGhostMP(int ghostMP) {
        this.ghostMP = ghostMP;
    }

    /**
     * Getter of position
     * @return The position
     */
    public  Tile getPosition() {
        return position;
    }

    /**
     * Setter of position
     * @param position The new position
     */
    public  void setPosition(Tile position) {
        this.position = position;
    }

    /**
     * Getter of ghostPosition
     * @return The ghost position
     */
    public  Tile getGhostPosition() {
        return ghostPosition;
    }

    /**
     * Setter of ghostPosition
     * @param ghostPosition The new ghost position
     */
    public  void setGhostPosition(Tile ghostPosition) {
        this.ghostPosition = ghostPosition;
    }
}
