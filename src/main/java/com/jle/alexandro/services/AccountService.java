package com.jle.alexandro.services;

import com.jle.alexandro.models.entities.Client;

public interface AccountService {
    Client saveUser(Client user);
    Client findUserByUsername(String username);
}