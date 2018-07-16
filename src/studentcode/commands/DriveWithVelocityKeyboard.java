package studentcode.commands;

import java.util.Scanner;

import lib.Command;
import studentcode.robot.Robot;
import studentcode.robot.RobotMap.KeyboardCharacters;

/**
 * Drives the robot using input from the keyboard.
 * @author Finn Frankis
 * @version Jul 15, 2018
 */
public class DriveWithVelocityKeyboard extends Command
{
    private boolean isFinished;
    private double prevSpeed;
    private double prevTurn;
    private Scanner sc;
    
    public void initialize()
    {
        isFinished = false;
        sc = new Scanner(System.in);
    }
    public void execute()
    {
        double speed = 0;
        double turn = 0;
        String nextLine = sc.nextLine();
        if (nextLine.equals(KeyboardCharacters.FORWARD))
            speed = 1;
        else if (nextLine.equals(KeyboardCharacters.BACKWARD))
            speed = -1;
        else if (nextLine.equals(KeyboardCharacters.LEFT))
            turn = -1;
        else if (nextLine.equals(KeyboardCharacters.RIGHT))
            turn = 1;
        else if (!nextLine.equals(KeyboardCharacters.STOP))
        {
            speed = prevSpeed;
            turn = prevTurn;
        }
        Robot.getDrivetrain().arcadeDriveVelocity(speed, turn);
        prevSpeed = speed;
        prevTurn = turn;
            
    }
    
    public boolean isFinished()
    {
        return isFinished;
    }
    /**
    * 
    */
    @Override
    protected void end()
    {
        sc.close();
    }
}