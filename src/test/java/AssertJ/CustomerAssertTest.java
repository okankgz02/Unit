package AssertJ;

import com.havelsan.assertj.Customer;
import com.havelsan.assertj.CustomerRepository;
import com.havelsan.assertj.CustomerService;
import com.havelsan.assertj.NotificationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CustomerAssertTest {

    private CustomerRepository customerRepository;
    private NotificationService notificationService;
    private CustomerService customerService;

    public static final String USERNAME="baris";
    public static final String EMAIL="b@b.com";

    @Before
    public  void setUp() throws Exception{
        customerService=new CustomerService();
        customerRepository= Mockito.mock(CustomerRepository.class); //sahte nesne üretimi mock ile
        notificationService=Mockito.mock(NotificationService.class);

        customerService.setCustomerRepository(customerRepository);
        customerService.setNotificationService(notificationService);

    }


    @Test
    public void testCustomerAssert() throws  Exception{
        Customer customer=customerService.handleNewCustomer(USERNAME,EMAIL);

        Mockito.verify(customerRepository).save(Mockito.any(Customer.class)); //Müşteri nesnesinin kayıt edildğini kontrol ediyoruz
        Mockito.verify(notificationService).sendWelcomeNotification(USERNAME,EMAIL);

        Assert.assertNotNull(customer.getGifts());
        Assert.assertEquals(2,customer.getGifts().size());
        Assert.assertEquals("welcome1",customer.getGifts().get(0));
        Assert.assertEquals("welcome2",customer.getGifts().get(1));
    }


    @Test
    public void testCustomAssert() throws  Exception{
        Customer customer=customerService.handleNewCustomer(USERNAME,EMAIL);


    }
}
