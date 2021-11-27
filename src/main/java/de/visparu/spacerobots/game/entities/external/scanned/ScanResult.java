package de.visparu.spacerobots.game.entities.external.scanned;

import java.util.ArrayList;
import java.util.List;

import de.visparu.spacerobots.game.entities.internal.Bullet;
import de.visparu.spacerobots.game.entities.internal.InternalRobot;
import de.visparu.spacerobots.game.entities.internal.Rocket;

public final class ScanResult
{
	private final List<ScannedRobot>  robots;
	private final List<ScannedBullet> bullets;
	private final List<ScannedRocket> rockets;
	
	private final int iteration;
	
	public ScanResult(final List<InternalRobot> robots, final List<Bullet> bullets, final List<Rocket> rockets, final int iteration)
	{
		this.iteration = iteration;
		
		this.robots  = new ArrayList<>();
		this.bullets = new ArrayList<>();
		this.rockets = new ArrayList<>();
		
		for (var i = 0; i < robots.size(); i++)
		{
			final var robot    = robots.get(i);
			final var health   = robot.getHealth();
			final var energy   = robot.getEnergy();
			final var position = robot.getPosition();
			final var scan     = new ScannedRobot(health, energy, position);
			this.robots.add(scan);
		}
		for (var i = 0; i < bullets.size(); i++)
		{
			final var bullet   = bullets.get(i);
			final var position = bullet.getPosition();
			final var scan     = new ScannedBullet(position);
			this.bullets.add(scan);
		}
		for (var i = 0; i < rockets.size(); i++)
		{
			final var rocket   = rockets.get(i);
			final var position = rocket.getPosition();
			final var scan     = new ScannedRocket(position);
			this.rockets.add(scan);
		}
	}
	
	public int getIteration()
	{
		return this.iteration;
	}
	
	public List<ScannedBullet> getScannedBullets()
	{
		return this.bullets;
	}
	
	public List<ScannedRobot> getScannedRobots()
	{
		return this.robots;
	}
	
	public List<ScannedRocket> getScannedRockets()
	{
		return this.rockets;
	}
}