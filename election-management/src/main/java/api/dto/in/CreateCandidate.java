package api.dto.in;

import domain.Candidate;

import java.util.Optional;

/**
 * Classe da camada Adpter. DTO de criação de um Candidato
 * @param photo
 * @param givenName
 * @param familyName
 * @param email
 * @param phone
 * @param jobTitle
 */
public record CreateCandidate(Optional<String> photo,
                              String givenName,
                              String familyName,
                              String email,
                              Optional<String> phone,
                              Optional<String> jobTitle) {
    public Candidate toDomain() {
        return Candidate.create(photo(), givenName(), familyName(), email(), phone(), jobTitle());
    }
}