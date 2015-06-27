package io.listened.api.repo;

import io.listened.common.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Clay on 5/29/2015.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

}
