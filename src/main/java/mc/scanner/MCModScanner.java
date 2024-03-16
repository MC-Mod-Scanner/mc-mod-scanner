package mc.scanner;

import mc.scanner.core.JarAnalyzer;
import mc.scanner.core.code.WarningManager;
import mc.scanner.core.strings.StringManager;

public class MCModScanner {
    public static ScanMode SCAN_MODE = ScanMode.CODE;

    public static void main(String[] args) {
        String fileName = "";

        if (args.length == 0) {
            fileName = "./bedtrap.jar";
        } else {
            if (args[0] != null) {
                fileName = args[0];
            }

            if (args[1] != null) {
                try {
                    SCAN_MODE = ScanMode.valueOf(args[1].toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid mode argument: " + e);
                }
            }
        }

        JarAnalyzer jarAnalyzer = new JarAnalyzer(fileName);
        jarAnalyzer.analyze();

        switch (SCAN_MODE) {
            case CODE -> WarningManager.printJson();
            case STRING -> StringManager.printJson();
        }
    }
}
