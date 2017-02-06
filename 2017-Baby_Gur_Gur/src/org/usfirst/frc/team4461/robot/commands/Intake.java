package org.usfirst.frc.team4461.robot.commands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Intake extends Command {	
	public Intake() {
        requires(Robot.Hopper);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	Robot.Hopper.Take();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	Robot.Hopper.Stop();
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
