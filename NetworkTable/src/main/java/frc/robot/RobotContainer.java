// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.upXYValues;
import frc.robot.subsystems.NetworkTableClient;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private XboxController driveStick;
  // The robot's subsystems

  // The driver's controller
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveStick = new XboxController(0);

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands

        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling passing it to a
   * {@link JoystickButton}.
   */
        private void configureButtonBindings() {
          Trigger aButton = new JoystickButton(driveStick,XboxController.Button.kA.value); 
          aButton.whileTrue(new upXYValues(new NetworkTableClient()));
        }

}

