package mc.scanner.core.util;

public class AllowedFile {
    private final String extension;
    private final String tikaName;
    private final long maxSizeKB;

    public AllowedFile(String extension, String tikaName, long maxSizeKB) {
        this.extension = extension;
        this.tikaName = tikaName;
        this.maxSizeKB = maxSizeKB;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getTikaName() {
        return this.tikaName;
    }

    public long getMaxSizeKB() {
        return this.maxSizeKB;
    }
}
