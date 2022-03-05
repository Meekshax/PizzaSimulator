
/**
 * Write a description of class Alfredo here.
 *This is the Alfredo class, it is one of the two
 *classes at the bottom of the Base ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Alfredo extends Base
{
    //This is the instance variable for the string description of Alfredo,
    //didn't want to do all the work in the constructor so this was done here
    private static final String alfredoDescription = "Fettuccine Alfredo or fettuccine al burro is an Italian "+
    "pasta dish of fresh fettuccine tossed with butter and Parmesan cheese";
    
    /**
     *This is the Alfredo constructor that calls the Base constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Alfredo()
    {
        super(new Money(3, 25), 220, alfredoDescription); 
    } 
}
