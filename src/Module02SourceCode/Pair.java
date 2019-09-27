package Module02SourceCode;

public class Pair<T> {
	
	private T item1, item2;
	
	public Pair(T item1, T item2) {
		this.item1 = item1;
		this.item2 = item2;
	}

	public T getItem1() {
		return item1;
	}
	public T getItem2() {
		return item2;
	}
	public void setItem1(T item1) {
		this.item1 = item1;
	}
	public void setItem2(T item2) {
		this.item2 = item2;
	}

	@Override
	public String toString() {
		return item1.toString() + "\t" + item2.toString();
	}

	public boolean sameItems() {
		return item1.equals(item2);
		// return item1==item2; INCORRECT! tests for aliases, not logical equivalence
	}

	@Override
	public boolean equals(Object other) {
		if(other instanceof Pair<?>) {
			Pair<?> otherPair = (Pair<?>) other;

			boolean matchItem1 = (this.item1.equals(otherPair.item1) | this.item1.equals(otherPair.item2));
			boolean matchItem2 = (this.item2.equals(otherPair.item1) | this.item2.equals(otherPair.item2));

			if(this.sameItems()) {
				return (matchItem1 & otherPair.sameItems());
			}
			else {
				return (matchItem1 & matchItem2);
			}

//			if(this.sameItems()) {
//				boolean matchItem = (this.item1.equals(otherPair.item1));
//				return (matchItem & otherPair.sameItems());
//			}
//			else {
//				boolean matchItem1 = (this.item1.equals(otherPair.item1) | this.item1.equals(otherPair.item2));
//				boolean matchItem2 = (this.item2.equals(otherPair.item1) | this.item2.equals(otherPair.item2));
//				return (matchItem1 & matchItem2);
//			}

		}
		else {
			return false;
		}
	}

}
