package Model;

public class Genders {
    private int genderId;
    private String genderName;

    public Genders() {
    }

    public Genders(String genderName) {
        this.genderName = genderName;
    }
    
    public Genders(int genderId, String genderName) {
        this.genderId = genderId;
        this.genderName = genderName;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
    @Override
        public String toString() {
            return genderName;  
        }
}
