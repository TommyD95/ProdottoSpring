package it.devle.EsercitazioneFinale.repository;

import it.devle.EsercitazioneFinale.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {

}

