package trafficcamera;

public class Camera {
    private String licensePlate;
    private float speed;
    private String cameraId;

    public Camera(String licensePlate, float speed, String cameraId) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        this.cameraId = cameraId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId;
    }
}
