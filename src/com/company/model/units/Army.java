package com.company.model.units;

import com.company.model.Tile;

import java.util.List;

public class Army {
	/**
	 *
	 */
	private List<Leader> leaders;

	/**
	 *
	 */
	private List<Fighter> fighters;

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
	 *
	 * @param leader
	 * @param fighters
	 * @param position
	 */
	public Army(List<Leader> leader, List<Fighter> fighters, Tile position){
		this.leaders = leader;
		this.fighters = fighters;
		this.MP = 10;
		this.ghostMP = 10;
		this.position = position;
		this.ghostPosition = position;
	}

	/**
	 *
	 * @return
	 */
	public List<Fighter> getFighters(){
		return this.fighters;
	}

	/**
	 *
	 * @return
	 */
	public List<Leader> getLeader(){
		return this.leaders;
	}

	/**
	 *
	 * @param fighter
	 */
	public void addUnit(Fighter fighter){
		this.fighters.add(fighter);
	}

	/**
	 *
	 * @param leader
	 */
	public void addLeader(Leader leader){
		this.leaders.add(leader);
	}

	/**
	 *
	 * @param unit
	 * @return
	 */
	public Boolean removeUnit(Fighter unit){
		return fighters.contains(unit) && this.fighters.remove(unit);
	}

	/**
	 *
	 * @param leader
	 * @return
	 */
	public Boolean removeLeader(Leader leader){
		return leaders.contains(leader) && this.leaders.remove(leader);
	}

	/**
	 *
	 * @return
	 */
	public int getMissileValue(){
		return this.fighters.stream().mapToInt(Fighter::getMissileValue).sum();
	}

	/**
	 *
	 * @return
	 */
	public int getMeleeValue(){
		return this.fighters.stream().mapToInt(Fighter::getMeleeValue).sum();
	}

	/**
	 *
	 * @return
	 */
	public int getArmorValue(){
		return this.fighters.stream().mapToInt(Unit::getArmor).sum();
	}

	/**
	 *
	 * @param attackValue
	 */
	public void decreaseMoral(int attackValue){
		this.fighters.forEach(fighter -> fighter.setMP(0));
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
