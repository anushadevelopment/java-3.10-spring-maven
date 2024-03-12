package sg.edu.ntu.javaspringmaven310;

public class CustomerNotFoundException extends RuntimeException{
    CustomerNotFoundException(String id){
        super("Could not find customer with id "+id);

    }

    
}
