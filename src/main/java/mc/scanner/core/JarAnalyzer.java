package mc.scanner.core;

import mc.scanner.core.util.FileUtil;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarAnalyzer {
    JarFile jar;
    List<JarEntry> entries;

    public JarAnalyzer(String fileName) {
        try {
            this.jar = new JarFile(fileName);
            this.entries = Collections.list(this.jar.entries());
        } catch (IOException exception) {
            System.exit(1);
        }
    }

    public void analyze() {
        this.analyzeFiles();
        this.analyzeClasses();
    }

    public long extractedSizeKB() {
        return entries.stream()
                .mapToLong(JarEntry::getSize)
                .sum() / 1024;
    }

    public void analyzeFiles() {
        entries.stream()
                .filter(entry -> !entry.isDirectory())
                .forEach(FileAnalyzer::analyzeFile);
    }

    public void analyzeClasses() {
        entries.stream()
                .filter(entry -> !entry.isDirectory())
                .filter(entry -> FileUtil.getFileExtension(entry.getName()).equals("class"))
                .forEach(entry -> {
                    try {
                        InputStream classStream = jar.getInputStream(entry);
                        //ByteCodeDumper.dumpByteCode(classStream);
                        ClassReader classReader = new ClassReader(classStream);
                        classReader.accept(new ClassAnalyzer(entry.getName()), 0);
                    } catch(IOException exception) {
                        // TODO
                    }
                });
    }
}
