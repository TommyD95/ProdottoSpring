package it.devle.EsercitazioneFinale.configurazione;

import it.devle.EsercitazioneFinale.EsercitazioneFinaleApplication;
import it.devle.EsercitazioneFinale.model.Prodotto;
import it.devle.EsercitazioneFinale.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static final Logger logger= LoggerFactory.getLogger(EsercitazioneFinaleApplication.class);

    @Bean
    CommandLineRunner inserisciElementi(ProdottoRepository repository) {
        return args -> {
            SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
            Date dataDiAcquistoP1=dateFormat.parse("15-10-2020");
            Date dataDiAcquistoP2=dateFormat.parse("23-06-2019");
            Date dataDiAcquistoP3=dateFormat.parse("02-12-2020");
            Date dataDiScadenzaP1=dateFormat.parse("05-12-2026");
            Date dataDiScadenzaP2=dateFormat.parse("26-04-2025");
            Date dataDiScadenzaP3=dateFormat.parse("14-11-2023");

            Prodotto p1=new Prodotto("pasta",10,dataDiAcquistoP1,dataDiScadenzaP1,2.5);
            Prodotto p2=new Prodotto("carne",15,dataDiAcquistoP2,dataDiScadenzaP2,4.5);
            Prodotto p3=new Prodotto("acqua",2,dataDiAcquistoP3,dataDiScadenzaP3,1.5);

            List<Prodotto> prodotti=new ArrayList<>();
            prodotti.add(p1);
            prodotti.add(p2);
            prodotti.add(p3);

            repository.saveAll(prodotti);
        };
    }
}
