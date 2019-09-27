package Previous;

public class Trio<T> {

//    (10 points) instance data variables to store the three items contained in the Previous.Trio
    private T item1, item2, item3;
//    (10 points) two constructors:
//      one constructor takes in the three items as parameters
    public Trio(T item1, T item2, T item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }
//      a second constructor takes in a single item and the Previous.Trio will then consist of three of these items
//      for full credit, reduce duplicated code in the constructors and follow best practices for overloading constructors.
    public Trio(T item) {
        //  reduce duplicated code in the constructors and follow best practices for overloading constructors.
        item1 = item2 = item3 = item;
//        this.item1 = item;
//        this.item2 = item;
//        this.item3 = item;
    }
//    (5 points) getters and setters for each item in the trio
    public T getItem1() {
    return item1;
}
    public T getItem2() {
        return item2;
    }
    public T getItem3() {
        return item3;
    }
    public void setItem1(T item1) {
        this.item1 = item1;
    }
    public void setItem2(T item2) {
        this.item2 = item2;
    }
    public void setItem3(T item3) {
        this.item3 = item3;
    }
//    (5 points) a toString method that returns a text representation of the trio
    @Override
    public String toString() {
        return "A trio of: " + item1.toString() + "\t" + item2.toString() + "\t" + item3.toString();
    }

// (10 points) a method called reset that takes in one item as a parameter and modifies the Previous.Trio to hold three of that item
    public void reset(T item) {
        this.setItem1(item);
        this.setItem2(item);
        this.setItem3(item);
    }
// (15 points) a method called count that returns a count of how many times an item is in the Previous.Trio
    public int count(T item) {
//        int eq1, eq2, eq3;
//        eq1 = eq2 = eq3 = 0;
        int eq1 = 0;
        int eq2 = 0;
        int eq3 = 0;
        if (item1.equals(item)) {
            eq1 = 1;
        }
        if (item2.equals(item)) {
            eq2 = 1;
        }
        if (item3.equals(item)) {
            eq3 = 1;
        }

        return eq1 + eq2 + eq3;

    }
//    (15 points) a method called hasDuplicates that returns true if the at least two items within the Previous.Trio are
//          the same as each other.
//             Note this does not determine duplicates based on whether any of the items are aliases,
//             but whether any of the items are equal- logically equivalent to each other.
    public boolean hasDuplicates() {
        int item1Count = this.count(item1);
        int item2Count = this.count(item2);
        int item3Count = this.count(item3);

        return (item1Count>1 | item2Count>1 | item3Count>1);
    }
//   (20 points) an equals method that overrides the equals method of the Object class.
//              The method returns true if the current Previous.Trio holds the same (logically equivalent) three items in any order as the Previous.Trio sent as a parameter and false otherwise.
//              The equals method should not alter either the current Previous.Trio object or the Previous.Trio object passed in as a parameter.
//              Be sure to test your method with different cases, particularly cases where the Trios have duplicate items!
    @Override
    public boolean equals(Object other) {
        if (other instanceof Trio<?>) {
            Trio<?> otherTrio = (Trio<?>) other;

            boolean oneTwoThree = (this.item1.equals(otherTrio.item1) & this.item2.equals(otherTrio.item2) & this.item3.equals(otherTrio.item3));
            boolean oneThreeTwo = (this.item1.equals(otherTrio.item1) & this.item2.equals(otherTrio.item3) & this.item3.equals(otherTrio.item2));
            boolean twoOneThree = (this.item1.equals(otherTrio.item2) & this.item2.equals(otherTrio.item1) & this.item3.equals(otherTrio.item3));
            boolean twoThreeOne = (this.item1.equals(otherTrio.item2) & this.item2.equals(otherTrio.item3) & this.item3.equals(otherTrio.item1));
            boolean threeOneTwo = (this.item1.equals(otherTrio.item3) & this.item2.equals(otherTrio.item1) & this.item3.equals(otherTrio.item2));
            boolean threeTwoOne = (this.item1.equals(otherTrio.item3) & this.item2.equals(otherTrio.item2) & this.item3.equals(otherTrio.item1));

            return (oneTwoThree | oneThreeTwo | twoOneThree | twoThreeOne | threeOneTwo | threeTwoOne);
        }
        else {
            return false;
        }
    }
//  cleanup style:
//      (10 points) Style: Your class should follow Java coding conventions and best practices.
//      Follow naming conventions for variables, classes, and methods. Reduce duplicated code.

}
