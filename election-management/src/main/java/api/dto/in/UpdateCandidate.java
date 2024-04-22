package api.dto.in;

import domain.Candidate;

import java.util.Optional;

/**
 * Classe da camada Adpter. DTO de atualização de um Candidato
 * @param photo
 * @param givenName
 * @param familyName
 * @param email
 * @param phone
 * @param jobTitle
 */
public record UpdateCandidate(Optional<String> photo,
                              String givenName,
                              String familyName,
                              String email,
                              Optional<String> phone,
                              Optional<String> jobTitle) {
    public Candidate toDomain(String id) {
        return new Candidate(id, photo(), givenName(), familyName(), email(), phone(), jobTitle());
    }
}