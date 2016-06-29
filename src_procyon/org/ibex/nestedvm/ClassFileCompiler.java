package org.ibex.nestedvm;

import java.io.*;
import org.ibex.nestedvm.util.*;
import org.ibex.classgen.*;

public class ClassFileCompiler extends Compiler implements CGConst
{
    private static final boolean OPTIMIZE_CP = true;
    private OutputStream os;
    private File outDir;
    private PrintStream warn;
    private final Type$Class me;
    private ClassFile cg;
    private MethodGen clinit;
    private MethodGen init;
    private static int initDataCount;
    private int startOfMethod;
    private int endOfMethod;
    private MethodGen$PhantomTarget returnTarget;
    private MethodGen$PhantomTarget defaultTarget;
    private MethodGen$PhantomTarget[] insnTargets;
    private MethodGen mg;
    private static final int UNREACHABLE = 1;
    private static final int SKIP_NEXT = 2;
    private boolean textDone;
    private static final Float POINT_5_F;
    private static final Double POINT_5_D;
    private static final Long FFFFFFFF;
    private static final int R = 0;
    private static final int F = 32;
    private static final int HI = 64;
    private static final int LO = 65;
    private static final int FCSR = 66;
    private static final int REG_COUNT = 67;
    private static final String[] regField;
    private static final int MAX_LOCALS = 4;
    private static final int LOAD_LENGTH = 3;
    private int[] regLocalMapping;
    private boolean[] regLocalWritten;
    private int nextAvailLocal;
    private int loadsStart;
    private int preSetRegStackPos;
    private int[] preSetRegStack;
    private int memWriteStage;
    private boolean didPreMemRead;
    private boolean preMemReadDoPreWrite;
    
    public ClassFileCompiler(final String s, final String s2, final OutputStream outputStream) {
        this(new Seekable$File(s), s2, outputStream);
    }
    
    public ClassFileCompiler(final Seekable seekable, final String s, final OutputStream os) {
        this(seekable, s);
        if (os == null) {
            throw new NullPointerException();
        }
        this.os = os;
    }
    
    public ClassFileCompiler(final Seekable seekable, final String s, final File outDir) {
        this(seekable, s);
        if (outDir == null) {
            throw new NullPointerException();
        }
        this.outDir = outDir;
    }
    
    private ClassFileCompiler(final Seekable seekable, final String s) {
        super(seekable, s);
        this.warn = System.err;
        this.startOfMethod = 0;
        this.endOfMethod = 0;
        this.regLocalMapping = new int[67];
        this.regLocalWritten = new boolean[67];
        this.preSetRegStack = new int[8];
        this.me = Type$Class.instance(this.fullClassName);
    }
    
    public void setWarnWriter(final PrintStream warn) {
        this.warn = warn;
    }
    
    protected void _go() {
        try {
            this.__go();
        }
        catch (ClassFile$Exn classFile$Exn) {
            classFile$Exn.printStackTrace(this.warn);
            throw new Compiler$Exn("Class generation exception: " + classFile$Exn.toString());
        }
    }
    
    private void __go() {
        if (!this.pruneCases) {
            throw new Compiler$Exn("-o prunecases MUST be enabled for ClassFileCompiler");
        }
        final Type$Class instance = Type$Class.instance(this.runtimeClass);
        this.cg = new ClassFile(this.me, instance, 49);
        if (this.source != null) {
            this.cg.setSourceFile(this.source);
        }
        this.cg.addField("pc", Type.INT, 2);
        this.cg.addField("hi", Type.INT, 2);
        this.cg.addField("lo", Type.INT, 2);
        this.cg.addField("fcsr", Type.INT, 2);
        for (int i = 1; i < 32; ++i) {
            this.cg.addField("r" + i, Type.INT, 2);
        }
        for (int j = 0; j < 32; ++j) {
            this.cg.addField("f" + j, this.singleFloat ? Type.FLOAT : Type.INT, 2);
        }
        this.clinit = this.cg.addMethod("<clinit>", Type.VOID, Type.NO_ARGS, 10);
        (this.init = this.cg.addMethod("<init>", Type.VOID, Type.NO_ARGS, 1)).add((byte)42);
        this.init.add((byte)18, this.pageSize);
        this.init.add((byte)18, this.totalPages);
        this.init.add((byte)(-73), (Object)this.me.method("<init>", Type.VOID, new Type[] { Type.INT, Type.INT }));
        this.init.add((byte)(-79));
        (this.init = this.cg.addMethod("<init>", Type.VOID, new Type[] { Type.BOOLEAN }, 1)).add((byte)42);
        this.init.add((byte)18, this.pageSize);
        this.init.add((byte)18, this.totalPages);
        this.init.add((byte)27);
        this.init.add((byte)(-73), (Object)this.me.method("<init>", Type.VOID, new Type[] { Type.INT, Type.INT, Type.BOOLEAN }));
        this.init.add((byte)(-79));
        (this.init = this.cg.addMethod("<init>", Type.VOID, new Type[] { Type.INT, Type.INT }, 1)).add((byte)42);
        this.init.add((byte)27);
        this.init.add((byte)28);
        this.init.add((byte)3);
        this.init.add((byte)(-73), (Object)this.me.method("<init>", Type.VOID, new Type[] { Type.INT, Type.INT, Type.BOOLEAN }));
        this.init.add((byte)(-79));
        (this.init = this.cg.addMethod("<init>", Type.VOID, new Type[] { Type.INT, Type.INT, Type.BOOLEAN }, 1)).add((byte)42);
        this.init.add((byte)27);
        this.init.add((byte)28);
        this.init.add((byte)29);
        this.init.add((byte)(-73), (Object)instance.method("<init>", Type.VOID, new Type[] { Type.INT, Type.INT, Type.BOOLEAN }));
        if (this.onePage) {
            this.cg.addField("page", (Type)Type.INT.makeArray(), 18);
            this.init.add((byte)42);
            this.init.add((byte)89);
            this.init.add((byte)(-76), (Object)this.me.field("readPages", (Type)Type.INT.makeArray(2)));
            this.init.add((byte)18, 0);
            this.init.add((byte)50);
            this.init.add((byte)(-75), (Object)this.me.field("page", (Type)Type.INT.makeArray()));
        }
        if (this.supportCall) {
            this.cg.addField("symbols", (Type)Type$Class.instance(this.hashClass), 26);
        }
        int max = 0;
        for (int k = 0; k < this.elf.sheaders.length; ++k) {
            final ELF$SHeader elf$SHeader = this.elf.sheaders[k];
            final String name = elf$SHeader.name;
            if (elf$SHeader.addr != 0) {
                max = Math.max(max, elf$SHeader.addr + elf$SHeader.size);
                if (name.equals(".text")) {
                    this.emitText(elf$SHeader.addr, new DataInputStream(elf$SHeader.getInputStream()), elf$SHeader.size);
                }
                else if (name.equals(".data") || name.equals(".sdata") || name.equals(".rodata") || name.equals(".ctors") || name.equals(".dtors")) {
                    this.emitData(elf$SHeader.addr, new DataInputStream(elf$SHeader.getInputStream()), elf$SHeader.size, name.equals(".rodata"));
                }
                else {
                    if (!name.equals(".bss") && !name.equals(".sbss")) {
                        throw new Compiler$Exn("Unknown segment: " + name);
                    }
                    this.emitBSS(elf$SHeader.addr, elf$SHeader.size);
                }
            }
        }
        this.init.add((byte)(-79));
        if (this.supportCall) {
            final Type$Class instance2 = Type$Class.instance(this.hashClass);
            this.clinit.add((byte)(-69), (Object)instance2);
            this.clinit.add((byte)89);
            this.clinit.add((byte)89);
            this.clinit.add((byte)(-73), (Object)instance2.method("<init>", Type.VOID, Type.NO_ARGS));
            this.clinit.add((byte)(-77), (Object)this.me.field("symbols", (Type)instance2));
            final ELF$Symbol[] symbols = this.elf.getSymtab().symbols;
            for (int l = 0; l < symbols.length; ++l) {
                final ELF$Symbol elf$Symbol = symbols[l];
                if (elf$Symbol.type == 2 && elf$Symbol.binding == 1 && (elf$Symbol.name.equals("_call_helper") || !elf$Symbol.name.startsWith("_"))) {
                    this.clinit.add((byte)89);
                    this.clinit.add((byte)18, (Object)elf$Symbol.name);
                    this.clinit.add((byte)(-69), (Object)Type.INTEGER_OBJECT);
                    this.clinit.add((byte)89);
                    this.clinit.add((byte)18, elf$Symbol.addr);
                    this.clinit.add((byte)(-73), (Object)Type.INTEGER_OBJECT.method("<init>", Type.VOID, new Type[] { Type.INT }));
                    this.clinit.add((byte)(-74), (Object)instance2.method("put", (Type)Type.OBJECT, new Type[] { Type.OBJECT, Type.OBJECT }));
                    this.clinit.add((byte)87);
                }
            }
            this.clinit.add((byte)87);
        }
        this.clinit.add((byte)(-79));
        final ELF$SHeader sectionWithName = this.elf.sectionWithName(".text");
        final MethodGen addMethod = this.cg.addMethod("trampoline", Type.VOID, Type.NO_ARGS, 2);
        final int size = addMethod.size();
        addMethod.add((byte)42);
        addMethod.add((byte)(-76), (Object)this.me.field("state", Type.INT));
        addMethod.add((byte)(-103), addMethod.size() + 2);
        addMethod.add((byte)(-79));
        addMethod.add((byte)42);
        addMethod.add((byte)42);
        addMethod.add((byte)(-76), (Object)this.me.field("pc", Type.INT));
        addMethod.add((byte)18, this.methodShift);
        addMethod.add((byte)124);
        final int n = sectionWithName.addr >>> this.methodShift;
        final int n2 = sectionWithName.addr + sectionWithName.size + this.maxBytesPerMethod - 1 >>> this.methodShift;
        final MethodGen$Switch$Table methodGen$Switch$Table = new MethodGen$Switch$Table(n, n2 - 1);
        addMethod.add((byte)(-86), (Object)methodGen$Switch$Table);
        for (int n3 = n; n3 < n2; ++n3) {
            methodGen$Switch$Table.setTargetForVal(n3, addMethod.size());
            addMethod.add((byte)(-73), (Object)this.me.method("run_" + Compiler.toHex(n3 << this.methodShift), Type.VOID, Type.NO_ARGS));
            addMethod.add((byte)(-89), size);
        }
        methodGen$Switch$Table.setDefaultTarget(addMethod.size());
        addMethod.add((byte)87);
        addMethod.add((byte)(-69), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
        addMethod.add((byte)89);
        addMethod.add((byte)(-69), (Object)Type.STRINGBUFFER);
        addMethod.add((byte)89);
        addMethod.add((byte)18, (Object)"Jumped to invalid address in trampoline (r2: ");
        addMethod.add((byte)(-73), (Object)Type.STRINGBUFFER.method("<init>", Type.VOID, new Type[] { Type.STRING }));
        addMethod.add((byte)42);
        addMethod.add((byte)(-76), (Object)this.me.field("r2", Type.INT));
        addMethod.add((byte)(-74), (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[] { Type.INT }));
        addMethod.add((byte)18, (Object)" pc: ");
        addMethod.add((byte)(-74), (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[] { Type.STRING }));
        addMethod.add((byte)42);
        addMethod.add((byte)(-76), (Object)this.me.field("pc", Type.INT));
        addMethod.add((byte)(-74), (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[] { Type.INT }));
        addMethod.add((byte)18, (Object)")");
        addMethod.add((byte)(-74), (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[] { Type.STRING }));
        addMethod.add((byte)(-74), (Object)Type.STRINGBUFFER.method("toString", (Type)Type.STRING, Type.NO_ARGS));
        addMethod.add((byte)(-73), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[] { Type.STRING }));
        addMethod.add((byte)(-65));
        this.addConstReturnMethod("gp", this.gp.addr);
        this.addConstReturnMethod("entryPoint", this.elf.header.entry);
        this.addConstReturnMethod("heapStart", max);
        if (this.userInfo != null) {
            this.addConstReturnMethod("userInfoBase", this.userInfo.addr);
            this.addConstReturnMethod("userInfoSize", this.userInfo.size);
        }
        if (this.supportCall) {
            final Type$Class instance3 = Type$Class.instance(this.hashClass);
            final MethodGen addMethod2 = this.cg.addMethod("lookupSymbol", Type.INT, new Type[] { Type.STRING }, 4);
            addMethod2.add((byte)(-78), (Object)this.me.field("symbols", (Type)instance3));
            addMethod2.add((byte)43);
            addMethod2.add((byte)(-74), (Object)instance3.method("get", (Type)Type.OBJECT, new Type[] { Type.OBJECT }));
            addMethod2.add((byte)89);
            final int add = addMethod2.add((byte)(-58));
            addMethod2.add((byte)(-64), (Object)Type.INTEGER_OBJECT);
            addMethod2.add((byte)(-74), (Object)Type.INTEGER_OBJECT.method("intValue", Type.INT, Type.NO_ARGS));
            addMethod2.add((byte)(-84));
            addMethod2.setArg(add, addMethod2.size());
            addMethod2.add((byte)87);
            addMethod2.add((byte)2);
            addMethod2.add((byte)(-84));
        }
        final Type$Class instance4 = Type$Class.instance("org.ibex.nestedvm.Runtime$CPUState");
        final MethodGen addMethod3 = this.cg.addMethod("setCPUState", Type.VOID, new Type[] { instance4 }, 4);
        final MethodGen addMethod4 = this.cg.addMethod("getCPUState", Type.VOID, new Type[] { instance4 }, 4);
        addMethod3.add((byte)43);
        addMethod4.add((byte)43);
        addMethod3.add((byte)(-76), (Object)instance4.field("r", (Type)Type.INT.makeArray()));
        addMethod4.add((byte)(-76), (Object)instance4.field("r", (Type)Type.INT.makeArray()));
        addMethod3.add((byte)77);
        addMethod4.add((byte)77);
        for (int n4 = 1; n4 < 32; ++n4) {
            addMethod3.add((byte)42);
            addMethod3.add((byte)44);
            addMethod3.add((byte)18, n4);
            addMethod3.add((byte)46);
            addMethod3.add((byte)(-75), (Object)this.me.field("r" + n4, Type.INT));
            addMethod4.add((byte)44);
            addMethod4.add((byte)18, n4);
            addMethod4.add((byte)42);
            addMethod4.add((byte)(-76), (Object)this.me.field("r" + n4, Type.INT));
            addMethod4.add((byte)79);
        }
        addMethod3.add((byte)43);
        addMethod4.add((byte)43);
        addMethod3.add((byte)(-76), (Object)instance4.field("f", (Type)Type.INT.makeArray()));
        addMethod4.add((byte)(-76), (Object)instance4.field("f", (Type)Type.INT.makeArray()));
        addMethod3.add((byte)77);
        addMethod4.add((byte)77);
        for (int n5 = 0; n5 < 32; ++n5) {
            addMethod3.add((byte)42);
            addMethod3.add((byte)44);
            addMethod3.add((byte)18, n5);
            addMethod3.add((byte)46);
            if (this.singleFloat) {
                addMethod3.add((byte)(-72), (Object)Type.FLOAT_OBJECT.method("intBitsToFloat", Type.FLOAT, new Type[] { Type.INT }));
            }
            addMethod3.add((byte)(-75), (Object)this.me.field("f" + n5, this.singleFloat ? Type.FLOAT : Type.INT));
            addMethod4.add((byte)44);
            addMethod4.add((byte)18, n5);
            addMethod4.add((byte)42);
            addMethod4.add((byte)(-76), (Object)this.me.field("f" + n5, this.singleFloat ? Type.FLOAT : Type.INT));
            if (this.singleFloat) {
                addMethod4.add((byte)(-72), (Object)Type.FLOAT_OBJECT.method("floatToIntBits", Type.INT, new Type[] { Type.FLOAT }));
            }
            addMethod4.add((byte)79);
        }
        final String[] array = { "hi", "lo", "fcsr", "pc" };
        for (int n6 = 0; n6 < array.length; ++n6) {
            addMethod3.add((byte)42);
            addMethod3.add((byte)43);
            addMethod3.add((byte)(-76), (Object)instance4.field(array[n6], Type.INT));
            addMethod3.add((byte)(-75), (Object)this.me.field(array[n6], Type.INT));
            addMethod4.add((byte)43);
            addMethod4.add((byte)42);
            addMethod4.add((byte)(-76), (Object)this.me.field(array[n6], Type.INT));
            addMethod4.add((byte)(-75), (Object)instance4.field(array[n6], Type.INT));
        }
        addMethod3.add((byte)(-79));
        addMethod4.add((byte)(-79));
        final MethodGen addMethod5 = this.cg.addMethod("_execute", Type.VOID, Type.NO_ARGS, 4);
        final int size2 = addMethod5.size();
        addMethod5.add((byte)42);
        addMethod5.add((byte)(-73), (Object)this.me.method("trampoline", Type.VOID, Type.NO_ARGS));
        final int size3 = addMethod5.size();
        addMethod5.add((byte)(-79));
        final int size4 = addMethod5.size();
        addMethod5.add((byte)76);
        addMethod5.add((byte)(-69), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$FaultException"));
        addMethod5.add((byte)89);
        addMethod5.add((byte)43);
        addMethod5.add((byte)(-73), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$FaultException").method("<init>", Type.VOID, new Type[] { Type$Class.instance("java.lang.RuntimeException") }));
        addMethod5.add((byte)(-65));
        addMethod5.addExceptionHandler(size2, size3, size4, Type$Class.instance("java.lang.RuntimeException"));
        addMethod5.addThrow(Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
        final MethodGen addMethod6 = this.cg.addMethod("main", Type.VOID, new Type[] { Type.STRING.makeArray() }, 9);
        addMethod6.add((byte)(-69), (Object)this.me);
        addMethod6.add((byte)89);
        addMethod6.add((byte)(-73), (Object)this.me.method("<init>", Type.VOID, Type.NO_ARGS));
        addMethod6.add((byte)18, (Object)this.fullClassName);
        addMethod6.add((byte)42);
        if (this.unixRuntime) {
            final Type$Class instance5 = Type$Class.instance("org.ibex.nestedvm.UnixRuntime");
            addMethod6.add((byte)(-72), (Object)instance5.method("runAndExec", Type.INT, new Type[] { instance5, Type.STRING, Type.STRING.makeArray() }));
        }
        else {
            addMethod6.add((byte)(-74), (Object)this.me.method("run", Type.INT, new Type[] { Type.STRING, Type.STRING.makeArray() }));
        }
        addMethod6.add((byte)(-72), (Object)Type$Class.instance("java.lang.System").method("exit", Type.VOID, new Type[] { Type.INT }));
        addMethod6.add((byte)(-79));
        if (this.outDir != null) {
            if (!this.outDir.isDirectory()) {
                throw new IOException("" + this.outDir + " isn't a directory");
            }
            this.cg.dump(this.outDir);
        }
        else {
            this.cg.dump(this.os);
        }
    }
    
    private void addConstReturnMethod(final String s, final int n) {
        final MethodGen addMethod = this.cg.addMethod(s, Type.INT, Type.NO_ARGS, 4);
        addMethod.add((byte)18, n);
        addMethod.add((byte)(-84));
    }
    
    private void emitData(int i, final DataInputStream dataInputStream, int n, final boolean b) {
        if ((i & 0x3) != 0x0 || (n & 0x3) != 0x0) {
            throw new Compiler$Exn("Data section on weird boundaries");
        }
        while (i < i + n) {
            final int min = Math.min(n, 28000);
            final StringBuffer sb = new StringBuffer();
            for (int j = 0; j < min; j += 7) {
                long n2 = 0L;
                for (int k = 0; k < 7; ++k) {
                    n2 = (n2 << 8 | (((j + k < n) ? dataInputStream.readByte() : 1) & 0xFFL));
                }
                for (int l = 0; l < 8; ++l) {
                    sb.append((char)(n2 >>> 7 * (7 - l) & 0x7FL));
                }
            }
            final String string = "_data" + ++ClassFileCompiler.initDataCount;
            this.cg.addField(string, (Type)Type.INT.makeArray(), 26);
            this.clinit.add((byte)18, (Object)sb.toString());
            this.clinit.add((byte)18, min / 4);
            this.clinit.add((byte)(-72), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime").method("decodeData", (Type)Type.INT.makeArray(), new Type[] { Type.STRING, Type.INT }));
            this.clinit.add((byte)(-77), (Object)this.me.field(string, (Type)Type.INT.makeArray()));
            this.init.add((byte)42);
            this.init.add((byte)(-78), (Object)this.me.field(string, (Type)Type.INT.makeArray()));
            this.init.add((byte)18, i);
            this.init.add((byte)18, (int)(b ? 1 : 0));
            this.init.add((byte)(-74), (Object)this.me.method("initPages", Type.VOID, new Type[] { Type.INT.makeArray(), Type.INT, Type.BOOLEAN }));
            i += min;
            n -= min;
        }
        dataInputStream.close();
    }
    
    private void emitBSS(final int n, int n2) {
        if ((n & 0x3) != 0x0) {
            throw new Compiler$Exn("BSS section on weird boundaries");
        }
        n2 = (n2 + 3 & 0xFFFFFFFC);
        final int n3 = n2 / 4;
        this.init.add((byte)42);
        this.init.add((byte)18, n);
        this.init.add((byte)18, n3);
        this.init.add((byte)(-74), (Object)this.me.method("clearPages", Type.VOID, new Type[] { Type.INT, Type.INT }));
    }
    
    private boolean jumpable(final int n) {
        return this.jumpableAddresses.get(new Integer(n)) != null;
    }
    
    private void emitText(int n, final DataInputStream dataInputStream, final int n2) {
        if (this.textDone) {
            throw new Compiler$Exn("Multiple text segments");
        }
        this.textDone = true;
        if ((n & 0x3) != 0x0 || (n2 & 0x3) != 0x0) {
            throw new Compiler$Exn("Section on weird boundaries");
        }
        final int n3 = n2 / 4;
        int n4 = -1;
        boolean b = true;
        boolean b2 = false;
        for (int i = 0; i < n3; ++i, n += 4) {
            final int n5 = b ? dataInputStream.readInt() : n4;
            n4 = ((i == n3 - 1) ? -1 : dataInputStream.readInt());
            if (n >= this.endOfMethod) {
                this.endMethod(n, b2);
                this.startMethod(n);
            }
            if (this.insnTargets[i % this.maxInsnPerMethod] != null) {
                this.insnTargets[i % this.maxInsnPerMethod].setTarget(this.mg.size());
            }
            else if (b2) {
                continue;
            }
            try {
                final int emitInstruction = this.emitInstruction(n, n5, n4);
                b2 = ((emitInstruction & 0x1) != 0x0);
                b = ((emitInstruction & 0x2) != 0x0);
            }
            catch (Compiler$Exn compiler$Exn) {
                compiler$Exn.printStackTrace(this.warn);
                this.warn.println("Exception at " + Compiler.toHex(n));
                throw compiler$Exn;
            }
            catch (RuntimeException ex) {
                this.warn.println("Exception at " + Compiler.toHex(n));
                throw ex;
            }
            if (b) {
                n += 4;
                ++i;
            }
        }
        this.endMethod(0, b2);
        dataInputStream.close();
    }
    
    private void startMethod(final int n) {
        this.startOfMethod = (n & this.methodMask);
        this.endOfMethod = this.startOfMethod + this.maxBytesPerMethod;
        this.mg = this.cg.addMethod("run_" + Compiler.toHex(this.startOfMethod), Type.VOID, Type.NO_ARGS, 18);
        if (this.onePage) {
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field("page", (Type)Type.INT.makeArray()));
            this.mg.add((byte)77);
        }
        else {
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field("readPages", (Type)Type.INT.makeArray(2)));
            this.mg.add((byte)77);
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field("writePages", (Type)Type.INT.makeArray(2)));
            this.mg.add((byte)78);
        }
        this.returnTarget = new MethodGen$PhantomTarget();
        this.insnTargets = new MethodGen$PhantomTarget[this.maxBytesPerMethod / 4];
        final int[] array = new int[this.maxBytesPerMethod / 4];
        final Object[] array2 = new Object[this.maxBytesPerMethod / 4];
        int n2 = 0;
        for (int i = n; i < this.endOfMethod; i += 4) {
            if (this.jumpable(i)) {
                array2[n2] = (this.insnTargets[(i - this.startOfMethod) / 4] = new MethodGen$PhantomTarget());
                array[n2] = i;
                ++n2;
            }
        }
        final MethodGen$Switch$Lookup methodGen$Switch$Lookup = new MethodGen$Switch$Lookup(n2);
        System.arraycopy(array, 0, methodGen$Switch$Lookup.vals, 0, n2);
        System.arraycopy(array2, 0, methodGen$Switch$Lookup.targets, 0, n2);
        methodGen$Switch$Lookup.setDefaultTarget((Object)(this.defaultTarget = new MethodGen$PhantomTarget()));
        this.fixupRegsStart();
        this.mg.add((byte)42);
        this.mg.add((byte)(-76), (Object)this.me.field("pc", Type.INT));
        this.mg.add((byte)(-85), (Object)methodGen$Switch$Lookup);
    }
    
    private void endMethod(final int n, final boolean b) {
        if (this.startOfMethod == 0) {
            return;
        }
        if (!b) {
            this.preSetPC();
            this.mg.add((byte)18, n);
            this.setPC();
            this.jumpableAddresses.put(new Integer(n), Boolean.TRUE);
        }
        this.returnTarget.setTarget(this.mg.size());
        this.fixupRegsEnd();
        this.mg.add((byte)(-79));
        this.defaultTarget.setTarget(this.mg.size());
        if (this.debugCompiler) {
            this.mg.add((byte)(-69), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
            this.mg.add((byte)89);
            this.mg.add((byte)(-69), (Object)Type.STRINGBUFFER);
            this.mg.add((byte)89);
            this.mg.add((byte)18, (Object)"Jumped to invalid address: ");
            this.mg.add((byte)(-73), (Object)Type.STRINGBUFFER.method("<init>", Type.VOID, new Type[] { Type.STRING }));
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field("pc", Type.INT));
            this.mg.add((byte)(-74), (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[] { Type.INT }));
            this.mg.add((byte)(-74), (Object)Type.STRINGBUFFER.method("toString", (Type)Type.STRING, Type.NO_ARGS));
            this.mg.add((byte)(-73), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[] { Type.STRING }));
            this.mg.add((byte)(-65));
        }
        else {
            this.mg.add((byte)(-69), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
            this.mg.add((byte)89);
            this.mg.add((byte)18, (Object)"Jumped to invalid address");
            this.mg.add((byte)(-73), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[] { Type.STRING }));
            this.mg.add((byte)(-65));
        }
        final boolean b2 = false;
        this.startOfMethod = (b2 ? 1 : 0);
        this.endOfMethod = (b2 ? 1 : 0);
    }
    
    private void leaveMethod() {
        this.mg.add((byte)(-89), (Object)this.returnTarget);
    }
    
    private void link(final int n) {
        this.preSetReg(31);
        if (this.lessConstants) {
            final int n2 = n + 8 + 32768 & 0xFFFF0000;
            final int n3 = n + 8 - n2;
            if (n3 < -32768 || n3 > 32767) {
                throw new Error("should never happen " + n3);
            }
            this.mg.add((byte)18, n2);
            this.mg.add((byte)18, n3);
            this.mg.add((byte)96);
        }
        else {
            this.mg.add((byte)18, n + 8);
        }
        this.setReg();
    }
    
    private void branch(final int n, final int n2) {
        if ((n & this.methodMask) == (n2 & this.methodMask)) {
            this.mg.add((byte)(-89), (Object)this.insnTargets[(n2 - this.startOfMethod) / 4]);
        }
        else {
            this.preSetPC();
            this.mg.add((byte)18, n2);
            this.setPC();
            this.leaveMethod();
        }
    }
    
    private int doIfInstruction(final byte b, final int n, final int n2, final int n3) {
        this.emitInstruction(-1, n3, -1);
        if ((n2 & this.methodMask) == (n & this.methodMask)) {
            this.mg.add(b, (Object)this.insnTargets[(n2 - this.startOfMethod) / 4]);
        }
        else {
            final int add = this.mg.add(MethodGen.negate(b));
            this.branch(n, n2);
            this.mg.setArg(add, this.mg.size());
        }
        if (!this.jumpable(n + 4)) {
            return 2;
        }
        if (n + 4 == this.endOfMethod) {
            this.jumpableAddresses.put(new Integer(n + 8), Boolean.TRUE);
            this.branch(n, n + 8);
            return 1;
        }
        final int add2 = this.mg.add((byte)(-89));
        this.insnTargets[(n + 4 - this.startOfMethod) / 4].setTarget(this.mg.size());
        this.emitInstruction(-1, n3, 1);
        this.mg.setArg(add2, this.mg.size());
        return 2;
    }
    
    private int emitInstruction(final int n, final int n2, final int n3) {
        final MethodGen mg = this.mg;
        if (n2 == -1) {
            throw new Compiler$Exn("insn is -1");
        }
        int n4 = 0;
        final int n5 = n2 >>> 26 & 0xFF;
        final int n6 = n2 >>> 21 & 0x1F;
        final int n7 = n2 >>> 16 & 0x1F;
        final int n8 = n2 >>> 16 & 0x1F;
        final int n9 = n2 >>> 11 & 0x1F;
        final int n10 = n2 >>> 11 & 0x1F;
        final int n11 = n2 >>> 6 & 0x1F;
        final int n12 = n2 >>> 6 & 0x1F;
        final int n13 = n2 & 0x3F;
        final int n14 = n2 >>> 6 & 0xFFFFF;
        final int n15 = n2 & 0x3FFFFFF;
        final int n16 = n2 & 0xFFFF;
        final int n18;
        final int n17 = n18 = n2 << 16 >> 16;
        Label_7720: {
            switch (n5) {
                case 0: {
                    switch (n13) {
                        case 0: {
                            if (n2 == 0) {
                                break Label_7720;
                            }
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)18, n11);
                            mg.add((byte)120);
                            this.setReg();
                            break Label_7720;
                        }
                        case 2: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)18, n11);
                            mg.add((byte)124);
                            this.setReg();
                            break Label_7720;
                        }
                        case 3: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)18, n11);
                            mg.add((byte)122);
                            this.setReg();
                            break Label_7720;
                        }
                        case 4: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n7);
                            this.pushRegWZ(0 + n6);
                            mg.add((byte)120);
                            this.setReg();
                            break Label_7720;
                        }
                        case 6: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n7);
                            this.pushRegWZ(0 + n6);
                            mg.add((byte)124);
                            this.setReg();
                            break Label_7720;
                        }
                        case 7: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n7);
                            this.pushRegWZ(0 + n6);
                            mg.add((byte)122);
                            this.setReg();
                            break Label_7720;
                        }
                        case 8: {
                            if (n == -1) {
                                throw new Compiler$Exn("pc modifying insn in delay slot");
                            }
                            this.emitInstruction(-1, n3, -1);
                            this.preSetPC();
                            this.pushRegWZ(0 + n6);
                            this.setPC();
                            this.leaveMethod();
                            n4 |= 0x1;
                            break Label_7720;
                        }
                        case 9: {
                            if (n == -1) {
                                throw new Compiler$Exn("pc modifying insn in delay slot");
                            }
                            this.emitInstruction(-1, n3, -1);
                            this.link(n);
                            this.preSetPC();
                            this.pushRegWZ(0 + n6);
                            this.setPC();
                            this.leaveMethod();
                            n4 |= 0x1;
                            break Label_7720;
                        }
                        case 12: {
                            this.preSetPC();
                            mg.add((byte)18, n);
                            this.setPC();
                            this.restoreChangedRegs();
                            this.preSetReg(2);
                            mg.add((byte)42);
                            this.pushRegZ(2);
                            this.pushRegZ(4);
                            this.pushRegZ(5);
                            this.pushRegZ(6);
                            this.pushRegZ(7);
                            this.pushRegZ(8);
                            this.pushRegZ(9);
                            mg.add((byte)(-74), (Object)this.me.method("syscall", Type.INT, new Type[] { Type.INT, Type.INT, Type.INT, Type.INT, Type.INT, Type.INT, Type.INT }));
                            this.setReg();
                            mg.add((byte)42);
                            mg.add((byte)(-76), (Object)this.me.field("state", Type.INT));
                            final int add = mg.add((byte)(-103));
                            this.preSetPC();
                            mg.add((byte)18, n + 4);
                            this.setPC();
                            this.leaveMethod();
                            mg.setArg(add, mg.size());
                            break Label_7720;
                        }
                        case 13: {
                            mg.add((byte)(-69), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
                            mg.add((byte)89);
                            mg.add((byte)18, (Object)("BREAK Code " + Compiler.toHex(n14)));
                            mg.add((byte)(-73), (Object)Type$Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[] { Type.STRING }));
                            mg.add((byte)(-65));
                            n4 |= 0x1;
                            break Label_7720;
                        }
                        case 16: {
                            this.preSetReg(0 + n9);
                            this.pushReg(64);
                            this.setReg();
                            break Label_7720;
                        }
                        case 17: {
                            this.preSetReg(64);
                            this.pushRegZ(0 + n6);
                            this.setReg();
                            break Label_7720;
                        }
                        case 18: {
                            this.preSetReg(0 + n9);
                            this.pushReg(65);
                            this.setReg();
                            break Label_7720;
                        }
                        case 19: {
                            this.preSetReg(65);
                            this.pushRegZ(0 + n6);
                            this.setReg();
                            break Label_7720;
                        }
                        case 24: {
                            this.pushRegWZ(0 + n6);
                            mg.add((byte)(-123));
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)(-123));
                            mg.add((byte)105);
                            mg.add((byte)92);
                            mg.add((byte)(-120));
                            if (this.preSetReg(65)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            mg.add((byte)18, 32);
                            mg.add((byte)125);
                            mg.add((byte)(-120));
                            if (this.preSetReg(64)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 25: {
                            this.pushRegWZ(0 + n6);
                            mg.add((byte)(-123));
                            mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                            mg.add((byte)127);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)(-123));
                            mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                            mg.add((byte)127);
                            mg.add((byte)105);
                            mg.add((byte)92);
                            mg.add((byte)(-120));
                            if (this.preSetReg(65)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            mg.add((byte)18, 32);
                            mg.add((byte)125);
                            mg.add((byte)(-120));
                            if (this.preSetReg(64)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 26: {
                            this.pushRegWZ(0 + n6);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)92);
                            mg.add((byte)108);
                            if (this.preSetReg(65)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            mg.add((byte)112);
                            if (this.preSetReg(64)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 27: {
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)89);
                            this.setTmp();
                            final int add2 = mg.add((byte)(-103));
                            this.pushRegWZ(0 + n6);
                            mg.add((byte)(-123));
                            mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                            mg.add((byte)127);
                            mg.add((byte)92);
                            this.pushTmp();
                            mg.add((byte)(-123));
                            mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                            mg.add((byte)127);
                            mg.add((byte)94);
                            mg.add((byte)109);
                            mg.add((byte)(-120));
                            if (this.preSetReg(65)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            mg.add((byte)113);
                            mg.add((byte)(-120));
                            if (this.preSetReg(64)) {
                                mg.add((byte)95);
                            }
                            this.setReg();
                            mg.setArg(add2, mg.size());
                            break Label_7720;
                        }
                        case 32: {
                            throw new Compiler$Exn("ADD (add with oveflow trap) not suported");
                        }
                        case 33: {
                            this.preSetReg(0 + n9);
                            if (n7 != 0 && n6 != 0) {
                                this.pushReg(0 + n6);
                                this.pushReg(0 + n7);
                                mg.add((byte)96);
                            }
                            else if (n6 != 0) {
                                this.pushReg(0 + n6);
                            }
                            else {
                                this.pushRegZ(0 + n7);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 34: {
                            throw new Compiler$Exn("SUB (add with oveflow trap) not suported");
                        }
                        case 35: {
                            this.preSetReg(0 + n9);
                            if (n7 != 0 && n6 != 0) {
                                this.pushReg(0 + n6);
                                this.pushReg(0 + n7);
                                mg.add((byte)100);
                            }
                            else if (n7 != 0) {
                                this.pushReg(0 + n7);
                                mg.add((byte)116);
                            }
                            else {
                                this.pushRegZ(0 + n6);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 36: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n6);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)126);
                            this.setReg();
                            break Label_7720;
                        }
                        case 37: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n6);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)(-128));
                            this.setReg();
                            break Label_7720;
                        }
                        case 38: {
                            this.preSetReg(0 + n9);
                            this.pushRegWZ(0 + n6);
                            this.pushRegWZ(0 + n7);
                            mg.add((byte)(-126));
                            this.setReg();
                            break Label_7720;
                        }
                        case 39: {
                            this.preSetReg(0 + n9);
                            if (n6 != 0 || n7 != 0) {
                                if (n6 != 0 && n7 != 0) {
                                    this.pushReg(0 + n6);
                                    this.pushReg(0 + n7);
                                    mg.add((byte)(-128));
                                }
                                else if (n6 != 0) {
                                    this.pushReg(0 + n6);
                                }
                                else {
                                    this.pushReg(0 + n7);
                                }
                                mg.add((byte)2);
                                mg.add((byte)(-126));
                            }
                            else {
                                mg.add((byte)18, -1);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 42: {
                            this.preSetReg(0 + n9);
                            if (n6 != n7) {
                                this.pushRegZ(0 + n6);
                                this.pushRegZ(0 + n7);
                                final int add3 = mg.add((byte)(-95));
                                mg.add((byte)3);
                                final int add4 = mg.add((byte)(-89));
                                mg.setArg(add3, mg.add((byte)4));
                                mg.setArg(add4, mg.size());
                            }
                            else {
                                mg.add((byte)18, 0);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 43: {
                            this.preSetReg(0 + n9);
                            if (n6 != n7) {
                                int n19;
                                if (n6 != 0) {
                                    this.pushReg(0 + n6);
                                    mg.add((byte)(-123));
                                    mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                                    mg.add((byte)127);
                                    this.pushReg(0 + n7);
                                    mg.add((byte)(-123));
                                    mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                                    mg.add((byte)127);
                                    mg.add((byte)(-108));
                                    n19 = mg.add((byte)(-101));
                                }
                                else {
                                    this.pushReg(0 + n7);
                                    n19 = mg.add((byte)(-102));
                                }
                                mg.add((byte)3);
                                final int add5 = mg.add((byte)(-89));
                                mg.setArg(n19, mg.add((byte)4));
                                mg.setArg(add5, mg.size());
                            }
                            else {
                                mg.add((byte)18, 0);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        default: {
                            throw new Compiler$Exn("Illegal instruction 0/" + n13);
                        }
                    }
                    break;
                }
                case 1: {
                    switch (n7) {
                        case 0: {
                            if (n == -1) {
                                throw new Compiler$Exn("pc modifying insn in delay slot");
                            }
                            this.pushRegWZ(0 + n6);
                            return this.doIfInstruction((byte)(-101), n, n + n18 * 4 + 4, n3);
                        }
                        case 1: {
                            if (n == -1) {
                                throw new Compiler$Exn("pc modifying insn in delay slot");
                            }
                            this.pushRegWZ(0 + n6);
                            return this.doIfInstruction((byte)(-100), n, n + n18 * 4 + 4, n3);
                        }
                        case 16: {
                            if (n == -1) {
                                throw new Compiler$Exn("pc modifying insn in delay slot");
                            }
                            this.pushRegWZ(0 + n6);
                            final int add6 = mg.add((byte)(-100));
                            this.emitInstruction(-1, n3, -1);
                            this.link(n);
                            this.branch(n, n + n18 * 4 + 4);
                            mg.setArg(add6, mg.size());
                            break Label_7720;
                        }
                        case 17: {
                            if (n == -1) {
                                throw new Compiler$Exn("pc modifying insn in delay slot");
                            }
                            int add7 = -1;
                            if (n6 != 0) {
                                this.pushRegWZ(0 + n6);
                                add7 = mg.add((byte)(-101));
                            }
                            this.emitInstruction(-1, n3, -1);
                            this.link(n);
                            this.branch(n, n + n18 * 4 + 4);
                            if (add7 != -1) {
                                mg.setArg(add7, mg.size());
                            }
                            if (add7 == -1) {
                                n4 |= 0x1;
                                break Label_7720;
                            }
                            break Label_7720;
                        }
                        default: {
                            throw new Compiler$Exn("Illegal Instruction 1/" + n7);
                        }
                    }
                    break;
                }
                case 2: {
                    if (n == -1) {
                        throw new Compiler$Exn("pc modifying insn in delay slot");
                    }
                    this.emitInstruction(-1, n3, -1);
                    this.branch(n, (n & 0xF0000000) | n15 << 2);
                    n4 |= 0x1;
                    break;
                }
                case 3: {
                    if (n == -1) {
                        throw new Compiler$Exn("pc modifying insn in delay slot");
                    }
                    final int n20 = (n & 0xF0000000) | n15 << 2;
                    this.emitInstruction(-1, n3, -1);
                    this.link(n);
                    this.branch(n, n20);
                    n4 |= 0x1;
                    break;
                }
                case 4: {
                    if (n == -1) {
                        throw new Compiler$Exn("pc modifying insn in delay slot");
                    }
                    if (n6 == n7) {
                        this.emitInstruction(-1, n3, -1);
                        this.branch(n, n + n18 * 4 + 4);
                        n4 |= 0x1;
                        break;
                    }
                    if (n6 == 0 || n7 == 0) {
                        this.pushReg((n7 == 0) ? (0 + n6) : (0 + n7));
                        return this.doIfInstruction((byte)(-103), n, n + n18 * 4 + 4, n3);
                    }
                    this.pushReg(0 + n6);
                    this.pushReg(0 + n7);
                    return this.doIfInstruction((byte)(-97), n, n + n18 * 4 + 4, n3);
                }
                case 5: {
                    if (n == -1) {
                        throw new Compiler$Exn("pc modifying insn in delay slot");
                    }
                    this.pushRegWZ(0 + n6);
                    if (n7 == 0) {
                        return this.doIfInstruction((byte)(-102), n, n + n18 * 4 + 4, n3);
                    }
                    this.pushReg(0 + n7);
                    return this.doIfInstruction((byte)(-96), n, n + n18 * 4 + 4, n3);
                }
                case 6: {
                    if (n == -1) {
                        throw new Compiler$Exn("pc modifying insn in delay slot");
                    }
                    this.pushRegWZ(0 + n6);
                    return this.doIfInstruction((byte)(-98), n, n + n18 * 4 + 4, n3);
                }
                case 7: {
                    if (n == -1) {
                        throw new Compiler$Exn("pc modifying insn in delay slot");
                    }
                    this.pushRegWZ(0 + n6);
                    return this.doIfInstruction((byte)(-99), n, n + n18 * 4 + 4, n3);
                }
                case 8: {
                    throw new Compiler$Exn("ADDI (add immediate with oveflow trap) not suported");
                }
                case 9: {
                    if (n6 != 0 && n17 != 0 && n6 == n7 && this.doLocal(n7) && n17 >= -32768 && n17 <= 32767) {
                        this.regLocalWritten[n7] = true;
                        mg.add((byte)(-124), (Object)new MethodGen$Pair(this.getLocalForReg(n7), n17));
                        break;
                    }
                    this.preSetReg(0 + n7);
                    this.addiu(n6, n17);
                    this.setReg();
                    break;
                }
                case 10: {
                    this.preSetReg(0 + n7);
                    this.pushRegWZ(0 + n6);
                    mg.add((byte)18, n17);
                    final int add8 = mg.add((byte)(-95));
                    mg.add((byte)3);
                    final int add9 = mg.add((byte)(-89));
                    mg.setArg(add8, mg.add((byte)4));
                    mg.setArg(add9, mg.size());
                    this.setReg();
                    break;
                }
                case 11: {
                    this.preSetReg(0 + n7);
                    this.pushRegWZ(0 + n6);
                    mg.add((byte)(-123));
                    mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
                    mg.add((byte)127);
                    mg.add((byte)18, (Object)new Long(n17 & 0xFFFFFFFFL));
                    mg.add((byte)(-108));
                    final int add10 = mg.add((byte)(-101));
                    mg.add((byte)3);
                    final int add11 = mg.add((byte)(-89));
                    mg.setArg(add10, mg.add((byte)4));
                    mg.setArg(add11, mg.size());
                    this.setReg();
                    break;
                }
                case 12: {
                    this.preSetReg(0 + n7);
                    this.pushRegWZ(0 + n6);
                    mg.add((byte)18, n16);
                    mg.add((byte)126);
                    this.setReg();
                    break;
                }
                case 13: {
                    this.preSetReg(0 + n7);
                    if (n6 != 0 && n16 != 0) {
                        this.pushReg(0 + n6);
                        mg.add((byte)18, n16);
                        mg.add((byte)(-128));
                    }
                    else if (n6 != 0) {
                        this.pushReg(0 + n6);
                    }
                    else {
                        mg.add((byte)18, n16);
                    }
                    this.setReg();
                    break;
                }
                case 14: {
                    this.preSetReg(0 + n7);
                    this.pushRegWZ(0 + n6);
                    mg.add((byte)18, n16);
                    mg.add((byte)(-126));
                    this.setReg();
                    break;
                }
                case 15: {
                    this.preSetReg(0 + n7);
                    mg.add((byte)18, n16 << 16);
                    this.setReg();
                    break;
                }
                case 16: {
                    throw new Compiler$Exn("TLB/Exception support not implemented");
                }
                case 17: {
                    switch (n6) {
                        case 0: {
                            this.preSetReg(0 + n7);
                            this.pushReg(32 + n9);
                            this.setReg();
                            break Label_7720;
                        }
                        case 2: {
                            if (n10 != 31) {
                                throw new Compiler$Exn("FCR " + n10 + " unavailable");
                            }
                            this.preSetReg(0 + n7);
                            this.pushReg(66);
                            this.setReg();
                            break Label_7720;
                        }
                        case 4: {
                            this.preSetReg(32 + n9);
                            if (n7 != 0) {
                                this.pushReg(0 + n7);
                            }
                            else {
                                mg.add((byte)3);
                            }
                            this.setReg();
                            break Label_7720;
                        }
                        case 6: {
                            if (n10 != 31) {
                                throw new Compiler$Exn("FCR " + n10 + " unavailable");
                            }
                            this.preSetReg(66);
                            this.pushReg(0 + n7);
                            this.setReg();
                            break Label_7720;
                        }
                        case 8: {
                            this.pushReg(66);
                            mg.add((byte)18, 8388608);
                            mg.add((byte)126);
                            return this.doIfInstruction((byte)(((n2 >>> 16 & 0x1) == 0x0) ? -103 : -102), n, n + n18 * 4 + 4, n3);
                        }
                        case 16:
                        case 17: {
                            final boolean b = n6 == 17;
                            switch (n13) {
                                case 0: {
                                    this.preSetDouble(32 + n12, b);
                                    this.pushDouble(32 + n10, b);
                                    this.pushDouble(32 + n8, b);
                                    mg.add((byte)(b ? 99 : 98));
                                    this.setDouble(b);
                                    break Label_7720;
                                }
                                case 1: {
                                    this.preSetDouble(32 + n12, b);
                                    this.pushDouble(32 + n10, b);
                                    this.pushDouble(32 + n8, b);
                                    mg.add((byte)(b ? 103 : 102));
                                    this.setDouble(b);
                                    break Label_7720;
                                }
                                case 2: {
                                    this.preSetDouble(32 + n12, b);
                                    this.pushDouble(32 + n10, b);
                                    this.pushDouble(32 + n8, b);
                                    mg.add((byte)(b ? 107 : 106));
                                    this.setDouble(b);
                                    break Label_7720;
                                }
                                case 3: {
                                    this.preSetDouble(32 + n12, b);
                                    this.pushDouble(32 + n10, b);
                                    this.pushDouble(32 + n8, b);
                                    mg.add((byte)(b ? 111 : 110));
                                    this.setDouble(b);
                                    break Label_7720;
                                }
                                case 5: {
                                    this.preSetDouble(32 + n12, b);
                                    this.pushDouble(32 + n10, b);
                                    mg.add((byte)(b ? 92 : 89));
                                    mg.add((byte)(b ? 14 : 11));
                                    mg.add((byte)(b ? -104 : -106));
                                    final int add12 = mg.add((byte)(-99));
                                    mg.add((byte)(b ? 14 : 11));
                                    if (b) {
                                        mg.add((byte)94);
                                        mg.add((byte)88);
                                    }
                                    else {
                                        mg.add((byte)95);
                                    }
                                    mg.add((byte)(b ? 103 : 102));
                                    mg.setArg(add12, mg.size());
                                    this.setDouble(b);
                                    break Label_7720;
                                }
                                case 6: {
                                    this.preSetReg(32 + n12);
                                    this.pushReg(32 + n10);
                                    this.setReg();
                                    if (b) {
                                        this.preSetReg(32 + n12 + 1);
                                        this.pushReg(32 + n10 + 1);
                                        this.setReg();
                                        break Label_7720;
                                    }
                                    break Label_7720;
                                }
                                case 7: {
                                    this.preSetDouble(32 + n12, b);
                                    this.pushDouble(32 + n10, b);
                                    mg.add((byte)(b ? 119 : 118));
                                    this.setDouble(b);
                                    break Label_7720;
                                }
                                case 32: {
                                    this.preSetFloat(32 + n12);
                                    this.pushDouble(32 + n10, b);
                                    if (b) {
                                        mg.add((byte)(-112));
                                    }
                                    this.setFloat();
                                    break Label_7720;
                                }
                                case 33: {
                                    this.preSetDouble(32 + n12);
                                    this.pushDouble(32 + n10, b);
                                    if (!b) {
                                        mg.add((byte)(-115));
                                    }
                                    this.setDouble();
                                    break Label_7720;
                                }
                                case 36: {
                                    final MethodGen$Switch$Table methodGen$Switch$Table = new MethodGen$Switch$Table(0, 3);
                                    this.preSetReg(32 + n12);
                                    this.pushDouble(32 + n10, b);
                                    this.pushReg(66);
                                    mg.add((byte)6);
                                    mg.add((byte)126);
                                    mg.add((byte)(-86), (Object)methodGen$Switch$Table);
                                    methodGen$Switch$Table.setTarget(2, mg.size());
                                    if (!b) {
                                        mg.add((byte)(-115));
                                    }
                                    mg.add((byte)(-72), (Object)Type$Class.instance("java.lang.Math").method("ceil", Type.DOUBLE, new Type[] { Type.DOUBLE }));
                                    if (!b) {
                                        mg.add((byte)(-112));
                                    }
                                    final int add13 = mg.add((byte)(-89));
                                    methodGen$Switch$Table.setTarget(0, mg.size());
                                    mg.add((byte)18, (Object)(b ? ClassFileCompiler.POINT_5_D : ClassFileCompiler.POINT_5_F));
                                    mg.add((byte)(b ? 99 : 98));
                                    methodGen$Switch$Table.setTarget(3, mg.size());
                                    if (!b) {
                                        mg.add((byte)(-115));
                                    }
                                    mg.add((byte)(-72), (Object)Type$Class.instance("java.lang.Math").method("floor", Type.DOUBLE, new Type[] { Type.DOUBLE }));
                                    if (!b) {
                                        mg.add((byte)(-112));
                                    }
                                    methodGen$Switch$Table.setTarget(1, mg.size());
                                    methodGen$Switch$Table.setDefaultTarget(mg.size());
                                    mg.setArg(add13, mg.size());
                                    mg.add((byte)(b ? -114 : -117));
                                    this.setReg();
                                    break Label_7720;
                                }
                                case 50:
                                case 60:
                                case 62: {
                                    this.preSetReg(66);
                                    this.pushReg(66);
                                    mg.add((byte)18, -8388609);
                                    mg.add((byte)126);
                                    this.pushDouble(32 + n10, b);
                                    this.pushDouble(32 + n8, b);
                                    mg.add((byte)(b ? -104 : -106));
                                    int n21 = 0;
                                    switch (n13) {
                                        case 50: {
                                            n21 = mg.add((byte)(-102));
                                            break;
                                        }
                                        case 60: {
                                            n21 = mg.add((byte)(-100));
                                            break;
                                        }
                                        case 62: {
                                            n21 = mg.add((byte)(-99));
                                            break;
                                        }
                                        default: {
                                            n21 = -1;
                                            break;
                                        }
                                    }
                                    mg.add((byte)18, 8388608);
                                    mg.add((byte)(-128));
                                    mg.setArg(n21, mg.size());
                                    this.setReg();
                                    break Label_7720;
                                }
                                default: {
                                    throw new Compiler$Exn("Invalid Instruction 17/" + n6 + "/" + n13);
                                }
                            }
                            break;
                        }
                        case 20: {
                            switch (n13) {
                                case 32: {
                                    this.preSetFloat(32 + n12);
                                    this.pushReg(32 + n10);
                                    mg.add((byte)(-122));
                                    this.setFloat();
                                    break Label_7720;
                                }
                                case 33: {
                                    this.preSetDouble(32 + n12);
                                    this.pushReg(32 + n10);
                                    mg.add((byte)(-121));
                                    this.setDouble();
                                    break Label_7720;
                                }
                                default: {
                                    throw new Compiler$Exn("Invalid Instruction 17/" + n6 + "/" + n13);
                                }
                            }
                            break;
                        }
                        default: {
                            throw new Compiler$Exn("Invalid Instruction 17/" + n6);
                        }
                    }
                    break;
                }
                case 18:
                case 19: {
                    throw new Compiler$Exn("coprocessor 2 and 3 instructions not available");
                }
                case 32: {
                    this.preSetReg(0 + n7);
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead();
                    this.pushTmp();
                    this.memRead(true);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)(-111));
                    this.setReg();
                    break;
                }
                case 33: {
                    this.preSetReg(0 + n7);
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead();
                    this.pushTmp();
                    this.memRead(true);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)5);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)(-109));
                    this.setReg();
                    break;
                }
                case 34: {
                    this.preSetReg(0 + n7);
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.pushRegWZ(0 + n7);
                    mg.add((byte)18, 16777215);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)126);
                    this.preMemRead();
                    this.pushTmp();
                    this.memRead(true);
                    this.pushTmp();
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)(-128));
                    this.setReg();
                    break;
                }
                case 35: {
                    this.preSetReg(0 + n7);
                    this.memRead(0 + n6, n17);
                    this.setReg();
                    break;
                }
                case 36: {
                    this.preSetReg(0 + n7);
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead();
                    this.pushTmp();
                    this.memRead(true);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)18, 255);
                    mg.add((byte)126);
                    this.setReg();
                    break;
                }
                case 37: {
                    this.preSetReg(0 + n7);
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead();
                    this.pushTmp();
                    this.memRead(true);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)5);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)(-110));
                    this.setReg();
                    break;
                }
                case 38: {
                    this.preSetReg(0 + n7);
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.pushRegWZ(0 + n7);
                    mg.add((byte)18, -256);
                    this.pushTmp();
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)126);
                    this.preMemRead();
                    this.pushTmp();
                    this.memRead(true);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)(-128));
                    this.setReg();
                    break;
                }
                case 40: {
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead(true);
                    this.pushTmp();
                    this.memRead(true);
                    mg.add((byte)18, -16777216);
                    this.pushTmp();
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)126);
                    if (n7 != 0) {
                        this.pushReg(0 + n7);
                        mg.add((byte)18, 255);
                        mg.add((byte)126);
                    }
                    else {
                        mg.add((byte)18, 0);
                    }
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)(-128));
                    this.memWrite();
                    break;
                }
                case 41: {
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead(true);
                    this.pushTmp();
                    this.memRead(true);
                    mg.add((byte)18, 65535);
                    this.pushTmp();
                    mg.add((byte)5);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)126);
                    if (n7 != 0) {
                        this.pushReg(0 + n7);
                        mg.add((byte)18, 65535);
                        mg.add((byte)126);
                    }
                    else {
                        mg.add((byte)18, 0);
                    }
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)5);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)(-128));
                    this.memWrite();
                    break;
                }
                case 42: {
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead(true);
                    this.pushTmp();
                    this.memRead(true);
                    mg.add((byte)18, -256);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)126);
                    this.pushRegWZ(0 + n7);
                    this.pushTmp();
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)(-128));
                    this.memWrite();
                    break;
                }
                case 43: {
                    this.preMemWrite1();
                    this.preMemWrite2(0 + n6, n17);
                    this.pushRegZ(0 + n7);
                    this.memWrite();
                    break;
                }
                case 46: {
                    this.addiu(0 + n6, n17);
                    this.setTmp();
                    this.preMemRead(true);
                    this.pushTmp();
                    this.memRead(true);
                    mg.add((byte)18, 16777215);
                    this.pushTmp();
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)124);
                    mg.add((byte)126);
                    this.pushRegWZ(0 + n7);
                    this.pushTmp();
                    mg.add((byte)2);
                    mg.add((byte)(-126));
                    mg.add((byte)6);
                    mg.add((byte)126);
                    mg.add((byte)6);
                    mg.add((byte)120);
                    mg.add((byte)120);
                    mg.add((byte)(-128));
                    this.memWrite();
                    break;
                }
                case 48: {
                    this.preSetReg(0 + n7);
                    this.memRead(0 + n6, n17);
                    this.setReg();
                    break;
                }
                case 49: {
                    this.preSetReg(32 + n7);
                    this.memRead(0 + n6, n17);
                    this.setReg();
                    break;
                }
                case 56: {
                    this.preSetReg(0 + n7);
                    this.preMemWrite1();
                    this.preMemWrite2(0 + n6, n17);
                    this.pushReg(0 + n7);
                    this.memWrite();
                    mg.add((byte)18, 1);
                    this.setReg();
                    break;
                }
                case 57: {
                    this.preMemWrite1();
                    this.preMemWrite2(0 + n6, n17);
                    this.pushReg(32 + n7);
                    this.memWrite();
                    break;
                }
                default: {
                    throw new Compiler$Exn("Invalid Instruction: " + n5 + " at " + Compiler.toHex(n));
                }
            }
        }
        return n4;
    }
    
    private boolean doLocal(final int n) {
        return n == 2 || n == 3 || n == 4 || n == 29;
    }
    
    private int getLocalForReg(final int n) {
        if (this.regLocalMapping[n] != 0) {
            return this.regLocalMapping[n];
        }
        return this.regLocalMapping[n] = this.nextAvailLocal++;
    }
    
    private void fixupRegsStart() {
        for (int i = 0; i < 67; ++i) {
            this.regLocalMapping[i] = 0;
            this.regLocalWritten[i] = false;
        }
        this.nextAvailLocal = (this.onePage ? 4 : 5);
        this.loadsStart = this.mg.size();
        for (int j = 0; j < 12; ++j) {
            this.mg.add((byte)0);
        }
    }
    
    private void fixupRegsEnd() {
        int loadsStart = this.loadsStart;
        for (int i = 0; i < 67; ++i) {
            if (this.regLocalMapping[i] != 0) {
                this.mg.set(loadsStart++, (byte)42);
                this.mg.set(loadsStart++, (byte)(-76), (Object)this.me.field(ClassFileCompiler.regField[i], Type.INT));
                this.mg.set(loadsStart++, (byte)54, this.regLocalMapping[i]);
                if (this.regLocalWritten[i]) {
                    this.mg.add((byte)42);
                    this.mg.add((byte)21, this.regLocalMapping[i]);
                    this.mg.add((byte)(-75), (Object)this.me.field(ClassFileCompiler.regField[i], Type.INT));
                }
            }
        }
    }
    
    private void restoreChangedRegs() {
        for (int i = 0; i < 67; ++i) {
            if (this.regLocalWritten[i]) {
                this.mg.add((byte)42);
                this.mg.add((byte)21, this.regLocalMapping[i]);
                this.mg.add((byte)(-75), (Object)this.me.field(ClassFileCompiler.regField[i], Type.INT));
            }
        }
    }
    
    private int pushRegWZ(final int n) {
        if (n == 0) {
            this.warn.println("Warning: Pushing r0!");
            new Exception().printStackTrace(this.warn);
        }
        return this.pushRegZ(n);
    }
    
    private int pushRegZ(final int n) {
        if (n == 0) {
            return this.mg.add((byte)3);
        }
        return this.pushReg(n);
    }
    
    private int pushReg(final int n) {
        final int size = this.mg.size();
        if (this.doLocal(n)) {
            this.mg.add((byte)21, this.getLocalForReg(n));
        }
        else if (n >= 32 && n <= 63 && this.singleFloat) {
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field(ClassFileCompiler.regField[n], Type.FLOAT));
            this.mg.add((byte)(-72), (Object)Type.FLOAT_OBJECT.method("floatToIntBits", Type.INT, new Type[] { Type.FLOAT }));
        }
        else {
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field(ClassFileCompiler.regField[n], Type.INT));
        }
        return size;
    }
    
    private boolean preSetReg(final int n) {
        this.preSetRegStack[this.preSetRegStackPos] = n;
        ++this.preSetRegStackPos;
        if (this.doLocal(n)) {
            return false;
        }
        this.mg.add((byte)42);
        return true;
    }
    
    private int setReg() {
        if (this.preSetRegStackPos == 0) {
            throw new RuntimeException("didn't do preSetReg");
        }
        --this.preSetRegStackPos;
        final int n = this.preSetRegStack[this.preSetRegStackPos];
        final int size = this.mg.size();
        if (this.doLocal(n)) {
            this.mg.add((byte)54, this.getLocalForReg(n));
            this.regLocalWritten[n] = true;
        }
        else if (n >= 32 && n <= 63 && this.singleFloat) {
            this.mg.add((byte)(-72), (Object)Type.FLOAT_OBJECT.method("intBitsToFloat", Type.FLOAT, new Type[] { Type.INT }));
            this.mg.add((byte)(-75), (Object)this.me.field(ClassFileCompiler.regField[n], Type.FLOAT));
        }
        else {
            this.mg.add((byte)(-75), (Object)this.me.field(ClassFileCompiler.regField[n], Type.INT));
        }
        return size;
    }
    
    private int preSetPC() {
        return this.mg.add((byte)42);
    }
    
    private int setPC() {
        return this.mg.add((byte)(-75), (Object)this.me.field("pc", Type.INT));
    }
    
    private int pushFloat(final int n) {
        return this.pushDouble(n, false);
    }
    
    private int pushDouble(final int n, final boolean b) {
        if (n < 32 || n >= 64) {
            throw new IllegalArgumentException("" + n);
        }
        final int size = this.mg.size();
        if (b) {
            if (this.singleFloat) {
                throw new Compiler$Exn("Double operations not supported when singleFloat is enabled");
            }
            if (n == 63) {
                throw new Compiler$Exn("Tried to use a double in f31");
            }
            this.pushReg(n + 1);
            this.mg.add((byte)(-123));
            this.mg.add((byte)18, 32);
            this.mg.add((byte)121);
            this.pushReg(n);
            this.mg.add((byte)(-123));
            this.mg.add((byte)18, (Object)ClassFileCompiler.FFFFFFFF);
            this.mg.add((byte)127);
            this.mg.add((byte)(-127));
            this.mg.add((byte)(-72), (Object)Type.DOUBLE_OBJECT.method("longBitsToDouble", Type.DOUBLE, new Type[] { Type.LONG }));
        }
        else if (this.singleFloat) {
            this.mg.add((byte)42);
            this.mg.add((byte)(-76), (Object)this.me.field(ClassFileCompiler.regField[n], Type.FLOAT));
        }
        else {
            this.pushReg(n);
            this.mg.add((byte)(-72), (Object)Type$Class.instance("java.lang.Float").method("intBitsToFloat", Type.FLOAT, new Type[] { Type.INT }));
        }
        return size;
    }
    
    private void preSetFloat(final int n) {
        this.preSetDouble(n, false);
    }
    
    private void preSetDouble(final int n) {
        this.preSetDouble(n, true);
    }
    
    private void preSetDouble(final int n, final boolean b) {
        this.preSetReg(n);
    }
    
    private int setFloat() {
        return this.setDouble(false);
    }
    
    private int setDouble() {
        return this.setDouble(true);
    }
    
    private int setDouble(final boolean b) {
        final int n = this.preSetRegStack[this.preSetRegStackPos - 1];
        if (n < 32 || n >= 64) {
            throw new IllegalArgumentException("" + n);
        }
        final int size = this.mg.size();
        if (b) {
            if (this.singleFloat) {
                throw new Compiler$Exn("Double operations not supported when singleFloat is enabled");
            }
            if (n == 63) {
                throw new Compiler$Exn("Tried to use a double in f31");
            }
            this.mg.add((byte)(-72), (Object)Type.DOUBLE_OBJECT.method("doubleToLongBits", Type.LONG, new Type[] { Type.DOUBLE }));
            this.mg.add((byte)92);
            this.mg.add((byte)18, 32);
            this.mg.add((byte)125);
            this.mg.add((byte)(-120));
            if (this.preSetReg(n + 1)) {
                this.mg.add((byte)95);
            }
            this.setReg();
            this.mg.add((byte)(-120));
            this.setReg();
        }
        else if (this.singleFloat) {
            --this.preSetRegStackPos;
            this.mg.add((byte)(-75), (Object)this.me.field(ClassFileCompiler.regField[n], Type.FLOAT));
        }
        else {
            this.mg.add((byte)(-72), (Object)Type.FLOAT_OBJECT.method("floatToRawIntBits", Type.INT, new Type[] { Type.FLOAT }));
            this.setReg();
        }
        return size;
    }
    
    private void pushTmp() {
        this.mg.add((byte)27);
    }
    
    private void setTmp() {
        this.mg.add((byte)60);
    }
    
    private void addiu(final int n, final int n2) {
        if (n != 0 && n2 != 0) {
            this.pushReg(n);
            this.mg.add((byte)18, n2);
            this.mg.add((byte)96);
        }
        else if (n != 0) {
            this.pushReg(n);
        }
        else {
            this.mg.add((byte)18, n2);
        }
    }
    
    private void preMemWrite1() {
        if (this.memWriteStage != 0) {
            throw new Error("pending preMemWrite1/2");
        }
        this.memWriteStage = 1;
        if (this.onePage) {
            this.mg.add((byte)44);
        }
        else if (this.fastMem) {
            this.mg.add((byte)25, 3);
        }
        else {
            this.mg.add((byte)42);
        }
    }
    
    private void preMemWrite2(final int n, final int n2) {
        this.addiu(n, n2);
        this.preMemWrite2();
    }
    
    private void preMemWrite2() {
        this.preMemWrite2(false);
    }
    
    private void preMemWrite2(final boolean b) {
        if (this.memWriteStage != 1) {
            throw new Error("pending preMemWrite2 or no preMemWrite1");
        }
        this.memWriteStage = 2;
        if (this.nullPointerCheck) {
            this.mg.add((byte)89);
            this.mg.add((byte)42);
            this.mg.add((byte)95);
            this.mg.add((byte)(-74), (Object)this.me.method("nullPointerCheck", Type.VOID, new Type[] { Type.INT }));
        }
        if (this.onePage) {
            this.mg.add((byte)5);
            this.mg.add((byte)124);
        }
        else if (this.fastMem) {
            if (!b) {
                this.mg.add((byte)90);
            }
            this.mg.add((byte)18, this.pageShift);
            this.mg.add((byte)124);
            this.mg.add((byte)50);
            if (b) {
                this.pushTmp();
            }
            else {
                this.mg.add((byte)95);
            }
            this.mg.add((byte)5);
            this.mg.add((byte)124);
            this.mg.add((byte)18, (this.pageSize >> 2) - 1);
            this.mg.add((byte)126);
        }
    }
    
    private void memWrite() {
        if (this.memWriteStage != 2) {
            throw new Error("didn't do preMemWrite1 or preMemWrite2");
        }
        this.memWriteStage = 0;
        if (this.onePage) {
            this.mg.add((byte)79);
        }
        else if (this.fastMem) {
            this.mg.add((byte)79);
        }
        else {
            this.mg.add((byte)(-74), (Object)this.me.method("unsafeMemWrite", Type.VOID, new Type[] { Type.INT, Type.INT }));
        }
    }
    
    private void memRead(final int n, final int n2) {
        this.preMemRead();
        this.addiu(n, n2);
        this.memRead();
    }
    
    private void preMemRead() {
        this.preMemRead(false);
    }
    
    private void preMemRead(final boolean preMemReadDoPreWrite) {
        if (this.didPreMemRead) {
            throw new Error("pending preMemRead");
        }
        this.didPreMemRead = true;
        this.preMemReadDoPreWrite = preMemReadDoPreWrite;
        if (this.onePage) {
            this.mg.add((byte)44);
        }
        else if (this.fastMem) {
            this.mg.add((byte)25, preMemReadDoPreWrite ? 3 : 2);
        }
        else {
            this.mg.add((byte)42);
        }
    }
    
    private void memRead() {
        this.memRead(false);
    }
    
    private void memRead(final boolean b) {
        if (!this.didPreMemRead) {
            throw new Error("didn't do preMemRead");
        }
        this.didPreMemRead = false;
        if (this.preMemReadDoPreWrite) {
            this.memWriteStage = 2;
        }
        if (this.nullPointerCheck) {
            this.mg.add((byte)89);
            this.mg.add((byte)42);
            this.mg.add((byte)95);
            this.mg.add((byte)(-74), (Object)this.me.method("nullPointerCheck", Type.VOID, new Type[] { Type.INT }));
        }
        if (this.onePage) {
            this.mg.add((byte)5);
            this.mg.add((byte)124);
            if (this.preMemReadDoPreWrite) {
                this.mg.add((byte)92);
            }
            this.mg.add((byte)46);
        }
        else if (this.fastMem) {
            if (!b) {
                this.mg.add((byte)90);
            }
            this.mg.add((byte)18, this.pageShift);
            this.mg.add((byte)124);
            this.mg.add((byte)50);
            if (b) {
                this.pushTmp();
            }
            else {
                this.mg.add((byte)95);
            }
            this.mg.add((byte)5);
            this.mg.add((byte)124);
            this.mg.add((byte)18, (this.pageSize >> 2) - 1);
            this.mg.add((byte)126);
            if (this.preMemReadDoPreWrite) {
                this.mg.add((byte)92);
            }
            this.mg.add((byte)46);
        }
        else {
            if (this.preMemReadDoPreWrite) {
                this.mg.add((byte)92);
            }
            this.mg.add((byte)(-74), (Object)this.me.method("unsafeMemRead", Type.INT, new Type[] { Type.INT }));
        }
    }
    
    static {
        POINT_5_F = new Float(0.5f);
        POINT_5_D = new Double(0.5);
        FFFFFFFF = new Long(4294967295L);
        regField = new String[] { "r0", "r1", "r2", "r3", "r4", "r5", "r6", "r7", "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "r27", "r28", "r29", "r30", "r31", "f0", "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12", "f13", "f14", "f15", "f16", "f17", "f18", "f19", "f20", "f21", "f22", "f23", "f24", "f25", "f26", "f27", "f28", "f29", "f30", "f31", "hi", "lo", "fcsr" };
    }
}
