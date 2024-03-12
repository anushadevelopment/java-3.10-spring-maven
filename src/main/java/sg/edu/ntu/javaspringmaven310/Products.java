package sg.edu.ntu.javaspringmaven310;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products {
private final String productId;
private String productName;
private double price;
private String desc;


public Products(){
    this.productId = UUID.randomUUID().toString();
}

    
}
