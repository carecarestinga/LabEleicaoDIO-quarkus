package domain;

import java.util.List;

/**
 * Interface de contrato do dominio voto
 */
public interface ElectionRepository {
    void submit(Election election);
    List<Election> findAll();
}