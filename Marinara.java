
/**
 * Write a description of class Marinara here.
 *This is the Marinara class, it is one of the two
 *classes at the bottom of the Base ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Marinara extends Base
{
    //This is the instance variable for the string description of Marinara,
    //didn't want to do all the work in the constructor so this was done here
    private static final String marinaraDescription = "Marinara sauce is a tomato sauce "+ 
    "usually made with tomatoes, garlic, herbs, and onions";
    
    /**
     *This is the Marinara constructor that calls the Base constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Marinara()
    {
        super(new Money(2, 0), 150, marinaraDescription); 
    } 
}
