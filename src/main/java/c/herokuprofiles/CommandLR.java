package c.herokuprofiles;

import c.herokuprofiles.model.Account;
import c.herokuprofiles.model.Role;
import c.herokuprofiles.repo.AccountRepository;
import c.herokuprofiles.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

/*
Этот класс генерирует мастер пароль и логин для бд.
можно сгенерировать руками, но тогда придется отдельно
оборачивать пароль внутрь BcryptPasswordEncoder::encode(пароль)
Бин кодировщика лежит в секьюрити конфиг классе
 */

@Component  //раскоменти чтобы сгенерировать
public class CommandLR implements CommandLineRunner {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public void run(String... args) throws Exception {


        Role r = new Role("ROLE_ADMIN");

        roleRepository.save(r);

        Account acc = new Account("345345", encoder.encode("234234234"));
        accountRepository.save(acc);

        HashSet<Role> roles = new HashSet<>();
        roles.add(r);

        HashSet<Account> accounts = new HashSet<>();
        accounts.add(acc);


        r.setAccounts(accounts);
        acc.setRoles(roles);

        accountRepository.save(acc);


    }
}
