package bank.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
    private MyFactory myFactory;

    public DaoFactory(){
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        try{
            Properties properties = new Properties();
            properties.load(new FileInputStream(rootPath+"/config.properties"));
            String environment = properties.getProperty("environment");
            if(environment.equals("production")){
                myFactory = new ProductionFactory();
            }else if(environment.equals("test")){
                myFactory = new MockFactory();
            }else{
                System.out.println("Please set environment properly");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyFactory getMyFactoryInstance(){
        return myFactory;
    }
}
