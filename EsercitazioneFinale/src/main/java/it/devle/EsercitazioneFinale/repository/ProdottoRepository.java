package it.devle.EsercitazioneFinale.repository;

import it.devle.EsercitazioneFinale.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProdottoRepository extends JpaRepository<Prodotto,Long> {

List<Prodotto> findBynome(String nome);


    List<Prodotto> findByquantita(int quantita);

    List<Prodotto> findByprezzoBetween(float min, float max);
}

