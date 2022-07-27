package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="summer mecanum test")
public class summer_mecanum_test extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor m_back_left = hardwareMap.dcMotor.get("back_left");
        DcMotor m_back_right = hardwareMap.dcMotor.get("back_right");
        DcMotor m_front_left = hardwareMap.dcMotor.get("front_left");
        DcMotor m_front_right = hardwareMap.dcMotor.get("front_right");

        // reverse right side motors
        m_front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        m_back_right.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
           double y = -gamepad1.left_stick_y;
           double x = gamepad1.left_stick_x * 1.1; // this p-gain is experimental and should be updated
           double rx = gamepad1.right_stick_x;
           double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

           double front_left_power = (y + x + rx) / denominator;
           double back_left_power = (y - x + rx) / denominator;
           double front_right_power = (y - x - rx) / denominator;
           double back_right_power = (y + x - rx) / denominator;

           m_back_left.setPower(back_left_power);
           m_back_right.setPower(back_right_power);
           m_front_left.setPower(front_left_power);
           m_front_right.setPower(front_right_power);


        }
    }


}
