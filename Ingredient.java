
/**
 * Write a description of class Ingredient here.
 *This is the ingredient superclass that all other
 *ingredients will extend. This class is Comparable based
 *off the price of the toppings and sauces. 
 * @author Meeksha Tyagi
 * @version 6-3-2020
 */
public abstract class Ingredient implements Comparable
{
    // instance variables - replace the example below with your own
    //this is the cost Money instance variable, will be used to keep
    //track of the ingredient cost
    private Money cost;
    //this is the calories integer instance variable that will keep track
    //of the toppings calorie count
    private int calories;
    //This is the description String instance variable that will describe 
    //the topping currently being stored and added.
    private String description;

    /**
     *This is the Ingredient constructor, takes in a Money object for the
     *cost of the ingredient, an int that represents the calorie count of
     *the ingredient, and a String that will be the description of the ingredient
     */
    public Ingredient(Money newCost, int newCalories, String newDescription)
    {
        setIngredientCost(newCost);
        setIngredientCalories(newCalories);
        setIngredientDescription(newDescription);
    }

    /**
     *This is the setter method for the cost of the ingredient, this
     *method first checks if the Money object being passed in is null,
     *if its not null then just set the cost instance variable to a clone
     *of the Money object in the parameter, otherwise throw a PizzaException
     *that reports a null object cannot be set to cost
     */
    public void setIngredientCost(Money newCost)
    {
        if(newCost != null)
        {
            this.cost = newCost.clone();
        }
        else
        {
            throw new PizzaException("Cannot set cost value with a null Money object.");
        }
    }
    
    /**
     *This is the setter method for the calories of the ingredient, first
     *checks if the calories being passed in the parameter are less that 0, 
     *if the calorie count is not less than 0 just set the calories instance
     *variable to the passed in calorie value, otherwise throw a PizzaException
     *that states a negative calorie value cannot be set to calories.
     */
    public void setIngredientCalories(int newCalories)
    {
        if(newCalories > 0)
        {
            this.calories = newCalories;
        }
        else
        {
            throw new PizzaException("Cannot set a negative value for calories.");
        }
    }
    
    /**
     *This is the setter method for the description of the ingredient, first checks
     *if the description being passed in is null and then also checks if the length
     *of the description is 0, if this all passes then just set the description instance
     *variable to the description being passed in. Otherwise throw a PizzaException that
     *reports the passed in string is either null or empty.
     */
    public void setIngredientDescription(String newDescription)
    {
        if(newDescription != null && newDescription.length() != 0)
        {
            this.description = newDescription;
        }
        else
        {
            throw new RuntimeException("Cannot set a null or empty string.");
        }
    }
    
    /**
     *This is just a helper method to avoid privacy leaks in the
     *comparison methods, returns a clean copy of the cost of
     *the ingredient
     */
    public Money getCost()
    {
        return this.cost.clone();
    }
    
    /**
     *This is the getter method for the calories private instance
     *variable
     */
    public int getCalories()
    {
        return this.calories;
    }
    
    /**
     *This is the getter for the description private instance variable
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     *This is the compareTo method, first there is a check to
     *see if the object is of type ingredient and also if its not
     *null, if the checks pass then the cost of both ingredients are
     *compared and returned. Otherwise throw an exception that says Ingredients
     *cannot be compared to objects not of type ingredient.
     */
    public int compareTo(Object other)
    {
        if(other instanceof Ingredient && other != null)
        {
            Ingredient that = (Ingredient)other;
            return this.cost.compareTo(that.getCost());
        }
        else
        {
            throw new PizzaException("Cannot compare this Ingredient object to other types of objects.");
        }
    }
    
    /**
     *This is the toString method that returns the description, cost
     *, and calorie count of the ingredient in one string
     */
    public String toString()
    {
        return "Description: " + this.description + " Cost: " + this.cost.toString()
        + " Calories: " + this.calories;
    }
    
    /**
     *This is the equals method that checks if the instance variables of 
     *the ingredients are equal, before that there is a check to see if the Object
     *in the parameter is of type Ingredient as well as if its not null, if these
     *conditions are met then a comparison is returned comparing the costs, calories, and
     *description of both ingredients, returning either true or false. Otherwise this 
     *method throws an exception stating a comparison cannot be made with this Ingredient
     *and another type of object.
     */
    public boolean equals(Object other)
    {
        if(other instanceof Ingredient && other != null)
        {
            Ingredient that = (Ingredient)other;
            return this.cost.equals(that.getCost()) && this.calories == that.calories
            && this.description.equals(that.description);
        }
        else
        {
            throw new PizzaException("Cannot compare this Ingredient object to other types of objects.");
        }
    }
}
