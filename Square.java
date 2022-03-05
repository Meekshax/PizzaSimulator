import java.awt.Graphics;
/**
 * Write a description of class Square here.
 *This is an implementation of the Square shape
 *has its own getAre() and getSide() methods as getters
 *also has a draw method that draws a rectangle with
 *the dimensions of side.
 * @author Meeksha Tyagi
 * @version 6/4/2020
 */
public class Square extends Shape
{
    // instance variables - replace the example below with your own
    //side, since a square has eqqual sides only
    //one instance variable is needed
    public int side;
    
    /**
     *This is the no-arg default constructor which just
     *calls Shape constructor using super and hands 0 into
     *x and y
     */
    public Square()
    {
        super(0,0);
    }
    
    /**
     *This is the constructor that takes as parameter x and y
     *starting coordinates, again uses Shapes constructor using
     *super but this time hands x and y into the parameters.
     *Sets side to 1
     */
    public Square(int x, int y)
    {
        super(x,y);
        this.side = 1;
    }
    
    /**
     *This is the constructor that as parameters takes x y coordinates
     *as well as the side length for the square. Uses Shape constructor
     *to set xy coordinates and then just sets the side of the square.
     */
    public Square(int x, int y, int size)
    {
        super(x,y);
        this.side = side;
    }

    /**
     *This method returns the area of a square which is just the side length
     *times itself because all sides are equal.
     */
    public double getArea()
    {
        return (this.side * this.side);
    }
    
    /**
     *This method returns the value that the side private instance variable holds
     */
    public int getSide()
    {
        return this.side;
    }
    
    /**
     *This is the draw method, using Graphics a sketch of square with
     *starting xy coordinates and width and length as side.
     */
    public void draw(Graphics g)
    {
        g.drawRect(this.getX(),this.getY(),this.side,this.side);
    }
    
    /**
     *This is the clone method for the Square class, returns 
     *a clean copy of the square using this classes getter methods
     */
    public Square clone()
    {
        return new Square(this.getX(), this.getY(), this.getSide());
    }
    
    /**
     *toString method for square used to get the formatting of 
     *the menu correctly
     */
    public String toString()
    {
        return "Square";
    }
}
