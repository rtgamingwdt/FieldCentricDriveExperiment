// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.cyberorioles.subsystems;

import com.cyberorioles.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {

    public int yaw = Math.floorMod(-1, 360);

    /**
     * Creates a new ExampleSubsystem.
     */
    public ExampleSubsystem() {
    }


    /**
     * Example command factory method.
     *
     * @return a command
     */
    public CommandBase exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }


    /**
     * An example method querying a boolean state of the subsystem (for example, a digital sensor).
     *
     * @return value of some boolean subsystem state, such as a digital sensor.
     */
    public boolean exampleCondition() {
        // Query some boolean state, such as a digital sensor.
        return false;
    }


    @Override
    public void periodic() {

        double angleInRadians = Math.toRadians(yaw);
        double joyX = RobotContainer.driverController.getRightX(); // Input for strafing
        double joyY = -RobotContainer.driverController.getRightY(); // Input for forward motion

        double fieldX = joyX * Math.cos(angleInRadians) - joyY * Math.sin(angleInRadians);
        double fieldY = joyX * Math.sin(angleInRadians) + joyY * Math.cos(angleInRadians);

        SmartDashboard.putNumber("yaw", yaw);
        SmartDashboard.putNumber("fieldX", fieldX);
        SmartDashboard.putNumber("fieldY", fieldY);
        // This method will be called once per scheduler run
    }


    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
