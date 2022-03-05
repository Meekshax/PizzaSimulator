import java.awt.Color;
/**
 * Write a description of class Vegetable here.
 *This is the Vegetable class, it is one of the four
 *types of Ingredients, so this class is still not 
 *the bottom of the ingredient hierarchy. There will be
 *two types of vegetables, Pepper and Olive. ADditionally these
 *store a color unlike the rest of the ingredients.
 * @author Meeksha Tyagi
 * @version 6-3-2020
 */
public class Vegetable extends Ingredient
{
    Color color;
    /**
     *This is the constructor that takes in a cost, calories, and a description
     *and sets it to the instance variables defined in the Ingredients superclass
     *using the super function
     */
    public Vegetable(Money newCost, int newCalories, String newDescription)
    {
        super(newCost, newCalories, newDescription);
    } 
    
    /**
     *This is like the previous constructor as it sets the cost, cals, and description
     *of this ingredient as well as the Color of the vegetable as well. If the color is
     *null then an exception is thrown, otherwise the color is set.
     */
    public Vegetable(Money newCost, int newCalories, String newDescription, Color c)
    {
        super(newCost, newCalories, newDescription);
        if(c != null)
        {
            this.color = c;
        }
        else
        {
            throw new PizzaException("Cannot set a null Color to the color instance variable");
        }
    }  
    
    /**
     *This is the setter method for the color instance variable, if the Color object thats
     *being passed in is null then throws an exception. If its not null then set the color
     */
    public void setColor(Color c)
    {
        if(c != null)
        {
            this.color = c;
        }
        else
        {
            throw new PizzaException("Cannot compare this Color object to a null object.");
        }
    }
    
    /**
     *This is the getter method for the color instance variable, just
     *directly returns the color object
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     *This is the toString() method of the vegetable, uses the toString()
     *method of the ingredient class to reduce redundancy, with the color 
     *added on at the end of the description.
     */
    public String toString()
    {
        return super.toString() + " Color: " + this.color;
    }
    
    /**
     *This is the equals method, first there is a check to see if the object being
     *passed in and instance of Vegetable as well as if the object is null. If it 
     *passes those conditions then use the ingredients equals method as well as
     *comparing the colors of the two vegetable objects. If the object does happen to
     *be null or not of type Vegetable an exception is thrown
     */
    public boolean equals(Object other)
    {
        if(other instanceof Vegetable && other != null)
        {
            Vegetable that = (Vegetable)other;
            return super.equals(that) && this.color == that.color;
        }
        else
        {
            throw new PizzaException("Cannot compare this Vegetable object to other types of objects.");
        }
    }
}
