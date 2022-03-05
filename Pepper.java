import java.awt.Color;
/**
* Write a description of class Pepper here.
 *This is the Pepper class, it is one of the two
 *classes at the bottom of the Vegetable ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Pepper extends Vegetable
{
    //This is the instance variable for the string description of Pepper,
    //didn't want to do all the work in the constructor so this was done here
    private static final String pepperDescription = "The banana pepper is a medium-sized member "+
    "of the chili pepper family that has a mild, tangy taste";
    
    /**
     *This is the Pepper constructor that calls the Vegetable constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Pepper()
    {
        super(new Money(3, 50), 140, pepperDescription, Color.YELLOW); 
    } 
}
