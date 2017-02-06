package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
	//Joysticks
	public static Joystick lJoy, rJoy;
	
	//Left Joystick Buttons
	JoystickButton lb1, lb2, lb3, lb4;
				   
	//Right Joystick Buttons
	JoystickButton rb1, rb2, rb3, rb4;
	
	public OI(){
		System.out.println("4461: Start OI Init.");
		lJoy = new Joystick(0);
		rJoy = new Joystick(1);
		lb1 = new JoystickButton(lJoy, 1);
		rb2 = new JoystickButton(rJoy, 2);
		System.out.println("4461: Complete OI Init.");			
	}
	
	public double lJoyGetY(){
		return lJoy.getY();
	}
	
	public double rJoyGetY(){
		return rJoy.getY();
	}
	public boolean rb2Get(){
		return rb2.get();
	}
}