import com.havelsan.ornek.HesapMakinesi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametreTest {
    private HesapMakinesi hesapMakinesi = new HesapMakinesi();

    @Parameterized.Parameters
    private static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, 2, 5},
                {10, 2, 5},
                {10, 2, 5},
                {10, 2, 5}});

    }

    private int eni;
    private int boyu;
    private int toplamMetreKare;

    public ParametreTest(int eni, int boyu, int toplamMetreKare) {
        this.eni = eni;
        this.boyu = boyu;
        this.toplamMetreKare = toplamMetreKare;
    }

    @Test
    public void testMetreKareHesapla() throws Exception {

        assertEquals(toplamMetreKare,hesapMakinesi.metreKareHesapla(eni,boyu));
    }
}
