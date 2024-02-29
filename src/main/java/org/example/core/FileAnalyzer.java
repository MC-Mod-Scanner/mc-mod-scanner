package org.example.core;

import org.example.core.util.AllowedFile;
import org.example.core.util.FileUtil;
import org.example.core.warning.Warning;
import org.example.core.warning.WarningManager;
import org.example.core.warning.WarningType;

import java.util.jar.JarEntry;

public class FileAnalyzer {
    public static void analyzeFile(JarEntry entry) {
        if (entry.isDirectory()) {
            return;
        }

        String extension = FileUtil.getFileExtension(entry.getName());

        boolean allowedType = false;
        for(AllowedFile af : FileUtil.ALLOWED_FILES) {
            if (af.getExtension().equals(extension)) {
                allowedType = true;
                long fileSize = entry.getSize() / 1024;
                if (fileSize > af.getMaxSizeKB()) {
                    WarningManager.addWarning(
                            entry.getName(),
                            new Warning(WarningType.LARGE_FILE, fileSize + "KB")
                    );
                    break;
                }
            }
        }

        if (!allowedType) {
            WarningManager.addWarning(
                    entry.getName(),
                    new Warning(WarningType.UNKNOWN_FILE_TYPE, extension)
            );
        }
    }
}
