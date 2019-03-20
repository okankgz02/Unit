import com.havelsan.ornek.HesapMakinesi;
import org.junit.Test;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

public class ParametreTest2 {
    private HesapMakinesi hesapMakinesi = new HesapMakinesi();



    @Test

    public void testMetreKareHesapla(int eni,int boyu,int toplamMetreKare) throws Exception {

        assertEquals(toplamMetreKare,hesapMakinesi.metreKareHesapla(eni,boyu));
    }
}
