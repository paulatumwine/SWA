package kafka;

public class SpeedRecord {
    String licensePlate;
    int speed;

    public SpeedRecord() {
    }

    public SpeedRecord(String licensePlate, int speed) {
        this.licensePlate = licensePlate;
        this.speed = speed;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
