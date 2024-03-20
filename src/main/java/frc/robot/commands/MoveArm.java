// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ArmConstants;
import frc.robot.RobotContainer;

public class MoveArm extends Command {
  /** Creates a new MoveArm. */

  double direction;

  public MoveArm(double direction) {
    addRequirements(RobotContainer.arm);
    this.direction = direction;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = (RobotContainer.m_driverController.getLeftTriggerAxis() + RobotContainer.m_driverController.getRightTriggerAxis()) * 0.25;
    double angleSpeed = Math.cos(RobotContainer.arm.getEncoder() * ArmConstants.kEncoderToAngleRadians) * ArmConstants.kG;
    RobotContainer.arm.moveArm(speed * direction + angleSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.arm.moveArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
