package api.dto.in;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Optional;

/**
 * Classe de saida response
 * @param id
 * @param candidates
 */
public record Election(String id, List<Candidate> candidates) {
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public record Candidate(String id,
                            Optional<String> photo,
                            String fullName,
                            String email,
                            Optional<String> phone,
                            Optional<String> jobTitle,
                            Integer votes) {
    }
}