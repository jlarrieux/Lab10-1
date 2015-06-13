//--------------------------------------------------------------------
//
//  Laboratory 10                                        ListRec.jshl
//
//  (Shell) Partial linked list implementation of the List ADT with
//  additional recursive linked list functions
//
//--------------------------------------------------------------------

//--------------------------------------------------------------------
//
// This class inherits from your singly linked list implementation
// (from Laboratory 7)
//
//  Assumes the following files have been copied into this package
//      List.java, SList.java, SListNode.java (from Laboratory 7)
//      Stack.java, AStack.java (from Laboratory 5)
//
//--------------------------------------------------------------------



class ListRec extends SList {

//--------------------------------------------------------------------
//
// Recursively implemented linked list methods used in the Prelab
// Exercise
//
//--------------------------------------------------------------------


    void write()
    // Outputs the elements in a list from beginning to end.
    // Assumes that objects of type Object can be meaningfully
    // printed to the output stream.

    {
        System.out.printf("List: ");
        writeSub(head);
        System.out.println();

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void writeSub(SListNode p)
    // Recursive partner of the write() method. Processes the sublist
    // that begins with the node referenced by p.

    {
        if(p!=null){
            System.out.print(p.getElement());
            writeSub(p.getNext());
        }
    }

    //--------------------------------------------------------------------


    void insertEnd(Object newElement)
    // Inserts newElement at the end of a list. Moves the cursor to
    // newElement.

    {
        if(isEmpty()){
            head = new SListNode(newElement, null);
            cursor = head;
        }
        else insertEndSub(head,newElement);

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void insertEndSub(SListNode p, Object newElement)
    // Recursive partner of the insertEnd() method. Processes the
    // sublist that begins with the node referenced by p.

    {
        if(p.getNext()!=null)   insertEndSub(p.getNext(), newElement);
        else {
            p.setNext(new SListNode(newElement, null));
            cursor = p.getNext();
        }


    }

    //--------------------------------------------------------------------


    void writeMirror()
    // Outputs the elements in a list from beginning to end and back again.
    // Assumes that objects of type Object can be meaningfully
    // printed to the output stream.

    {
        System.out.print("Mirror: ");
        writeMirrorSub(head);
        System.out.println();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void writeMirrorSub(SListNode p)
    // Recursive partner of the writeMirror() method. Processes the
    // sublist that begins with the node referenced by p.

    {
        if(p!=null){
            System.out.print(p.getElement());
            writeMirrorSub(p.getNext());
            System.out.print(p.getElement());
        }

    }

    //--------------------------------------------------------------------


    void reverse()
    // Reverses the order of the elements in a list.

    {
        System.out.print("Reverse: ");
        reverseSub(null, head);
        showStructure();
        System.out.println();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void reverseSub(SListNode p, SListNode nextP)
    // Recursive partner of the reverse() method. Processes the sublist
    // that begins with the node referenced by nextP.

    {
        if(nextP !=null){
            reverseSub(nextP, nextP.getNext());
            nextP.setNext(p);
        }
        else  head = p;
    }

    //--------------------------------------------------------------------


    void deleteEnd()
    // Deletes the element at the end of a list. Moves the cursor to the
    // beginning of the list.

    {

        if(!isEmpty()) {
            System.out.print("Delete End: ");
            deleteEndSub(head);
            cursor = head;
        }
        showStructure();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void deleteEndSub(SListNode p)
    // Recursive partner of the deleteEnd() method. Processes the
    // sublist that begins with the node referenced by p.

    {

        if(p.getNext()!=null  ) {
            if(p.getNext().getNext()!=null)deleteEndSub(p.getNext());
            else  p.setNext(null);
        }

    }

    //--------------------------------------------------------------------


    int length()
    // Returns the number of elements in a list.

    {
        return lengthSub(head);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    int lengthSub(SListNode p)
    // Recursive partner of the length() method. Processes the sublist
    // that begins with the node referenced by p.

    {
        int result;   // Result returned

        if (p == null)
            result = 0;                               // End of list reached
        else
            result = (lengthSub(p.getNext()) + 1); // Number of nodes after
        // this one + 1
        return result;
    }

    //--------------------------------------------------------------------
    //
    // "Unknown" operations used in the Bridge Exercise
    //
    //--------------------------------------------------------------------


    void unknown1()
    // Unknown method 1.

    {
        unknown1Sub(head);
        System.out.println();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void unknown1Sub(SListNode p)
    // Recursive partner of the unknown1( ) method.

    {
        if (p != null) {
            System.out.print(p.getElement());
            if (p.getNext() != null) {
                unknown1Sub(p.getNext().getNext());
                System.out.print(p.getNext().getElement());
            }
        }
    }

    //--------------------------------------------------------------------


    void unknown2()
    // Unknown method 2.

    {
        unknown2Sub(head);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void unknown2Sub(SListNode p)
    // Recursive partner of the unknown2( ) method.

    {
        SListNode q;

        if (p != null && p.getNext() != null) {
            q = p;
            p = p.getNext();
            q.setNext(p.getNext());
            p.setNext(q);
            unknown2Sub(q.getNext());
        }
    }

    //--------------------------------------------------------------------
    //
    // Solutions to the In-lab Exercises
    //
    //--------------------------------------------------------------------


    void iterReverse()                    // In-lab Exercise 1
    {
        int i = length();
        System.out.printf("Number or elements: %d\n", i);
        Object current,  next;
        gotoEnd();


        while(i>1){
            gotoBeginning();

            for(int j=1; j<i; j++) {
                System.out.print("Before: ");
                showStructure();
                current = cursor.getElement();
                if (cursor.getNext() != null) {
                    next = cursor.getNext().getElement();
                    cursor.getNext().setElement(current);
                    cursor.setElement(next);
                    cursor = cursor.getNext();
                }
                System.out.printf("Head: %s\t j: %d\ti: %d\n", head.getElement(), j, i);
                System.out.print("After: ");
                showStructure();
                System.out.println();

            }
                i--;
        }

        cursor = head;



    }

    //--------------------------------------------------------------------


    void stackWriteMirror()               // In-lab Exercise 1
    {
        Stack tempStack = new AStack(length());
        SListNode p= head;
        System.out.print("Stack Mirror: ");
        while ((p!=null)){
            System.out.print(p.getElement());
            tempStack.push(p);
            p = p.getNext();
        }
        while(!tempStack.isEmpty()){
            p = (SListNode)tempStack.pop();
            System.out.print(p.getElement());
        }
        System.out.println();

    }

    //--------------------------------------------------------------------


    void aBeforeb()                       // In-lab Exercise 2
    {

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void aBeforebSub(SListNode p)        // In-lab Exercise 2
    {

    }

    //--------------------------------------------------------------------


    void cRemove()                        // In-lab Exercise 3
    {

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    void cRemoveSub(SListNode p)         // In-lab Exercise 3
    {

    }

} // class ListRec