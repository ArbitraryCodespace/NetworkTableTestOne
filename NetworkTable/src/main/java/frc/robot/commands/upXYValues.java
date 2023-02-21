// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NetworkTableClient;

public class upXYValues extends CommandBase {
  private final NetworkTableClient networkTableClient;
  private double x;
  private double y;
  private final DoublePublisher xPub;
  private final DoublePublisher yPub;
  
  /** Creates a new upXYValues. */
  public upXYValues(NetworkTableClient ntc) { 
    System.out.println("initializing upXYValuesCommand...");
    networkTableClient = ntc;
    NetworkTableInstance networkTableInstance = networkTableClient.getNetworkTableInstance();
    NetworkTable networkTable = networkTableInstance.getTable(getName());
    xPub  = networkTable.getDoubleTopic("x").publish();
    yPub = networkTable.getDoubleTopic("y").publish();
    addRequirements(ntc);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    x = 10;
    y = 20;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      xPub.set(x);
      yPub.set(y);
      x += 1.00007;
      y += 1.5;
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
