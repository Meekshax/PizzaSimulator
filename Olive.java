import java.awt.Color;
/**
* Write a description of class Olive here.
 *This is the Olive class, it is one of the two
 *classes at the bottom of the Vegetable ingredients hierarchy,
 *Here there are actual set prices, calories, and descriptions for the
 *ingredients, and this class is not an abstract class like the parents to
 *this class.
 * @author Meeksha Tyagi
 * @version 6-4-2020
 */
public class Olive extends Vegetable
{
    //This is the instance variable for the string description of Olive,
    //didn't want to do all the work in the constructor so this was done here
    private static final String oliveDescription = "Black olives are fruits from the olive tree which are "+
    "picked when fully grown and fully ripe while the green ones are not ripe yet.";
    
    /**
     *This is the Pepper constructor that calls the Vegetable constructor which calls
     *the Ingredient constructor where the cost, calories, and description of the ingredient 
     *is set
     */
    public Olive()
    {
        super(new Money(2, 50), 160, oliveDescription, Color.BLACK); 
    } 
}
