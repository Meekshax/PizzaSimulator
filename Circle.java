import java.awt.Graphics;
/**
 * Write a description of class Circle here.
 *
 * @author Meeksha Tyagi
 * @version 5/5/20
 */
public class Circle extends Shape
{
    //instance variables - replace the example below with your own
    //the first is the radius of the circle
    private double radius;
    //Pi math constant
    private static double PI = 3.14;
    /**
     *This is the contructor that only takes a 
     *radius in the parameter, uses shape constructor
     *for x,y coordinates and then sets radius to the
     *instance variable
     */
    public Circle(double radius)
    {
        super(1,1);
        this.radius = radius;
    }
    
    /**
     *This is the constructor that takes in an
     *x,y coordinate, uses shape constructor to set
     *x,y coordinate, set radius to 150 so it can be
     *see in the JPanel
     */
    public Circle(int x, int y)
    {
        super(x,y);
        this.radius = 150;
    }

    /**
     *This is the constructor that takes in an
     *x,y coordinates and a radius, uses shape constructor to set
     *x,y coordinate, set radius to the passed in parameter 
     */
    public Circle(int x, int y, double radius)
    {
        super(x,y);
        this.radius = radius;
    }
    
    /**
     *This returns the radius of the circle
     */
    public double getRadius()
    {
        return this.radius;
    }
    
    /**
     *This is the setter method for the
     *radius instance variable, takes in parameter a
     *double radius that is then set to the instance variable
     */
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    
    /**
     *Calculates the area of the circle using the PI*r^2 
     *formula for the area of a circle by multiplying the
     *radius by itself, times PI
     */
    public double getArea()
    {
        return (this.radius * this.radius) * this.PI;
    }
    
    /**
     *This method draws the circle using the drawOval() method,
     *I used the getter methods to set the start points and endpoints
     *of the circle, endpoints are radius*2 because the endpoint would
     *be across the diameter which is radius*2
     */
    public void draw(Graphics g)
    {
        g.drawOval(this.getX(), this.getY(), (int)this.getRadius() * 2, (int)this.getRadius() * 2); 
    }
    
    /**
     *This is the clone method for the Circle class, returns 
     *a clean copy of the circle using this classes getter methods
     */
    public Circle clone()
    {
        return new Circle(this.getX(), this.getY(), this.getRadius());
    }
    
    /**
     *toString method for circle used to get the formatting of 
     *the menu correctly
     */
    public String toString()
    {
        return "Circular";
    }
}
