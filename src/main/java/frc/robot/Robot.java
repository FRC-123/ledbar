/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;

public class Robot extends TimedRobot {
  private PS4Controller m_stick;

  private static int loop_count = 0;
  private static int togglef = 0;
  private static AddressableLED led_bar;
  private static AddressableLEDBuffer led_buffer1;
  private static AddressableLEDBuffer led_buffer2;

  @Override
  public void robotInit() {
    led_bar = new AddressableLED(0);
    led_bar.setLength(20);
    led_buffer1 = new AddressableLEDBuffer(20);
    led_buffer2 = new AddressableLEDBuffer(20);
    for ( int i=0; i<20 ; i++ ) {
      led_buffer1.setLED(i, Color.kFirstBlue);
      led_buffer2.setLED(i, Color.kFirstRed);
    }
    led_bar.setData(led_buffer1);
    led_bar.start();

  }

  @Override
  public void teleopPeriodic() {
    loop_count++;
    if ( loop_count > 40 ) {
      loop_count = 0;
      if ( togglef==0 ) {
        led_bar.setData(led_buffer2);
      } else {
        led_bar.setData(led_buffer1);
      }
      togglef = 1 - togglef;
    }

  }

  
}
