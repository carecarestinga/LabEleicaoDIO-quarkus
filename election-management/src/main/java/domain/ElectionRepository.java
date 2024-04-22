package domain;

/**
 * Interface de contrato do dominio voto
 */
public interface ElectionRepository {
    void submit(Election election);
}