package thesenuts;

public class Roster {
    private static final int NOT_FOUND = -1;
    private static final int START = 0;
    private static final int GROWTH_CONSTANT = 4;
    private Student[] roster;
    private int size; //keep track of the number of students in the roster

    private int find(Student student) {
        for (int i = 0; i < size; i++) {
            if (roster[i].equals(student)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        Student[] newRoster = new Student[size + 4];
        if (size >= START) {
            int index = START;
            while (this.roster[index] != null) {
                newRoster[index] = roster[index];
            }
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
}

