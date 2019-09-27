import java.util.*;

public class HomeworkM3Driver {

	public static void main(String[] args) {
		
		System.out.println("******TESTING QUESTION: TESTING IF BAG IS A SET");
		BagInterface<String> wordBag = new ArrayBag<>();
		System.out.println("Bag is set? true: " + isSet(wordBag));
		System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[]");
		System.out.println(Arrays.toString(wordBag.toArray()));
		wordBag.add("hi");
		System.out.println("Bag is set? true: " + isSet(wordBag));
		System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[hi]");
		System.out.println(Arrays.toString(wordBag.toArray()));
		wordBag.add("HI");
		wordBag.add("hello");
		System.out.println("Bag is set? true: " + isSet(wordBag));
		System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[hi, HI, hello]");
		System.out.println(Arrays.toString(wordBag.toArray()));
		wordBag.add("hi");
		System.out.println("Bag is set? false: " + isSet(wordBag));
		System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[hi, HI, hello, hi]");
		System.out.println(Arrays.toString(wordBag.toArray()));
		wordBag.clear();
		wordBag.add("a");
		wordBag.add("c");
		wordBag.add("b");
		wordBag.add("d");
		wordBag.add("a");
		System.out.println("Bag is set? false: " + isSet(wordBag));
		System.out.println("The contents of the bag should be (in ANY order- the order might not match): \n[a, c, b, d, a]");
		System.out.println(Arrays.toString(wordBag.toArray()));
		
		System.out.println("\n******TESTING QUESTION: CREATING LIST OF WORDS THAT CONTAIN CHAR");
		ListInterface<String> wordList = new AList<>();
		ListInterface<String> shortWordList = createWordListContainChar(wordList,'a');
		System.out.println("The contents of the list should be: \n[]");
		System.out.println(Arrays.toString(shortWordList.toArray()));
		wordList.add("apple");
		wordList.add("anna");
		wordList.add("bob"); 
		wordList.add("ANIMAL");
		wordList.add("canal");
		wordList.add("frog");
		wordList.add("cat");
		System.out.println(wordList.getLength());
		shortWordList = createWordListContainChar(wordList,'a');
		System.out.println("The contents of the list should be (in THIS ORDER): \n[apple, anna, canal, cat]");
		System.out.println(Arrays.toString(shortWordList.toArray()));
		System.out.println("The original list should still contain (in THIS ORDER): \n[apple, anna, bob, ANIMAL, canal, frog, cat]");
		System.out.println(Arrays.toString(wordList.toArray()));

		System.out.println("\n******TESTING QUESTION: FINDING LAST POSITION");
		List<String> itemList = new ArrayList<>();
		itemList.add("adam");
		itemList.add("frank");
		itemList.add("betty");
		itemList.add("sue");
		itemList.add("sam");
		itemList.add("frank");
		itemList.add("sue");
		itemList.add("terry");
		itemList.add("adam");
		itemList.add("frank");
		System.out.println(itemList.size());
		System.out.println("The index should be: \n9\n" + lastPosition(itemList, "frank"));
		System.out.println(Arrays.toString(itemList.toArray()));
		
		System.out.println("\n******TESTING QUESTION: LIST COMPARISON");
		ListInterface<Integer> numListA = new AList<Integer>();
		List<Integer> numListB = new ArrayList<Integer>();
		numListB.add(1);
		numListB.add(3);
		numListB.add(1);
		numListB.add(5);
		numListB.add(7);
		System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numListA, numListB));		
		numListA.add(1);
		System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numListA, numListB));	
		numListA.add(3);
		numListA.add(1);
		numListA.add(5);
		System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numListA, numListB));
		numListA.add(7);
		System.out.println("Equivalent should be: \ntrue\n" + equivalentLists(numListA, numListB));
		System.out.println("ListInt length: " + numListA.getLength() + " and List size: " + numListB.size());
		numListA.add(8);
		System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numListA, numListB));
		numListB.add(8);
		numListB.add(10);
		System.out.println("Equivalent should be: \nfalse\n" + equivalentLists(numListA, numListB));
		numListA.clear();
		System.out.println("Equivalent for one empty should be: \nfalse\n" + equivalentLists(numListA, numListB));
		numListB.clear();
		System.out.println("Equivalent for both empty should be: \ntrue\n" + equivalentLists(numListA, numListB));

		
		System.out.println("\n******TESTING EXTRA CREDIT QUESTION: MOVE THE MINIMUM TO THE FRONT");
		List<Integer> numberList = new ArrayList<Integer>();
		prioritizeMinimumValue(numberList);
		System.out.println("The list should contain: \n[]\n" + numberList);
		numberList.add(4);
		prioritizeMinimumValue(numberList);
		System.out.println("The list should contain: \n[4]\n" + numberList);
		numberList.add(3);
		numberList.add(1);
		numberList.add(5);
		numberList.add(7);
		prioritizeMinimumValue(numberList);
		System.out.println("The list should contain: \n[1, 4, 3, 5, 7]\n" + numberList);
		numberList.add(0);
		prioritizeMinimumValue(numberList);
		System.out.println("The list should contain: \n[0, 1, 4, 3, 5, 7]\n" + numberList);


	}

	public static boolean isSet(BagInterface<String> wordBag) {
		// YOUR CODE HERE
		BagInterface<String> tempBag = new ArrayBag<>();
		boolean hasDups = false;
		while(!wordBag.isEmpty()) { //loop to copy and do stuff
			String word = wordBag.remove();
			tempBag.add(word);
			if(wordBag.getFrequencyOf(word)>=1) {
				hasDups = true;
			}
		}

		while(!tempBag.isEmpty()) { //loop to copy back to parameter
			wordBag.add(tempBag.remove());
		}

		return !hasDups;
	}
	
	public static ListInterface<String> createWordListContainChar(ListInterface<String> wordList, char key) {
		// YOUR CODE HERE
		/*
		* The relative order of the names in the returned list should match the order of the names in the parameter list.
			The wordList parameter should be unchanged when the method completes.
			You can use local objects of type ListInterface (initialized as AList).
			For full credit, do not use another data structure, such as ArrayList or an array.
			Post any questions about what you can and cannot use to the discussion board.
			For full credit, do not invoke the toArray() method on wordList.
		* */
		ListInterface<String> charList = new AList<>();

		if(!wordList.isEmpty()){
			for(int i=1; i<=wordList.getLength(); i++) {
				String word = wordList.getEntry(i);
				if(word.indexOf(key) != -1) {
					charList.add(word);
				}
			}
		}

		return charList;

	}
	
	public static int lastPosition(List<String> wordList, String targetWord) {
		// YOUR CODE HERE
//		If the item appears more than once, return the position of the last appearance.
//		Decide what to do if the item is not on the list. Make sure your action is logical!
//		The wordList parameter should be unchanged when the method completes.
//		Note that there is a lastIndexOf method in the ArrayList class. Do not use this method- you will receive 0 points for using this.
//		This question is essentially asking you to re-write this method for yourself!

		int twordPosition = -1;
		if(!wordList.isEmpty() & wordList.contains(targetWord)) {
			for(int i=0; i<wordList.size(); i++){
				if(wordList.get(i).equals(targetWord)) {
					twordPosition = i;
				}
			}
		}
		return twordPosition;
	}
	
	public static boolean equivalentLists(ListInterface<Integer> numberListInterface, List<Integer> numberList) {
		// YOUR CODE HERE
//		Neither parameter list should be changed when the method completes.
//		Do not assume anything about the size of the lists!
//				For full credit, do not convert either list to an array.
//				For full credit, do not use another data structure, such as ArrayList, AList, or an array.
//		Post any questions about what you can and cannot use to the discussion board.

		boolean isEquivalent = true;
		if(!numberListInterface.isEmpty() & !numberList.isEmpty()) {
			//both not empty, check each item until mismatch
			if(numberList.size()==numberListInterface.getLength()) {
				for(int i=0; i<numberList.size(); i++) {
					int j = i+1; //index for list interface (from 1 to length)
					if(!numberList.get(i).equals(numberListInterface.getEntry(j))) {
						isEquivalent = false;
						break;
					}
				}
			} else {
				isEquivalent = false;
			}
//			int minMaxLen = Integer.min(numberListInterface.getLength(), numberList.size());

		} else if(!numberListInterface.isEmpty() | !numberList.isEmpty()) {
			//one is not empty, other is not (because checked both not empty above), so not equivalent
			isEquivalent = false;
		}
		return isEquivalent;
	}
	
	public static void prioritizeMinimumValue(List<Integer> numberList) {
		// YOUR CODE HERE
//		Do not make any assumptions about the length of the list!
//				Your code should not crash with empty lists, one-element lists, or longer lists.
//		If there is more than one copy of the minimum, you can move any of those copies to the front.
//				You are not swapping values- but performing a shift by moving the minimum value to the front of the list.
//		For full credit, do not use another data structure, such as ArrayList or an array.
//				For full credit, take advantage of the methods provided in List rather than rewriting code yourself.
		if(!numberList.isEmpty()) {
			int minValue = numberList.get(0); //a var to store minValue, start with first item
			int minIndex = 0;
			for(int i=0; i<numberList.size(); i++) {
				int checkValue = numberList.get(i);
				if(checkValue<minValue){
					minValue = checkValue;
					minIndex = i;
				}
			}
			numberList.add(0, numberList.remove(minIndex));

		} else {
			System.out.println("Empty list cannot prioritize minimum.");
		}
	}
}
