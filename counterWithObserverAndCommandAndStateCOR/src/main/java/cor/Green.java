package cor;

public class Green implements ColorHandler{
    private ColorHandler colorHandler;
    @Override
    public void handler(int count) {
        System.out.println("Count is "+count);
        if((count%2==0 && count >= 10) || (count!=12 ||count!=13)){
            System.out.println("The color handler is GREEN");
        }else{
            colorHandler.handler(count);
        }
    }

    @Override
    public void setHandler(ColorHandler colorHandler) {
        this.colorHandler = colorHandler;
    }
}
