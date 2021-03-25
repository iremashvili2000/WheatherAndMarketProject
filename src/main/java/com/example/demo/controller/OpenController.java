package com.example.demo.controller;

import com.example.demo.exception.BadDataException;
import com.example.demo.jwt.JwtTokenProvider;
import com.example.demo.models.realmodel.Product;
import com.example.demo.models.realmodel.User;
import com.example.demo.models.requests.openRequests.Login;
import com.example.demo.models.requests.openRequests.RegistrationAdmin;
import com.example.demo.models.requests.openRequests.SendOrder;
import com.example.demo.models.response.Token;
import com.example.demo.models.response.api.Amindi;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AmindService;
import com.example.demo.service.admin.UserService;
import com.example.demo.service.open.OpenService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/open")
public class OpenController {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final ProductsRepository productsRepository;
    private final OpenService openService;
    private final AmindService amindService;

    public OpenController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, UserService userService, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager, ProductsRepository productsRepository, OpenService openService, AmindService amindService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
        this.productsRepository = productsRepository;
        this.openService = openService;
        this.amindService = amindService;
    }

    @RequestMapping(value = "/admin/registration",method = RequestMethod.POST)
    public User registrationAdmin(@Valid @RequestBody RegistrationAdmin registrationAdmin){
        if(!registrationAdmin.getPassword().equals(registrationAdmin.getRepassword())){
            throw  new BadDataException("passwords must be equeals");
        }
        if(registrationAdmin.getPassword().length()<6){
            throw new BadDataException("password is small");
        }
        if(registrationAdmin.getPassword()==null || registrationAdmin.getEmail()==null || registrationAdmin.getUsername()==null){
            throw new BadDataException("empty line is not corect");
        }
        User user1=(User)userRepository.findByUsername(registrationAdmin.getUsername());
        if(user1!=null){
            throw new BadDataException("this mail alredy use");
        }
        User user=new User();
        user.setEmail(registrationAdmin.getEmail());
        user.setRole("admin");
        user.setUsername(registrationAdmin.getUsername());
        user.setPassword(passwordEncoder.encode(registrationAdmin.getPassword()));
        userRepository.save(user);
        return user;
    }
    @RequestMapping(value = "/admin/login",method = RequestMethod.POST)
    public Token login(@Valid @RequestBody Login login){
        User user=(User)userService.loadUserByUsername(login.getUsername());
        if(user==null){
            throw new BadDataException("password or username is not correct");
        }
        if(!passwordEncoder.matches(login.getPassword(), user.getPassword())){
            throw new BadDataException("password or username is not correct");
        }
        List<String> roles=new ArrayList<>();
        roles.add(user.getRole());
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getUsername(),login.getPassword(),getGrantedAuthorities(roles));

        authenticationManager.authenticate(authentication);
        String token = jwtTokenProvider.createToken(user);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Token token1=new Token(token);
        userRepository.save(user);
        return token1;

    }


    @RequestMapping(value = "/products/list/{num}/{page}",method = RequestMethod.POST)
    public List<Product> getProductList(@PathVariable(name = "num")String num, @PathVariable(name="page")Integer page){

        if(productsRepository.findAllByTitleLike(num, PageRequest.of(page,20,Sort.by("title")))!=null){
           return productsRepository.findAllByTitleLike(num,PageRequest.of(page,2,Sort.by("title"))).getContent();


        }
        throw new BadDataException("araferia");
    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registrationCompany(@Valid @RequestBody SendOrder sendOrder){
        return openService.registration(sendOrder);
    }

    @RequestMapping(value = "/amindi/{city}",method = RequestMethod.GET)
    public Amindi getAmindi(@PathVariable(name="city")String city) throws IOException {
       return amindService.getUrlObject(amindService.GetRequests(city));
    }






    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }




}
