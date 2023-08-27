package trafficcamera;

public class SpeedDetector implements Detector{
    private Detector detector;
    @Override
    public void detect(Camera camera) {
        if(camera.getSpeed() > 60) {
            System.out.println("The vehicle speed is high " + camera.getSpeed());
        }else{
            detector.detect(camera);
        }
    }

    @Override
    public void setDetector(Detector detector) {
        this.detector = detector;
    }
}
