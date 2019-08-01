package eu.rmichniewski.repository;

import eu.rmichniewski.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findOneByUsername(String username);
}
