package com.example.demo.service.admin;
import com.example.demo.models.realmodel.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user= (User) userRepository.findByUsername(username);
            if (user == null){
                throw new UsernameNotFoundException("Dont Found "+username);
            }

            return (UserDetails) user;
        }

}
