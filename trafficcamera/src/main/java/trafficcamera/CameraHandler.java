package trafficcamera;

public class CameraHandler {
    private Detector stolenDetector;
    public CameraHandler() {
        stolenDetector = new StolenDetector();
        Detector speedDetector = new SpeedDetector();
        Detector unregisterDetector = new UnregisterDetector();
        Detector unPaidDetector = new UnPaidDetector();
        stolenDetector.setDetector(speedDetector);
        speedDetector.setDetector(unregisterDetector);
        unregisterDetector.setDetector(unPaidDetector);
    }

    public Detector getDetector(){
        return stolenDetector;
    }
}
