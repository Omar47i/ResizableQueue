/**
 *
 * @author Omar Saeed
 */

public class ResizableQueue
{
    String[] array;
    int first;
    int last;
    
    public ResizableQueue()
    {
        first = 0;
        last = first;
        array = new String[1];
    }
    
    public void enqueue(String element)
    {
        if (last >= array.length)  
        {
            // We need to resize the array or shift elements to be at zero index
            if (getSize() < array.length)
            {
                int size = getSize();
                int len = getLength();
                // shift array elements to start at zero index
                shiftArrayToBeAtZero();
            }
            else
            {
                resize(array.length * 2);
            }
        }
        
        array[last++] = element;
    }
    
    public String deqeueue()
    {
        if (isEmpty())
        {
            return "Queue is empty";
        }
        
        if (getSize() <= getLength() / 4)
        {
            resize(array.length / 2);
        }
        
        return array[first++];
    }
    
    public void resize(int capacity)
    {
        String[] temp = new String[capacity];
        int firstNew = 0;
        int firstOld = first;
        
        for ( ; firstOld < last; firstOld++,firstNew++)
        {
            temp[firstNew] = array[firstOld];
        }
        
        array = temp;
        first = 0;
        last = firstNew;
    }
    
    // Shift all elements to start at index zero
    public void shiftArrayToBeAtZero()
    {
        String[] temp = new String[getLength()];
        int size = getSize();
        int i;
        
        for (i = 0; i < size; i++)
        {
            temp[i] = array[first];
            first++;
        }
        
        array = temp;
        first = 0;
        last = i;
    }
    
    public void Display()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
        }
        
        for (int i = first; i < last; i++)
        {
            System.out.println("Element " + i + " : " + array[i]);
        }
    }
    
    public boolean isEmpty()
    {
        return first == last;
    }
    
    public int getLength()
    {
        return array.length;
    }
    
    public int getSize()
    {
        return last - first;
    }
}
