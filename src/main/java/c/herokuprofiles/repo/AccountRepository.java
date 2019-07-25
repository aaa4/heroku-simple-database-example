package c.herokuprofiles.repo;


import c.herokuprofiles.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


    Account findDistinctByName(String s);
}
