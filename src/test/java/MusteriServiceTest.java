import com.havelsan.unittest.service.BilgilendirmeService;
import com.havelsan.unittest.service.Musteri;
import com.havelsan.unittest.service.MusteriRepository;
import com.havelsan.unittest.service.MusteriService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class MusteriServiceTest {

    private MusteriService musteriService;

    private MusteriRepositoryStub  musteriRepository = new MusteriRepositoryStub(); //Repositorydan extend edilir.


    private BilgilendirmeService bilgilendirmeService;

    @Before
    public void setUp() throws Exception {
        musteriService = new MusteriService();
        bilgilendirmeService = Mockito.mock(BilgilendirmeService.class);



        musteriService.setMusteriRepository(musteriRepository);
        musteriService.setBilgilendirmeService(bilgilendirmeService);
    }

    @After
    public void after() {
        musteriRepository.herseyiSil();
    }

    @Test
    public void testMusteriSil() throws Exception {
        musteriService.musteriKaydet(new Musteri(1234));
        //  assertNotNull(musteriRepository.bul(1234)); //veritabanında varmı yok mu null olmasın

        musteriService.musteriSil(1234);

        assertNull(musteriRepository.bul(1234)); //yoksa sil

    }

    @Test
    public void testMusteriKaydet() {
        Musteri musteri = new Musteri(1234);
        musteriService.musteriKaydet(musteri);

        //kontrol etmemiz gerekir
        //Mockito.verify(musteriRepository).kaydet(musteri);
        //  assertTrue(musteriRepository.getMusteriListesi().containsValue(musteri)); //assertTrue verilen parametrenin doğrumu yanlısmı oldugunu test ederiz

        // assertNotNull(musteriRepository.bul(musteri.getId()));//assertNotNull obje alır nul olup olmadığını kontrol eder

        assertEquals(musteri, musteriRepository.bul(musteri.getId()));  //2 nesnenin eşit mi
        Mockito.verify(bilgilendirmeService).yeniKayitMailGonder(musteri);
    }


}
