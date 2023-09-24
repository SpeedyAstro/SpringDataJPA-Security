package in.astro.repo;

import in.astro.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserDetailsRepo extends JpaRepository<UserDetails,Integer> {
    public Optional<UserDetails> findByUname(String name);
}
