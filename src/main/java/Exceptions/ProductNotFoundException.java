package Exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String s) {
        super(s);
    }
}
