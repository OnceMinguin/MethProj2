package thesenuts;

public class Resident extends Student{
    private static final int FULL_RESIDENT = 12536;
    private static final int PART_RESIDENT = 404;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int INITIAL_TUITION = 0;
    private static final int CREDIT_FULL = 12;
    private static final int CREDIT_OVERLOAD = 16;
    private static final double PART_TIME_DEPRECIATION = .8;
    private static final int ADDITIONAL_FEE = 2650;
    private static double financialAid;
    public Resident(String name, Major major, int creditHours, String type){
        super(name,major, creditHours, type);
        this.financialAid = 0;
    }
    @Override
    public void tuitionDue() {
        double tuitionDue = INITIAL_TUITION;
        if (this.creditHours >= CREDIT_FULL){
            tuitionDue = FULL_RESIDENT + UNIVERSITY_FEE;
            if (this.creditHours > CREDIT_OVERLOAD){
                tuitionDue += PART_RESIDENT * (this.creditHours - 16);
            }
        }
        else{
            tuitionDue = (PART_RESIDENT * this.creditHours) + PART_TIME_DEPRECIATION * UNIVERSITY_FEE;
        }
        this.tuitionDue = tuitionDue - this.financialAid - this.tuitionPaid;

    }
    @Override
    public boolean alreadyAwarded(){
        if (this.financialAid > 0){
            return true;
        }
        return false;
    }
    @Override
    public void setFinancialAid(double financialAid){
        this.financialAid = financialAid;
    }
}
