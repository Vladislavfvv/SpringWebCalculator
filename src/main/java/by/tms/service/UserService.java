package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.InMemoryUserStorage;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private Storage<User, Long> storage;

    public User saveUser(User user) {
        storage.save(user);
        return user;
    }

    public Optional<User> findUserByEmail(String email) {
        for (User u : storage.getList()) {
            if (u.getEmail().equals(email))
                return Optional.of(u);
        }
        return Optional.empty();
    }

}
