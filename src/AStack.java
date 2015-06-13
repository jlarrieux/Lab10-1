//--------------------------------------------------------------------
//
//  Laboratory 5                                        AStack.java
//
//  SOLUTION: Array implementation of the Stack ADT
//
//--------------------------------------------------------------------



class AStack implements Stack   // Array based stack class
{


    // Data members
    private int top;             // Index for the top element
    private Object[] element;  // Array containing stack elements


    //Stack constructors and helper method setup
    public AStack()                  // Default constructor
    {
        setup(DEF_MAX_STACK_SIZE);
    }


    private void setup(int size)     // Called by constructor
    // Creates an empty stack. Allocates enough memory for maxNumber
    // elements.
    {
        // Requires size > 0
        if (size <= 0)
            System.out.println("Size of stack must be greater than 0 -- "
                    + "array stack not created");
        else {
            top = 0;
            element = new Object[size];
        }
    }


    public AStack(int size)          // Construct stack of specific size
    {
        setup(size);
    }


    //Stack manipulation operations
    public void push(Object newElement)     // Push Object onto stack
    {
        // make sure newElement isn't null and stack isn't full
        if (newElement == null) {
            System.out.println("Element is null -- added nothing to the stack");
            return;
        }
        if (isFull()) {
            System.out.println("Stack is full -- nothing added to the stack");
            return;
        }
        element[top++] = newElement;
    }


    public Object pop()                // Pop Object from top of stack
    {
        // make sure stack isn't empty
        if (isEmpty()) {
            System.out.println("Empty stack -- removed nothing from stack");
            return null;
        }
        return element[--top];
    }


    public void clear()              // Remove all Objects from stack
    {
        top = 0;
    }


    //Stack status operations
    public boolean isEmpty()         // Return true if stack is empty
    {
        return top == 0;
    }


    public boolean isFull()         // Return true if stack is full
    {
        return top >= element.length;
    }


    public void showStructure()
    // Array implementation. Outputs the elements in a stack. If the
    // stack is empty, outputs "Empty stack". This operation is intended
    // for testing and debugging purposes only.
    {
        int j;   // Loop counter

        if (isEmpty())
            System.out.println("Stack is empty");
        else {
            System.out.print("top = ");
            System.out.println(top);
            for (j = 0; j < element.length; j++)
                System.out.print(j + "\t");
            System.out.println();
            for (j = 0; j < top; j++) {
                System.out.print(element[j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    } // showStructure()

} // class AStack
