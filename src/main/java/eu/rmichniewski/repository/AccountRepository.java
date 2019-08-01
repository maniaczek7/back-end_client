package de.ertantoker.tutorial.repository;

import de.ertantoker.tutorial.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findOneByUsername(String username);
}
