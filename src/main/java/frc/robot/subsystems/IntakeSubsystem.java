// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkAbsoluteEncoder.Type;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  CANSparkMax intakeMotor;
  AbsoluteEncoder absEncoder;
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    intakeMotor = new CANSparkMax(6, MotorType.kBrushed);
    absEncoder = intakeMotor.getAbsoluteEncoder(Type.kDutyCycle);
  }

  public void runIntake(double speed) {
    intakeMotor.set(speed);
  }
  
  public double getArmPostion() {
   return  absEncoder.getPosition();
  } 

  public double getArmPostionRad() {
   return Units.degreesToRadians(absEncoder.getPosition());
  } 




  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  SmartDashboard.putNumber("armAngle", getArmPostion());
  }
}
