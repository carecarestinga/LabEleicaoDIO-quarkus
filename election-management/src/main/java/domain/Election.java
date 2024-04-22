package domain;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Classe de dominio voto
 * @param id
 * @param votes
 */
public record Election(String id, Map<Candidate, Integer> votes) {
    public static Election create(List<Candidate> candidates) {
        Map<Candidate, Integer> votes = candidates.stream()
                .collect(Collectors.toMap(candidate -> candidate, o -> 0));

        return new Election(UUID.randomUUID().toString(), votes);
    }
}