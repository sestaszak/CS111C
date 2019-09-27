package Module02SourceCode;

public class Quad<T,S> {

    private Pair<T> pair1;
    private Pair<S> pair2;

    public Quad(Pair<T> pair1, Pair<S> pair2) {
        this.pair1 = pair1;
        this.pair2 = pair2;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Quad<?,?>){
            Quad<?,?> otherQuad = (Quad<?,?>) other;
            boolean matchPair1 = (this.pair1.equals(otherQuad.pair1) | this.pair1.equals(otherQuad.pair2));
            boolean matchPair2 = (this.pair2.equals(otherQuad.pair1) | this.pair2.equals(otherQuad.pair2));
            if (this.pair1.equals(this.pair2)) {
                return (otherQuad.pair1.equals(otherQuad.pair2) & matchPair1);
            }
            else {
                return (matchPair1 & matchPair2);
            }

        }
        else {
            return false;
        }
    }
}
