package thesenuts;
public class Student {
    public int creditHours;
    public Profile profile;
    public double tuitionDue;
    public Student(){

    }
    public Student (String name, Major major, int creditHours) {
        this.profile = new Profile(name,major);
        this.creditHours = creditHours;
    }
    public void tuitionDue() {
    }
    public String toString(){
        return "";
    }
}
