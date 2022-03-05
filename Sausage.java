
/**
 * Write a description of class Sausage here.
 *This is the Sausage class, it is one of the two
 *classes at the bottom of the Meat ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Sausage extends Meat
{
    //This is the instance variable for the string description of Sausage,
    //didn't want to do all the work in the constructor so this was done here
    private static final String sausageDescription = "Sausages are a meat product usually made from ground meat, often pork, "+
    "beef, or poultry, along with salt, spices and other flavourings";
    
    /**
     *This is the Sausage constructor that calls the Meat constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Sausage()
    {
        super(new Money(2, 25), 245, sausageDescription); 
    } 
}
