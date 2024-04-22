package domain;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.instancio.Instancio;

import javax.inject.Inject;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Classe de Teste das Regras de Negócio do candidato
 */
@QuarkusTest
public class CandidateServiceTest {
    @Inject
    CandidateService service;

    @InjectMock
    CandidateRepository repository;

    @Test
    public void save() {
        var domain = Instancio.create(Candidate.class);

        service.save(domain);

        verify(repository).save(domain);
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void findAll() {
        var candidates = Instancio.stream(Candidate.class).limit(10).toList();

        when(repository.findAll()).thenReturn(candidates);

        var result = service.findAll();

        verify(repository).findAll();
        verifyNoMoreInteractions(repository);

        assertEquals(result, candidates);
    }

    @Test
    public void findById_whenCandidateIsFound_returnsCandidate() {
        var domain = Instancio.create(Candidate.class);

        when(repository.findById(domain.id())).thenReturn(Optional.of(domain));

        var result = service.findById(domain.id());

        verify(repository).findById(domain.id());
        verifyNoMoreInteractions(repository);

        assertEquals(result, domain);
    }

    @Test
    public void findById_whenCandidateIsNotFound_throwsException() {
        var id = UUID.randomUUID().toString();
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class, () -> service.findById(id));
        verify(repository).findById(id);
        verifyNoMoreInteractions(repository);
    }
}