/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.ibex.nestedvm.ClassFileCompiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.Compiler$Option;
import org.ibex.nestedvm.JavaSourceCompiler;
import org.ibex.nestedvm.Registers;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFHeader;
import org.ibex.nestedvm.util.ELF$ELFIdent;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public abstract class Compiler
implements Registers {
    ELF elf;
    final String fullClassName;
    String source = "unknown.mips.binary";
    boolean fastMem = true;
    int maxInsnPerMethod = 128;
    int maxBytesPerMethod;
    int methodMask;
    int methodShift;
    boolean pruneCases = true;
    boolean assumeTailCalls = true;
    boolean debugCompiler = false;
    boolean printStats = false;
    boolean runtimeStats = false;
    boolean supportCall = true;
    boolean nullPointerCheck = false;
    String runtimeClass = "org.ibex.nestedvm.Runtime";
    String hashClass = "java.util.Hashtable";
    boolean unixRuntime;
    boolean lessConstants;
    boolean singleFloat;
    int pageSize = 4096;
    int totalPages = 65536;
    int pageShift;
    boolean onePage;
    Hashtable jumpableAddresses;
    ELF$Symbol userInfo;
    ELF$Symbol gp;
    private boolean used;
    private static String[] options = new String[]{"fastMem", "Enable fast memory access - RuntimeExceptions will be thrown on faults", "nullPointerCheck", "Enables checking at runtime for null pointer accessses (slows things down a bit, only applicable with fastMem)", "maxInsnPerMethod", "Maximum number of MIPS instructions per java method (128 is optimal with Hotspot)", "pruneCases", "Remove unnecessary case 0xAABCCDD blocks from methods - may break some weird code", "assumeTailCalls", "Assume the JIT optimizes tail calls", "optimizedMemcpy", "Use an optimized java version of memcpy where possible", "debugCompiler", "Output information in the generated code for debugging the compiler - will slow down generated code significantly", "printStats", "Output some useful statistics about the compilation", "runtimeStats", "Keep track of some statistics at runtime in the generated code - will slow down generated code significantly", "supportCall", "Keep a stripped down version of the symbol table in the generated code to support the call() method", "runtimeClass", "Full classname of the Runtime class (default: Runtime) - use this is you put Runtime in a package", "hashClass", "Full classname of a Hashtable class (default: java.util.HashMap) - this must support get() and put()", "unixRuntime", "Use the UnixRuntime (has support for fork, wai, du, pipe, etc)", "pageSize", "The page size (must be a power of two)", "totalPages", "Total number of pages (total mem = pageSize*totalPages, must be a power of two)", "onePage", "One page hack (FIXME: document this better)", "lessConstants", "Use less constants at the cost of speed (FIXME: document this better)", "singleFloat", "Support single precision (32-bit) FP ops only"};
    static Class class$org$ibex$nestedvm$Compiler;
    static Class class$java$lang$String;

    public void setSource(String string) {
        this.source = string;
    }

    void maxInsnPerMethodInit() {
        if ((this.maxInsnPerMethod & this.maxInsnPerMethod - 1) != 0) {
            throw new Compiler$Exn("maxBytesPerMethod is not a power of two");
        }
        this.maxBytesPerMethod = this.maxInsnPerMethod * 4;
        this.methodMask = ~ (this.maxBytesPerMethod - 1);
        while (this.maxBytesPerMethod >>> this.methodShift != 1) {
            ++this.methodShift;
        }
    }

    void pageSizeInit() {
        if ((this.pageSize & this.pageSize - 1) != 0) {
            throw new Compiler$Exn("pageSize not a multiple of two");
        }
        if ((this.totalPages & this.totalPages - 1) != 0) {
            throw new Compiler$Exn("totalPages not a multiple of two");
        }
        while (this.pageSize >>> this.pageShift != 1) {
            ++this.pageShift;
        }
    }

    private static void usage() {
        System.err.println("Usage: java Compiler [-outfile output.java] [-o options] [-dumpoptions] <classname> <binary.mips>");
        System.err.println("-o takes mount(8) like options and can be specified multiple times");
        System.err.println("Available options:");
        int n2 = 0;
        do {
            if (n2 >= options.length) {
                System.exit(1);
                return;
            }
            System.err.print(new StringBuffer().append(options[n2]).append(": ").append(Compiler.wrapAndIndent(options[n2 + 1], 16 - options[n2].length(), 18, 62)).toString());
            n2 += 2;
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] arrstring) {
        String string = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        boolean bl2 = false;
        int n2 = 0;
        while (arrstring.length - n2 > 0) {
            if (arrstring[n2].equals("-outfile")) {
                if (++n2 == arrstring.length) {
                    Compiler.usage();
                }
                string = arrstring[n2];
            } else if (arrstring[n2].equals("-d")) {
                if (++n2 == arrstring.length) {
                    Compiler.usage();
                }
                string2 = arrstring[n2];
            } else if (arrstring[n2].equals("-outformat")) {
                if (++n2 == arrstring.length) {
                    Compiler.usage();
                }
                string6 = arrstring[n2];
            } else if (arrstring[n2].equals("-o")) {
                if (++n2 == arrstring.length) {
                    Compiler.usage();
                }
                if (string3 == null || string3.length() == 0) {
                    string3 = arrstring[n2];
                } else if (arrstring[n2].length() != 0) {
                    string3 = new StringBuffer().append(string3).append(",").append(arrstring[n2]).toString();
                }
            } else if (arrstring[n2].equals("-dumpoptions")) {
                bl2 = true;
            } else if (string4 == null) {
                string4 = arrstring[n2];
            } else if (string5 == null) {
                string5 = arrstring[n2];
            } else {
                Compiler.usage();
            }
            ++n2;
        }
        Compiler.usage();
        Seekable$File seekable$File = new Seekable$File(string5);
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        Compiler compiler = null;
        if (string6 == null || string6.equals("class")) {
            if (string != null) {
                fileOutputStream = new FileOutputStream(string);
                compiler = new ClassFileCompiler((Seekable)seekable$File, string4, (OutputStream)fileOutputStream);
            } else if (string2 != null) {
                File file = new File(string2);
                if (!file.isDirectory()) {
                    System.err.println(new StringBuffer().append(string2).append(" doesn't exist or is not a directory").toString());
                    System.exit(1);
                }
                compiler = new ClassFileCompiler((Seekable)seekable$File, string4, file);
            } else {
                System.err.println("Refusing to write a classfile to stdout - use -outfile foo.class");
                System.exit(1);
            }
        } else if (string6.equals("javasource") || string6.equals("java")) {
            outputStreamWriter = string == null ? new OutputStreamWriter(System.out) : new FileWriter(string);
            compiler = new JavaSourceCompiler(seekable$File, string4, outputStreamWriter);
        } else {
            System.err.println(new StringBuffer().append("Unknown output format: ").append(string6).toString());
            System.exit(1);
        }
        compiler.parseOptions(string3);
        compiler.setSource(string5);
        if (bl2) {
            System.err.println("== Options ==");
            for (int i2 = 0; i2 < options.length; i2 += 2) {
                System.err.println(new StringBuffer().append(options[i2]).append(": ").append(compiler.getOption(options[i2]).get()).toString());
            }
            System.err.println("== End Options ==");
        }
        try {
            compiler.go();
            return;
        }
        catch (Compiler$Exn var13_15) {
            System.err.println(new StringBuffer().append("Compiler Error: ").append(var13_15.getMessage()).toString());
            System.exit(1);
            return;
        }
        finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public Compiler(Seekable seekable, String string) {
        this.fullClassName = string;
        this.elf = new ELF(seekable);
        if (this.elf.header.type != 2) {
            throw new IOException("Binary is not an executable");
        }
        if (this.elf.header.machine != 8) {
            throw new IOException("Binary is not for the MIPS I Architecture");
        }
        if (this.elf.ident.data == 2) return;
        throw new IOException("Binary is not big endian");
    }

    abstract void _go();

    public void go() {
        if (this.used) {
            throw new RuntimeException("Compiler instances are good for one shot only");
        }
        this.used = true;
        if (this.onePage && this.pageSize <= 4096) {
            this.pageSize = 4194304;
        }
        if (this.nullPointerCheck && !this.fastMem) {
            throw new Compiler$Exn("fastMem must be enabled for nullPointerCheck to be of any use");
        }
        if (this.onePage && !this.fastMem) {
            throw new Compiler$Exn("fastMem must be enabled for onePage to be of any use");
        }
        if (this.totalPages == 1 && !this.onePage) {
            throw new Compiler$Exn("totalPages == 1 and onePage is not set");
        }
        if (this.onePage) {
            this.totalPages = 1;
        }
        this.maxInsnPerMethodInit();
        this.pageSizeInit();
        ELF$Symtab eLF$Symtab = this.elf.getSymtab();
        if (eLF$Symtab == null) {
            throw new Compiler$Exn("Binary has no symtab (did you strip it?)");
        }
        this.userInfo = eLF$Symtab.getGlobalSymbol("user_info");
        this.gp = eLF$Symtab.getGlobalSymbol("_gp");
        if (this.gp == null) {
            throw new Compiler$Exn("no _gp symbol (did you strip the binary?)");
        }
        if (this.pruneCases) {
            this.jumpableAddresses = new Hashtable<K, V>();
            this.jumpableAddresses.put(new Integer(this.elf.header.entry), Boolean.TRUE);
            ELF$SHeader eLF$SHeader = this.elf.sectionWithName(".text");
            if (eLF$SHeader == null) {
                throw new Compiler$Exn("No .text segment");
            }
            this.findBranchesInSymtab(eLF$Symtab, this.jumpableAddresses);
            for (int i2 = 0; i2 < this.elf.sheaders.length; ++i2) {
                ELF$SHeader eLF$SHeader2 = this.elf.sheaders[i2];
                String string = eLF$SHeader2.name;
                if (eLF$SHeader2.addr == 0 || !string.equals(".data") && !string.equals(".sdata") && !string.equals(".rodata") && !string.equals(".ctors") && !string.equals(".dtors")) continue;
                this.findBranchesInData(new DataInputStream(eLF$SHeader2.getInputStream()), eLF$SHeader2.size, this.jumpableAddresses, eLF$SHeader.addr, eLF$SHeader.addr + eLF$SHeader.size);
            }
            this.findBranchesInText(eLF$SHeader.addr, new DataInputStream(eLF$SHeader.getInputStream()), eLF$SHeader.size, this.jumpableAddresses);
        }
        if (this.unixRuntime && this.runtimeClass.startsWith("org.ibex.nestedvm.")) {
            this.runtimeClass = "org.ibex.nestedvm.UnixRuntime";
        }
        int n2 = 0;
        do {
            if (n2 >= this.elf.sheaders.length) {
                this._go();
                return;
            }
            String string = this.elf.sheaders[n2].name;
            if (!((this.elf.sheaders[n2].flags & 2) == 0 || string.equals(".text") || string.equals(".data") || string.equals(".sdata") || string.equals(".rodata") || string.equals(".ctors") || string.equals(".dtors") || string.equals(".bss") || string.equals(".sbss"))) {
                throw new Compiler$Exn(new StringBuffer().append("Unknown section: ").append(string).toString());
            }
            ++n2;
        } while (true);
    }

    private void findBranchesInSymtab(ELF$Symtab eLF$Symtab, Hashtable hashtable) {
        ELF$Symbol[] arreLF$Symbol = eLF$Symtab.symbols;
        int n2 = 0;
        int n3 = 0;
        do {
            if (n3 >= arreLF$Symbol.length) {
                if (!this.printStats) return;
                System.err.println(new StringBuffer().append("Found ").append(n2).append(" additional possible branch targets in Symtab").toString());
                return;
            }
            ELF$Symbol eLF$Symbol = arreLF$Symbol[n3];
            if (eLF$Symbol.type == 2 && hashtable.put(new Integer(eLF$Symbol.addr), Boolean.TRUE) == null) {
                ++n2;
            }
            ++n3;
        } while (true);
    }

    private void findBranchesInText(int n2, DataInputStream dataInputStream, int n3, Hashtable hashtable) {
        int n4 = n3 / 4;
        int n5 = n2;
        int n6 = 0;
        int[] arrn = new int[32];
        int[] arrn2 = new int[32];
        int n7 = 0;
        do {
            if (n7 >= n4) {
                dataInputStream.close();
                if (!this.printStats) return;
                System.err.println(new StringBuffer().append("Found ").append(n6).append(" additional possible branch targets in Text segment").toString());
                return;
            }
            int n8 = dataInputStream.readInt();
            int n9 = n8 >>> 26 & 255;
            int n10 = n8 >>> 21 & 31;
            int n11 = n8 >>> 16 & 31;
            int n12 = n8 << 16 >> 16;
            int n13 = n8 & 65535;
            int n14 = n12;
            int n15 = n8 & 67108863;
            int n16 = n8 & 63;
            block0 : switch (n9) {
                case 0: {
                    switch (n16) {
                        case 9: {
                            if (hashtable.put(new Integer(n5 + 8), Boolean.TRUE) != null) break;
                            ++n6;
                            break block0;
                        }
                        case 12: {
                            if (hashtable.put(new Integer(n5 + 4), Boolean.TRUE) != null) break;
                            ++n6;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (n11) {
                        case 16: 
                        case 17: {
                            if (hashtable.put(new Integer(n5 + 8), Boolean.TRUE) == null) {
                                ++n6;
                            }
                        }
                        case 0: 
                        case 1: {
                            if (hashtable.put(new Integer(n5 + n14 * 4 + 4), Boolean.TRUE) != null) break;
                            ++n6;
                        }
                    }
                    break;
                }
                case 3: {
                    if (hashtable.put(new Integer(n5 + 8), Boolean.TRUE) == null) {
                        ++n6;
                    }
                }
                case 2: {
                    if (hashtable.put(new Integer(n5 & -268435456 | n15 << 2), Boolean.TRUE) != null) break;
                    ++n6;
                    break;
                }
                case 4: 
                case 5: 
                case 6: 
                case 7: {
                    if (hashtable.put(new Integer(n5 + n14 * 4 + 4), Boolean.TRUE) != null) break;
                    ++n6;
                    break;
                }
                case 9: {
                    if (n5 - arrn2[n10] > 128) break;
                    int n17 = (arrn[n10] << 16) + n12;
                    if ((n17 & 3) == 0 && n17 >= n2 && n17 < n2 + n3 && hashtable.put(new Integer(n17), Boolean.TRUE) == null) {
                        ++n6;
                    }
                    if (n11 != n10) break;
                    arrn2[n10] = 0;
                    break;
                }
                case 15: {
                    arrn[n11] = n13;
                    arrn2[n11] = n5;
                    break;
                }
                case 17: {
                    switch (n10) {
                        case 8: {
                            if (hashtable.put(new Integer(n5 + n14 * 4 + 4), Boolean.TRUE) != null) break block0;
                            ++n6;
                        }
                    }
                }
            }
            ++n7;
            n5 += 4;
        } while (true);
    }

    private void findBranchesInData(DataInputStream dataInputStream, int n2, Hashtable hashtable, int n3, int n4) {
        int n5 = n2 / 4;
        int n6 = 0;
        int n7 = 0;
        do {
            if (n7 >= n5) {
                dataInputStream.close();
                if (n6 <= 0) return;
                if (!this.printStats) return;
                System.err.println(new StringBuffer().append("Found ").append(n6).append(" additional possible branch targets in Data segment").toString());
                return;
            }
            int n8 = dataInputStream.readInt();
            if ((n8 & 3) == 0 && n8 >= n3 && n8 < n4 && hashtable.put(new Integer(n8), Boolean.TRUE) == null) {
                ++n6;
            }
            ++n7;
        } while (true);
    }

    static final String toHex(int n2) {
        return new StringBuffer().append("0x").append(Long.toString((long)n2 & 0xFFFFFFFFL, 16)).toString();
    }

    static final String toHex8(int n2) {
        String string = Long.toString((long)n2 & 0xFFFFFFFFL, 16);
        StringBuffer stringBuffer = new StringBuffer("0x");
        int n3 = 8 - string.length();
        do {
            if (n3 <= 0) {
                stringBuffer.append(string);
                return stringBuffer.toString();
            }
            stringBuffer.append('0');
            --n3;
        } while (true);
    }

    static final String toOctal3(int n2) {
        char[] arrc = new char[3];
        int n3 = 2;
        while (n3 >= 0) {
            arrc[n3] = (char)(48 + (n2 & 7));
            n2 >>= 3;
            --n3;
        }
        return new String(arrc);
    }

    private Compiler$Option getOption(String string) {
        string = string.toLowerCase();
        try {
            int n2 = 0;
            while (n2 < options.length) {
                if (options[n2].toLowerCase().equals(string)) {
                    return new Compiler$Option(this, options[n2]);
                }
                n2 += 2;
            }
            return null;
        }
        catch (NoSuchFieldException var2_3) {
            return null;
        }
    }

    public void parseOptions(String string) {
        if (string == null) return;
        if (string.length() == 0) {
            return;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        while (stringTokenizer.hasMoreElements()) {
            String string2;
            String string3;
            String string4 = stringTokenizer.nextToken();
            if (string4.indexOf("=") != -1) {
                string2 = string4.substring(0, string4.indexOf("="));
                string3 = string4.substring(string4.indexOf("=") + 1);
            } else if (string4.startsWith("no")) {
                string2 = string4.substring(2);
                string3 = "false";
            } else {
                string2 = string4;
                string3 = "true";
            }
            Compiler$Option compiler$Option = this.getOption(string2);
            if (compiler$Option == null) {
                System.err.println(new StringBuffer().append("WARNING: No such option: ").append(string2).toString());
                continue;
            }
            if (compiler$Option.getType() == (class$java$lang$String == null ? Compiler.class$("java.lang.String") : class$java$lang$String)) {
                compiler$Option.set(string3);
                continue;
            }
            if (compiler$Option.getType() == Integer.TYPE) {
                try {
                    compiler$Option.set(Compiler.parseInt(string3));
                }
                catch (NumberFormatException var7_7) {
                    System.err.println(new StringBuffer().append("WARNING: ").append(string3).append(" is not an integer").toString());
                }
                continue;
            }
            if (compiler$Option.getType() != Boolean.TYPE) throw new Error(new StringBuffer().append("Unknown type: ").append(compiler$Option.getType()).toString());
            compiler$Option.set(new Boolean(string3.toLowerCase().equals("true") || string3.toLowerCase().equals("yes")));
        }
    }

    private static Integer parseInt(String string) {
        int n2;
        int n3 = 1;
        if (!(string = string.toLowerCase()).startsWith("0x") && string.endsWith("m")) {
            string = string.substring(0, string.length() - 1);
            n3 = 1048576;
        } else if (!string.startsWith("0x") && string.endsWith("k")) {
            string = string.substring(0, string.length() - 1);
            n3 = 1024;
        }
        if (string.length() > 2 && string.startsWith("0x")) {
            n2 = Integer.parseInt(string.substring(2), 16);
            return new Integer(n2 * n3);
        }
        n2 = Integer.parseInt(string);
        return new Integer(n2 * n3);
    }

    private static String wrapAndIndent(String string, int n2, int n3, int n4) {
        int n5;
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        StringBuffer stringBuffer = new StringBuffer();
        for (n5 = 0; n5 < n2; ++n5) {
            stringBuffer.append(' ');
        }
        n5 = 0;
        do {
            if (!stringTokenizer.hasMoreTokens()) {
                stringBuffer.append('\n');
                return stringBuffer.toString();
            }
            String string2 = stringTokenizer.nextToken();
            if (string2.length() + n5 + 1 > n4 && n5 > 0) {
                stringBuffer.append('\n');
                for (int i2 = 0; i2 < n3; ++i2) {
                    stringBuffer.append(' ');
                }
                n5 = 0;
            } else if (n5 > 0) {
                stringBuffer.append(' ');
                ++n5;
            }
            stringBuffer.append(string2);
            n5 += string2.length();
        } while (true);
    }

    static String dateTime() {
        try {
            return new Date().toString();
        }
        catch (RuntimeException var0) {
            return "<unknown>";
        }
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

