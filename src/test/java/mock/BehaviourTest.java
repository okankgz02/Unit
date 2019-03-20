package mock;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BehaviourTest {

  @Test
  public void testBehavior() throws Exception {
    DummyCustomerService customerService =
        Mockito.mock(DummyCustomerService.class); // sahte özellik olusturduk
    customerService.addCustomer("istanbul");
    customerService.addCustomer("ankara");

    Mockito.verify(customerService)
        .addCustomer("istanbul"); // istanbul parametresi cağrıldıysa true
    Mockito.verify(customerService).addCustomer("ankara");
  }

  @Test
  public void testKackereCagrildi() throws Exception {
    DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);

    customerService.addCustomer("istanbul");
    customerService.addCustomer("istanbul");
    customerService.addCustomer("ankara");
    customerService.addCustomer("istanbul");

    Mockito.verify(customerService, times(3)).addCustomer("istanbul"); // istanbul 3 kere cagrıldımı
    Mockito.verify(customerService, times(1)).addCustomer("ankara"); // ankara cagrıldımı 1 kere

    Mockito.verify(customerService, never())
        .removeCustomer(
            anyString()); // remove customer hiç çağrılmaadı //remov fonksiyonu hiç çağrılmadımı

    Mockito.verify(customerService, never())
        .addCustomer("izmir"); // hiç çağrılmadığını kontrol etmek

    // en az 2 defa çağrıldıysa
    Mockito.verify(customerService, atLeast(1))
        .addCustomer("ankara"); // ankara en az 1 kere cagrılmalı
  }

  @Test
  public void testSirasiniKontrolEt() throws Exception {
    DummyCustomerService customerService = Mockito.mock(DummyCustomerService.class);
    customerService.addCustomer("istanbul");
    customerService.addCustomer("ankara");
    customerService.addCustomer("izmir");

    InOrder inOrder = inOrder(customerService);

    inOrder.verify(customerService).addCustomer("istanbul");
    inOrder.verify(customerService).addCustomer("izmir");
    inOrder.verify(customerService).addCustomer("istanbul");
  }

  @Test
  public void testWhen() throws Exception {
    DummyCustomerService service = mock(DummyCustomerService.class);

    when(service.getCustomer(anyString())).thenReturn("customerIstanbul");
    when(service.getCustomer(eq("ankara"))).thenReturn("customerIstanbul");

    String customer = service.getCustomer("istanbul");
    //  Assert.assertEquals(customer,"customerIstanbul");

  }

  @Test
  public void testWhen2() throws Exception {
    DummyCustomerService service = mock(DummyCustomerService.class);

    when(service.getCustomer(anyString())).thenReturn("customerIstanbul");
    when(service.getCustomer(eq("ankara")))
        .thenThrow(
            new RuntimeException()); // ankaaara parametresi verilirse RuntimeException atılır.

    String customer = service.getCustomer("istanbul");
    //  Assert.assertEquals(customer,"customerIstanbul");

  }

  @Test
  public void voidWhen2() throws Exception {

    // void metotalrı geri döndermek için doNothing()
    DummyCustomerService service = mock(DummyCustomerService.class);

    // do ile başlayan metotlar
    doNothing().when(service).addCustomer(anyString());

    //throw
      doThrow(new RuntimeException()).when(service).addCustomer(anyString());  //hata fırlatma
    //return burda yazabailirz
      doReturn("ankara").when(service).getCustomer("istanbul");

  }
}
