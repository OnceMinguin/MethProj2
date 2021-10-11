package thesenuts;

public class International extends Student{
        private static final int FULL_TIME = 29737;
        private static final int UNIVERSITY_FEE = 3268;
        private static final int INITIAL_TUITION = 0;
        private static final int ADDITIIONAL_FEE = 2650;
        private static final int CREDIT_FULL = 12;
        private static final int CREDIT_OVERLOAD = 16;
        private static final int EXTRA_CREDIT_EXPENSE = 966;
        private Boolean studyAbroad;
        public International(String name, Major major, int creditHours, boolean studyAbroad, String type){
            super(name,major, creditHours, type);
            this.studyAbroad = studyAbroad;
        }
        @Override
        public void tuitionDue() {
            double tuitionDue = INITIAL_TUITION;
            if (!studyAbroad){
                tuitionDue = FULL_TIME + UNIVERSITY_FEE + ADDITIIONAL_FEE;
                if (this.creditHours > CREDIT_OVERLOAD){
                    tuitionDue += EXTRA_CREDIT_EXPENSE * (this.creditHours - 16);
                }
            }
            else{
                tuitionDue = UNIVERSITY_FEE + ADDITIIONAL_FEE;
            }
            this.tuitionDue = tuitionDue - this.tuitionPaid;
        }
}
