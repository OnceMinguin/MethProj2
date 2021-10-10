package thesenuts;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {
        private static final int FIRST_PARAMETER = 0;
        private static final int SECOND_PARAMETER = 1;
        private static final int THIRD_PARAMETER = 2;
        private static final int FOURTH_PARAMETER = 3;
        private static final int TOTAL_PARAMETERS = 4;
        private static final int STARTING_CREDITS = 0;
        Roster roster;

        /**
         * Driver for the project, takes in command lines
         */
        public void run() {
                Scanner scanner = new Scanner(System.in);
                roster = new Roster();
                while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        StringTokenizer tokenizer = new StringTokenizer(line, ",");
                        while (tokenizer.hasMoreTokens()) {
                                String command = tokenizer.nextToken();
                                if (command.equals("AR") || command.equals("AN")
                                        || command.equals("AT") || command.equals("AT")) {
                                        addStudent(line, tokenizer);
                                } else if (command.equals("R")) {
                                        removeStudent(line, tokenizer);
                                } else if (command.equals("C")) {
                                        calculateTuition(line, tokenizer);
                                } else if (command.equals("T")) {
                                        payTuition(line, tokenizer);
                                } else if (command.equals("S")) {
                                        studyAbroad(line, tokenizer);
                                } else if (command.equals("F")) {
                                        financialAid(line, tokenizer);
                                } else if ((command.equals("PN") || command.equals("PT")
                                        || command.equals("P")) && !tokenizer.hasMoreTokens()) {
                                        display(line, command);
                                } else if (command.equals("\n")) {
                                        continue;
                                } else {
                                        System.out.println("Invalid command!");
                                }
                        }
                }
        }

        /**
         * Adds student with its respective parameters to the roster
         *
         * @param text
         * @param tokenizer
         */
        private void addStudent(String text, StringTokenizer tokenizer) {
                int counter = FIRST_PARAMETER;
                String name = new String(), major = new String(), state = new String();
                boolean studyAbroad;
                int credits = STARTING_CREDITS;
                while (tokenizer.hasMoreTokens()) {
                        if (counter == FIRST_PARAMETER) {
                                name = tokenizer.nextToken();
                        } else if (counter == SECOND_PARAMETER) {
                                major = tokenizer.nextToken();
                        } else if (counter == THIRD_PARAMETER) {
                                credits = Integer.parseInt(tokenizer.nextToken());
                        } else if (counter == FOURTH_PARAMETER & text.equals("AT")) {
                                state = tokenizer.nextToken();
                                continue;
                        } else if (counter == FOURTH_PARAMETER & text.equals("AI")) {
                                studyAbroad = Boolean.parseBoolean(tokenizer.nextToken());
                                continue;
                        }
                        counter++;
                }
                if (!text.equals("AI") || !text.equals("AT") && counter != THIRD_PARAMETER) {
                        System.out.println("Invalid command");
                }
                Student student;
                major.toLowerCase();
                student = switch (major){
                        case "cs" -> new Student(name, Major.CS, credits);
                        case "it" -> new Student(name, Major.IT, credits);
                        case "ba" -> new Student(name, Major.BA, credits);
                        case "ee" -> new Student(name, Major.EE, credits);
                        case "me" -> new Student(name, Major.ME, credits);
                };
                if (roster.add(student)) {
                        System.out.println(student.toString() + " >> added.");
                } else {
                        System.out.println(student.toString() + " >> is already in the collection.");
                }
        }

        private void removeStudent(String text, StringTokenizer tokenizer) {
                int counter = FIRST_PARAMETER;
                String name = new String(), major = new String();
                int credits = STARTING_CREDITS;
                while (tokenizer.hasMoreTokens()) {
                        if (counter == FIRST_PARAMETER) {
                                name = tokenizer.nextToken();
                        } else if (counter == SECOND_PARAMETER){
                                major = tokenizer.nextToken();
                        } else if (counter == THIRD_PARAMETER) {
                                credits = Integer.parseInt(tokenizer.nextToken());
                        }
                        counter++;
                }
                if (counter != THIRD_PARAMETER){
                        System.out.println("Invalid command!");
                }
                Student student;
                student = switch (major){
                        case "cs" -> new Student(name, Major.CS, credits);
                        case "it" -> new Student(name, Major.IT, credits);
                        case "ba" -> new Student(name, Major.BA, credits);
                        case "ee" -> new Student(name, Major.EE, credits);
                        case "me" -> new Student(name, Major.ME, credits);
                };
                if (roster.remove(student)){
                        System.out.println("Student removed from the roster");
                } else {
                        System.out.println("Student is not in the roster");
                }
        }

        private void calculateTuition(String text, StringTokenizer tokenizer) {

        }

        private void payTuition(String text, StringTokenizer tokenizer) {

        }

        private void studyAbroad(String text, StringTokenizer tokenizer) {

        }

        private void financialAid(String text, StringTokenizer tokenizer) {

        }

        private void display(String text, String command) {

        }
}
