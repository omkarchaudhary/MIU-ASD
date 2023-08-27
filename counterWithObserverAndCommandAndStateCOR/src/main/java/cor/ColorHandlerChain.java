package cor;

public class ColorHandlerChain {
    private ColorHandler colorHandler;

    public ColorHandlerChain() {
        colorHandler = new Red();
        ColorHandler greenHandler = new Green();
        ColorHandler blueHandler = new Blue();
        ColorHandler orangeHandler = new Orange();
        colorHandler.setHandler(greenHandler);
        greenHandler.setHandler(blueHandler);
        blueHandler.setHandler(orangeHandler);
    }

    public ColorHandler getColorHandler() {
        return colorHandler;
    }
}
