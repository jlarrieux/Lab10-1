//--------------------------------------------------------------------
//
//  Laboratory 8                                         List.java
//
//  List Interface:  will allow declaration of any kind of list
//   object as long as the list variant class 'implements List'
//
//--------------------------------------------------------------------



public interface List        // Constants & Methods common to list ADTs
{


    public void clear();
    // Inserts newElement after the cursor. If the list is empty, then
    // newElement is inserted as the first (and only) element in the list.
    // In either case, moves the cursor to newElement.

    public Object getCursor();
    // Removes the element marked by the cursor from a list. Moves the
    // cursor to the next element in the list. Assumes that the first list
    // element "follows" the last list element.

    public boolean gotoBeginning();
    // Replaces the element marked by the cursor with newElement and
    // leaves the cursor at newElement.

    public boolean gotoEnd();
    // Removes all elements in a list

    public boolean gotoNext();
    // Returns true if list is empty, else returns false

    public boolean gotoPrior();
    // Returns true if list is full, else returns false
    // Always returns false because Java automatically 
    //  generates an OutOfMemory error otherwise.

    public void insert(Object newElement);
    // If list not empty, moves cursor to beginning of list & returns true,
    // else returns false

    public boolean isEmpty();
    // If list not empty, moves cursor toend of list & returns true,
    // else returns false

    public boolean isFull();
    // If cursor not at end of list, moves cursor to next element in list & returns true
    //  else returns false  

    public void remove();
    // If cursor not at beginning of list, moves cursor to preceding element 
    //   in list & returns true, else returns false 

    public void replace(Object newElement);
    // Returns the element at the cursor

    public void showStructure();
    // Outputs the elements in a list. If the list is empty, outputs
    // "Empty list". This operation is intended for testing and
    // debugging purposes only.

} // interface List
