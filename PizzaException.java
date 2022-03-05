
/**
 * Write a description of class PizzaException here.
 *This is the PizzaException class, this is the custom Pizza exception
 *that will be thrown anywhere a RuntimeException occurs.
 * @author Meeksha Tyagi
 * @version 6/4/2020
 */
public class PizzaException extends RuntimeException
{
    /**
     *This is the default no-arg constructor that sends out
     *a default message when an exception occurs.
     */
    public PizzaException()
    {
        super("A runtime exception has occured involving a pizza.");
    }
    
    /**
     *This is the constructor that has a custom message, the message
     *is passed into the RuntimeExceptions constructor.
     */
    public PizzaException(String e)
    {
        super(e);
    }
}
