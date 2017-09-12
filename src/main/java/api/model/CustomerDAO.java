package api.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pfunes on 09/09/17.
 */
public interface CustomerDAO extends JpaRepository<api.model.Customer,Long> {
}
