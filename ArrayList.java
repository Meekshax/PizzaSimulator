
/**
 * Write a description of class ArrayList here.
 *This is the ArrayList ADT implementation. An
 *ArrayList, unlike a stack and a queue is random
 *access. This means that the user or the programmer
 *picks the index of where things are inserted and 
 *removed rather then following the LIFO or FIFO 
 *structure.
 * @author Meeksha Tyagi
 * @version 4/20/20
 */
public class ArrayList<T>
{
    //private instance variable array that
    //will mimic the behaviour of an arraylist
    private Object[] arrayList = new Object[100];
    //private instance varialbe int that will
    //keep track of the count of objects in
    //the arraylist
    private int count;    

    /**
     *This is the no argument constructor
     *sets count to 0
     */
    public ArrayList()
    {
        this.count = 0;
    }
    
    public static void main(String[] args)
    {
        ArrayList<Object> a = new ArrayList<>();
        a.add(5);
        a.add(3);
        System.out.println(a.toString());
    }

    /**
     *This method takes in the parameter
     *an object to insert and an index of
     *where the item will be inserted into
     *The object is then placed into the index
     *once the item and the index and all the items
     *after it are moved 1 cell to the right. Count
     *is then incremented.
     */
    public void insert(T item, int index)
    {
        this.count++;
        //checks to see if the array needs to be resized
        //by seeing if the last element has something in it
        //meaning the array is full
        if(this.count >= this.arrayList.length)
        {
            this.arrayList = resizeList(this.arrayList);
        }       
        //this checks if the index is within the bounds
        //of the array
        if(index < this.arrayList.length && index >= 0)
        {
            for(int i = this.count; i > index; i--)
            {
                arrayList[i] = arrayList[i-1];                    
            }
            arrayList[index] = item;
        }
        else
        {
            System.out.println("Cannot insert this object at index " + index);
        }
    }
    
    /**
     *Implemented an adding method that adds to the end of the arraylist
     */
    public void add(T item)
    {
        this.insert(item, this.count);
    }
    
    /**
     *To make this arraylist as easy to manipulate as an
     *array, I want to include a put method that just inserts
     *the given item to the given index
     */
    public T put(T item, int index)
    {
        if(index >= 0 && index < this.count)
        {
            T currentItem = this.get(index);
            this.arrayList[index] = item;
            return currentItem;
        }
        else
        {
            throw new RuntimeException("Cannot insert an index outside of [0-" + (this.count-1) + "]");
        }
    }

    /**
     *This method is used to resize the arraylist
     *when the list needs more slots to be filled
     *A new array with 100 more slots is created
     *and is filled by the old array, this array
     *is then returned and is set equal to the old
     *array
     */
    public Object[] resizeList(Object[] array)
    {
        Object[] newList = new Object[array.length+100];
        for(int i = 0; i < array.length; i++)
        {
            newList[i] = array[i];
        }
        return newList;
    }

    /**
     *This is the remove method that takes
     *an index as a parameter. First this 
     *method checks if the index is within
     *the bounds of the array, then if it
     *is the method saves a copy of this 
     *item so it can return it, sets the slot
     *to null and shift all the items down one
     *after the items been removed to fill the
     *gap
     */
    public T remove(int index)
    {
        //will hold the removed item
        T removedItem = null;
        //if the index is within the range
        if(index < this.arrayList.length)
        {           
            //check if this slot is empty
            if(this.arrayList[index] != null)
            {
                //store the item thats going to be
                //removed
                removedItem = (T)arrayList[index];
                //after its stored set the slot to
                //null
                arrayList[index] = null;
                //this will move everything down 1
                for(int i = index+1; i < count; i++)
                {
                    arrayList[i-1] = arrayList[i];                    
                }
                //set the top slot to null as 
                //everything got moved down
                this.arrayList[count-1] = null;
                //decrements the count
                this.count--;
            }
            else
            {
                //report to system the items null
                System.out.println("Trying to remove null.");
                return null;
            }             
        }  
        //returns the removed item
        return removedItem;
    }

    /**
     *returns the count of the array
     */
    public int size()
    {
        return this.count;
    }

    /**
     *this method returns the string
     *form of the array, lists all 
     *the objects in their string form
     *by using the objects built in 
     *toString() method.
     */
    public String toString()
    {
        String elements = "";
        for(int i = 0; i < this.count; i++)
        {
            elements = elements + this.arrayList[i].toString() + " ";
        }
        return elements;
    }

    /**
     *this method checks to see if the
     *count is equal to 0, if it is that
     *means the arraylist is empty, so true
     *is returned otherwise return false.
     */
    public boolean isEmpty()
    {
        if(this.count == 0)
        {
            return true;
        }
        else
        {
            return false; 
        }
    }

    /**
     *this method returns the index
     *of the object in the parameter
     *if it is found, if its not found
     *the method just returns -1.
     */    
    public int indexOf(Object itemToFind)
    {
        int itemIndex = -1;
        for(int i = 0; i < this.count; i++)
        {
            if(this.arrayList[i].equals(itemToFind))
            {
                itemIndex = i;
            }
        }
        return itemIndex;
    }

    /**
     *this method first checks if the size of 
     *the arrays are equal, if they're not
     *false is returned because the arrays are
     *clearly not the same. Then it checks to
     *see if every element is equal, if one isn't
     *that means the arraylists are not equal, so
     *false is returned. If all the elements equal 
     *the if statement will be avoided and true is 
     *returned.
     */
    public boolean equals(ArrayList other) 
    {
        if(other == null)
        {
            return false;
        }

        if(this.size() == other.size())
        {
            for(int i = 0; i < this.size(); i++)
            {
                //should there be an array accessor method 
                //rather then just calling the private instance
                //variables?
                if(this.arrayList[i] != other.arrayList[i])
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *this method returns the object at 
     *the specified index in the parameter,
     *if the index is not in the range of the 
     *list null is returned otherwise it 
     *returns the object at the index.
     */
    public T get(int index)
    {
        if(index > this.arrayList.length)
        {
            System.out.println("The items index is out of range.");
            return null;
        }
        else
        {
            return (T)this.arrayList[index];
        }
    }
}
