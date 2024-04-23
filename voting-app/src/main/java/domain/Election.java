package domain;

import java.util.List;

/**
 * Classe do dominio referente ao ic do voto e a lista de candidatos
 * @param id
 * @param candidates
 */
public record Election(String id, List<Candidate> candidates) {
}