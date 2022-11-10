package by.tms.storage;

import by.tms.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class InMemoryOperationStorage extends Storage<Operation, Long> {

    private final AtomicLong operationIdGenerator;

    public InMemoryOperationStorage(@Qualifier("operationIdGenerator") AtomicLong operationIdGenerator) {
        this.operationIdGenerator = operationIdGenerator;
    }

    @Override
    public Operation save(Operation operation) {
        operation.setId(operationIdGenerator.incrementAndGet());
        list.add(operation);
        return operation;
    }

    @Override
    public Optional<Operation> findById(Long aLong) {
        for (Operation o : this.getList()) {
            if (o.getId().equals(aLong))
                return Optional.of(o);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Operation> findEntity(String operation) {
        for (Operation o : this.getList()) {
            if (o.getOperation().equals(operation))
                return Optional.of(o);
        }
        return Optional.empty();
    }
}
