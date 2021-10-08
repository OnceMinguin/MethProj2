package thesenuts;

public class Profile {
    private String name;
    private Major major; //5 majors and 2-charater each: CS, IT, BA, EE, ME
    public Profile(String name, Major major){
        this.name = name;
        this.major = major;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Profile){
            Profile comp = (Profile) obj;
            return this.name.equals(comp.name) && this.major.equals(comp.major);
        }
        return false;
    }
    /**
     * Converts an album to string
     * @return the string form of the album
     */
    @Override
    public String toString() {
        String profile = this.name + ":" + this.major.toString();
        return profile;
    }

}
