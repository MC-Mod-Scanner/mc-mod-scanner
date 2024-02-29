package org.example;

import org.example.core.ClassAnalyzer;
import org.example.core.JarAnalyzer;
import org.example.core.warning.Warning;
import org.example.core.warning.WarningManager;
import org.objectweb.asm.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

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
