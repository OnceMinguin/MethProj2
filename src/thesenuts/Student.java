package thesenuts;
public class Student {
    public int creditHours;
    public Profile profile;
    public double tuitionDue;
    public double tuitionPaid;
    public Date date;
    public String type;
    public Student(){

    }
    public Student (String name, Major major, int creditHours, String type) {
        this.profile = new Profile(name,major);
        this.creditHours = creditHours;
        this.tuitionPaid = 0;
        this.tuitionDue = 0;
        this.date = null;
        this.type = type;
    }
    public void tuitionDue() {
    }
    public String toString(){
        if (date == null){
            return profile.toString() + ":" + creditHours + " credit hours:tuition due:" + tuitionDue +
                    ":total payment:" + tuitionPaid + ":last payment date:--/--/--:" + type;
        }
        return profile.toString() + ":" + creditHours + " credit hours:tuition due:" + tuitionDue +
                ":total payment:" + tuitionPaid + ":last payment date:" + date + ":" + type;
    }
    public boolean alreadyAwarded(){
        return false;
    }
    public void setFinancialAid(double financialAid){
    }
}
