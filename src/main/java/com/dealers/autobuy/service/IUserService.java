package com.dealers.autobuy.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.dealers.autobuy.model.User;

/**
 * User service interface
 */
public interface IUserService extends UserDetailsService {
    User save(User user);
}
