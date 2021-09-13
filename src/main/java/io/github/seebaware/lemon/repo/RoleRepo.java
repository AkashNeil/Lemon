package io.github.seebaware.lemon.repo;

import io.github.seebaware.lemon.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
