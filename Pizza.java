
/**
 * Write a description of class Pizza here.
 *This is the pizza class, a lot of the work is done in this
 *class. The ingredients list for the pizza is formed here, the
 *cost of the pizza based off the number of ingredients is also determined
 *here, the cost of the pizza, its total fractional size, its Shape, and
 *its calorie count. This class also 
 * @author Meeksha Tyagi
 * @version 6/4/2020
 */
public class Pizza implements PizzaComparable
{
   //this is the private instance variable that will 
   //hold a list of all the ingredients on the pizza
   private ArrayList<Ingredient> ingredientsList;
   //this is the private instance variable that will hold
   //the total calorie count of the pizza
   private int ingredientsCalories;
   //this is the private instance variable that will hold the
   //cost of the pizza
   private Money ingredientsCost;
   //this is the private instance variable that will hold the
   //shape of the current pizza, either Circle or Square
   private Shape pizzaShape;
   //this is the private instance variable that will hold the
   //fraction remainder of how pizza is left
   private Fraction pizzaSize;
   
   public Pizza()
   {
       this.ingredientsList = new ArrayList<>();
       this.pizzaSize = new Fraction(1,1);
       int randShape = (int)(Math.random() * 2);
       int size = (int)(Math.random() * 11);
       if(randShape == 0)
       {
           this.pizzaShape = new Circle(0,0, size);
       }
       else
       {
           this.pizzaShape = new Square(0,0, size);
       }
       this.ingredientsCost = new Money(0,0);
       this.ingredientsCalories = 0;
       int randomNumOfIngredients = (int)(Math.random() * 11); // so 10 random ingredients are generated
       for(int i = 0; i < randomNumOfIngredients; i++)
       {
           //calling the add method automatically updates all the instance 
           //varaibles that need to be modified
           this.addIngredient(pickRandomIngredient());
       }
    }
   
   /**
    *This is the main method that will be used for testing
    */
   public static void main(String[] args)
   {
       //will use this to randomly generate an ingredient
       //number from 0-7, if 1 was added then it would generate
       //1-8 but I will just do 0-7 for the ingredient switch cases
       //System.out.println((int)(Math.random() * 8));
       //System.out.println((int)(Math.random() * 2));
       //System.out.println((int)(Math.random() * 2));
       //System.out.println((int)(Math.random() * 2));
       //System.out.println((int)(Math.random() * 2));
       Pizza a = new Pizza();
       Pizza b = new Pizza();
       System.out.println(a.toString());
       System.out.println(b.toString());
   }
   
   /**
    *This is the getter method for the fractional value of 
    *the remainder of the pizza
    */
   public Fraction getRemaining()
   {
       return this.pizzaSize;
   }
   
   /**
    *This is the setter method for the fractional value of 
    *the pizza, cannot be bigger than 1 and cannot be smaller
    *than 0
    */
   public void setRemaining(Fraction f)
   {
       if(f.doubleFracValue() > 0 &&
       f.doubleFracValue() < 1)
       {
           this.pizzaSize = f;
       }
       else if(f.doubleFracValue() > 1)
       {
           throw new PizzaException("Cannot set pizza size greater that 1.");
       }
       else
       {
           throw new PizzaException("Cannot set pizza size less than 0.");
       }
   }
   
   /**
    *This is the getter method for the calories, returns
    *calories private instance variable
    */
   public int getCalories()
   {
       return this.ingredientsCalories; 
   }
   
   /**
    *This is the getter method for the cost of the pizza,
    *returns the cost private instance variable
    */
   public Money getCost()
   {
       return this.ingredientsCost.clone();
   }
   
   /**
    *This is the getter method for the remaining area
    *of the pizza, multiplies the double value of the
    *fractional remainder of the pizza times the area of the
    *pizza to get the remaining area
    */
   public double getRemainingArea()
   {
       return this.pizzaSize.doubleFracValue() * this.pizzaShape.getArea();
   }
   
   /**
    *this is the provided setShape method that has to
    *be implemented
    */
   public void setShape(Shape s) 
   { 
       this.pizzaShape = (Shape)(s.clone());
   }
   
   /**
    *This is the provided getShape method that has to be
    *implemented
    */
   public Shape getShape() 
   { 
       return this.pizzaShape.clone();    
   }
   
   /**
    *This is the addIngredient method that adds an ingredient
    *to the ingredient list and also adjusts the cost and calorie
    *count of the pizza accordingly
    */
   public void addIngredient(Ingredient a)
   {
       if( a != null)
       {
           this.ingredientsList.add(a);
           this.ingredientsCalories += a.getCalories();
           this.ingredientsCost.add(a.getCost());
       }
       else
       {
           throw new PizzaException("Cannot add an ingredient that is null to the ingredient list.");
       }
   }
   
   /**
    *This method will subtract amt from the remaining
    *pizza fraction, if the size of the pizza afterwards is
    *0 an exception is thrown to show the pizza remainder is now 0,
    *and this method will also throw exceptions where necessary like
    *when the amt is greater than the remaining fraction of pizza, an 
    *exception is thrown.
    */
   public void eatSomePizza(Fraction amt)
   {
       if(amt.getNumerator() > 0)
       {
           if(this.pizzaSize.getNumerator() == 0)
           {
               throw new PizzaException("Cannot subtract from a pizza that has size 0.");
           }
           //need to make the two fractions equivalent so
           //subtraction can take place
           int currentNum = this.pizzaSize.getNumerator() * amt.getDenominator();
           int otherNum = amt.getNumerator() * this.pizzaSize.getDenominator();
           int currentDenominator = this.pizzaSize.getDenominator() * amt.getDenominator();
           //now that they're equivalent numerators subtract
           if(currentNum - otherNum >= 0)
           {
               int remainingNum = currentNum - otherNum;
               this.pizzaSize = new Fraction(remainingNum, currentDenominator);               
           }
           else if(currentNum - otherNum < 0)
           {
               throw new PizzaException("Cannot subtract a fractional amount bigger than the current pizza size.");
           }
           
           if(this.pizzaSize.getNumerator() == 0)
           {
               throw new PizzaException("The pizza's size is 0, the pizza has been eaten.");
           }
       }
       else
       {
           throw new PizzaException("Cannot subtract a negative amount of pizza.");
       }
   }
   
   /**
    *Displays the cost, calorie count, ingredients, and fraction of 
    *pizza remaining
    */
   public String toString()
   {
       String ingredients = "";
       for(int i = 0; i < this.ingredientsList.size(); i++)
       {
           ingredients += this.ingredientsList.get(i) +"\n";
       }
       return "Cost: " + this.ingredientsCost + " Calories: " + this.ingredientsCalories
       + "\nSize: " + this.getRemainingArea() + "\nIngredients List:\n" + ingredients;
   }
   
   /**
    *This is the compareTo method that compares two pizzas by their
    *price as stated in the instructions
    */
   public int compareTo(Object other)
   {
       if(other instanceof Pizza && other != null)
       {
           Pizza that = (Pizza)other;
           return this.ingredientsCost.compareTo(that.ingredientsCost);
       }
       else
       {
           throw new PizzaException("Cannot compare this pizza object to an object not of type Pizza.");
       }
   }
   
   /**
    *This is the compareTo method that compares two pizzas by their
    *size, the second of three compareTo methods.
    */
   public int compareToBySize(Object other)
   {
       if(other instanceof Pizza && other != null)
       {
           Pizza that = (Pizza)other;
           if(this.getRemainingArea() > that.getRemainingArea())
           {
               return 1;
           }
           else if(this.getRemainingArea() < that.getRemainingArea())
           {
               return -1;
           }
           else
           {
               return 0;
           }
       }
       else
       {
           throw new PizzaException("Cannot compare this pizza object to an object not of type Pizza.");
       }
   }
   
   /**
    *This is the compareTo method that compares two Pizzas based of
    *their total calorie count.
    */
   public int compareToByCalories(Object other)
   {
       if(other instanceof Pizza && other != null)
       {
           Pizza that = (Pizza)other;
           if(this.ingredientsCalories > that.ingredientsCalories)
           {
               return 1;
           }
           else if(this.ingredientsCalories < that.ingredientsCalories)
           {
               return -1;
           }
           else
           {
               return 0;
           }
       }
       else
       {
           throw new PizzaException("Cannot compare this pizza object to an object not of type Pizza.");
       }
   }
   
   /**
    *To be able to randomly generate pizzas a method that chooses
    *a random ingredient from the list of ingredients has to be created
    *this method chooses a random ingredient to be put on a pizza
    */
   public Ingredient pickRandomIngredient()
   {
       //like earlier in the main method I will use
       // Math.random * 8 here
       Ingredient randomChosenIngredient = null;
       int choice = (int)(Math.random() * 8);
       switch(choice)
       {
           case 0:
            randomChosenIngredient = new Mozzarella();
            break;
           case 1:
            randomChosenIngredient = new Goat();
            break;
           case 2:
            randomChosenIngredient = new Pepperoni();
            break;
           case 3:
            randomChosenIngredient = new Sausage();
            break;
           case 4: 
            randomChosenIngredient = new Marinara();
            break;
           case 5:
            randomChosenIngredient = new Alfredo();
            break;
           case 6:
            randomChosenIngredient = new Pepper();
            break;
           case 7:
            randomChosenIngredient = new Olive();
            break;
        }
        return randomChosenIngredient;       
   }
}
