package trafficcamera;

public class TrafficCameraApplication {
    public static void main(String[] args) {
        System.out.println("The traffic camera application");
        CameraHandler cameraHandler = new CameraHandler();
        Detector detector = cameraHandler.getDetector();
        detector.detect(new Camera("123",60,"Camera1"));
        detector.detect(new Camera("456",120, "Camera2"));
        detector.detect(new Camera("678",50,"Camera3"));
        detector.detect(new Camera("890",55,"Camers4"));
    }
}
