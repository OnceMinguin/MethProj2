package thesenuts;

public class NonResident extends Student{
    private static final int FULL_NONRESIDENT = 29737;
    private static final int PART_NONRESIDENT = 966;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int INITIAL_TUITION = 0;
    private static final int CREDIT_FULL = 12;
    private static final int CREDIT_OVERLOAD = 16;
    private static final double PART_TIME_DEPRECIATION = .8;
    public NonResident(){

    }
    public NonResident(String name, Major major, int creditHours, String type){

        super(name,major, creditHours, type);
    }
    @Override
    public void tuitionDue() {
        double tuitionDue = INITIAL_TUITION;
        if (this.creditHours >= CREDIT_FULL){
            tuitionDue = FULL_NONRESIDENT + UNIVERSITY_FEE;
            if (this.creditHours > CREDIT_OVERLOAD){
                tuitionDue += PART_NONRESIDENT * (this.creditHours - CREDIT_OVERLOAD);
            }
        }
        else{
            tuitionDue = (PART_NONRESIDENT * this.creditHours) + PART_TIME_DEPRECIATION * UNIVERSITY_FEE;
        }
        this.tuitionDue = tuitionDue - this.tuitionPaid;
    }
}
