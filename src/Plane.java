package src;

public class Plane extends PlaneBase {

    public Plane(String planeNumber, String time) {
        super(planeNumber, time);
    }

    @Override
    public int compareTo(PlaneBase o) {
        int thisTime = Integer.valueOf(this.getTime()).intValue();
        int oTime = Integer.valueOf(o.getTime()).intValue();
        int result = thisTime - oTime;       
        if(result > 0) {
            return 1;
        } else if(result < 0) {
            return -1;
        } else {
           int i = this.getPlaneNumber().compareTo(o.getPlaneNumber());
           if(i>0){
               return 1;
           }else if(i<0) {
               return -1;
           } else {
               return 0;
           }
        }
    }

    /* Implement all the necessary methods of Plane here */
}
