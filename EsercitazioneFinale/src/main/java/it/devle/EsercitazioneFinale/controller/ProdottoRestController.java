package it.devle.EsercitazioneFinale.controller;

import it.devle.EsercitazioneFinale.EsercitazioneFinaleApplication;
import it.devle.EsercitazioneFinale.avviso.ProdottoNonTrovato;
import it.devle.EsercitazioneFinale.model.Prodotto;
import it.devle.EsercitazioneFinale.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ProdottoRestController {

    private static final Logger logger= LoggerFactory.getLogger(EsercitazioneFinaleApplication.class);

    private ProdottoRepository repository;

    ProdottoRestController(ProdottoRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/prodotto")
    public List<Prodotto> readAll() {

        logger.info("prendo tutti i prodotti: ");
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public Prodotto readWithId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdottoNonTrovato(id));
    }

    @GetMapping("/prodotto/{nome}")
    public List<Prodotto> readWithnome(@PathVariable String nome) {
        return repository.findBynome(nome);
    }

    @GetMapping("/prodotto/{quantita}")
    public List<Prodotto> readWithquantita(@PathVariable int quantita){
            return repository.findByquantita(quantita);

        }
    @DeleteMapping("/prodotto/{id}")
    void deleteProdotto(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto) {
        return repository.save(nuovoProdotto);
    }
    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaDatiProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto) {
    return repository.save(prodotto);

    }
    @GetMapping("/prodotto/prezzo")
    public List<Prodotto> ricercaprodottoconprezzo(@RequestParam(name = "min") float min,
                                                @RequestParam(name = "max") float max) {
        return repository.findByprezzoBetween(min, max);
    }

    @PostMapping ("/caricafile")
    public  String caricaFile(@RequestParam ("file") MultipartFile file){
        String infoFile= file.getOriginalFilename() + " - "+file.getContentType();
        String conFormat = String.format("%S-%S", file.getOriginalFilename(),file.getContentType());
        logger.info((infoFile));
        logger.warn(conFormat);
        return conFormat;
    }

}

