// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  CANSparkMax armMotor;
  // SparkAbsoluteEncoder armEncoder;
  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    armMotor = new CANSparkMax(5, MotorType.kBrushless);
    // armEncoder = intakeMotor.getAbsoluteEncoder();

    armMotor.setIdleMode(IdleMode.kBrake);
  }

  public void moveArm(double speed) {
    armMotor.set(speed);
  }

  public double getEncoder() {
    return armMotor.getEncoder().getPosition();
  }

  public void zeroEncoder() {
    armMotor.getEncoder().setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
