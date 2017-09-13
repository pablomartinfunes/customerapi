package api.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pfunes on 09/09/17.
 */
@Repository
public interface CustomerDAO extends JpaRepository<Customer,Long> {
}
