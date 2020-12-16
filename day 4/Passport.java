import java.util.HashMap;

public class Passport {

    protected static final String[] requiredPassportFields = {"byr", "iyr", "eyr", "hgt",
    "hcl", "ecl", "pid"};
    public boolean isValid = false;
    private HashMap<String, String> map = new HashMap<>();

    
    public Passport(String rawData) {
        String[] fields = AoCFileReader.splitBySpacesAndLineSeparators(rawData);
        if (!this.containsRequiredFields(rawData)) {
            isValid = false;
            return;
        }
        for (String field : fields) {
            for(String requiredField : requiredPassportFields) {
                if (field.contains(requiredField)) {
                    String fieldValue = field.substring(requiredField.length() + 1, field.length());
                    map.put(requiredField, fieldValue);
                }
            }
        }
        isValid = this.areFieldsValid();
    }

    public boolean areFieldsValid() {
        return (isByrValid() &&
        isIyrValid() &&
        isEyrValid() &&
        isHgtValid() && 
        isHclValid() &&
        isEclValid() &&
        isPidValid());
    }

    private boolean containsRequiredFields(String rawData) {
        for (String requiredField : requiredPassportFields) {
            if (!rawData.contains(requiredField)) {
                return false;
            }
        }
        return true;
    }
    private boolean isByrValid() {
        int byrValue = Integer.parseInt(map.get("byr"));
        return this.isInRange(byrValue, 1920, 2002);
    }
    private boolean isIyrValid() {
        int iyrValue = Integer.parseInt(map.get("iyr"));
        return this.isInRange(iyrValue, 2010, 2020);
    }
    private boolean isEyrValid() {
        int eyrValue = Integer.parseInt(map.get("eyr"));
        return this.isInRange(eyrValue, 2020, 2030);
    }
    private boolean isHgtValid() {
        String hgtValue = map.get("hgt");
        if (hgtValue.contains("cm")) {
            return isInRange(Integer.parseInt(hgtValue.substring(0, hgtValue.length() - 2)), 150, 193);    
        }
        if (hgtValue.contains("in")) {
            return isInRange(Integer.parseInt(hgtValue.substring(0, hgtValue.length() - 2)), 59, 76);
        }
        return false;
    }
    private boolean isHclValid() {
        String hclValue = map.get("hcl");
        return hclValue.matches("[#]([0-9a-f]{6})");
    }
    private boolean isEclValid() {
        String[] validEyeColors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        String eclValue = map.get("ecl");
        for (String validEyeColor : validEyeColors) {
            if (eclValue.contains(validEyeColor)) {
                return true;
            }
        }
        return false;
    }
    private boolean isPidValid() {
        String pidValue = map.get("pid");
        return pidValue.matches("[0-9]{9}");
    }
    
    private boolean isInRange(int value, int lowerBound, int upperBound) {
        return (value >= lowerBound && value <= upperBound);
    }
}
