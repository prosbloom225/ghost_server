package main.java.rengine.exception;

/**
 * Created by prosbloom on 11/7/17.
 */
// TODO - need to actually implement custom exceptions and not just return nulls
public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String name) {
        super(name);
    }
}
