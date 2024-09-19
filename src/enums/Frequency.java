package enums;

public enum Frequency {
    DAILY("DAILY"), 
    WEEKLY("WEEKLY"), 
    MONTHLY("MONTHLY");
    
    private String frequency;
    
    Frequency(String frequency) {
        this.frequency = frequency;
    }
    public String getFrequency() {
        return this.frequency;
    }
}
