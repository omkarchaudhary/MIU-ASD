package trafficcamera;

public class StolenDetector implements Detector{
    private Detector detector;
    @Override
    public void detect(Camera camera) {
        if(camera.getLicensePlate().equals("123")) {
            System.out.println("The vehicle is stolen " + camera.getLicensePlate());
        }else{
            detector.detect(camera);
        }
    }

    @Override
    public void setDetector(Detector detector) {
        this.detector = detector;
    }
}
