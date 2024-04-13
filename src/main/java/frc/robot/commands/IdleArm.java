// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.Constants.ArmConstants;

public class IdleArm extends Command {
  /** Creates a new IdleArm. */
  public IdleArm() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.arm);
    // SmartDashboard.putNumber("KG", 0);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // double KG = SmartDashboard.getNumber("KG", 0);
    double armOutput = Math.sin(RobotContainer.intake.getArmPostionRad()) * Constants.ArmConstants.kG;
    if (RobotContainer.intake.getArmPostion() < 95)
      RobotContainer.arm.moveArm(MathUtil.clamp(armOutput, -0.3, 0.3));
      // System.out.println(armOutput);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
