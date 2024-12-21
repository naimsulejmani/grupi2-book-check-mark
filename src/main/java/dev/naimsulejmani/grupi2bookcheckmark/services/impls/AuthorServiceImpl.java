package dev.naimsulejmani.grupi2bookcheckmark.services.impls;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.AuthorDto;
import dev.naimsulejmani.grupi2bookcheckmark.mappers.AuthorMapper;
import dev.naimsulejmani.grupi2bookcheckmark.repositories.AuthorRepository;
import dev.naimsulejmani.grupi2bookcheckmark.services.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    public AuthorServiceImpl(AuthorRepository repository, AuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AuthorDto> findAll() {
//        return repository.findAll().stream().map(mapper::toDto).toList();
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public AuthorDto findById(Long id) {
//        if (!repository.existsById(id)) {
//            throw new EntityNotFoundException("Author with id " + id + " not found.");
//        }
//        return mapper.toDto(repository.findById(id).get());

        var optionalAuthor = repository.findById(id);
        if (optionalAuthor.isEmpty()) {
            throw new EntityNotFoundException("Author with id " + id + " not found.");
        }
        return mapper.toDto(optionalAuthor.get());
    }

    @Override
    public AuthorDto add(AuthorDto model) {
        var author = mapper.toEntity(model);
        //valido autorin, mos lejo update, edhe autore existues
        return mapper.toDto(repository.save(author));
    }

    @Override
    public AuthorDto modify(Long id, AuthorDto model) {
        if (id != model.getId()) {
            throw new IllegalArgumentException("Id does not match.");
        }

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Author with id " + id + " not found.");
        }

        var author = mapper.toEntity(model);
        return mapper.toDto(repository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Author with id " + id + " not found.");
        }
        repository.deleteById(id);
    }
}
