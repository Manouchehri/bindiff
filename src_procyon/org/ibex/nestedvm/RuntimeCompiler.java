package org.ibex.nestedvm;

import java.io.*;
import org.ibex.nestedvm.util.*;

public class RuntimeCompiler
{
    public static Class compile(final Seekable seekable) {
        return compile(seekable, null);
    }
    
    public static Class compile(final Seekable seekable, final String s) {
        return compile(seekable, s, null);
    }
    
    public static Class compile(final Seekable seekable, final String s, final String s2) {
        final String s3 = "nestedvm.runtimecompiled";
        byte[] array;
        try {
            array = runCompiler(seekable, s3, s, s2, null);
        }
        catch (Compiler$Exn compiler$Exn) {
            if (compiler$Exn.getMessage() == null && compiler$Exn.getMessage().indexOf("constant pool full") == -1) {
                throw compiler$Exn;
            }
            array = runCompiler(seekable, s3, s, s2, "lessconstants");
        }
        return new RuntimeCompiler$SingleClassLoader((RuntimeCompiler$1)null).fromBytes(s3, array);
    }
    
    private static byte[] runCompiler(final Seekable seekable, final String s, final String s2, final String source, final String s3) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            final ClassFileCompiler classFileCompiler = new ClassFileCompiler(seekable, s, byteArrayOutputStream);
            classFileCompiler.parseOptions("nosupportcall,maxinsnpermethod=256");
            classFileCompiler.setSource(source);
            if (s2 != null) {
                classFileCompiler.parseOptions(s2);
            }
            if (s3 != null) {
                classFileCompiler.parseOptions(s3);
            }
            classFileCompiler.go();
        }
        finally {
            seekable.seek(0);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
    
    public static void main(final String[] array) {
        if (array.length == 0) {
            System.err.println("Usage: RuntimeCompiler mipsbinary");
            System.exit(1);
        }
        final UnixRuntime unixRuntime = compile(new Seekable$File(array[0]), "unixruntime").newInstance();
        System.err.println("Instansiated: " + unixRuntime);
        System.exit(UnixRuntime.runAndExec(unixRuntime, array));
    }
}
