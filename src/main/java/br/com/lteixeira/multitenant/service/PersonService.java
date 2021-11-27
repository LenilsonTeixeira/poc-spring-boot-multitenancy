package br.com.lteixeira.multitenant.service;

import br.com.lteixeira.multitenant.dto.PersonDTO;
import br.com.lteixeira.multitenant.mapper.PersonMapper;
import br.com.lteixeira.multitenant.model.Person;
import br.com.lteixeira.multitenant.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonDTO save(final PersonDTO personDTO) {
        final Person person = PersonMapper.toModel(personDTO);
        return PersonMapper.toDTO(personRepository.save(person));
    }

    public List<PersonDTO> findAll() {
        return personRepository.findAll()
                .stream()
                .map(PersonMapper::toDTO)
                .collect(Collectors.toList());
    }
}
