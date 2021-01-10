package kafka;

public class FeeRecord {
	public String licencePlate;
	public String ownerInfo;
	public int speed;
	public int fee;

    public FeeRecord(String licencePlate, String ownerInfo, int speed, int fee) {
        this.licencePlate = licencePlate;
        this.ownerInfo = ownerInfo;
        this.speed = speed;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "FeeRecord{" +
                "licencePlate='" + licencePlate + '\'' +
                ", ownerInfo=" + ownerInfo +
                ", speed=" + speed +
                ", fee=" + fee +
                '}';
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getOwnerInfo() {
        return ownerInfo;
    }

    public void setOwnerInfo(String ownerInfo) {
        this.ownerInfo = ownerInfo;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}
