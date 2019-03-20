import org.junit.Assert.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class AssertTest {

    @Test
    public void testAssertions() throws Exception{
        Dummy d1=new Dummy(4);
        Dummy d3=d1;
        Dummy d2=new Dummy(4);
        Dummy d4=null;

        assertEquals(d1,d3);  //eşitmi diye kontrol
        assertSame("d1 d3 eşit olmalı",d1,d3); //aynı referasnmı
        assertNull(d4); //null olmalı
        assertNull(null);
//        assertNotNull(d4); //null olmaamalı
        assertTrue(d4==null); //içi doğru olmalı

    }

    @Test
    public  void diziTest(){
        String[] s1=new String[]{"okan","ali"};
        String[] s2=new String[]{"okan","ali"};
        assertArrayEquals(s1,s2);

    }

    private static class Dummy{
        private int id;

        public Dummy(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
