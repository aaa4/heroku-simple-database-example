package c.herokuprofiles.repo;

import c.herokuprofiles.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findDistinctByRole(String role);
    List<Role> findAll();
}
