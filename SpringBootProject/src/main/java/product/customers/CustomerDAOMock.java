package product.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("MOCK")
public class CustomerDAOMock implements ICustomerDAO{
    @Autowired
    private ILogger logger;
    @Override
    public void save(Customer customer) {
        // simple sleep
        try {
            Thread.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerDAOMOCK: saving customer "+customer.getName());
        logger.log("Mock Customer is saved in the DB: "+ customer.getName() );
    }
}
