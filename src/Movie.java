public class Movie implements Comparable<Movie> {
    private String name;
    private int year;

    public Movie(String mName, int mYear){
        name = mName;
        year = mYear;
    }

    @Override
    public int compareTo(Movie otherMovie){
//        year first then name
        if(this.year<otherMovie.year) {
            return -1;
        } else if (this.year>otherMovie.year) {
            return 1;
        } else {
            if(this.name.compareToIgnoreCase(otherMovie.name) < 0) { //this name is smaller than the other name
                 return -1;
            } else if (this.name.compareToIgnoreCase(otherMovie.name) > 0) { //this name is greater than other name
                return 1;
            } else {
                return 0;
            }
        }
    }


//        if(this.name.compareTo(otherMovie.name) < 0) { //this name is smaller than the other name
//            return -1;
//        } else if (this.name.compareTo(otherMovie.name) > 0) { //this name is greater than other name
//            return 1;
//        } else { // this name and other name same
//            return Integer.compare(this.year, otherMovie.year);
//            if (Integer.compare(this.year, otherMovie.year) < 0) { //this year less than other year
//                return -1;
//            } else if (Integer.compare(this.year, otherMovie.year) > 0) { // this year greater than other year
//                return 1;
//            } else { //same years (same name)
//                return 0;
//            }


}
