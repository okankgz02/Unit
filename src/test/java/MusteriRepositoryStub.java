import com.havelsan.unittest.service.Musteri;
import com.havelsan.unittest.service.MusteriRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusteriRepositoryStub extends MusteriRepository {

    private Map<Integer, Musteri> musteriListesi = new HashMap<Integer, Musteri>();


    @Override
    public void kaydet(Musteri musteri) {
        musteriListesi.put(musteri.getId(),musteri);

    }

    @Override
    public void sil(Integer musteriId) {
        musteriListesi.remove(musteriId);
    }



    @Override
    public  Musteri bul(Integer musterId){
        return musteriListesi.get(musterId);
    }

    public Map<Integer,Musteri> getMusteriListesi(){
        return musteriListesi;
    }

    public void herseyiSil() {
        musteriListesi.clear();
    }
}
