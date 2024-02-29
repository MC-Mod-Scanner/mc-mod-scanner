package mc.scanner;

import mc.scanner.core.JarAnalyzer;
import mc.scanner.core.warning.WarningManager;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];
        JarAnalyzer jarAnalyzer = new JarAnalyzer(fileName);

        jarAnalyzer.analyze();
        warningPrinter();
        WarningManager.printJson();
    }

    private static void warningPrinter() {
        // TODO
        /*
        Map<String, ArrayList<Warning>> warningMap = WarningManager.getWarnings();

        for (Map.Entry<String, ArrayList<Warning>> entry : warningMap.entrySet()) {
            String fileName = entry.getKey();
            ArrayList<Warning> warnings  = entry.getValue();

            for (Warning warning : warnings) {
                System.out.println("[+] warning - " + fileName + ":" + warning.getInfo());
            }
        }
         */
    }

}
