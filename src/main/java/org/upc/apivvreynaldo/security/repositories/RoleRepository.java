package org.upc.apivvreynaldo.security.repositories;
import org.upc.apivvreynaldo.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
