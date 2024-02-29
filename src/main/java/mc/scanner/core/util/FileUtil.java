package mc.scanner.core.util;

import java.util.Arrays;
import java.util.List;

public class FileUtil {
    public static final List<AllowedFile> ALLOWED_FILES = Arrays.asList(
            // TODO make the max size accurate
            new AllowedFile("class", "class", 1024),
            new AllowedFile("json", "json", 1024),
            new AllowedFile("toml", "toml", 1024),
            new AllowedFile("mcmeta", "mcmeta", 1024),
            new AllowedFile("MF", "MF", 1024),
            new AllowedFile("cfg", "cfg", 1024),
            new AllowedFile("ttf", "ttf", 1024),
            new AllowedFile("png", "png", 1024),
            new AllowedFile("jpg", "jpg", 1024),
            new AllowedFile("jpeg", "jpeg", 1024),
            new AllowedFile("html", "html", 1024),
            new AllowedFile("xml", "xml", 1024)
    );


    public static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1 || lastDotIndex == fileName.length() - 1) {
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }
}
