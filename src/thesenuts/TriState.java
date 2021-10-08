package thesenuts;

public class TriState extends NonResident{
    private static final int FULL_NONRESIDENT = 29737;
    private static final int PART_NONRESIDENT = 966;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int INITIAL_TUITION = 0;
    private static final int CREDIT_FULL = 12;
    private static final int CREDIT_OVERLOAD = 16;
    private static final double PART_TIME_DEPRECIATION = .8;
    private static final Boolean NEW_YORK = false;
    private static final Boolean CONNETICUT = true;
    private static final int NY_DISCOUNT = 4000;
    private static final int CT_DISCOUNT = 5000;
    private Boolean triState;
    public TriState(String name, Major major, int creditHours, String triState){
        super(name,major, creditHours);
        if (triState.equals("NY")){
            this.triState = NEW_YORK;
        }
        else{
            this.triState = CONNETICUT;
        }
    }
    @Override
    public void tuitionDue() {
        double tuitionDue = INITIAL_TUITION;
        if (this.creditHours > CREDIT_FULL){
            tuitionDue = FULL_NONRESIDENT + UNIVERSITY_FEE ;
            if (this.creditHours > CREDIT_OVERLOAD){
                tuitionDue += PART_NONRESIDENT * (this.creditHours - 16);
            }
        }
        else{
            tuitionDue = (PART_NONRESIDENT * this.creditHours) + PART_TIME_DEPRECIATION * UNIVERSITY_FEE;
        }
        if (this.triState == NEW_YORK){
            tuitionDue -= NY_DISCOUNT;
        }
        else{
            tuitionDue -= CT_DISCOUNT;
        }
        this.tuitionDue = tuitionDue;
    }
}
