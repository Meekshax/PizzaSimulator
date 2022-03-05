
/**
 * Write a description of class Fraction here.
 *This is the Fraction class and it is used
 *to store fractions by using the constructor or
 *the setter methods in this class. This class 
 *also has an important functionally of simplifying
 *the fraction thats passed in to the simplest form
 *before actually setting the numerator and denominator
 *of the fraction. So if 4/2 was handed this would store
 *2/1 instead.
 * @author Meeksha Tyagi
 * @version 4/13/2020
 */
public class Fraction implements Comparable
{
    private int numerator;
    private int denominator;
    /**
     *Default no arg constructor for fraction
     *sets the numerator and denominator to 1
     */
    public Fraction()
    {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     *Constructor for objects of class Fraction
     *takes two parameters. One int for the numerator
     *and one int for the denominator. These parameters
     *are set to the Fraction instance variables. This method
     *also checks for a 0 in the denominator of the fraction, as
     *a number cannot be divide by 0.
     */
    public Fraction(int newNum, int newDen)
    {
        if(newDen == 0)
        {
            throw new RuntimeException("Fractions cannot have denominator of zero.");
        }
        else if(newNum == 0)
        {
            this.numerator = newNum;
            this.denominator = newDen;
        }
        else
        {
            //to simplify the numerator and denominator I divide both values 
            //by their GCF.
            this.numerator = newNum / findGreatestCommonFac(newNum,newDen); 
            this.denominator = newDen / findGreatestCommonFac(newNum,newDen);
        }
    }

    /**
     *This is the getter method for the numerator 
     *instance variable,returns the numerator instance variable.
     */
    public int getNumerator()
    {
        return this.numerator;
    }

    /**
     *This is the setter method for the numerator
     *instance variable, takes as parameter a new
     *numerator to set as this fractions numerator
     */
    public void setNumerator(int newNum)
    {
        this.numerator = newNum;
    }

    /**
     *This is the getter method for the denominator
     *instance variable, returns the denominator instance variable.
     */
    public int getDenominator()
    {
        return this.denominator;
    }

    /**
     *This is the setter method for the denominator
     *instance variable, takes as parameter a new
     *denominator to set as this fractions denominator
     */
    public void setDenominator(int newDen)
    {
        if(newDen == 0)
        {
            throw new RuntimeException("Fractions cannot have denominator of zero.");
        }
        else
        {
            this.denominator = newDen;
        }
    }

    /**
     *This method is used to find the greatest common factor
     *between the numerator and denominator. I do this by
     *finding both numbers greatest common factor. Firstly 
     *I find the smaller number of the numerator and denominator
     *and store that number inside the integer greatestCommonFactor,
     *once this is done I try to do the modulas of the numerator
     *and denominator to see if the current GCF evenly divides into
     *the numerator and denominator, if it does not evenly divide
     *into either the numerator or denominator decrement the 
     *greastestCommonFactor by 1 so if the GCF was 12 it is now 11.
     *The process of doing the modulas of the numerator and denominator
     *by the new GCF is repeated until there is a remainder of 0 for
     *both the numerator and denominator, once this condition is met
     *the fraction cannot be further simplified and the greatestCommonFac
     *is returned
     */
    public int findGreatestCommonFac(int numerator, int denominator)
    {
        //Declare the greatestCommonFactor and initialize it to 0
        int greatestCommonFactor = 0;  
        //Finds the smaller number between the numerator and denominator
        if(numerator > denominator)
        {
            greatestCommonFactor = denominator;
        }
        else 
        {
            greatestCommonFactor = numerator;
        }       
        //The code Only doesn't make it into the loop if the numerator 
        //and denominator do not give a remainder when dividing
        if(numerator == 0)
        {
            throw new RuntimeException("Numerator cannot be zero");
            
        }
        //by the greatestCommonFactor
        while((numerator % greatestCommonFactor != 0) || 
        (denominator % greatestCommonFactor != 0))
        {
            //If either give a remainder
            //minus one from the greatestCommonFac and try to find the next GCF
            greatestCommonFactor--;
        }        
        return greatestCommonFactor;
    }
    
    
    /**
     *This is the method that turns the fraction
     *into a double value so partial area of a pizza shape
     *can get calculated
     */
    public double doubleFracValue()
    {
        return (double)(this.numerator / this.denominator);
    }

    /**
     *This is the equals method that compares this
     *fraction to the fraction being passed in for 
     *comparison in the parameter. If the numerator
     *and denominator of both fractions are the same
     *the method returns true, otherwise it returns false.
     */
    public boolean equals(Fraction other)
    {
        if(other == null)
        {
            return false;
        }
                
        if(this.getNumerator() == other.getNumerator() &&
        this.getDenominator() == other.getDenominator())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *This method returns the fraction in the form of a 
     *String formatted by "A/B" where A is the numerator
     *and B is the denominator
     */
    public String toString()
    {
        return this.getNumerator() + "/" + this.getDenominator();
    }
    
    /**
     *This is the compareTo method that is implmented in order to make
     *the setRemaining Pizza class method work, comparing the passed in
     *fraction is crucial to be able to successfully set pizza size.
     */
    public int compareTo(Object other)
    {
        if(other instanceof Fraction && other != null)
        {
            Fraction that = (Fraction)other;
            if(this.doubleFracValue() > that.doubleFracValue())
            {
                return 1;
            }
            else if(this.doubleFracValue() < that.doubleFracValue())
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
            throw new RuntimeException("Cannot compare an Object that is not of type Fraction.");
        }
    }
}
