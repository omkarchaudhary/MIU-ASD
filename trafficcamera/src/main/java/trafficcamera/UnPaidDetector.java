package trafficcamera;

public class UnPaidDetector implements Detector {
    private Detector detector;
    @Override
    public void detect(Camera camera) {
        if(camera.getLicensePlate().equals("890")) {
            System.out.println("The vehicle is unpaid two times " + camera.getLicensePlate());
        }else{
            detector.detect(camera);
        }
    }

    @Override
    public void setDetector(Detector detector) {
        this.detector = detector;
    }
}
