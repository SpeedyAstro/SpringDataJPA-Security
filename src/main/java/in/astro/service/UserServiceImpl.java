package in.astro.service;

import in.astro.model.UserDetails;
import in.astro.repo.IUserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDetailsRepo repo;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Override
    public String register(UserDetails details) {
        details.setPwd(encoder.encode(details.getPwd()));
        return "User is registered Successfully with id "+repo.save(details).getUid();
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        System.out.println("UserServiceImpl.loadUserByUsername");
        Optional<UserDetails> optional = repo.findByUname(username);
        if(optional.isEmpty()){
            throw new IllegalArgumentException("user not found");
        }else {
            UserDetails userDetails = optional.get();
            User user = new User(userDetails.getUname(),userDetails.getPwd(),userDetails.getRoles().stream()
                    .map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
            return user;
        }
    }
}
