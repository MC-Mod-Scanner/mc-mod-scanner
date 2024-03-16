package mc.scanner.core.strings;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;
import java.util.Optional;

public class StringManager {
    private static final LinkedList<ClassStrings> classStrings = new LinkedList<>();

    public static void addString(String key, String string, int nullByteCount) {
        Optional<ClassStrings> cws = classStrings.stream()
                .filter(cw -> key.equals(cw.getClassPath()))
                .findFirst();

        if (cws.isPresent()) {
            if (cws.get().getStrings().stream().noneMatch(string::equals)) {
                cws.get().addString(string, nullByteCount);
            }
        } else {
            ClassStrings newClassStrings = new ClassStrings(key);
            newClassStrings.addString(string, nullByteCount);

            classStrings.add(newClassStrings);
        }
    }
    public static void printJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(classStrings);

            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}