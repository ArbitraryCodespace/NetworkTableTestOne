// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import edu.wpi.first.networktables.DoublePublisher;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StringPublisher;
import edu.wpi.first.wpilibj2.command.SubsystemBase;    

public class NetworkTableClient extends SubsystemBase {
  private final DoublePublisher xPub;
  private final DoublePublisher yPub;
  private final StringPublisher timePub;
  private final DateTimeFormatter timeFormat;
  private final NetworkTableInstance instance;
  
  private double x = 0;
  private double y = 0;
  private LocalDateTime time = java.time.LocalDateTime.now();

  public NetworkTableClient() {
    instance = NetworkTableInstance.getDefault();
    //instance.setServer("localhost", NetworkTableInstance.kDefaultPort4);

    NetworkTable table = instance.getTable("datatable");

    xPub = table.getDoubleTopic("x").publish();
    yPub = table.getDoubleTopic("y").publish();
    timePub = table.getStringTopic("time").publish();
    timeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd | hh:mm:ss | a");
  }

  @Override
  public void periodic() {
    //public values that increase constantly
    xPub.set(x);
    yPub.set(y);
    timePub.set(time.format(timeFormat));
    time = LocalDateTime.now();
  }
  
  public NetworkTableInstance getNetworkTableInstance() {
    return instance;
  }
}
