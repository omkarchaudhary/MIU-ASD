package cor;

public class Blue implements ColorHandler{
    private ColorHandler colorHandler;
    @Override
    public void handler(int count) {
        System.out.println("Count is "+count);
        if((count%2!=0 && count < 15) || (count==17 ||count==19)){
            System.out.println("The color handler is BLUE");
        }else{
            colorHandler.handler(count);
        }
    }

    @Override
    public void setHandler(ColorHandler colorHandler) {
        this.colorHandler = colorHandler;
    }
}
