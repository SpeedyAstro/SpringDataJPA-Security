package in.astro.service;

import in.astro.model.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface IUserService extends UserDetailsService {
    public String register(UserDetails details);
}
