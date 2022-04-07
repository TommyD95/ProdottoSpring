package it.devle.EsercitazioneFinale.repository;

import it.devle.EsercitazioneFinale.model.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

    List<Prodotto> findAllBynome(String nome);

    List<Prodotto> findByprezzoBetween(float min, float max);

    List<Prodotto> findAllByquantita(int quantita);

    List<Prodotto> findByOrderByQuantita();

    List<Prodotto> findBydatadiacquisto(Date data);
}

