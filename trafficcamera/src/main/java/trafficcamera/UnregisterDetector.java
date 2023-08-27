package trafficcamera;

public class UnregisterDetector implements Detector{
    private Detector detector;
    @Override
    public void detect(Camera camera) {
        if(camera.getLicensePlate().equals("678")) {
            System.out.println("The vehicle is unregister " + camera.getLicensePlate());
        }
        else{
            detector.detect(camera);
        }
    }

    @Override
    public void setDetector(Detector detector) {
        this.detector = detector;
    }
}
