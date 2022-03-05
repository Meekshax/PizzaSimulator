
/**
 * Write a description of class Pepperoni here.
 *This is the Pepperoni class, it is one of the two
 *classes at the bottom of the Meat ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Pepperoni extends Meat
{
    //This is the instance variable for the string description of Pepperoni,
    //didn't want to do all the work in the constructor so this was done here
    private static final String pepperoniDescription = "Pepperoni is an American variety of salami, made from a cured "+ 
    "mixture of pork and beef seasoned with paprika or other chili pepper.";
    
    /**
     *This is the Pepperoni constructor that calls the Meat constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Pepperoni()
    {
        super(new Money(2, 25), 195, pepperoniDescription); 
    } 
}
