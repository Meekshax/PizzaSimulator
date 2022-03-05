
/**
 * Write a description of class Mozzarella here.
 *This is the Mozzarella class, it is one of the two
 *classes at the bottom of the cheese ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Mozzarella extends Cheese
{
    //This is the instance variable for the string description of Mozzarella cheese,
    //didn't want to do all the work in the constructor so this was done here
    private static final String mozzarellaDescription = "The white gold of Italy, Mozzarella hails from Campania near " +
    "the Gulf of Naples. Beneath hillsides and the resting Mount Vesuvius, milk from the Mediterranean " +
    "buffalo produced a rich cheese that soon became a favorite among those who tried it";
    
    /**
     *This is the Mozzarella constructor that calls the Cheese constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Mozzarella()
    {
        super(new Money(2, 0), 220, mozzarellaDescription); 
    }
}
