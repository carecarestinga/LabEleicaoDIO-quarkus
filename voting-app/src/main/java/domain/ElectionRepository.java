package domain;

import java.util.List;

/**
 * Interface de contrato de acesso ao repositorio
 */
public interface ElectionRepository {
    List<Election> findAll();
    Election findById(String id);

    void vote(String id, Candidate candidate);
}