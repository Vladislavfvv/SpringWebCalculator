package by.tms.service;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.InMemoryOperationStorage;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OperationService {

    @Autowired
    private Storage<Operation, Long> storage;


    private double findSum(double num1, double num2) {
        return num1 + num2;
    }

    private double findDiff(double num1, double num2) {
        return num1 - num2;
    }

    private double findMulti(double num1, double num2) {
        return num1 * num2;
    }

    private double findDiv(double num1, double num2) {
        return num1 / num2;
    }

    public Operation calculate(Operation operation, User currentUser) {
        double num1 = operation.getNum1();
        double num2 = operation.getNum2();
        switch (operation.getOperation()) {
            case ("sum"):
                operation.setResult(findSum(num1, num2));
                break;
            case ("diff"):
                operation.setResult(findDiff(num1, num2));
                break;
            case ("mul"):
                operation.setResult(findMulti(num1, num2));
                break;
            case ("div"):
                operation.setResult(findDiv(num1, num2));
                break;
            default:
                break;
        }
        operation.setDate(LocalDateTime.now());
//        userRepository.save(user);
//        operation.setUserId(user.getId());
        operation.setUser(currentUser);
        storage.save(operation);
        // operationRepository.save(operation);

        return operation;
    }

    public void checkOperation(Operation operation){
        if (!(operation.getOperation().equals("sum")
                || !operation.getOperation().equals("diff")
                || !operation.getOperation().equals("mul")
                || !operation.getOperation().equals("div"))) {
            throw new RuntimeException("Operation isn't correct");
        }
    }


//    public Optional<List<Operation>> findAll(User user) {
//        Optional.of(storage.getList());
//
//        return
//        //operationRepository.findAll());
//    }

    public List<Operation> findOperationsByUser(User user){
        List<Operation> operationList = storage.getList();
        List<Operation> operationListCurrentUser = operationList.stream().filter(operation -> operation.getUser().equals(user)).collect(Collectors.toList());
//        List<Operation> operationListCurrentUser = null;
//        for (Operation o : operationList) {
//            if(o.getUser().equals(user))
//                operationListCurrentUser.add(o);
        //}
        return operationListCurrentUser;
    }
}
