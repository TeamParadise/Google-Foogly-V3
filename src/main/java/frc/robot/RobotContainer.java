// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IdleArm;
import frc.robot.commands.MoveArm;
import frc.robot.commands.SetColor;
import frc.robot.commands.MoveArmUp;
import frc.robot.commands.RunIntake;
import frc.robot.commands.RunScore;
import frc.robot.commands.zeroArmEncoder;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.LedSubsystem;
import frc.robot.commands.wave;;



/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static DriveSubsystem drive = new DriveSubsystem();
  public final static ArmSubsystem arm = new ArmSubsystem();
  public final static IntakeSubsystem intake = new IntakeSubsystem();
  public static LedSubsystem m_led = new LedSubsystem();


  // Replace with CommandPS4Controller or CommandJoystick if needed
  public static final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // drive.setDefaultCommand(new ArcadeDrive());
    arm.setDefaultCommand(new IdleArm());

    m_driverController.rightTrigger(0.1).whileTrue(new MoveArm(1));
    m_driverController.leftTrigger(0.1).whileTrue(new MoveArm(-1));
    m_driverController.leftBumper().whileTrue(new RunIntake());
    m_driverController.rightBumper().whileTrue(new RunScore());
    // m_driverController.a().onTrue(new zeroArmEncoder());
    // m_driverController.b().onTrue(new SetColor(0.91)); //Left Trigger
    // m_driverController.x().onTrue(new SetColor(0.61)); //Right Trigger
  }
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
