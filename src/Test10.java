//--------------------------------------------------------------------
//
//  Laboratory 10                                         Test10.java
//
//  Test program for a set of recursive linked list methods
//
//--------------------------------------------------------------------

// Reads a list of characters and calls the specified recursive
// routine.

import java.io.IOException;

class Test10 {


    public static void main(String[] args) throws IOException {
        ListRec testList = new ListRec();      // Test list
        char testElement;                       // List element

        System.out.println("\nEnter a list of characters (all on the same line): ");
        testElement = (char) System.in.read();
        while (testElement != '\n' && testElement != '\r') {
            testList.insert(new Character(testElement));
            testElement = (char) System.in.read();
        }
        testList.showStructure();

        // Call a recursive routine by uncommenting the call you wish to
        // execute.

          testList.write();
          testList.insertEnd(new Character('!'));
        //PB  testList.writeMirror();
        //PC  testList.reverse();
        //PD  testList.deleteEnd();
        //PE  System.out.println("length = " +  testList.length());

        //BA  testList.unknown1();
        //BB  testList.unknown2();

        //1A  testList.iterReverse();
        //1B  testList.stackWriteMirror();
        //2   testList.aBeforeb();
        //3   testList.cRemove();

        testList.showStructure();
    } // main

} // class Test10