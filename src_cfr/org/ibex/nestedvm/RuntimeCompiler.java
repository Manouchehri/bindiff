/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.ibex.nestedvm.ClassFileCompiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.RuntimeCompiler$1;
import org.ibex.nestedvm.RuntimeCompiler$SingleClassLoader;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public class RuntimeCompiler {
    public static Class compile(Seekable seekable) {
        return RuntimeCompiler.compile(seekable, null);
    }

    public static Class compile(Seekable seekable, String string) {
        return RuntimeCompiler.compile(seekable, string, null);
    }

    public static Class compile(Seekable seekable, String string, String string2) {
        byte[] arrby;
        String string3 = "nestedvm.runtimecompiled";
        try {
            arrby = RuntimeCompiler.runCompiler(seekable, string3, string, string2, null);
            return new RuntimeCompiler$SingleClassLoader(null).fromBytes(string3, arrby);
        }
        catch (Compiler$Exn var5_5) {
            if (var5_5.getMessage() == null) {
                if (var5_5.getMessage().indexOf("constant pool full") == -1) throw var5_5;
            }
            arrby = RuntimeCompiler.runCompiler(seekable, string3, string, string2, "lessconstants");
            return new RuntimeCompiler$SingleClassLoader(null).fromBytes(string3, arrby);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static byte[] runCompiler(Seekable seekable, String string, String string2, String string3, String string4) {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ClassFileCompiler classFileCompiler = new ClassFileCompiler(seekable, string, (OutputStream)byteArrayOutputStream);
            classFileCompiler.parseOptions("nosupportcall,maxinsnpermethod=256");
            classFileCompiler.setSource(string3);
            if (string2 != null) {
                classFileCompiler.parseOptions(string2);
            }
            if (string4 != null) {
                classFileCompiler.parseOptions(string4);
            }
            classFileCompiler.go();
        }
        finally {
            seekable.seek(0);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] arrstring) {
        if (arrstring.length == 0) {
            System.err.println("Usage: RuntimeCompiler mipsbinary");
            System.exit(1);
        }
        UnixRuntime unixRuntime = (UnixRuntime)RuntimeCompiler.compile(new Seekable$File(arrstring[0]), "unixruntime").newInstance();
        System.err.println(new StringBuffer().append("Instansiated: ").append(unixRuntime).toString());
        System.exit(UnixRuntime.runAndExec(unixRuntime, arrstring));
    }

    private RuntimeCompiler() {
    }
}

