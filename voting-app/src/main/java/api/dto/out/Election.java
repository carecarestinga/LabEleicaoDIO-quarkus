package api.dto.out;

import domain.Candidate;

import java.util.List;

/**
 * Classe que adapta as camadas
 * @param id
 * @param candidates
 */
public record Election(String id, List<String> candidates) {
    public static Election fromDomain(domain.Election election) {
        return new Election(election.id(), election.candidates().stream().map(Candidate::id).toList());
    }
}