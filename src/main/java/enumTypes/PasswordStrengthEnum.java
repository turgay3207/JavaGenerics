package enumTypes;

public enum PasswordStrengthEnum {

    LOW(10),
    MEDIUM(20),
    HIGH(30);

    private final int level;
    //getter

    public int getLevel() {
        return level;
    }

    //constructor-private
    PasswordStrengthEnum(int level) {
        this.level = level;
    }
}
