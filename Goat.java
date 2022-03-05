
/**
 * Write a description of class Goat here.
 *This is the Goat class, it is one of the two
 *classes at the bottom of the cheese ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Goat extends Cheese
{
    //This is the instance variable for the string description of Goat cheese,
    //didn't want to do all the work in the constructor so this was done here
    private static final String goatDescription = "Goat cheese, goats' cheese, or chèvre, is cheese made from goat's milk";
    
    /**
     *This is the Goat constructor that calls the Cheese constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Goat()
    {
        super(new Money(3, 0), 265, goatDescription); 
    }  
}
