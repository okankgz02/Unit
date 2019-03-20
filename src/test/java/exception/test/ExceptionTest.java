package exception.test;

import com.havelsan.exception.MailServerUnavailableException;
import com.havelsan.unittest.service.BilgilendirmeService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionTest {

    private BilgilendirmeService bilgilendirmeService = new BilgilendirmeService();

    @Test
    public void testTryCatchException() {

        try {
            bilgilendirmeService.haftalikMailGonder();

        } catch (Exception ex) {
            assertTrue(ex instanceof MailServerUnavailableException); //yakalanan hatanın kendi hata sınıfımız olup olmadıgı
            assertEquals("mail server exception", ex.getMessage());

        }
    }

    @Test(expected = MailServerUnavailableException.class)
//hangi hatayı beklediğimizi expected ile belirtiyoruz //Hata mesajını kontrol edemeyiz
    public void textExpectedException() {
        bilgilendirmeService.haftalikMailGonder();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testRuleException() throws Exception {
        thrown.expect(MailServerUnavailableException.class);
        thrown.expectMessage("mail server hata");
        bilgilendirmeService.haftalikMailGonder();
    }

    @Test
    public void testCacheExceptionFramework() throws Exception{

    }

}
