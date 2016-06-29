package org.ibex.nestedvm;

import java.io.*;
import org.ibex.nestedvm.util.*;
import java.util.*;

public abstract class Compiler implements Registers
{
    ELF elf;
    final String fullClassName;
    String source;
    boolean fastMem;
    int maxInsnPerMethod;
    int maxBytesPerMethod;
    int methodMask;
    int methodShift;
    boolean pruneCases;
    boolean assumeTailCalls;
    boolean debugCompiler;
    boolean printStats;
    boolean runtimeStats;
    boolean supportCall;
    boolean nullPointerCheck;
    String runtimeClass;
    String hashClass;
    boolean unixRuntime;
    boolean lessConstants;
    boolean singleFloat;
    int pageSize;
    int totalPages;
    int pageShift;
    boolean onePage;
    Hashtable jumpableAddresses;
    ELF$Symbol userInfo;
    ELF$Symbol gp;
    private boolean used;
    private static String[] options;
    static Class class$org$ibex$nestedvm$Compiler;
    static Class class$java$lang$String;
    
    public void setSource(final String source) {
        this.source = source;
    }
    
    void maxInsnPerMethodInit() {
        if ((this.maxInsnPerMethod & this.maxInsnPerMethod - 1) != 0x0) {
            throw new Compiler$Exn("maxBytesPerMethod is not a power of two");
        }
        this.maxBytesPerMethod = this.maxInsnPerMethod * 4;
        this.methodMask = ~(this.maxBytesPerMethod - 1);
        while (this.maxBytesPerMethod >>> this.methodShift != 1) {
            ++this.methodShift;
        }
    }
    
    void pageSizeInit() {
        if ((this.pageSize & this.pageSize - 1) != 0x0) {
            throw new Compiler$Exn("pageSize not a multiple of two");
        }
        if ((this.totalPages & this.totalPages - 1) != 0x0) {
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
        for (int i = 0; i < Compiler.options.length; i += 2) {
            System.err.print(Compiler.options[i] + ": " + wrapAndIndent(Compiler.options[i + 1], 16 - Compiler.options[i].length(), 18, 62));
        }
        System.exit(1);
    }
    
    public static void main(final String[] array) {
        String s = null;
        String s2 = null;
        String string = null;
        String s3 = null;
        String source = null;
        String s4 = null;
        boolean b = false;
        for (int n = 0; array.length - n > 0; ++n) {
            if (array[n].equals("-outfile")) {
                if (++n == array.length) {
                    usage();
                }
                s = array[n];
            }
            else if (array[n].equals("-d")) {
                if (++n == array.length) {
                    usage();
                }
                s2 = array[n];
            }
            else if (array[n].equals("-outformat")) {
                if (++n == array.length) {
                    usage();
                }
                s4 = array[n];
            }
            else if (array[n].equals("-o")) {
                if (++n == array.length) {
                    usage();
                }
                if (string == null || string.length() == 0) {
                    string = array[n];
                }
                else if (array[n].length() != 0) {
                    string = string + "," + array[n];
                }
            }
            else if (array[n].equals("-dumpoptions")) {
                b = true;
            }
            else if (s3 == null) {
                s3 = array[n];
            }
            else if (source == null) {
                source = array[n];
            }
            else {
                usage();
            }
        }
        if (s3 == null || source == null) {
            usage();
        }
        final Seekable$File seekable$File = new Seekable$File(source);
        Writer writer = null;
        OutputStream outputStream = null;
        Compiler compiler = null;
        if (s4 == null || s4.equals("class")) {
            if (s != null) {
                outputStream = new FileOutputStream(s);
                compiler = new ClassFileCompiler(seekable$File, s3, outputStream);
            }
            else if (s2 != null) {
                final File file = new File(s2);
                if (!file.isDirectory()) {
                    System.err.println(s2 + " doesn't exist or is not a directory");
                    System.exit(1);
                }
                compiler = new ClassFileCompiler(seekable$File, s3, file);
            }
            else {
                System.err.println("Refusing to write a classfile to stdout - use -outfile foo.class");
                System.exit(1);
            }
        }
        else if (s4.equals("javasource") || s4.equals("java")) {
            writer = ((s == null) ? new OutputStreamWriter(System.out) : new FileWriter(s));
            compiler = new JavaSourceCompiler(seekable$File, s3, writer);
        }
        else {
            System.err.println("Unknown output format: " + s4);
            System.exit(1);
        }
        compiler.parseOptions(string);
        compiler.setSource(source);
        if (b) {
            System.err.println("== Options ==");
            for (int i = 0; i < Compiler.options.length; i += 2) {
                System.err.println(Compiler.options[i] + ": " + compiler.getOption(Compiler.options[i]).get());
            }
            System.err.println("== End Options ==");
        }
        try {
            compiler.go();
        }
        catch (Compiler$Exn compiler$Exn) {
            System.err.println("Compiler Error: " + compiler$Exn.getMessage());
            System.exit(1);
        }
        finally {
            if (writer != null) {
                writer.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    public Compiler(final Seekable seekable, final String fullClassName) {
        this.source = "unknown.mips.binary";
        this.fastMem = true;
        this.maxInsnPerMethod = 128;
        this.pruneCases = true;
        this.assumeTailCalls = true;
        this.debugCompiler = false;
        this.printStats = false;
        this.runtimeStats = false;
        this.supportCall = true;
        this.nullPointerCheck = false;
        this.runtimeClass = "org.ibex.nestedvm.Runtime";
        this.hashClass = "java.util.Hashtable";
        this.pageSize = 4096;
        this.totalPages = 65536;
        this.fullClassName = fullClassName;
        this.elf = new ELF(seekable);
        if (this.elf.header.type != 2) {
            throw new IOException("Binary is not an executable");
        }
        if (this.elf.header.machine != 8) {
            throw new IOException("Binary is not for the MIPS I Architecture");
        }
        if (this.elf.ident.data != 2) {
            throw new IOException("Binary is not big endian");
        }
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
        final ELF$Symtab symtab = this.elf.getSymtab();
        if (symtab == null) {
            throw new Compiler$Exn("Binary has no symtab (did you strip it?)");
        }
        this.userInfo = symtab.getGlobalSymbol("user_info");
        this.gp = symtab.getGlobalSymbol("_gp");
        if (this.gp == null) {
            throw new Compiler$Exn("no _gp symbol (did you strip the binary?)");
        }
        if (this.pruneCases) {
            (this.jumpableAddresses = new Hashtable()).put(new Integer(this.elf.header.entry), Boolean.TRUE);
            final ELF$SHeader sectionWithName = this.elf.sectionWithName(".text");
            if (sectionWithName == null) {
                throw new Compiler$Exn("No .text segment");
            }
            this.findBranchesInSymtab(symtab, this.jumpableAddresses);
            for (int i = 0; i < this.elf.sheaders.length; ++i) {
                final ELF$SHeader elf$SHeader = this.elf.sheaders[i];
                final String name = elf$SHeader.name;
                if (elf$SHeader.addr != 0) {
                    if (name.equals(".data") || name.equals(".sdata") || name.equals(".rodata") || name.equals(".ctors") || name.equals(".dtors")) {
                        this.findBranchesInData(new DataInputStream(elf$SHeader.getInputStream()), elf$SHeader.size, this.jumpableAddresses, sectionWithName.addr, sectionWithName.addr + sectionWithName.size);
                    }
                }
            }
            this.findBranchesInText(sectionWithName.addr, new DataInputStream(sectionWithName.getInputStream()), sectionWithName.size, this.jumpableAddresses);
        }
        if (this.unixRuntime && this.runtimeClass.startsWith("org.ibex.nestedvm.")) {
            this.runtimeClass = "org.ibex.nestedvm.UnixRuntime";
        }
        for (int j = 0; j < this.elf.sheaders.length; ++j) {
            final String name2 = this.elf.sheaders[j].name;
            if ((this.elf.sheaders[j].flags & 0x2) != 0x0 && !name2.equals(".text") && !name2.equals(".data") && !name2.equals(".sdata") && !name2.equals(".rodata") && !name2.equals(".ctors") && !name2.equals(".dtors") && !name2.equals(".bss") && !name2.equals(".sbss")) {
                throw new Compiler$Exn("Unknown section: " + name2);
            }
        }
        this._go();
    }
    
    private void findBranchesInSymtab(final ELF$Symtab elf$Symtab, final Hashtable hashtable) {
        final ELF$Symbol[] symbols = elf$Symtab.symbols;
        int n = 0;
        for (int i = 0; i < symbols.length; ++i) {
            final ELF$Symbol elf$Symbol = symbols[i];
            if (elf$Symbol.type == 2 && hashtable.put(new Integer(elf$Symbol.addr), Boolean.TRUE) == null) {
                ++n;
            }
        }
        if (this.printStats) {
            System.err.println("Found " + n + " additional possible branch targets in Symtab");
        }
    }
    
    private void findBranchesInText(final int n, final DataInputStream dataInputStream, final int n2, final Hashtable hashtable) {
        final int n3 = n2 / 4;
        int n4 = n;
        int n5 = 0;
        final int[] array = new int[32];
        final int[] array2 = new int[32];
        for (int i = 0; i < n3; ++i, n4 += 4) {
            final int int1 = dataInputStream.readInt();
            final int n6 = int1 >>> 26 & 0xFF;
            final int n7 = int1 >>> 21 & 0x1F;
            final int n8 = int1 >>> 16 & 0x1F;
            final int n9 = int1 << 16 >> 16;
            final int n10 = int1 & 0xFFFF;
            final int n11 = n9;
            final int n12 = int1 & 0x3FFFFFF;
            final int n13 = int1 & 0x3F;
            switch (n6) {
                case 0: {
                    switch (n13) {
                        case 9: {
                            if (hashtable.put(new Integer(n4 + 8), Boolean.TRUE) == null) {
                                ++n5;
                                break;
                            }
                            break;
                        }
                        case 12: {
                            if (hashtable.put(new Integer(n4 + 4), Boolean.TRUE) == null) {
                                ++n5;
                                break;
                            }
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (n8) {
                        case 16:
                        case 17: {
                            if (hashtable.put(new Integer(n4 + 8), Boolean.TRUE) == null) {
                                ++n5;
                            }
                        }
                        case 0:
                        case 1: {
                            if (hashtable.put(new Integer(n4 + n11 * 4 + 4), Boolean.TRUE) == null) {
                                ++n5;
                                break;
                            }
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    if (hashtable.put(new Integer(n4 + 8), Boolean.TRUE) == null) {
                        ++n5;
                    }
                }
                case 2: {
                    if (hashtable.put(new Integer((n4 & 0xF0000000) | n12 << 2), Boolean.TRUE) == null) {
                        ++n5;
                        break;
                    }
                    break;
                }
                case 4:
                case 5:
                case 6:
                case 7: {
                    if (hashtable.put(new Integer(n4 + n11 * 4 + 4), Boolean.TRUE) == null) {
                        ++n5;
                        break;
                    }
                    break;
                }
                case 9: {
                    if (n4 - array2[n7] <= 128) {
                        final int n14 = (array[n7] << 16) + n9;
                        if ((n14 & 0x3) == 0x0 && n14 >= n && n14 < n + n2 && hashtable.put(new Integer(n14), Boolean.TRUE) == null) {
                            ++n5;
                        }
                        if (n8 == n7) {
                            array2[n7] = 0;
                        }
                        break;
                    }
                    break;
                }
                case 15: {
                    array[n8] = n10;
                    array2[n8] = n4;
                    break;
                }
                case 17: {
                    switch (n7) {
                        case 8: {
                            if (hashtable.put(new Integer(n4 + n11 * 4 + 4), Boolean.TRUE) == null) {
                                ++n5;
                                continue;
                            }
                            continue;
                        }
                    }
                    break;
                }
            }
        }
        dataInputStream.close();
        if (this.printStats) {
            System.err.println("Found " + n5 + " additional possible branch targets in Text segment");
        }
    }
    
    private void findBranchesInData(final DataInputStream dataInputStream, final int n, final Hashtable hashtable, final int n2, final int n3) {
        final int n4 = n / 4;
        int n5 = 0;
        for (int i = 0; i < n4; ++i) {
            final int int1 = dataInputStream.readInt();
            if ((int1 & 0x3) == 0x0 && int1 >= n2 && int1 < n3 && hashtable.put(new Integer(int1), Boolean.TRUE) == null) {
                ++n5;
            }
        }
        dataInputStream.close();
        if (n5 > 0 && this.printStats) {
            System.err.println("Found " + n5 + " additional possible branch targets in Data segment");
        }
    }
    
    static final String toHex(final int n) {
        return "0x" + Long.toString(n & 0xFFFFFFFFL, 16);
    }
    
    static final String toHex8(final int n) {
        final String string = Long.toString(n & 0xFFFFFFFFL, 16);
        final StringBuffer sb = new StringBuffer("0x");
        for (int i = 8 - string.length(); i > 0; --i) {
            sb.append('0');
        }
        sb.append(string);
        return sb.toString();
    }
    
    static final String toOctal3(int n) {
        final char[] array = new char[3];
        for (int i = 2; i >= 0; --i) {
            array[i] = (char)(48 + (n & 0x7));
            n >>= 3;
        }
        return new String(array);
    }
    
    private Compiler$Option getOption(String lowerCase) {
        lowerCase = lowerCase.toLowerCase();
        try {
            for (int i = 0; i < Compiler.options.length; i += 2) {
                if (Compiler.options[i].toLowerCase().equals(lowerCase)) {
                    return new Compiler$Option(this, Compiler.options[i]);
                }
            }
            return null;
        }
        catch (NoSuchFieldException ex) {
            return null;
        }
    }
    
    public void parseOptions(final String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        final StringTokenizer stringTokenizer = new StringTokenizer(s, ",");
        while (stringTokenizer.hasMoreElements()) {
            final String nextToken = stringTokenizer.nextToken();
            String s2;
            String substring;
            if (nextToken.indexOf("=") != -1) {
                s2 = nextToken.substring(0, nextToken.indexOf("="));
                substring = nextToken.substring(nextToken.indexOf("=") + 1);
            }
            else if (nextToken.startsWith("no")) {
                s2 = nextToken.substring(2);
                substring = "false";
            }
            else {
                s2 = nextToken;
                substring = "true";
            }
            final Compiler$Option option = this.getOption(s2);
            if (option == null) {
                System.err.println("WARNING: No such option: " + s2);
            }
            else if (option.getType() == ((Compiler.class$java$lang$String == null) ? (Compiler.class$java$lang$String = class$("java.lang.String")) : Compiler.class$java$lang$String)) {
                option.set(substring);
            }
            else if (option.getType() == Integer.TYPE) {
                try {
                    option.set(parseInt(substring));
                }
                catch (NumberFormatException ex) {
                    System.err.println("WARNING: " + substring + " is not an integer");
                }
            }
            else {
                if (option.getType() != Boolean.TYPE) {
                    throw new Error("Unknown type: " + option.getType());
                }
                option.set(new Boolean(substring.toLowerCase().equals("true") || substring.toLowerCase().equals("yes")));
            }
        }
    }
    
    private static Integer parseInt(String s) {
        int n = 1;
        s = s.toLowerCase();
        if (!s.startsWith("0x") && s.endsWith("m")) {
            s = s.substring(0, s.length() - 1);
            n = 1048576;
        }
        else if (!s.startsWith("0x") && s.endsWith("k")) {
            s = s.substring(0, s.length() - 1);
            n = 1024;
        }
        int n2;
        if (s.length() > 2 && s.startsWith("0x")) {
            n2 = Integer.parseInt(s.substring(2), 16);
        }
        else {
            n2 = Integer.parseInt(s);
        }
        return new Integer(n2 * n);
    }
    
    private static String wrapAndIndent(final String s, final int n, final int n2, final int n3) {
        final StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        int n4 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            final String nextToken = stringTokenizer.nextToken();
            if (nextToken.length() + n4 + 1 > n3 && n4 > 0) {
                sb.append('\n');
                for (int j = 0; j < n2; ++j) {
                    sb.append(' ');
                }
                n4 = 0;
            }
            else if (n4 > 0) {
                sb.append(' ');
                ++n4;
            }
            sb.append(nextToken);
            n4 += nextToken.length();
        }
        sb.append('\n');
        return sb.toString();
    }
    
    static String dateTime() {
        try {
            return new Date().toString();
        }
        catch (RuntimeException ex) {
            return "<unknown>";
        }
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        Compiler.options = new String[] { "fastMem", "Enable fast memory access - RuntimeExceptions will be thrown on faults", "nullPointerCheck", "Enables checking at runtime for null pointer accessses (slows things down a bit, only applicable with fastMem)", "maxInsnPerMethod", "Maximum number of MIPS instructions per java method (128 is optimal with Hotspot)", "pruneCases", "Remove unnecessary case 0xAABCCDD blocks from methods - may break some weird code", "assumeTailCalls", "Assume the JIT optimizes tail calls", "optimizedMemcpy", "Use an optimized java version of memcpy where possible", "debugCompiler", "Output information in the generated code for debugging the compiler - will slow down generated code significantly", "printStats", "Output some useful statistics about the compilation", "runtimeStats", "Keep track of some statistics at runtime in the generated code - will slow down generated code significantly", "supportCall", "Keep a stripped down version of the symbol table in the generated code to support the call() method", "runtimeClass", "Full classname of the Runtime class (default: Runtime) - use this is you put Runtime in a package", "hashClass", "Full classname of a Hashtable class (default: java.util.HashMap) - this must support get() and put()", "unixRuntime", "Use the UnixRuntime (has support for fork, wai, du, pipe, etc)", "pageSize", "The page size (must be a power of two)", "totalPages", "Total number of pages (total mem = pageSize*totalPages, must be a power of two)", "onePage", "One page hack (FIXME: document this better)", "lessConstants", "Use less constants at the cost of speed (FIXME: document this better)", "singleFloat", "Support single precision (32-bit) FP ops only" };
    }
}
