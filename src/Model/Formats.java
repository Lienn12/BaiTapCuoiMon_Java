package Model;

public class Formats {
    private int formatId;
    private String formatName;

    public Formats() {
    }

    public Formats(int formatId, String formatName) {
        this.formatId = formatId;
        this.formatName = formatName;
    }

    public int getFormatId() {
        return formatId;
    }

    public void setFormatId(int formatId) {
        this.formatId = formatId;
    }

    public String getFormatName() {
        return formatName;
    }

    public void setFormatName(String formatName) {
        this.formatName = formatName;
    }
    @Override
    public String toString() {
        return formatName;  
    }
}

