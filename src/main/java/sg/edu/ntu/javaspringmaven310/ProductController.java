package sg.edu.ntu.javaspringmaven310;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ArrayList<Products> products = new ArrayList<>();
    private Logger logger;

    @PostMapping("/")
    public ResponseEntity<Products> createProducts(@RequestBody Products product){
        logger.info("Create Products");
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);

    }
    @GetMapping("/")
    public ResponseEntity <ArrayList<Products>> getAllProducts(){
        logger.info("Get All Products");
        return new ResponseEntity<>(products, HttpStatus.FOUND);
    }

    public int getProductIndex(String id){
        for (Products product : products ){
            if (product.getProductId().equals(id)){
                return products.indexOf(product);
            }
        }
        return -1;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> GetProductsById(@PathVariable String id){
        logger.info("Get products by Id");
        int index = getProductIndex(id);
        return new ResponseEntity<>(products.get(index), HttpStatus.FOUND);
        
    }
    
}
