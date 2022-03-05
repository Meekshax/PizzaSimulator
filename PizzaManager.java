import java.util.Scanner;
/**
 * Write a description of class PizzaManager here.
 *This is the PizzaManager class that does all of the fun
 *stuff with the pizzas. This method firstly can perform eating
 *a pizza, it can sort all the pizzas either by price, size, and calories.
 *Then there is also the binarySearch method that finds a calorie by doing
 *the conquer and divide binarySearch algorithm on all the pizzas in the list
 * @author Meeksha Tyagi
 * @version 6-5-2020
 */
public class PizzaManager
{
    //this is the pizzaList private instance variable that will store
    //all the pizzas that will be getting sorted, eaten, and having binarySearch
    //done on them
    private ArrayList<Pizza> pizzaList;

    /**
     *This the no-arg constructor that just creates a new
     *arraylist of pizzas, the list is currently empty
     */
    public PizzaManager()
    {
        this.pizzaList = new ArrayList<>();
    }

    public static void main(String[] args)
    {
        PizzaManager a = new PizzaManager();
        //a.pizzaList.add(new Pizza());
        a.displayMenu();
    }
    
    /**
     *This will display the menu with the choices of eating a pizza
     *, sorting a pizza by price,size, and calories, and doing a binary
     *search for a target calorie. All these methods require the use of a lot
     *of methods from the Pizza class.
     */
    public void displayMenu()
    {
        Scanner input = new Scanner(System.in);
        //seems like a switch case would be extremely helpful here
        //will create infinite while loop so menu keeps popping up if a
        //invalid choice is chosen by the user
        while(true)
        {
            this.displayAllPizzas();
            System.out.println("-----------------------");
            System.out.println("Welcome to PizzaManager");
            System.out.println("-----------------------");
            System.out.println("(A)dd a random pizza");
            System.out.println("Add a (H)undred random pizzas");
            System.out.println("(E)at a fraction of a pizza");
            System.out.println("Sort pizzas by (P)rice");
            System.out.println("Sort pizzas by (S)ize");
            System.out.println("Sort pizzas by (C)alories");
            System.out.println("(B)inary Search pizzas by calories");
            System.out.println("(Q)uit");
            String userChoice = input.next();     
            char menuChoice = userChoice.substring(0,1).toUpperCase().charAt(0);
            System.out.println(menuChoice);
            switch(menuChoice)
            {
                case 'A':                 
                  System.out.println("Adding a random pizza to the ArrayList.");
                  this.addPizza();
                  break;
                case 'H':
                  System.out.println("Adding one hundred random pizzas to the ArrayList.");
                  this.addHundredPizzas();
                  break;
                case 'E':                  
                  this.eatSomePizza(input);
                  break;
                case 'P':
                  this.sortByPrice();
                  break;
                case 'S':
                  this.sortBySize();
                  break;
                case 'C':
                  this.sortByCalories();
                  break;
                case 'B':
                   System.out.println("A binary search by calories will be performed.");
                   this.sortByCalories();
                   System.out.println("Enter a desired calorie count:");
                   int userGivenCalories = input.nextInt();                   
                   int indexOfUserGivenCalories = binarySearchByCalories(userGivenCalories);
                   if(indexOfUserGivenCalories != -1)
                   {
                       System.out.println("The pizza with these calories is at index " + indexOfUserGivenCalories);                       
                   }
                   else
                   {
                       System.out.println("Cannot find a pizza with the given calories.");
                   }
                  break;
                case 'Q':
                  System.out.println("The program will now exit.");
                  System.exit(0);
                  break;
                  
                default:
                  System.out.println("Your choice does not match any of the options.");                
            }
        }

    } 
           
    /**
     *This is the insertion sort, it checks the calories of the two
     *pizza objects that are being compared. The insertion sort iterates through the
     *list of pizzas by checking one element at each method repetition, and creating a
     *partition of the list that is sorted and will not be checked. Continues to sort
     *the unsorted part of the list until it is fully sorted.
     */
    public void sortByCalories()
    {
        for(int i = 1; i < this.pizzaList.size(); i++)
        {
            Pizza itemToSort = this.pizzaList.get(i);
            int j = i;
            while(j > 0 && this.pizzaList.get(j - 1).getCalories() < itemToSort.getCalories())
            {
                this.pizzaList.put(this.pizzaList.get(j - 1), j);
                j--;
            }
            this.pizzaList.put(itemToSort, j);
        }
    }
    
    /**
     *This is the implementation of the selection sort, finds the largest index
     *and moves it to the front of the list, doesn't look at the sorted partition
     *of the listand only sorts the remaining unsorted pizzas by the price of the 
     *pizzas
     */
    public void sortByPrice()
    {
        for(int i = 0; i < this.pizzaList.size(); i++)
        {
            int largestIndex = i;
            for(int j = i; j < this.pizzaList.size(); j++)
            {
                if(this.pizzaList.get(largestIndex).
                compareTo(this.pizzaList.get(j)) < 0)
                {
                    largestIndex = j;
                }
            }
            Pizza pizzaToSwap = this.pizzaList.put(this.pizzaList.get(largestIndex), i);
            this.pizzaList.put(pizzaToSwap, largestIndex);
        }
    }
    
    /**
     *This is the insertion sort, it checks the sizes of the two
     *pizza objects that are being compared. The insertion sort iterates through the
     *list of pizzas by checking one element at each method repetition, and creating a
     *partition of the list that is sorted and will not be checked. Continues to sort
     *the unsorted part of the list until it is fully sorted.
     */
    public void sortBySize()
    {
        for(int i = 1; i < this.pizzaList.size(); i++)
        {
            Pizza itemToSort = this.pizzaList.get(i);
            int j = i;
            while(j > 0 && this.pizzaList.get(j - 1).getRemainingArea()
            < itemToSort.getRemainingArea())
            {
                this.pizzaList.put(this.pizzaList.get(j - 1), j);
                j--;
            }
            this.pizzaList.put(itemToSort, j);
        }
    }
    
    /**
     *This is the implmentation of the binary search by calories, uses
     *the divide and conquer method, checks middle index and if the calories at the
     *middle index are bigger than that of the targetCalories set start to middle + 1
     *because the list is in descending order. If the calories at the middle pizza are
     *smaller than the target calories then set start to middle + 1 because the list is
     *in descending order.
     */
    public int binarySearchByCalories(int targetCal)
    {
        if(this.pizzaList.size() != 0 && this.pizzaList.size() > 1)
        {
            int start = 0;
            int end = this.pizzaList.size() - 1;
            while(start <= end)
            {
                int middle = (start + end) / 2;
                if(targetCal == this.pizzaList.get(middle).getCalories())
                {
                    return middle;
                }
                else if(targetCal > this.pizzaList.get(middle).getCalories())
                {
                    end = middle - 1;
                }
                else
                {
                    start = middle + 1;
                }
            }
            return -1;
        }
        else
        {
            if(this.pizzaList.size() == 1)
            {
                if(this.pizzaList.get(0).getCalories() == targetCal)
                {
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
            else 
            {
                return -1;
            }            
        }
    }
    
    /**
     *This is like the addPizza method but it
     *adds 100 pizzas with the use of a for loop
     */
    public void addHundredPizzas()
    {
        for(int i = 0; i < 100; i++)
        {
            this.pizzaList.add(new Pizza());
        }
    }
    
    /**
     *Adds one random pizza to list of pizzas
     */
    public void addPizza()
    {
        this.pizzaList.add(new Pizza());
    }
    
    /**
     *This is the eatSomePizza method that takes user input for the fraction of pizza
     *that will be eaten and then index of the pizza to eat from. I parse the fraction
     *into a string array where the 0th index is the numerator and the 1st index is the
     *denominator. Finds the pizza at the given index and then tries to eat some pizza
     *by using the pizza eatSomePizza method. This method also tries to catch an exception
     *that states the pizza has been fully eaten so the pizza can be removed from the arraylist
     *if the right exception is thrown that means the double value of the fraction will be 0,
     *then the pizza is removed from the list of pizzas.
     */
    public void eatSomePizza(Scanner keys)
    {
        if(this.pizzaList.size() > 0)
        {
            System.out.println("Eating a fraction of a pizza. How much? (a/b)");
            String[] fraction = keys.next().split("/");
            int num = Integer.parseInt(fraction[0]);
            int den = Integer.parseInt(fraction[1]);
            Fraction amt = new Fraction(num,den);
            System.out.println("At which index?");
            String indexOfPizzaToEat = keys.next();
            int intIndexOfPizzaToEat = Integer.parseInt(indexOfPizzaToEat);
            Pizza pizzaAtIndex = this.pizzaList.get(intIndexOfPizzaToEat);
            try
            {
                pizzaAtIndex.eatSomePizza(amt);
            }
            catch(PizzaException exception)
            {
                if(pizzaAtIndex.getRemaining().doubleFracValue() != 0)
                {
                    System.out.println("The wrong kind of exception was caught, the pizza still has slices.");
                }
                else
                {
                    this.pizzaList.remove(intIndexOfPizzaToEat);
                }
            }
        }
    }
    
    /**
     *This method displays information about each pizza exactly
     *how the sample output does on the assignment page.
     */
    public void displayAllPizzas()
    {
        for(int i = 0; i < this.pizzaList.size(); i++)
        {
            Pizza currentPizza = this.pizzaList.get(i);
            System.out.println("Pizza has a price:"+ currentPizza.getCost()+ " and"+
            " calories:" + currentPizza.getCalories() + ", Fraction remaining:" + 
            currentPizza.getRemaining().toString() + " and area left:" + currentPizza.getRemainingArea()
            + " and shape:" + currentPizza.getShape().toString());            
        }
    }
}
