package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "babys first software")
public class babys_first_robo_code extends OpMode {

    private DcMotor m0 = null;

    @Override
    public void init() {
        m0 = hardwareMap.dcMotor.get("back_left");
    }

    @Override
    public void loop() {
        telemetry.addLine("hello world");
        telemetry.update();
        m0.setPower(gamepad1.left_stick_x);
    }
}
