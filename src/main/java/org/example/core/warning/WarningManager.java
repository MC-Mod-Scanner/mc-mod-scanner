package org.example.core.warning;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class WarningManager {
    //private static final Map<String, ArrayList<Warning>> warnings = new HashMap<>();
    private static final LinkedList<ClassWarnings> warnings = new LinkedList<>();

    public static void addWarning(String key, Warning warning) {
        Optional<ClassWarnings> cws = warnings.stream()
                .filter(cw -> key.equals(cw.getClassPath()))
                .findFirst();

        if (cws.isPresent()) {
            if (!cws.get().getWarnings().stream().anyMatch(w -> w.getType().equals(warning.getType()))) {
                cws.get().addWarning(warning);
            }
        } else {
            ClassWarnings newClassWarnings = new ClassWarnings(key);
            newClassWarnings.addWarning(warning);
            warnings.add(newClassWarnings);
        }
    }

    public static void addWarningTop(String key, Warning warning) {
        Optional<ClassWarnings> cws = warnings.stream()
                .filter(cw -> key.equals(cw.getClassPath()))
                .findFirst();

        if (cws.isPresent()) {
            if (!cws.get().getWarnings().stream().anyMatch(w -> w.getType().equals(warning.getType()))) {
                cws.get().addWarning(warning);
            }
        } else {
            ClassWarnings newClassWarnings = new ClassWarnings(key);
            newClassWarnings.addWarning(warning);
            warnings.addFirst(newClassWarnings);
        }
    }

    public static void printJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert the warnings map to JSON
            String json = objectMapper.writeValueAsString(warnings);

            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
}

class ClassWarnings {
    private final String classPath;
    private final List<Warning> warnings;

    public ClassWarnings(String classPath) {
        this.classPath = classPath;
        this.warnings = new ArrayList<>();
    }

    public void addWarning(Warning warning) {
        this.warnings.add(warning);
    }

    public List<Warning> getWarnings() {
        return this.warnings;
    }

    public String getClassPath() {
        return this.classPath;
    }
}