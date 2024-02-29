package org.example.core;

import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.ASM7;

public class ClassAnalyzer extends ClassVisitor{
    private String fileName;
    public ClassAnalyzer(String fileName) {
        super(Opcodes.ASM9);

        this.fileName = fileName;
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
    }

    public void visitSource(String source, String debug) {
    }

    public void visitOuterClass(String owner, String name, String desc) {
    }

    public AnnotationVisitor visitAnnotation(String desc,
         boolean visible) {return null;
    }

    public void visitAttribute(Attribute attr) {
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new ByteCodeAnalyzer(this.fileName);
    }

    public void visitEnd() {
    }
}
