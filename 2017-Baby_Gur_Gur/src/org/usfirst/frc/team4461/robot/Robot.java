package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4461.robot.commands.Drive;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.Hopper;

public class Robot extends IterativeRobot {

	public static Chassis Chassis;
	public static OI oi;
	public static Hopper Hopper;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	@Override
	public void robotInit() {
		Chassis = new Chassis();
		oi = new OI();
		Hopper = new Hopper();
		
		System.out.println("4461: Robot robotInit.");
	}

	@Override
	public void disabledInit() {
		System.out.println("4461: Robot in disabled mode.");
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}
	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	@Override
	public void teleopPeriodic() {
		chooser.addDefault("Default Drive Command", new Drive());
		chooser.addDefault("Default Intake Command", new Intake());
		SmartDashboard.putData("Auto mode", chooser);
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
