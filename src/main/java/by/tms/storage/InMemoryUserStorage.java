package by.tms.storage;

import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class InMemoryUserStorage extends Storage<User, Long> {
    private final AtomicLong useridGenerator;

    public InMemoryUserStorage(@Qualifier("userIdGenerator") AtomicLong useridGenerator) {
        this.useridGenerator = useridGenerator;
    }

    @Override
    public User save(User user) {
        user.setId(useridGenerator.incrementAndGet());
        list.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        for (User u : this.getList()) {
            if(u.getId().equals(aLong))
                return Optional.of(u);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findEntity(String email) {
        for (User u : this.getList()) {
            if(u.getEmail().equals(email))
                return Optional.of(u);
        }
        return Optional.empty();
    }
}
