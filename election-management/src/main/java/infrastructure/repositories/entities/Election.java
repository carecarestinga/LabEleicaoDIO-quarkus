package infrastructure.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe Entidade voto de acesso ao repositorio
 */
@Entity(name = "elections")
public class Election {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Election fromDomain(domain.Election domain) {
        var entity = new Election();

        entity.setId(domain.id());

        return entity;
    }
}