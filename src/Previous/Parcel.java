package Previous;
/**
 *
 * @author sarastaszak
 *
 * */
public class Parcel {

    protected String id;
    protected double weight;

    public static final double DEFAULT_WEIGHT = 1.0;
    /**
     *
     * */
    public Parcel(String idvar, double wLbs) {
        this.id = idvar;
        this.weight = wLbs;
    }
    public Parcel(String idvar) {
        this(idvar, DEFAULT_WEIGHT);
    }

    /**
     *
     * @return
     */
    public String getID() {
        return id;
    }
    public void setID(String idvar) {
        this.id = idvar;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double wLbs) {
        if(wLbs>0.0) {
            this.weight = wLbs;
        }
        else {
            System.out.println("Weight should be positive.");
        }
    }

    public String toString() {
        return "Parcel with id: " + id + " and weight: "+weight;
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Parcel){
            Parcel otherParcel = (Parcel) other;
            //this.id.toUpperCase()==otherParcel.getID().toUpperCase()
            return (this.id.equalsIgnoreCase(otherParcel.getID()));
        }
        else {
            return false;
        }
    }

    public boolean idCriteria(char first, char second, int numberTimesSecond) {
        char[] idchars = getID().toCharArray();
        int firstInd = 0;
        boolean hasFirst = false;
        int secondCount = 0;
        for(int i=0; i<idchars.length; i++){
            if(idchars[i]==first) {
                firstInd = i;
                hasFirst = true;
                break;
            }
        }
        if(hasFirst) {
            for(int j=firstInd+1; j<idchars.length; j++){
                if(idchars[j]==second){
                    secondCount++;
                }
            }
            return (secondCount==numberTimesSecond);
        }
        else {
            return false;
        }
    }
}
