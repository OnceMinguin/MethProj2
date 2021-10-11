package thesenuts;

public class Roster {
    private static final int NOT_FOUND = -1;
    private static final int START = 0;
    private static final int GROWTH_CONSTANT = 4;
    private static final int UNIVERSITY_FEE = 3268;
    private static final int ADDITIONAL_FEE = 2650;
    private static final int BEFORE = 0;
    private static final int INVALID_DATE = 0;
    private static final int INVALID_PAYMENT= 1;
    private static final int OVER_PAY = 2;
    private static final int VALID_PAYMENT = 3;
    private static final int STUDENT_NOT_FOUND = 0;
    private static final int PART_TIME_INELIGIBLE = 1;
    private static final int ALREADY_AWARDED = 2;
    private static final int NOT_RESIDENT = 3;
    private static final int AWARD_ELIGIBLE = 4;
    private static final int INVALID_AWARD = 5;
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i].profile.equals(student.profile)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        Student[] newRoster = new Student[size + 4];
        if (size >= START) {
            int index = START;
            for (int i = 0; i < size; i++) {
                newRoster[i] = roster[i];
            }
            roster = newRoster;
            //System.arraycopy(roster, 0, newroster, 0, size);
        }
    }

    public boolean add(Student student) {
        if (size == 0) {
            roster = new Student[4];
        }
        if (find(student) != NOT_FOUND) {
            return false;
        }
        if (size % 4 == 0) {
            grow();
        }

        roster[size++] = student;
        return true;
    }

    public boolean remove(Student student) {
        int index = find(student);
        if (index == NOT_FOUND) {
            return false;
        }
        Student[] removedStudent = new Student[roster.length];
        int counter = START;
        for (int i = 0; i < size ; i++){
            if (i != index) {
                removedStudent[counter] = roster[i];
                counter++;
            }
        }
        roster = removedStudent;
        size--;
        return true;
    }

    public void calculateTuition(){
        for (int i = 0; roster[i] != null; i++){
            roster[i].tuitionDue();
        }
    }


    public int payTuition(Student student, double payment, Date date){
        int index = find(student);
        if (!date.isValid()){
            return INVALID_DATE;
        } else if (payment < 0){
            return INVALID_PAYMENT;
        }
        if (payment <= roster[index].tuitionDue && payment > 0){
            roster[index].tuitionDue = roster[index].tuitionDue - payment;
            roster[index].tuitionPaid += payment;
            roster[index].date = date;
        } else{
            if (payment > roster[index].tuitionDue){
                return OVER_PAY;
            }
        }
        return VALID_PAYMENT;
    }

    public int payAid(Student student, double financialAid){
        int index = find(student);
        if (index == -1){
            return STUDENT_NOT_FOUND;
        }
        if (!roster[index].type.equals("resident")){
            return NOT_RESIDENT;
        }
        if (roster[index].alreadyAwarded()){
            return ALREADY_AWARDED;
        }
        if (roster[index].creditHours < 12){
            return PART_TIME_INELIGIBLE;
        }
        if (financialAid <= 10000 && financialAid > 0){
            roster[index].tuitionDue = roster[index].tuitionDue - financialAid;
            roster[index].setFinancialAid(financialAid);
            return AWARD_ELIGIBLE;
        } else{
            return INVALID_AWARD;
        }
    }

    public boolean studyAbroad(Student student, Boolean studyAbroad) {
        int index = find(student);
        if (index == -1){
            return false;
        }
        if (studyAbroad) {
            if (roster[index].creditHours > 12) {
                roster[index].creditHours = 12;
            }
            roster[index].tuitionPaid = 0;
            roster[index].date = null;
            roster[index].tuitionDue = ADDITIONAL_FEE + UNIVERSITY_FEE;
        } else {
            return false;
        }
        return true;
    }

    public void print() {
        for (int i = 0; i<size; i++){
            System.out.println(roster[i].toString());
        }
    } //display the list without specifying the order

    /**
     * prints students who have paid by payment date
     */
    public void printByPaymentDate() {
        int totalPaid = START;
        Student newRoster[] = new Student[size];;
        for (int i = 0; i < size; i++) {
            if (roster[i].date == null){
                continue;
            } else {
                newRoster[totalPaid] = roster[i];
                totalPaid++;
            }
        }
        for (int i = 0; i < totalPaid - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < totalPaid; j++) {
                if (newRoster[j].date.compareTo(newRoster[minIndex].date) < BEFORE) {
                        minIndex = j;
                }
            }
                Student temp = newRoster[minIndex];
                newRoster[minIndex] = newRoster[i];
                newRoster[i] = temp;
        }
        for (int i = 0; i < totalPaid; i++){
            System.out.println(newRoster[i].toString());
        }
    }

    /**
     * prints album by Genre
     */
    public void printByName() {
        for (int i = 0; i < size - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < size; j++){
                if (roster[j].profile.getName().compareTo(roster[minIndex].profile.getName()) < BEFORE ){
                    minIndex = j;
                }
            }
            Student temp = roster[minIndex];
            roster[minIndex] = roster[i];
            roster[i] = temp;
        }
        for (int i = 0; i < size; i++){
            System.out.println(roster[i].toString());
        }
    }

    /**
     * checks if the roster is empty
     * @return true if there is no albums and false otherwise
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}

