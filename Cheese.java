
/**
 * Write a description of class Cheese here.
 *This is the Cheese class, it is one of the four
 *types of Ingredients, so this class is still not 
 *the bottom of the ingredient hierarchy. There will be
 *two types of cheese, Mozzarella and Goat cheese.
 * @author Meeksha Tyagi
 * @version 6-3-2020
 */
public abstract class Cheese extends Ingredient
{

    /**
     *This is the constructor that takes in a cost, calories, and a description
     *and sets it to the instance variables defined in the Ingredients superclass
     *using the super function
     */
    public Cheese(Money newCost, int newCalories, String newDescription)
    {
        super(newCost, newCalories, newDescription);
    }

}
