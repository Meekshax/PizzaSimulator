import java.lang.*;
import java.io.Serializable;
/**
 * Write a description of class Money here.
 *This is the Money class that is a representation
 *of the American Dollar currency, contains a dollar
 *int value and a cent int value as private instance
 *variables. This class avoids privacy leaks by using 
 *setter methods in most instances. This class can add
 *money as well as set different values to this money
 *object, being able to change it at any time. Also 
 *this class has an important equals method that compares
 *the currently stored money to another money object to 
 *see if the same amount is in each money object.
 * @author Meeksha Tyagi
 * @version 4/27/2020
 */
public class Money implements Comparable, Cloneable, Serializable
{
    //this is the cents private instance
    //variable that will store the cent value
    //of this money object
    private int cents;
    //this is the dollars private instance
    //varaible that will store the dollar value
    //of this money object
    private int dollars;
    
    /**
     *This is the default no arg constructor
     *sets both the cents and dollars to 0
     */
    public Money()
    {
        this.cents = 0;
        this.dollars = 0;
    }
    
    /**
     *This is the second constructor that
     *takes in parameter dollars and cents
     *to be set to the private instance
     *variables, this is done using setters
     *to avoid privacy leaks
     */
    public Money(int dol, int cents)
    {
        this.setDollars(dol);
        this.setCents(cents);        
    }
    
    /**
     *This is the third constructor and its
     *the copy constructor that takes in parameter
     *another money object, this first checks if
     *the passed in object is null, if it check I
     *report to the console, otherwise I use
     *this money objects setters and the other 
     *objects getter to set the dollars and cents
     *values to avoid privacy leaks
     */
    public Money(Money other)
    {
        //checks for null
        if(other == null)
        {
            //trying to stay within 80 characters
            System.out.println("Cannot pass a null object into this " 
            + "constructor");           
        }
        //if not null, set the value
        else
        {
            this.setMoney(other.getDollars(),other.getCents());
        }
    }
    
    /**
     *This is the getter method for
     *the cents instance variable, no 
     *need to create a new deep copy as it 
     *is a primitive, returns cents
     */
    public int getCents()
    {
        return this.cents;
    }
    
    /**
     *This is the getter method for
     *the dollars instance variable, just
     *returns the integer
     */
    public int getDollars()
    {
        return this.dollars;
    }
    
    /**
     *This is the getter method for double
     *value of the Money object, this menas
     *if there are 50 dollars and 50 cents,
     *the returned double will contain 50.5
     */
    public double getMoney()
    {
        //divide cents by 100 since in terms of dollars a cent is
        //1/100 of a dollar, this will store the cents in the decimal
        return (double)this.getDollars() + ((double)this.getCents()/100);
    }
    
    /**
     *This is the setter method for the cents
     *instance variable, taking an int cents 
     *parameter. Firstly the method checks if
     *cents are within the accepted range
     *(Class invariant), If it isn't within the
     *range this method will print a message to the
     *console, otherwise set the value
     */
    public void setCents(int cents)
    {
        if(cents < 0 || cents > 99)
        {
            throw new RuntimeException("Cannot have negative or values over 100 for cents.");
        }
        else
        {
            this.cents = cents;
        }
    }
    
    /**
     *This is the setter method for the dollars
     *instance variable, taking an int dol parameter.
     *Like the cents setter method, this method checks
     *to see if a negative dollar value has been passed
     *in, if it has been passed then report a error message
     *to the console, if the value is positive just set the
     *dol to dollars
     *
     */
    public void setDollars(int dol)
    {
        if(dol < 0)
        {
            throw new RuntimeException("Cannot have a negative dollar value.");
        }
        else
        {
            this.dollars = dol;
        }
    }
    
    /**
     *This is the setter for both cents and dollars
     *as this method takes in parameter both dollar values
     *and cents. This method only calls on setter method since
     *all the logic for setting these values is within the
     *other setter methods
     */
    public void setMoney(int dol, int cents)
    {
        this.setCents(cents);
        this.setDollars(dol);
    }
    
    /**
     *this add method takes in parameter an integer
     *represnting how many dollars will be added to the
     *total dollar value. If the int dol is less then 0,
     *this method doesn't add a negative number to the total.
     *Otherwise just sets the new total dollars to the 
     *dollars instance variable by using the setter method
     *for dollars.
     */
    public void add(int dol)
    {
        if(dol < 0)
        {
            throw new RuntimeException("Cannot add negative dollar value to money.");
        }
        else
        {
            this.setDollars(this.getDollars()+dol);
        }
    }
    
    /**
     *This is the second add method that
     *takes both a dollar and cent value in
     *the parameter. For dollars I use the
     *previous add method since it deals with
     *dollars and I dont want to rewrite code.
     *For cents I check first if the cents are
     *within the range they can be in (0-99) and
     *then I check to see if adding this cent value
     *is going to push the cents over 99, if it 
     *does then I increment dollars by 1 and minus 100
     *from the total cents. If adding the cents doesn't
     *push the cents total over 99 I just add the current
     *cent value to the passed in cent value and set that
     *as the new cents.
     */
    public void add(int dol, int cents)
    {
        this.add(dol);
        if(cents < 0)
        {
            throw new RuntimeException("Cannot add a negative value to cents.");
        }
        else if((this.getCents() + cents) > 99)
        {
            //System.out.println("Cents went over 99, a dollar has been added");
            this.add(1);
            this.setCents((this.getCents() + cents) - 100);
        }
        else
        {
            this.setCents(this.getCents() + cents);
        }       
    }
    
    /**
     *This is the third add method that takes in
     *parameter a Money object. If the object is
     *null report to the console, otherwise I 
     *use the second add method and pass into the
     *parameter the dollar and cent value of this
     *Money object through getter methods
     */
    public void add(Money other)
    {
        add(other.getDollars(),other.getCents());
    }
    
    /**
     *This method compares this current Money
     *object to another Objecy, first this method
     *makes sure the object is not null, then it checks
     *if the Object is of the type Money. Then compares 
     *the dollars and cents of these to Money objects, returning
     *true if they match, and false if they do not equal
     */
    public boolean equals(Object o)
    {
        if(o == null)
        {
            //System.out.println("Cannot compare this Money object to a null object");
            return false;
        }
        else if(o instanceof Money)
        {
            Money other = (Money)o;
            if(this.getDollars() == other.getDollars() && this.getCents() == other.getCents())
            {
                return true;
            }
            else
            {
                return false;
            }            
        }
        else
        {
            //System.out.println("Cannot compare this Money object to other types of objects");            
            return false;
        }
        
    }
    
    /**
     *This is the toString method that returns
     *a String form of the money in this object,
     *with a $ in front and 2 decimal places.
     *String.format came in handy for getting the
     *two decimal points.
     */
    public String toString()
    {
       return "$" + String.format("%.2f", this.getMoney()); 
    }
    
    /**
     *This method is the compareTo method that has to be
     *implemented when the Comparable interface is implemented
     *if the object being passed in is not a Money object, this
     *method calls the compareTo method on this Money object, 
     *which will result in a result of 0, couldn't think of other
     *solution to the object not being of instance money. Otherwise
     *1 is returned when the current object is bigger, -1 is returned
     *when the other Money object is bigger then the current money object
     *and 0 when they're equal.
     */
    public int compareTo(Object o)
    {
        if(o instanceof Money && o != null)
        {
            Money other = (Money)o;
            if(this.getDollars() > other.getDollars())
            {
                return 1;
            }
            else if(this.getDollars() == other.getDollars())
            {
                if(this.getCents() > other.getCents())
                {
                    return 1;
                }
                else if(this.getCents() < other.getCents())
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
                return -1;
            }
        }
        else
        {
            throw new RuntimeException("Cannot compare an Object that is not of type Money.");
        }
    }
    
    /**
     *this clone method returns a new Money object that
     *uses the copy constructor with this being passed into
     *the parameter
     */
    @Override
    public Money clone()
    {
        return new Money(this.dollars,this.cents);
    }
}
