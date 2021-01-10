package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SpeedCalculator {
    @Autowired
    Sender sender;

    public void handleRecord(SpeedRecord speedRecord) {
        int speed = speedRecord.getSpeed();
        int fee = 0;
        if (speed > 90) fee = 125;
        else if (speed >= 82 && speed <= 90) fee = 80;
        else if (speed >= 77 && speed < 82) fee = 45;
        else if (speed >= 72 && speed < 77) fee = 25;

        FeeRecord feeRecord = new FeeRecord(speedRecord.getLicensePlate(), "Dumbo", speed, fee);
        System.out.println(feeRecord);
        sender.send(feeRecord);
    }

}
