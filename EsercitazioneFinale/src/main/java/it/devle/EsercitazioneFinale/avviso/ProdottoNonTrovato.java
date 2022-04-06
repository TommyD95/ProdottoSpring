package it.devle.EsercitazioneFinale.avviso;

public class ProdottoNonTrovato extends RuntimeException{
    public ProdottoNonTrovato(Long id){
        super("prodotto non trovato "+id);
    }

    public ProdottoNonTrovato(String nomeProdotto) {
        super("prodotto non trovato "+nomeProdotto);
    }
}
