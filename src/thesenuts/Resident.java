package thesenuts;

public class Resident extends Student{
    private static final int FULL_RESIDENT = 12536;
    private static final int PART_RESIDENT = 404;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int INITIAL_TUITION = 0;
    private static final int CREDIT_FULL = 12;
    private static final int CREDIT_OVERLOAD = 16;
    private static final double PART_TIME_DEPRECIATION = .8;
    public Resident(String name, Major major, int creditHours){
        super(name,major, creditHours);
    }
    @Override
    public void tuitionDue() {
        double tuitionDue = INITIAL_TUITION;
        if (this.creditHours > CREDIT_FULL){
            tuitionDue = FULL_RESIDENT + UNIVERSITY_FEE;
            if (this.creditHours > CREDIT_OVERLOAD){
                tuitionDue += PART_RESIDENT * (this.creditHours - 16);
            }
        }
        else{
            tuitionDue = (PART_RESIDENT * this.creditHours) + PART_TIME_DEPRECIATION * UNIVERSITY_FEE;
        }
        this.tuitionDue = tuitionDue;
    }
}
