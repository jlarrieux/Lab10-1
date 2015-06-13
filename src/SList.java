//--------------------------------------------------------------------
//
//  Laboratory 7                                         SList.java
//
//  SOLUTION: Linked list implementation of the List ADT
//
//--------------------------------------------------------------------



class SList implements List {


    // Data members
    public SListNode head,     // Reference to the beginning of the list
            cursor;   // Reference to current cursor position


    // Constructors & Helper Method
    SList()                  // Default constructor: Creates an empty list
    {
        setup();
    }


    // Class Methods
    private void setup()       // Called by constructors only: Creates an empty list
    {
        head = null;
        cursor = null;
    }


    SList(int size)
    // Creates an empty list. The argument is included for compatibility
    // with the array implementation; size is ignored.
    {
        setup();
    }


    public void clear()
    // Removes all the elements from a list.

    {
        head = cursor = null;
    }


    public Object getCursor()
    // Returns the element marked by the cursor.

    {
        // Requires that the list is not empty
        if (isEmpty()) {
            System.out.println("List is empty -- no elements found!");
            return null;
        }

        return cursor.getElement();
    }


    public boolean gotoBeginning()
    // If a list is not empty, then moves the cursor to the beginning of
    // the list and returns true. Otherwise, returns false.

    {
        if (!isEmpty()) {
            cursor = head;
            return true;
        }

        return false;
    }


    public boolean gotoEnd()
    // If a list is not empty, then moves the cursor to the end of the
    // list and returns true. Otherwise, returns false.

    {
        if (!isEmpty()) {
            for (; cursor.getNext() != null; cursor = cursor.getNext()) ;
            return true;
        } else
            return false;
    }


    public boolean gotoNext()
    // If the cursor is not at the end of a list, then moves the
    // cursor to the next element in the list and returns true. Otherwise,
    // returns false.

    {
        if (cursor.getNext() != null) {
            cursor = cursor.getNext();
            return true;
        } else
            return false;
    }


    public boolean gotoPrior()
    // If the cursor is not at the beginning of a list, then moves the
    // cursor to the preceeding element in the list and returns true.
    // Otherwise, returns false.

    {
        SListNode p;   // Pointer to prior node

        if (cursor != head) {
            for (p = head; p.getNext() != cursor; p = p.getNext()) ;
            cursor = p;
            return true;
        } else
            return false;
    }


    public void insert(Object newElement)
    // Inserts newElement after the cursor. If the list is empty, then
    // newElement is inserted as the first (and only) element in the list.
    // In either case, moves the cursor to newElement.
    {
        // make sure newElement isn't null & list isn't full
        if (newElement == null || isFull()) {
            System.out.println("Element is null or list is Full "
                    + "-- added nothing to the list");
            return;
        }

        if (head == null)             // Empty list
        {
            head = new SListNode(newElement, null);
            cursor = head;
        } else                         // After cursor
        {
            cursor.setNext(new SListNode(newElement, cursor.getNext()));
            cursor = cursor.getNext();
        }
    }


    public boolean isEmpty()
    // Returns true if a list is empty. Otherwise, returns false.

    {
        return (head == null);
    }


    public boolean isFull()
    // Returns true if a list is full. Otherwise, returns false.
    // Always returns false because Java automatically
    //  generates an OutOfMemoryError otherwise.

    {
        return false;
    }


    public void remove()
    // Removes the element marked by the cursor from a list. Moves the
    // cursor to the next element in the list. Assumes that the first list
    // element "follows" the last list element.

    {
        SListNode p,                // Pointer to removed node
                q;              // Pointer to prior node

        // Requires that the list is not empty
        if (isEmpty()) {
            System.out.println("List is empty -- removed nothing");
            return;
        }

        if (cursor == head)                   // Remove first element
        {
            p = head;
            head = head.getNext();
            cursor = head;
        } else if (cursor.getNext() != null)   // Remove middle element
        {
            p = cursor.getNext();
            cursor.setElement(p.getElement());
            cursor.setNext(p.getNext());
        } else                                    // Remove last element
        {
            p = cursor;
            for (q = head; q.getNext() != cursor; q = q.getNext()) ;
            q.setNext(null);
            cursor = head;
        }

    }


    public void replace(Object newElement)
    // Replaces the element marked by the cursor with newElement and
    // leaves the cursor at newElement.

    {
        //  Requires that the list is not empty && newElement not null
        if (newElement == null || isEmpty()) {
            System.out.println("List is empty or Element is null " +
                    "-- nothing to replace");
            return;
        }

        cursor.setElement(newElement);
    }


    public void showStructure()
    // Outputs the elements in a list. If the list is empty, outputs
    // "Empty list". This operation is intended for testing and
    // debugging purposes only.

    {
        SListNode p;   // Iterates through the list

        if (head == null)
            System.out.println("Empty list");
        else {
            for (p = head; p != null; p = p.getNext())
                if (p == cursor)
                    System.out.print("[" + p.getElement() + "] ");
                else
                    System.out.print(p.getElement() + " ");
            System.out.println();
        }
    }

    //--------------------------------------------------------------------
    //
    //                        In-lab operations
    //
    //--------------------------------------------------------------------


    void moveToBeginning()
    // Removes the element marked by the cursor from a list and
    // reinserts it at the beginning of the list. Moves the cursor to the
    // beginning of the list.

    {
        SListNode p;   //  Pointer to prior node

        // Requires that the list is not empty
        if (isEmpty()) {
            System.out.println("List is empty -- no elements to move!");
            return;
        }

        if (cursor != head) {
            for (p = head; p.getNext() != cursor; p = p.getNext()) ;
            p.setNext(cursor.getNext());
            cursor.setNext(head);
            head = cursor;
        }
    }


    void insertBefore(Object newElement)
    // Inserts newElement before the cursor. If the list is empty, then
    // newElement is inserted as the first (and only) element in the list.
    // In either case, moves the cursor to newElement.

    {
        if (isEmpty())             // Empty list
        {
            head = new SListNode(newElement, null);
            cursor = head;
        } else                         // Before cursor
        {
            cursor.setNext(new SListNode(cursor.getElement(), cursor.getNext()));
            cursor.setElement(newElement);
        }
    }

} // class SList