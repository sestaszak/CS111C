package  Previous;
public class overnightParcel extends Parcel {

    private boolean signatureRequired;

    public overnightParcel(String idvar, double wLbs, boolean required){
        super(idvar, wLbs);
        signatureRequired = required;
    }


    public String toString(){
        return super.toString() + "\nSignature Required: " + signatureRequired;
    }

}
