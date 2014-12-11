package sherlock.base.user.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sherlock.base.user.domain.User;

import java.util.List;

@RepositoryRestResource
interface UserRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findByFirstnameAndLastnameAllIgnoreCase(
            @Param("firstname")
            String firstname,
            @Param("lastname")
            String lastname);

}
