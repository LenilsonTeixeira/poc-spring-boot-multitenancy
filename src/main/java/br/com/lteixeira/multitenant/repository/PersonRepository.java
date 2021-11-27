package br.com.lteixeira.multitenant.repository;

import br.com.lteixeira.multitenant.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
