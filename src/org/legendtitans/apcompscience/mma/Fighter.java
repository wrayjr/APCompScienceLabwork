package org.legendtitans.apcompscience.mma;

import java.awt.image.BufferedImage;
import java.lang.Math;

public class Fighter {
	private String name;
	private BufferedImage picture;
	private String description;
	private int currentHitPoints;
	private int maxHitPoints;
	private int minDamage;
	private int maxDamage;
	
	public Fighter(String name, String description, int currentHitPoints, int maxHitPoints, int minDamage, int maxDamage, BufferedImage picture) {
		this.name = name;
		this.description = description;
		this.currentHitPoints = currentHitPoints;
		this.maxHitPoints = maxHitPoints;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.picture = picture;
	}
	
	public Fighter(String name, String description, BufferedImage picture) {
		this.name = name;
		this.description = description;
		this.picture = picture;
	}
	
	public boolean isAlive() {
		if(currentHitPoints > 0) {
			return true;
		}
		return false;
	}
	public String getName() {
		return name;
	}
	public BufferedImage getPicture() {
		return picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDecription(String desc) {
		this.description = desc;
	}
	public int getCurrentHitPoints() {
		return currentHitPoints;
	}
	public void setCurrentHitPoints(int hitPoints) {
		currentHitPoints = currentHitPoints - hitPoints;
	}
	public int attack() {            
		int x = (int) ((Math.random()*(maxDamage - minDamage)) + minDamage);
		return x;
	}
	public void defend() {
		int x = (int) (maxHitPoints * .1)+(currentHitPoints);
		if (x > maxHitPoints) {
			currentHitPoints = maxHitPoints;
		}
		else {
			currentHitPoints = x;
		}
	}
	public int special() {
		return attack()*2;
	}
	
	public void heal() {
		currentHitPoints = maxHitPoints;
	}

}
