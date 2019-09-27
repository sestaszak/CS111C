package Module02SourceCode;

public class PairTester {

	public static void main(String[] args) {
		Pair<Integer> numberPair = new Pair<Integer>(3,4);
		Pair<String> wordPair = new Pair<String>("hello", "goodbye");
		
		System.out.println(numberPair);
		System.out.println(wordPair);
		
		// testing our sameItems method
		String s1 = new String("apple");
		String s2 = new String("apple");
		Pair<String> wordPair2 = new Pair<String>(s1, s2);
		System.out.println("wordPair2 contains the same items? " + wordPair2.sameItems());
		
		PairDifferent<Integer,String> numberWordPair = new PairDifferent<Integer,String>(2, "hello");
		PairDifferent<Integer,Integer> doubleNumberPair = new PairDifferent<Integer,Integer>(1,1);

		Pair<Integer> nPairTest1 = new Pair<Integer>(3,3);
		Pair<Integer> nPairTest2 = new Pair<Integer>(4,3);
		Pair<Integer> nPairTest3 = new Pair<Integer>(1,2);

		System.out.println("Check equals numberPair: " + numberPair.toString() + " test 1: " + nPairTest1.toString() + numberPair.equals(nPairTest1));
		System.out.println("Check equals numberPair: " + numberPair.toString() + " test 2: " + nPairTest2.toString() + numberPair.equals(nPairTest2));
		System.out.println("Check equals numberPair: " + numberPair.toString() + " test 3: " + nPairTest3.toString() + numberPair.equals(nPairTest3));


		Quad<Integer, String> numWordQuad = new Quad<>(numberPair, wordPair);
		Quad<Integer, Integer> numNumQuad = new Quad<>(numberPair, nPairTest2);
		System.out.println("Comparing Quads equals: " + numNumQuad.equals(numWordQuad));
	}

}
