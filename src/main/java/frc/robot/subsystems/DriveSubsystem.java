// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  WPI_TalonSRX leftDrive1, leftDrive2, rightDrive1, rightDrive2;
  DifferentialDrive drivetrain;
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftDrive1 = new WPI_TalonSRX(2);
    leftDrive2 = new WPI_TalonSRX(3);
    rightDrive1 = new WPI_TalonSRX(0);
    rightDrive2 = new WPI_TalonSRX(1);

    leftDrive2.follow(leftDrive1);
    rightDrive2.follow(rightDrive1);

    rightDrive1.setInverted(true);
    rightDrive2.setInverted(true);
  

    drivetrain = new DifferentialDrive(leftDrive1, rightDrive1);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drivetrain.tankDrive(leftSpeed, rightSpeed);
  }

  public void arcadeDrive(double speed, double rotation) {
    drivetrain.arcadeDrive(speed, rotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
