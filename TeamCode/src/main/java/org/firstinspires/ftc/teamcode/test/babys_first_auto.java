package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="babys first auto")
public class babys_first_auto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor m0 = hardwareMap.dcMotor.get("back_left");
        waitForStart();
        m0.setPower(0.2);
        sleep(1000);
        m0.setPower(0);
    }
}
