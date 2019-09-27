package Previous;
public class parcelTester {

    public static void main(String args[]){
        Parcel p1 = new Parcel("mdc4x1m43m");
        Parcel p2 = new Parcel("ddc4x1m4mm", 2.5);
        overnightParcel o1 = new overnightParcel("kdc2m1m4rv", 5.3, true);

        boolean xm2 = p1.idCriteria('x', 'm', 2);
        System.out.println(xm2);

        System.out.println(p2.toString());

        System.out.println("Check if p1 equals p2: " + p1.equals(p2));

        System.out.println(o1.toString());

    }
}
