package br.com.lteixeira.multitenant.mapper;

import br.com.lteixeira.multitenant.dto.PersonDTO;
import br.com.lteixeira.multitenant.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PersonMapper {

    public static final ObjectMapper MAPPER = new ObjectMapper();

    public Person toModel(final PersonDTO personDTO) {
        return MAPPER.convertValue(personDTO, Person.class);
    }

    public PersonDTO toDTO(final Person person) {
        return MAPPER.convertValue(person, PersonDTO.class);
    }
}
