package infrastructure.repositories;

import domain.Election;
import domain.ElectionRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Classe que implementa um contrato com do core do dominio do voto
 */
@ApplicationScoped
public class SQLElectionRepository implements ElectionRepository {
    private final EntityManager entityManager;

    public SQLElectionRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void submit(Election election) {
        entityManager.merge(infrastructure.repositories.entities.Election.fromDomain(election));

        election.votes()
                .entrySet()
                .stream()
                .map(entry -> infrastructure.repositories.entities.ElectionCandidate.fromDomain(election, entry.getKey(), entry.getValue()))
                .forEach(entityManager::merge);
    }
}