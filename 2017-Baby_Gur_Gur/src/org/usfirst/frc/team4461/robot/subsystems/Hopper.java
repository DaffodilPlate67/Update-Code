package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.Intake;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Hopper extends Subsystem {
	
	CANTalon hm1 = new CANTalon(RobotMap.hm1);
	CANTalon hm2 = new CANTalon(RobotMap.hm2);
	CANTalon hm3 = new CANTalon(RobotMap.hm3);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Intake());
    	System.out.println("4461: Hopper.java");
    }
    
    public void Take(){
    	System.out.println("4461: Button 2"+Robot.oi.rb2Get());
    	if(Robot.oi.rb2Get()){
    	hm1.set(.6);
    	}
    	else{
   		hm1.set(0);
    	}
    }
    
    public void Stop(){
    	hm1.set(0);
    }
}



