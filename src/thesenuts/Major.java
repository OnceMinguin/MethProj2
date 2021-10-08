package thesenuts;

public enum Major {
    CS, IT, BA, EE, ME;
    public String toString(Major major){
        if (major.equals(CS)){
            return "CS";
        }
        else if (major.equals(IT)){
            return "IT";
        }
        else if (major.equals(BA)){
            return "BA";
        }
        else if (major.equals(EE)){
            return "EE";
        }
        else if (major.equals(ME)){
            return "ME";
        }
        else{
            return "UNKNOWN";
        }
    }
}
