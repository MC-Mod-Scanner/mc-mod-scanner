package mc.scanner.core.code;

public class Warning {
    private final WarningType type;
    private final String info;

    public Warning(WarningType type, String info) {
        this.type = type;
        this.info = info;
    }

    public String getInfo() {
        return this.info;
    }

    public WarningType getType() {
        return this.type;
    }
}
