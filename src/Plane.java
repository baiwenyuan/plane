package src;

public class Plane extends PlaneBase {

    public Plane(String planeNumber, String time) {
        super(planeNumber, time);
    }

    @Override
    public int compareTo(PlaneBase o) {
        int thisTime = stringToInt(this.getTime());
        int oTime = stringToInt(o.getTime());
        int result = thisTime - oTime;
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
           return this.getPlaneNumber().compareTo(o.getPlaneNumber());
        }
    }

    /* Implement all the necessary methods of Plane here */
    public int stringToInt(String time) {
        return Integer.parseInt(time.replace(":", ""));
    }
}
