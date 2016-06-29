/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.ibex.classgen.CGConst
 *  org.ibex.classgen.ClassFile
 *  org.ibex.classgen.ClassFile$Exn
 *  org.ibex.classgen.FieldGen
 *  org.ibex.classgen.MethodGen
 *  org.ibex.classgen.MethodGen$Pair
 *  org.ibex.classgen.MethodGen$PhantomTarget
 *  org.ibex.classgen.MethodGen$Switch
 *  org.ibex.classgen.MethodGen$Switch$Lookup
 *  org.ibex.classgen.MethodGen$Switch$Table
 *  org.ibex.classgen.Type
 *  org.ibex.classgen.Type$Array
 *  org.ibex.classgen.Type$Class
 *  org.ibex.classgen.Type$Class$Field
 *  org.ibex.classgen.Type$Class$Method
 */
package org.ibex.nestedvm;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import org.ibex.classgen.CGConst;
import org.ibex.classgen.ClassFile;
import org.ibex.classgen.FieldGen;
import org.ibex.classgen.MethodGen;
import org.ibex.classgen.Type;
import org.ibex.nestedvm.Compiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFHeader;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public class ClassFileCompiler
extends Compiler
implements CGConst {
    private static final boolean OPTIMIZE_CP = true;
    private OutputStream os;
    private File outDir;
    private PrintStream warn = System.err;
    private final Type.Class me;
    private ClassFile cg;
    private MethodGen clinit;
    private MethodGen init;
    private static int initDataCount;
    private int startOfMethod = 0;
    private int endOfMethod = 0;
    private MethodGen.PhantomTarget returnTarget;
    private MethodGen.PhantomTarget defaultTarget;
    private MethodGen.PhantomTarget[] insnTargets;
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
    private int[] regLocalMapping = new int[67];
    private boolean[] regLocalWritten = new boolean[67];
    private int nextAvailLocal;
    private int loadsStart;
    private int preSetRegStackPos;
    private int[] preSetRegStack = new int[8];
    private int memWriteStage;
    private boolean didPreMemRead;
    private boolean preMemReadDoPreWrite;

    public ClassFileCompiler(String string, String string2, OutputStream outputStream) {
        this((Seekable)new Seekable$File(string), string2, outputStream);
    }

    public ClassFileCompiler(Seekable seekable, String string, OutputStream outputStream) {
        this(seekable, string);
        if (outputStream == null) {
            throw new NullPointerException();
        }
        this.os = outputStream;
    }

    public ClassFileCompiler(Seekable seekable, String string, File file) {
        this(seekable, string);
        if (file == null) {
            throw new NullPointerException();
        }
        this.outDir = file;
    }

    private ClassFileCompiler(Seekable seekable, String string) {
        super(seekable, string);
        this.me = Type.Class.instance((String)this.fullClassName);
    }

    public void setWarnWriter(PrintStream printStream) {
        this.warn = printStream;
    }

    @Override
    protected void _go() {
        try {
            this.__go();
            return;
        }
        catch (ClassFile.Exn var1_1) {
            var1_1.printStackTrace(this.warn);
            throw new Compiler$Exn(new StringBuffer().append("Class generation exception: ").append(var1_1.toString()).toString());
        }
    }

    private void __go() {
        int n2;
        ELF$Symbol[] arreLF$Symbol;
        int n3;
        String string;
        MethodGen methodGen;
        if (!this.pruneCases) {
            throw new Compiler$Exn("-o prunecases MUST be enabled for ClassFileCompiler");
        }
        Type.Class class_ = Type.Class.instance((String)this.runtimeClass);
        this.cg = new ClassFile(this.me, class_, 49);
        if (this.source != null) {
            this.cg.setSourceFile(this.source);
        }
        this.cg.addField("pc", Type.INT, 2);
        this.cg.addField("hi", Type.INT, 2);
        this.cg.addField("lo", Type.INT, 2);
        this.cg.addField("fcsr", Type.INT, 2);
        for (n2 = 1; n2 < 32; ++n2) {
            this.cg.addField(new StringBuffer().append("r").append(n2).toString(), Type.INT, 2);
        }
        for (n2 = 0; n2 < 32; ++n2) {
            this.cg.addField(new StringBuffer().append("f").append(n2).toString(), this.singleFloat ? Type.FLOAT : Type.INT, 2);
        }
        this.clinit = this.cg.addMethod("<clinit>", Type.VOID, Type.NO_ARGS, 10);
        this.init = this.cg.addMethod("<init>", Type.VOID, Type.NO_ARGS, 1);
        this.init.add(42);
        this.init.add(18, this.pageSize);
        this.init.add(18, this.totalPages);
        this.init.add(-73, (Object)this.me.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT}));
        this.init.add(-79);
        this.init = this.cg.addMethod("<init>", Type.VOID, new Type[]{Type.BOOLEAN}, 1);
        this.init.add(42);
        this.init.add(18, this.pageSize);
        this.init.add(18, this.totalPages);
        this.init.add(27);
        this.init.add(-73, (Object)this.me.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}));
        this.init.add(-79);
        this.init = this.cg.addMethod("<init>", Type.VOID, new Type[]{Type.INT, Type.INT}, 1);
        this.init.add(42);
        this.init.add(27);
        this.init.add(28);
        this.init.add(3);
        this.init.add(-73, (Object)this.me.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}));
        this.init.add(-79);
        this.init = this.cg.addMethod("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}, 1);
        this.init.add(42);
        this.init.add(27);
        this.init.add(28);
        this.init.add(29);
        this.init.add(-73, (Object)class_.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}));
        if (this.onePage) {
            this.cg.addField("page", (Type)Type.INT.makeArray(), 18);
            this.init.add(42);
            this.init.add(89);
            this.init.add(-76, (Object)this.me.field("readPages", (Type)Type.INT.makeArray(2)));
            this.init.add(18, 0);
            this.init.add(50);
            this.init.add(-75, (Object)this.me.field("page", (Type)Type.INT.makeArray()));
        }
        if (this.supportCall) {
            this.cg.addField("symbols", (Type)Type.Class.instance((String)this.hashClass), 26);
        }
        n2 = 0;
        for (int i2 = 0; i2 < this.elf.sheaders.length; ++i2) {
            arreLF$Symbol = this.elf.sheaders[i2];
            string = arreLF$Symbol.name;
            if (arreLF$Symbol.addr == 0) continue;
            n2 = Math.max(n2, arreLF$Symbol.addr + arreLF$Symbol.size);
            if (string.equals(".text")) {
                this.emitText(arreLF$Symbol.addr, new DataInputStream(arreLF$Symbol.getInputStream()), arreLF$Symbol.size);
                continue;
            }
            if (string.equals(".data") || string.equals(".sdata") || string.equals(".rodata") || string.equals(".ctors") || string.equals(".dtors")) {
                this.emitData(arreLF$Symbol.addr, new DataInputStream(arreLF$Symbol.getInputStream()), arreLF$Symbol.size, string.equals(".rodata"));
                continue;
            }
            if (!string.equals(".bss")) {
                if (!string.equals(".sbss")) throw new Compiler$Exn(new StringBuffer().append("Unknown segment: ").append(string).toString());
            }
            this.emitBSS(arreLF$Symbol.addr, arreLF$Symbol.size);
        }
        this.init.add(-79);
        if (this.supportCall) {
            Type.Class class_2 = Type.Class.instance((String)this.hashClass);
            this.clinit.add(-69, (Object)class_2);
            this.clinit.add(89);
            this.clinit.add(89);
            this.clinit.add(-73, (Object)class_2.method("<init>", Type.VOID, Type.NO_ARGS));
            this.clinit.add(-77, (Object)this.me.field("symbols", (Type)class_2));
            arreLF$Symbol = this.elf.getSymtab().symbols;
            for (int i3 = 0; i3 < arreLF$Symbol.length; ++i3) {
                ELF$Symbol eLF$Symbol = arreLF$Symbol[i3];
                if (eLF$Symbol.type != 2 || eLF$Symbol.binding != 1 || !eLF$Symbol.name.equals("_call_helper") && eLF$Symbol.name.startsWith("_")) continue;
                this.clinit.add(89);
                this.clinit.add(18, (Object)eLF$Symbol.name);
                this.clinit.add(-69, (Object)Type.INTEGER_OBJECT);
                this.clinit.add(89);
                this.clinit.add(18, eLF$Symbol.addr);
                this.clinit.add(-73, (Object)Type.INTEGER_OBJECT.method("<init>", Type.VOID, new Type[]{Type.INT}));
                this.clinit.add(-74, (Object)class_2.method("put", (Type)Type.OBJECT, new Type[]{Type.OBJECT, Type.OBJECT}));
                this.clinit.add(87);
            }
            this.clinit.add(87);
        }
        this.clinit.add(-79);
        ELF$SHeader eLF$SHeader = this.elf.sectionWithName(".text");
        arreLF$Symbol = this.cg.addMethod("trampoline", Type.VOID, Type.NO_ARGS, 2);
        string = (String)arreLF$Symbol.size();
        arreLF$Symbol.add(42);
        arreLF$Symbol.add(-76, (Object)this.me.field("state", Type.INT));
        arreLF$Symbol.add(-103, arreLF$Symbol.size() + 2);
        arreLF$Symbol.add(-79);
        arreLF$Symbol.add(42);
        arreLF$Symbol.add(42);
        arreLF$Symbol.add(-76, (Object)this.me.field("pc", Type.INT));
        arreLF$Symbol.add(18, this.methodShift);
        arreLF$Symbol.add(124);
        int n4 = eLF$SHeader.addr >>> this.methodShift;
        int n5 = eLF$SHeader.addr + eLF$SHeader.size + this.maxBytesPerMethod - 1 >>> this.methodShift;
        MethodGen.Switch.Table table = new MethodGen.Switch.Table(n4, n5 - 1);
        arreLF$Symbol.add(-86, (Object)table);
        for (int i4 = n4; i4 < n5; ++i4) {
            table.setTargetForVal(i4, arreLF$Symbol.size());
            arreLF$Symbol.add(-73, (Object)this.me.method(new StringBuffer().append("run_").append(ClassFileCompiler.toHex(i4 << this.methodShift)).toString(), Type.VOID, Type.NO_ARGS));
            arreLF$Symbol.add(-89, (int)string);
        }
        table.setDefaultTarget(arreLF$Symbol.size());
        arreLF$Symbol.add(87);
        arreLF$Symbol.add(-69, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException"));
        arreLF$Symbol.add(89);
        arreLF$Symbol.add(-69, (Object)Type.STRINGBUFFER);
        arreLF$Symbol.add(89);
        arreLF$Symbol.add(18, (Object)"Jumped to invalid address in trampoline (r2: ");
        arreLF$Symbol.add(-73, (Object)Type.STRINGBUFFER.method("<init>", Type.VOID, new Type[]{Type.STRING}));
        arreLF$Symbol.add(42);
        arreLF$Symbol.add(-76, (Object)this.me.field("r2", Type.INT));
        arreLF$Symbol.add(-74, (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[]{Type.INT}));
        arreLF$Symbol.add(18, (Object)" pc: ");
        arreLF$Symbol.add(-74, (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[]{Type.STRING}));
        arreLF$Symbol.add(42);
        arreLF$Symbol.add(-76, (Object)this.me.field("pc", Type.INT));
        arreLF$Symbol.add(-74, (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[]{Type.INT}));
        arreLF$Symbol.add(18, (Object)")");
        arreLF$Symbol.add(-74, (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[]{Type.STRING}));
        arreLF$Symbol.add(-74, (Object)Type.STRINGBUFFER.method("toString", (Type)Type.STRING, Type.NO_ARGS));
        arreLF$Symbol.add(-73, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
        arreLF$Symbol.add(-65);
        this.addConstReturnMethod("gp", this.gp.addr);
        this.addConstReturnMethod("entryPoint", this.elf.header.entry);
        this.addConstReturnMethod("heapStart", n2);
        if (this.userInfo != null) {
            this.addConstReturnMethod("userInfoBase", this.userInfo.addr);
            this.addConstReturnMethod("userInfoSize", this.userInfo.size);
        }
        if (this.supportCall) {
            Type.Class class_3 = Type.Class.instance((String)this.hashClass);
            methodGen = this.cg.addMethod("lookupSymbol", Type.INT, new Type[]{Type.STRING}, 4);
            methodGen.add(-78, (Object)this.me.field("symbols", (Type)class_3));
            methodGen.add(43);
            methodGen.add(-74, (Object)class_3.method("get", (Type)Type.OBJECT, new Type[]{Type.OBJECT}));
            methodGen.add(89);
            int n6 = methodGen.add(-58);
            methodGen.add(-64, (Object)Type.INTEGER_OBJECT);
            methodGen.add(-74, (Object)Type.INTEGER_OBJECT.method("intValue", Type.INT, Type.NO_ARGS));
            methodGen.add(-84);
            methodGen.setArg(n6, methodGen.size());
            methodGen.add(87);
            methodGen.add(2);
            methodGen.add(-84);
        }
        Type.Class class_4 = Type.Class.instance((String)"org.ibex.nestedvm.Runtime$CPUState");
        methodGen = this.cg.addMethod("setCPUState", Type.VOID, new Type[]{class_4}, 4);
        MethodGen methodGen2 = this.cg.addMethod("getCPUState", Type.VOID, new Type[]{class_4}, 4);
        methodGen.add(43);
        methodGen2.add(43);
        methodGen.add(-76, (Object)class_4.field("r", (Type)Type.INT.makeArray()));
        methodGen2.add(-76, (Object)class_4.field("r", (Type)Type.INT.makeArray()));
        methodGen.add(77);
        methodGen2.add(77);
        for (n3 = 1; n3 < 32; ++n3) {
            methodGen.add(42);
            methodGen.add(44);
            methodGen.add(18, n3);
            methodGen.add(46);
            methodGen.add(-75, (Object)this.me.field(new StringBuffer().append("r").append(n3).toString(), Type.INT));
            methodGen2.add(44);
            methodGen2.add(18, n3);
            methodGen2.add(42);
            methodGen2.add(-76, (Object)this.me.field(new StringBuffer().append("r").append(n3).toString(), Type.INT));
            methodGen2.add(79);
        }
        methodGen.add(43);
        methodGen2.add(43);
        methodGen.add(-76, (Object)class_4.field("f", (Type)Type.INT.makeArray()));
        methodGen2.add(-76, (Object)class_4.field("f", (Type)Type.INT.makeArray()));
        methodGen.add(77);
        methodGen2.add(77);
        for (n3 = 0; n3 < 32; ++n3) {
            methodGen.add(42);
            methodGen.add(44);
            methodGen.add(18, n3);
            methodGen.add(46);
            if (this.singleFloat) {
                methodGen.add(-72, (Object)Type.FLOAT_OBJECT.method("intBitsToFloat", Type.FLOAT, new Type[]{Type.INT}));
            }
            methodGen.add(-75, (Object)this.me.field(new StringBuffer().append("f").append(n3).toString(), this.singleFloat ? Type.FLOAT : Type.INT));
            methodGen2.add(44);
            methodGen2.add(18, n3);
            methodGen2.add(42);
            methodGen2.add(-76, (Object)this.me.field(new StringBuffer().append("f").append(n3).toString(), this.singleFloat ? Type.FLOAT : Type.INT));
            if (this.singleFloat) {
                methodGen2.add(-72, (Object)Type.FLOAT_OBJECT.method("floatToIntBits", Type.INT, new Type[]{Type.FLOAT}));
            }
            methodGen2.add(79);
        }
        String[] arrstring = new String[]{"hi", "lo", "fcsr", "pc"};
        for (int i5 = 0; i5 < arrstring.length; ++i5) {
            methodGen.add(42);
            methodGen.add(43);
            methodGen.add(-76, (Object)class_4.field(arrstring[i5], Type.INT));
            methodGen.add(-75, (Object)this.me.field(arrstring[i5], Type.INT));
            methodGen2.add(43);
            methodGen2.add(42);
            methodGen2.add(-76, (Object)this.me.field(arrstring[i5], Type.INT));
            methodGen2.add(-75, (Object)class_4.field(arrstring[i5], Type.INT));
        }
        methodGen.add(-79);
        methodGen2.add(-79);
        MethodGen methodGen3 = this.cg.addMethod("_execute", Type.VOID, Type.NO_ARGS, 4);
        int n7 = methodGen3.size();
        methodGen3.add(42);
        methodGen3.add(-73, (Object)this.me.method("trampoline", Type.VOID, Type.NO_ARGS));
        int n8 = methodGen3.size();
        methodGen3.add(-79);
        int n9 = methodGen3.size();
        methodGen3.add(76);
        methodGen3.add(-69, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$FaultException"));
        methodGen3.add(89);
        methodGen3.add(43);
        methodGen3.add(-73, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$FaultException").method("<init>", Type.VOID, new Type[]{Type.Class.instance((String)"java.lang.RuntimeException")}));
        methodGen3.add(-65);
        methodGen3.addExceptionHandler(n7, n8, n9, Type.Class.instance((String)"java.lang.RuntimeException"));
        methodGen3.addThrow(Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException"));
        MethodGen methodGen4 = this.cg.addMethod("main", Type.VOID, new Type[]{Type.STRING.makeArray()}, 9);
        methodGen4.add(-69, (Object)this.me);
        methodGen4.add(89);
        methodGen4.add(-73, (Object)this.me.method("<init>", Type.VOID, Type.NO_ARGS));
        methodGen4.add(18, (Object)this.fullClassName);
        methodGen4.add(42);
        if (this.unixRuntime) {
            Type.Class class_5 = Type.Class.instance((String)"org.ibex.nestedvm.UnixRuntime");
            methodGen4.add(-72, (Object)class_5.method("runAndExec", Type.INT, new Type[]{class_5, Type.STRING, Type.STRING.makeArray()}));
        } else {
            methodGen4.add(-74, (Object)this.me.method("run", Type.INT, new Type[]{Type.STRING, Type.STRING.makeArray()}));
        }
        methodGen4.add(-72, (Object)Type.Class.instance((String)"java.lang.System").method("exit", Type.VOID, new Type[]{Type.INT}));
        methodGen4.add(-79);
        if (this.outDir == null) {
            this.cg.dump(this.os);
            return;
        }
        if (!this.outDir.isDirectory()) {
            throw new IOException(new StringBuffer().append("").append(this.outDir).append(" isn't a directory").toString());
        }
        this.cg.dump(this.outDir);
    }

    private void addConstReturnMethod(String string, int n2) {
        MethodGen methodGen = this.cg.addMethod(string, Type.INT, Type.NO_ARGS, 4);
        methodGen.add(18, n2);
        methodGen.add(-84);
    }

    private void emitData(int n2, DataInputStream dataInputStream, int n3, boolean bl2) {
        if ((n2 & 3) != 0) throw new Compiler$Exn("Data section on weird boundaries");
        if ((n3 & 3) != 0) {
            throw new Compiler$Exn("Data section on weird boundaries");
        }
        int n4 = n2 + n3;
        block0 : do {
            if (n2 >= n4) {
                dataInputStream.close();
                return;
            }
            int n5 = Math.min(n3, 28000);
            StringBuffer stringBuffer = new StringBuffer();
            int n6 = 0;
            do {
                byte by2;
                int n7;
                long l2;
                if (n6 < n5) {
                    l2 = 0;
                } else {
                    String string = new StringBuffer().append("_data").append(++initDataCount).toString();
                    this.cg.addField(string, (Type)Type.INT.makeArray(), 26);
                    this.clinit.add(18, (Object)stringBuffer.toString());
                    this.clinit.add(18, n5 / 4);
                    this.clinit.add(-72, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime").method("decodeData", (Type)Type.INT.makeArray(), new Type[]{Type.STRING, Type.INT}));
                    this.clinit.add(-77, (Object)this.me.field(string, (Type)Type.INT.makeArray()));
                    this.init.add(42);
                    this.init.add(-78, (Object)this.me.field(string, (Type)Type.INT.makeArray()));
                    this.init.add(18, n2);
                    this.init.add(18, bl2 ? 1 : 0);
                    this.init.add(-74, (Object)this.me.method("initPages", Type.VOID, new Type[]{Type.INT.makeArray(), Type.INT, Type.BOOLEAN}));
                    n2 += n5;
                    n3 -= n5;
                    continue block0;
                }
                for (n7 = 0; n7 < 7; l2 |= (long)by2 & 255, ++n7) {
                    l2 <<= 8;
                    by2 = n6 + n7 < n3 ? dataInputStream.readByte() : 1;
                }
                for (n7 = 0; n7 < 8; ++n7) {
                    stringBuffer.append((char)(l2 >>> 7 * (7 - n7) & 127));
                }
                n6 += 7;
            } while (true);
            break;
        } while (true);
    }

    private void emitBSS(int n2, int n3) {
        if ((n2 & 3) != 0) {
            throw new Compiler$Exn("BSS section on weird boundaries");
        }
        n3 = n3 + 3 & -4;
        int n4 = n3 / 4;
        this.init.add(42);
        this.init.add(18, n2);
        this.init.add(18, n4);
        this.init.add(-74, (Object)this.me.method("clearPages", Type.VOID, new Type[]{Type.INT, Type.INT}));
    }

    private boolean jumpable(int n2) {
        if (this.jumpableAddresses.get(new Integer(n2)) == null) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void emitText(int var1_1, DataInputStream var2_2, int var3_3) {
        if (this.textDone) {
            throw new Compiler$Exn("Multiple text segments");
        }
        this.textDone = true;
        if ((var1_1 & 3) != 0) throw new Compiler$Exn("Section on weird boundaries");
        if ((var3_3 & 3) != 0) {
            throw new Compiler$Exn("Section on weird boundaries");
        }
        var4_4 = var3_3 / 4;
        var6_5 = -1;
        var7_6 = true;
        var8_7 = false;
        var9_8 = 0;
        do {
            if (var9_8 >= var4_4) {
                this.endMethod(0, var8_7);
                var2_2.close();
                return;
            }
            var5_9 = var7_6 != false ? var2_2.readInt() : var6_5;
            v0 = var6_5 = var9_8 == var4_4 - 1 ? -1 : var2_2.readInt();
            if (var1_1 >= this.endOfMethod) {
                this.endMethod(var1_1, var8_7);
                this.startMethod(var1_1);
            }
            if (this.insnTargets[var9_8 % this.maxInsnPerMethod] == null) ** GOTO lbl26
            this.insnTargets[var9_8 % this.maxInsnPerMethod].setTarget(this.mg.size());
            var8_7 = false;
            ** GOTO lbl-1000
lbl26: // 1 sources:
            if (!var8_7) lbl-1000: // 2 sources:
            {
                try {
                    var10_10 = this.emitInstruction(var1_1, var5_9, var6_5);
                    var8_7 = (var10_10 & 1) != 0;
                    var7_6 = (var10_10 & 2) != 0;
                }
                catch (Compiler$Exn var10_11) {
                    var10_11.printStackTrace(this.warn);
                    this.warn.println(new StringBuffer().append("Exception at ").append(ClassFileCompiler.toHex(var1_1)).toString());
                    throw var10_11;
                }
                catch (RuntimeException var10_12) {
                    this.warn.println(new StringBuffer().append("Exception at ").append(ClassFileCompiler.toHex(var1_1)).toString());
                    throw var10_12;
                }
                if (var7_6) {
                    var1_1 += 4;
                    ++var9_8;
                }
            }
            ++var9_8;
            var1_1 += 4;
        } while (true);
    }

    private void startMethod(int n2) {
        this.startOfMethod = n2 & this.methodMask;
        this.endOfMethod = this.startOfMethod + this.maxBytesPerMethod;
        this.mg = this.cg.addMethod(new StringBuffer().append("run_").append(ClassFileCompiler.toHex(this.startOfMethod)).toString(), Type.VOID, Type.NO_ARGS, 18);
        if (this.onePage) {
            this.mg.add(42);
            this.mg.add(-76, (Object)this.me.field("page", (Type)Type.INT.makeArray()));
            this.mg.add(77);
        } else {
            this.mg.add(42);
            this.mg.add(-76, (Object)this.me.field("readPages", (Type)Type.INT.makeArray(2)));
            this.mg.add(77);
            this.mg.add(42);
            this.mg.add(-76, (Object)this.me.field("writePages", (Type)Type.INT.makeArray(2)));
            this.mg.add(78);
        }
        this.returnTarget = new MethodGen.PhantomTarget();
        this.insnTargets = new MethodGen.PhantomTarget[this.maxBytesPerMethod / 4];
        int[] arrn = new int[this.maxBytesPerMethod / 4];
        Object[] arrobject = new Object[this.maxBytesPerMethod / 4];
        int n3 = 0;
        int n4 = n2;
        do {
            if (n4 >= this.endOfMethod) {
                MethodGen.Switch.Lookup lookup = new MethodGen.Switch.Lookup(n3);
                System.arraycopy(arrn, 0, lookup.vals, 0, n3);
                System.arraycopy(arrobject, 0, lookup.targets, 0, n3);
                this.defaultTarget = new MethodGen.PhantomTarget();
                lookup.setDefaultTarget((Object)this.defaultTarget);
                this.fixupRegsStart();
                this.mg.add(42);
                this.mg.add(-76, (Object)this.me.field("pc", Type.INT));
                this.mg.add(-85, (Object)lookup);
                return;
            }
            if (this.jumpable(n4)) {
                MethodGen.PhantomTarget phantomTarget = new MethodGen.PhantomTarget();
                this.insnTargets[(n4 - this.startOfMethod) / 4] = phantomTarget;
                arrobject[n3] = phantomTarget;
                arrn[n3] = n4;
                ++n3;
            }
            n4 += 4;
        } while (true);
    }

    private void endMethod(int n2, boolean bl2) {
        if (this.startOfMethod == 0) {
            return;
        }
        if (!bl2) {
            this.preSetPC();
            this.mg.add(18, n2);
            this.setPC();
            this.jumpableAddresses.put(new Integer(n2), Boolean.TRUE);
        }
        this.returnTarget.setTarget(this.mg.size());
        this.fixupRegsEnd();
        this.mg.add(-79);
        this.defaultTarget.setTarget(this.mg.size());
        if (this.debugCompiler) {
            this.mg.add(-69, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException"));
            this.mg.add(89);
            this.mg.add(-69, (Object)Type.STRINGBUFFER);
            this.mg.add(89);
            this.mg.add(18, (Object)"Jumped to invalid address: ");
            this.mg.add(-73, (Object)Type.STRINGBUFFER.method("<init>", Type.VOID, new Type[]{Type.STRING}));
            this.mg.add(42);
            this.mg.add(-76, (Object)this.me.field("pc", Type.INT));
            this.mg.add(-74, (Object)Type.STRINGBUFFER.method("append", (Type)Type.STRINGBUFFER, new Type[]{Type.INT}));
            this.mg.add(-74, (Object)Type.STRINGBUFFER.method("toString", (Type)Type.STRING, Type.NO_ARGS));
            this.mg.add(-73, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
            this.mg.add(-65);
        } else {
            this.mg.add(-69, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException"));
            this.mg.add(89);
            this.mg.add(18, (Object)"Jumped to invalid address");
            this.mg.add(-73, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
            this.mg.add(-65);
        }
        this.startOfMethod = 0;
        this.endOfMethod = 0;
    }

    private void leaveMethod() {
        this.mg.add(-89, (Object)this.returnTarget);
    }

    private void link(int n2) {
        this.preSetReg(31);
        if (this.lessConstants) {
            int n3 = n2 + 8 + 32768 & -65536;
            int n4 = n2 + 8 - n3;
            if (n4 < -32768) throw new Error(new StringBuffer().append("should never happen ").append(n4).toString());
            if (n4 > 32767) {
                throw new Error(new StringBuffer().append("should never happen ").append(n4).toString());
            }
            this.mg.add(18, n3);
            this.mg.add(18, n4);
            this.mg.add(96);
        } else {
            this.mg.add(18, n2 + 8);
        }
        this.setReg();
    }

    private void branch(int n2, int n3) {
        if ((n2 & this.methodMask) == (n3 & this.methodMask)) {
            this.mg.add(-89, (Object)this.insnTargets[(n3 - this.startOfMethod) / 4]);
            return;
        }
        this.preSetPC();
        this.mg.add(18, n3);
        this.setPC();
        this.leaveMethod();
    }

    private int doIfInstruction(byte by2, int n2, int n3, int n4) {
        int n5;
        this.emitInstruction(-1, n4, -1);
        if ((n3 & this.methodMask) == (n2 & this.methodMask)) {
            this.mg.add(by2, (Object)this.insnTargets[(n3 - this.startOfMethod) / 4]);
        } else {
            n5 = this.mg.add(MethodGen.negate((byte)by2));
            this.branch(n2, n3);
            this.mg.setArg(n5, this.mg.size());
        }
        if (!this.jumpable(n2 + 4)) {
            return 2;
        }
        if (n2 + 4 == this.endOfMethod) {
            this.jumpableAddresses.put(new Integer(n2 + 8), Boolean.TRUE);
            this.branch(n2, n2 + 8);
            return 1;
        }
        n5 = this.mg.add(-89);
        this.insnTargets[(n2 + 4 - this.startOfMethod) / 4].setTarget(this.mg.size());
        this.emitInstruction(-1, n4, 1);
        this.mg.setArg(n5, this.mg.size());
        return 2;
    }

    /*
     * Unable to fully structure code
     */
    private int emitInstruction(int var1_1, int var2_2, int var3_3) {
        var4_4 = this.mg;
        if (var2_2 == -1) {
            throw new Compiler$Exn("insn is -1");
        }
        var5_5 = 0;
        var6_6 = var2_2 >>> 26 & 255;
        var7_7 = var2_2 >>> 21 & 31;
        var8_8 = var2_2 >>> 16 & 31;
        var9_9 = var2_2 >>> 16 & 31;
        var10_10 = var2_2 >>> 11 & 31;
        var11_11 = var2_2 >>> 11 & 31;
        var12_12 = var2_2 >>> 6 & 31;
        var13_13 = var2_2 >>> 6 & 31;
        var14_14 = var2_2 & 63;
        var15_15 = var2_2 >>> 6 & 1048575;
        var16_16 = var2_2 & 67108863;
        var17_17 = var2_2 & 65535;
        var19_19 = var18_18 = var2_2 << 16 >> 16;
        switch (var6_6) {
            case 0: {
                switch (var14_14) {
                    case 0: {
                        if (var2_2 == 0) {
                            return var5_5;
                        }
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(18, var12_12);
                        var4_4.add(120);
                        this.setReg();
                        return var5_5;
                    }
                    case 2: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(18, var12_12);
                        var4_4.add(124);
                        this.setReg();
                        return var5_5;
                    }
                    case 3: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(18, var12_12);
                        var4_4.add(122);
                        this.setReg();
                        return var5_5;
                    }
                    case 4: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var8_8);
                        this.pushRegWZ(0 + var7_7);
                        var4_4.add(120);
                        this.setReg();
                        return var5_5;
                    }
                    case 6: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var8_8);
                        this.pushRegWZ(0 + var7_7);
                        var4_4.add(124);
                        this.setReg();
                        return var5_5;
                    }
                    case 7: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var8_8);
                        this.pushRegWZ(0 + var7_7);
                        var4_4.add(122);
                        this.setReg();
                        return var5_5;
                    }
                    case 8: {
                        if (var1_1 == -1) {
                            throw new Compiler$Exn("pc modifying insn in delay slot");
                        }
                        this.emitInstruction(-1, var3_3, -1);
                        this.preSetPC();
                        this.pushRegWZ(0 + var7_7);
                        this.setPC();
                        this.leaveMethod();
                        return var5_5 |= 1;
                    }
                    case 9: {
                        if (var1_1 == -1) {
                            throw new Compiler$Exn("pc modifying insn in delay slot");
                        }
                        this.emitInstruction(-1, var3_3, -1);
                        this.link(var1_1);
                        this.preSetPC();
                        this.pushRegWZ(0 + var7_7);
                        this.setPC();
                        this.leaveMethod();
                        return var5_5 |= 1;
                    }
                    case 12: {
                        this.preSetPC();
                        var4_4.add(18, var1_1);
                        this.setPC();
                        this.restoreChangedRegs();
                        this.preSetReg(2);
                        var4_4.add(42);
                        this.pushRegZ(2);
                        this.pushRegZ(4);
                        this.pushRegZ(5);
                        this.pushRegZ(6);
                        this.pushRegZ(7);
                        this.pushRegZ(8);
                        this.pushRegZ(9);
                        var4_4.add(-74, (Object)this.me.method("syscall", Type.INT, new Type[]{Type.INT, Type.INT, Type.INT, Type.INT, Type.INT, Type.INT, Type.INT}));
                        this.setReg();
                        var4_4.add(42);
                        var4_4.add(-76, (Object)this.me.field("state", Type.INT));
                        var20_20 = var4_4.add(-103);
                        this.preSetPC();
                        var4_4.add(18, var1_1 + 4);
                        this.setPC();
                        this.leaveMethod();
                        var4_4.setArg(var20_20, var4_4.size());
                        return var5_5;
                    }
                    case 13: {
                        var4_4.add(-69, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException"));
                        var4_4.add(89);
                        var4_4.add(18, (Object)new StringBuffer().append("BREAK Code ").append(ClassFileCompiler.toHex(var15_15)).toString());
                        var4_4.add(-73, (Object)Type.Class.instance((String)"org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
                        var4_4.add(-65);
                        return var5_5 |= 1;
                    }
                    case 16: {
                        this.preSetReg(0 + var10_10);
                        this.pushReg(64);
                        this.setReg();
                        return var5_5;
                    }
                    case 17: {
                        this.preSetReg(64);
                        this.pushRegZ(0 + var7_7);
                        this.setReg();
                        return var5_5;
                    }
                    case 18: {
                        this.preSetReg(0 + var10_10);
                        this.pushReg(65);
                        this.setReg();
                        return var5_5;
                    }
                    case 19: {
                        this.preSetReg(65);
                        this.pushRegZ(0 + var7_7);
                        this.setReg();
                        return var5_5;
                    }
                    case 24: {
                        this.pushRegWZ(0 + var7_7);
                        var4_4.add(-123);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(-123);
                        var4_4.add(105);
                        var4_4.add(92);
                        var4_4.add(-120);
                        if (this.preSetReg(65)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        var4_4.add(18, 32);
                        var4_4.add(125);
                        var4_4.add(-120);
                        if (this.preSetReg(64)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 25: {
                        this.pushRegWZ(0 + var7_7);
                        var4_4.add(-123);
                        var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                        var4_4.add(127);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(-123);
                        var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                        var4_4.add(127);
                        var4_4.add(105);
                        var4_4.add(92);
                        var4_4.add(-120);
                        if (this.preSetReg(65)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        var4_4.add(18, 32);
                        var4_4.add(125);
                        var4_4.add(-120);
                        if (this.preSetReg(64)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 26: {
                        this.pushRegWZ(0 + var7_7);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(92);
                        var4_4.add(108);
                        if (this.preSetReg(65)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        var4_4.add(112);
                        if (this.preSetReg(64)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 27: {
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(89);
                        this.setTmp();
                        var20_21 = var4_4.add(-103);
                        this.pushRegWZ(0 + var7_7);
                        var4_4.add(-123);
                        var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                        var4_4.add(127);
                        var4_4.add(92);
                        this.pushTmp();
                        var4_4.add(-123);
                        var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                        var4_4.add(127);
                        var4_4.add(94);
                        var4_4.add(109);
                        var4_4.add(-120);
                        if (this.preSetReg(65)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        var4_4.add(113);
                        var4_4.add(-120);
                        if (this.preSetReg(64)) {
                            var4_4.add(95);
                        }
                        this.setReg();
                        var4_4.setArg(var20_21, var4_4.size());
                        return var5_5;
                    }
                    case 32: {
                        throw new Compiler$Exn("ADD (add with oveflow trap) not suported");
                    }
                    case 33: {
                        this.preSetReg(0 + var10_10);
                        if (var8_8 != 0 && var7_7 != 0) {
                            this.pushReg(0 + var7_7);
                            this.pushReg(0 + var8_8);
                            var4_4.add(96);
                        } else if (var7_7 != 0) {
                            this.pushReg(0 + var7_7);
                        } else {
                            this.pushRegZ(0 + var8_8);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 34: {
                        throw new Compiler$Exn("SUB (add with oveflow trap) not suported");
                    }
                    case 35: {
                        this.preSetReg(0 + var10_10);
                        if (var8_8 != 0 && var7_7 != 0) {
                            this.pushReg(0 + var7_7);
                            this.pushReg(0 + var8_8);
                            var4_4.add(100);
                        } else if (var8_8 != 0) {
                            this.pushReg(0 + var8_8);
                            var4_4.add(116);
                        } else {
                            this.pushRegZ(0 + var7_7);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 36: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var7_7);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(126);
                        this.setReg();
                        return var5_5;
                    }
                    case 37: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var7_7);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(-128);
                        this.setReg();
                        return var5_5;
                    }
                    case 38: {
                        this.preSetReg(0 + var10_10);
                        this.pushRegWZ(0 + var7_7);
                        this.pushRegWZ(0 + var8_8);
                        var4_4.add(-126);
                        this.setReg();
                        return var5_5;
                    }
                    case 39: {
                        this.preSetReg(0 + var10_10);
                        if (var7_7 != 0 || var8_8 != 0) {
                            if (var7_7 != 0 && var8_8 != 0) {
                                this.pushReg(0 + var7_7);
                                this.pushReg(0 + var8_8);
                                var4_4.add(-128);
                            } else if (var7_7 != 0) {
                                this.pushReg(0 + var7_7);
                            } else {
                                this.pushReg(0 + var8_8);
                            }
                            var4_4.add(2);
                            var4_4.add(-126);
                        } else {
                            var4_4.add(18, -1);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 42: {
                        this.preSetReg(0 + var10_10);
                        if (var7_7 != var8_8) {
                            this.pushRegZ(0 + var7_7);
                            this.pushRegZ(0 + var8_8);
                            var20_22 = var4_4.add(-95);
                            var4_4.add(3);
                            var21_31 = var4_4.add(-89);
                            var4_4.setArg(var20_22, var4_4.add(4));
                            var4_4.setArg(var21_31, var4_4.size());
                        } else {
                            var4_4.add(18, 0);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 43: {
                        this.preSetReg(0 + var10_10);
                        if (var7_7 != var8_8) {
                            if (var7_7 != 0) {
                                this.pushReg(0 + var7_7);
                                var4_4.add(-123);
                                var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                                var4_4.add(127);
                                this.pushReg(0 + var8_8);
                                var4_4.add(-123);
                                var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                                var4_4.add(127);
                                var4_4.add(-108);
                                var20_23 = var4_4.add(-101);
                            } else {
                                this.pushReg(0 + var8_8);
                                var20_23 = var4_4.add(-102);
                            }
                            var4_4.add(3);
                            var21_32 = var4_4.add(-89);
                            var4_4.setArg(var20_23, var4_4.add(4));
                            var4_4.setArg(var21_32, var4_4.size());
                        } else {
                            var4_4.add(18, 0);
                        }
                        this.setReg();
                        return var5_5;
                    }
                }
                throw new Compiler$Exn(new StringBuffer().append("Illegal instruction 0/").append(var14_14).toString());
            }
            case 1: {
                switch (var8_8) {
                    case 0: {
                        if (var1_1 == -1) {
                            throw new Compiler$Exn("pc modifying insn in delay slot");
                        }
                        this.pushRegWZ(0 + var7_7);
                        return this.doIfInstruction(-101, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
                    }
                    case 1: {
                        if (var1_1 == -1) {
                            throw new Compiler$Exn("pc modifying insn in delay slot");
                        }
                        this.pushRegWZ(0 + var7_7);
                        return this.doIfInstruction(-100, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
                    }
                    case 16: {
                        if (var1_1 == -1) {
                            throw new Compiler$Exn("pc modifying insn in delay slot");
                        }
                        this.pushRegWZ(0 + var7_7);
                        var20_24 = var4_4.add(-100);
                        this.emitInstruction(-1, var3_3, -1);
                        this.link(var1_1);
                        this.branch(var1_1, var1_1 + var19_19 * 4 + 4);
                        var4_4.setArg(var20_24, var4_4.size());
                        return var5_5;
                    }
                    case 17: {
                        if (var1_1 == -1) {
                            throw new Compiler$Exn("pc modifying insn in delay slot");
                        }
                        var20_25 = -1;
                        if (var7_7 != 0) {
                            this.pushRegWZ(0 + var7_7);
                            var20_25 = var4_4.add(-101);
                        }
                        this.emitInstruction(-1, var3_3, -1);
                        this.link(var1_1);
                        this.branch(var1_1, var1_1 + var19_19 * 4 + 4);
                        if (var20_25 != -1) {
                            var4_4.setArg(var20_25, var4_4.size());
                        }
                        if (var20_25 != -1) return var5_5;
                        return var5_5 |= 1;
                    }
                }
                throw new Compiler$Exn(new StringBuffer().append("Illegal Instruction 1/").append(var8_8).toString());
            }
            case 2: {
                if (var1_1 == -1) {
                    throw new Compiler$Exn("pc modifying insn in delay slot");
                }
                this.emitInstruction(-1, var3_3, -1);
                this.branch(var1_1, var1_1 & -268435456 | var16_16 << 2);
                return var5_5 |= 1;
            }
            case 3: {
                if (var1_1 == -1) {
                    throw new Compiler$Exn("pc modifying insn in delay slot");
                }
                var22_35 = var1_1 & -268435456 | var16_16 << 2;
                this.emitInstruction(-1, var3_3, -1);
                this.link(var1_1);
                this.branch(var1_1, var22_35);
                return var5_5 |= 1;
            }
            case 4: {
                if (var1_1 == -1) {
                    throw new Compiler$Exn("pc modifying insn in delay slot");
                }
                if (var7_7 == var8_8) {
                    this.emitInstruction(-1, var3_3, -1);
                    this.branch(var1_1, var1_1 + var19_19 * 4 + 4);
                    return var5_5 |= 1;
                }
                if (var7_7 != 0 && var8_8 != 0) {
                    this.pushReg(0 + var7_7);
                    this.pushReg(0 + var8_8);
                    return this.doIfInstruction(-97, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
                }
                this.pushReg(var8_8 == 0 ? 0 + var7_7 : 0 + var8_8);
                return this.doIfInstruction(-103, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
            }
            case 5: {
                if (var1_1 == -1) {
                    throw new Compiler$Exn("pc modifying insn in delay slot");
                }
                this.pushRegWZ(0 + var7_7);
                if (var8_8 == 0) {
                    return this.doIfInstruction(-102, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
                }
                this.pushReg(0 + var8_8);
                return this.doIfInstruction(-96, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
            }
            case 6: {
                if (var1_1 == -1) {
                    throw new Compiler$Exn("pc modifying insn in delay slot");
                }
                this.pushRegWZ(0 + var7_7);
                return this.doIfInstruction(-98, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
            }
            case 7: {
                if (var1_1 == -1) {
                    throw new Compiler$Exn("pc modifying insn in delay slot");
                }
                this.pushRegWZ(0 + var7_7);
                return this.doIfInstruction(-99, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
            }
            case 8: {
                throw new Compiler$Exn("ADDI (add immediate with oveflow trap) not suported");
            }
            case 9: {
                if (var7_7 != 0 && var18_18 != 0 && var7_7 == var8_8 && this.doLocal(var8_8) && var18_18 >= -32768 && var18_18 <= 32767) {
                    this.regLocalWritten[var8_8] = true;
                    var4_4.add(-124, (Object)new MethodGen.Pair(this.getLocalForReg(var8_8), var18_18));
                    return var5_5;
                }
                this.preSetReg(0 + var8_8);
                this.addiu(var7_7, var18_18);
                this.setReg();
                return var5_5;
            }
            case 10: {
                this.preSetReg(0 + var8_8);
                this.pushRegWZ(0 + var7_7);
                var4_4.add(18, var18_18);
                var20_26 = var4_4.add(-95);
                var4_4.add(3);
                var21_33 = var4_4.add(-89);
                var4_4.setArg(var20_26, var4_4.add(4));
                var4_4.setArg(var21_33, var4_4.size());
                this.setReg();
                return var5_5;
            }
            case 11: {
                this.preSetReg(0 + var8_8);
                this.pushRegWZ(0 + var7_7);
                var4_4.add(-123);
                var4_4.add(18, (Object)ClassFileCompiler.FFFFFFFF);
                var4_4.add(127);
                var4_4.add(18, (Object)new Long((long)var18_18 & 0xFFFFFFFFL));
                var4_4.add(-108);
                var20_27 = var4_4.add(-101);
                var4_4.add(3);
                var21_34 = var4_4.add(-89);
                var4_4.setArg(var20_27, var4_4.add(4));
                var4_4.setArg(var21_34, var4_4.size());
                this.setReg();
                return var5_5;
            }
            case 12: {
                this.preSetReg(0 + var8_8);
                this.pushRegWZ(0 + var7_7);
                var4_4.add(18, var17_17);
                var4_4.add(126);
                this.setReg();
                return var5_5;
            }
            case 13: {
                this.preSetReg(0 + var8_8);
                if (var7_7 != 0 && var17_17 != 0) {
                    this.pushReg(0 + var7_7);
                    var4_4.add(18, var17_17);
                    var4_4.add(-128);
                } else if (var7_7 != 0) {
                    this.pushReg(0 + var7_7);
                } else {
                    var4_4.add(18, var17_17);
                }
                this.setReg();
                return var5_5;
            }
            case 14: {
                this.preSetReg(0 + var8_8);
                this.pushRegWZ(0 + var7_7);
                var4_4.add(18, var17_17);
                var4_4.add(-126);
                this.setReg();
                return var5_5;
            }
            case 15: {
                this.preSetReg(0 + var8_8);
                var4_4.add(18, var17_17 << 16);
                this.setReg();
                return var5_5;
            }
            case 16: {
                throw new Compiler$Exn("TLB/Exception support not implemented");
            }
            case 17: {
                switch (var7_7) {
                    case 0: {
                        this.preSetReg(0 + var8_8);
                        this.pushReg(32 + var10_10);
                        this.setReg();
                        return var5_5;
                    }
                    case 2: {
                        if (var11_11 != 31) {
                            throw new Compiler$Exn(new StringBuffer().append("FCR ").append(var11_11).append(" unavailable").toString());
                        }
                        this.preSetReg(0 + var8_8);
                        this.pushReg(66);
                        this.setReg();
                        return var5_5;
                    }
                    case 4: {
                        this.preSetReg(32 + var10_10);
                        if (var8_8 != 0) {
                            this.pushReg(0 + var8_8);
                        } else {
                            var4_4.add(3);
                        }
                        this.setReg();
                        return var5_5;
                    }
                    case 6: {
                        if (var11_11 != 31) {
                            throw new Compiler$Exn(new StringBuffer().append("FCR ").append(var11_11).append(" unavailable").toString());
                        }
                        this.preSetReg(66);
                        this.pushReg(0 + var8_8);
                        this.setReg();
                        return var5_5;
                    }
                    case 8: {
                        this.pushReg(66);
                        var4_4.add(18, 8388608);
                        var4_4.add(126);
                        if ((var2_2 >>> 16 & 1) == 0) {
                            v0 = -103;
                            return this.doIfInstruction(v0, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
                        }
                        v0 = -102;
                        return this.doIfInstruction(v0, var1_1, var1_1 + var19_19 * 4 + 4, var3_3);
                    }
                    case 16: 
                    case 17: {
                        var22_36 = var7_7 == 17;
                        switch (var14_14) {
                            case 0: {
                                this.preSetDouble(32 + var13_13, var22_36);
                                this.pushDouble(32 + var11_11, var22_36);
                                this.pushDouble(32 + var9_9, var22_36);
                                var4_4.add(var22_36 != false ? 99 : 98);
                                this.setDouble(var22_36);
                                return var5_5;
                            }
                            case 1: {
                                this.preSetDouble(32 + var13_13, var22_36);
                                this.pushDouble(32 + var11_11, var22_36);
                                this.pushDouble(32 + var9_9, var22_36);
                                var4_4.add(var22_36 != false ? 103 : 102);
                                this.setDouble(var22_36);
                                return var5_5;
                            }
                            case 2: {
                                this.preSetDouble(32 + var13_13, var22_36);
                                this.pushDouble(32 + var11_11, var22_36);
                                this.pushDouble(32 + var9_9, var22_36);
                                var4_4.add(var22_36 != false ? 107 : 106);
                                this.setDouble(var22_36);
                                return var5_5;
                            }
                            case 3: {
                                this.preSetDouble(32 + var13_13, var22_36);
                                this.pushDouble(32 + var11_11, var22_36);
                                this.pushDouble(32 + var9_9, var22_36);
                                var4_4.add(var22_36 != false ? 111 : 110);
                                this.setDouble(var22_36);
                                return var5_5;
                            }
                            case 5: {
                                this.preSetDouble(32 + var13_13, var22_36);
                                this.pushDouble(32 + var11_11, var22_36);
                                var4_4.add(var22_36 != false ? 92 : 89);
                                var4_4.add(var22_36 != false ? 14 : 11);
                                var4_4.add(var22_36 != false ? -104 : -106);
                                var20_28 = var4_4.add(-99);
                                var4_4.add(var22_36 != false ? 14 : 11);
                                if (var22_36) {
                                    var4_4.add(94);
                                    var4_4.add(88);
                                } else {
                                    var4_4.add(95);
                                }
                                var4_4.add(var22_36 != false ? 103 : 102);
                                var4_4.setArg(var20_28, var4_4.size());
                                this.setDouble(var22_36);
                                return var5_5;
                            }
                            case 6: {
                                this.preSetReg(32 + var13_13);
                                this.pushReg(32 + var11_11);
                                this.setReg();
                                if (var22_36 == false) return var5_5;
                                this.preSetReg(32 + var13_13 + 1);
                                this.pushReg(32 + var11_11 + 1);
                                this.setReg();
                                return var5_5;
                            }
                            case 7: {
                                this.preSetDouble(32 + var13_13, var22_36);
                                this.pushDouble(32 + var11_11, var22_36);
                                var4_4.add(var22_36 != false ? 119 : 118);
                                this.setDouble(var22_36);
                                return var5_5;
                            }
                            case 32: {
                                this.preSetFloat(32 + var13_13);
                                this.pushDouble(32 + var11_11, var22_36);
                                if (var22_36) {
                                    var4_4.add(-112);
                                }
                                this.setFloat();
                                return var5_5;
                            }
                            case 33: {
                                this.preSetDouble(32 + var13_13);
                                this.pushDouble(32 + var11_11, var22_36);
                                if (!var22_36) {
                                    var4_4.add(-115);
                                }
                                this.setDouble();
                                return var5_5;
                            }
                            case 36: {
                                var23_37 = new MethodGen.Switch.Table(0, 3);
                                this.preSetReg(32 + var13_13);
                                this.pushDouble(32 + var11_11, var22_36);
                                this.pushReg(66);
                                var4_4.add(6);
                                var4_4.add(126);
                                var4_4.add(-86, (Object)var23_37);
                                var23_37.setTarget(2, var4_4.size());
                                if (!var22_36) {
                                    var4_4.add(-115);
                                }
                                var4_4.add(-72, (Object)Type.Class.instance((String)"java.lang.Math").method("ceil", Type.DOUBLE, new Type[]{Type.DOUBLE}));
                                if (!var22_36) {
                                    var4_4.add(-112);
                                }
                                var20_29 = var4_4.add(-89);
                                var23_37.setTarget(0, var4_4.size());
                                var4_4.add(18, (Object)(var22_36 != false ? ClassFileCompiler.POINT_5_D : ClassFileCompiler.POINT_5_F));
                                var4_4.add(var22_36 != false ? 99 : 98);
                                var23_37.setTarget(3, var4_4.size());
                                if (!var22_36) {
                                    var4_4.add(-115);
                                }
                                var4_4.add(-72, (Object)Type.Class.instance((String)"java.lang.Math").method("floor", Type.DOUBLE, new Type[]{Type.DOUBLE}));
                                if (!var22_36) {
                                    var4_4.add(-112);
                                }
                                var23_37.setTarget(1, var4_4.size());
                                var23_37.setDefaultTarget(var4_4.size());
                                var4_4.setArg(var20_29, var4_4.size());
                                var4_4.add(var22_36 != false ? -114 : -117);
                                this.setReg();
                                return var5_5;
                            }
                            case 50: 
                            case 60: 
                            case 62: {
                                this.preSetReg(66);
                                this.pushReg(66);
                                var4_4.add(18, -8388609);
                                var4_4.add(126);
                                this.pushDouble(32 + var11_11, var22_36);
                                this.pushDouble(32 + var9_9, var22_36);
                                var4_4.add(var22_36 != false ? -104 : -106);
                                switch (var14_14) {
                                    case 50: {
                                        var20_30 = var4_4.add(-102);
                                        ** break;
                                    }
                                    case 60: {
                                        var20_30 = var4_4.add(-100);
                                        ** break;
                                    }
                                    case 62: {
                                        var20_30 = var4_4.add(-99);
                                        ** break;
                                    }
                                }
                                var20_30 = -1;
lbl643: // 4 sources:
                                var4_4.add(18, 8388608);
                                var4_4.add(-128);
                                var4_4.setArg(var20_30, var4_4.size());
                                this.setReg();
                                return var5_5;
                            }
                        }
                        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(var7_7).append("/").append(var14_14).toString());
                    }
                    case 20: {
                        switch (var14_14) {
                            case 32: {
                                this.preSetFloat(32 + var13_13);
                                this.pushReg(32 + var11_11);
                                var4_4.add(-122);
                                this.setFloat();
                                return var5_5;
                            }
                            case 33: {
                                this.preSetDouble(32 + var13_13);
                                this.pushReg(32 + var11_11);
                                var4_4.add(-121);
                                this.setDouble();
                                return var5_5;
                            }
                        }
                        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(var7_7).append("/").append(var14_14).toString());
                    }
                }
                throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(var7_7).toString());
            }
            case 18: 
            case 19: {
                throw new Compiler$Exn("coprocessor 2 and 3 instructions not available");
            }
            case 32: {
                this.preSetReg(0 + var8_8);
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead();
                this.pushTmp();
                this.memRead(true);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(-111);
                this.setReg();
                return var5_5;
            }
            case 33: {
                this.preSetReg(0 + var8_8);
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead();
                this.pushTmp();
                this.memRead(true);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(5);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(-109);
                this.setReg();
                return var5_5;
            }
            case 34: {
                this.preSetReg(0 + var8_8);
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.pushRegWZ(0 + var8_8);
                var4_4.add(18, 16777215);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(126);
                this.preMemRead();
                this.pushTmp();
                this.memRead(true);
                this.pushTmp();
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(-128);
                this.setReg();
                return var5_5;
            }
            case 35: {
                this.preSetReg(0 + var8_8);
                this.memRead(0 + var7_7, var18_18);
                this.setReg();
                return var5_5;
            }
            case 36: {
                this.preSetReg(0 + var8_8);
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead();
                this.pushTmp();
                this.memRead(true);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(18, 255);
                var4_4.add(126);
                this.setReg();
                return var5_5;
            }
            case 37: {
                this.preSetReg(0 + var8_8);
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead();
                this.pushTmp();
                this.memRead(true);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(5);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(-110);
                this.setReg();
                return var5_5;
            }
            case 38: {
                this.preSetReg(0 + var8_8);
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.pushRegWZ(0 + var8_8);
                var4_4.add(18, -256);
                this.pushTmp();
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(126);
                this.preMemRead();
                this.pushTmp();
                this.memRead(true);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(-128);
                this.setReg();
                return var5_5;
            }
            case 40: {
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead(true);
                this.pushTmp();
                this.memRead(true);
                var4_4.add(18, -16777216);
                this.pushTmp();
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(126);
                if (var8_8 != 0) {
                    this.pushReg(0 + var8_8);
                    var4_4.add(18, 255);
                    var4_4.add(126);
                } else {
                    var4_4.add(18, 0);
                }
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(-128);
                this.memWrite();
                return var5_5;
            }
            case 41: {
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead(true);
                this.pushTmp();
                this.memRead(true);
                var4_4.add(18, 65535);
                this.pushTmp();
                var4_4.add(5);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(126);
                if (var8_8 != 0) {
                    this.pushReg(0 + var8_8);
                    var4_4.add(18, 65535);
                    var4_4.add(126);
                } else {
                    var4_4.add(18, 0);
                }
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(5);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(-128);
                this.memWrite();
                return var5_5;
            }
            case 42: {
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead(true);
                this.pushTmp();
                this.memRead(true);
                var4_4.add(18, -256);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(126);
                this.pushRegWZ(0 + var8_8);
                this.pushTmp();
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(-128);
                this.memWrite();
                return var5_5;
            }
            case 43: {
                this.preMemWrite1();
                this.preMemWrite2(0 + var7_7, var18_18);
                this.pushRegZ(0 + var8_8);
                this.memWrite();
                return var5_5;
            }
            case 46: {
                this.addiu(0 + var7_7, var18_18);
                this.setTmp();
                this.preMemRead(true);
                this.pushTmp();
                this.memRead(true);
                var4_4.add(18, 16777215);
                this.pushTmp();
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(124);
                var4_4.add(126);
                this.pushRegWZ(0 + var8_8);
                this.pushTmp();
                var4_4.add(2);
                var4_4.add(-126);
                var4_4.add(6);
                var4_4.add(126);
                var4_4.add(6);
                var4_4.add(120);
                var4_4.add(120);
                var4_4.add(-128);
                this.memWrite();
                return var5_5;
            }
            case 48: {
                this.preSetReg(0 + var8_8);
                this.memRead(0 + var7_7, var18_18);
                this.setReg();
                return var5_5;
            }
            case 49: {
                this.preSetReg(32 + var8_8);
                this.memRead(0 + var7_7, var18_18);
                this.setReg();
                return var5_5;
            }
            case 56: {
                this.preSetReg(0 + var8_8);
                this.preMemWrite1();
                this.preMemWrite2(0 + var7_7, var18_18);
                this.pushReg(0 + var8_8);
                this.memWrite();
                var4_4.add(18, 1);
                this.setReg();
                return var5_5;
            }
            case 57: {
                this.preMemWrite1();
                this.preMemWrite2(0 + var7_7, var18_18);
                this.pushReg(32 + var8_8);
                this.memWrite();
                return var5_5;
            }
        }
        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction: ").append(var6_6).append(" at ").append(ClassFileCompiler.toHex(var1_1)).toString());
    }

    private boolean doLocal(int n2) {
        if (n2 == 2) return true;
        if (n2 == 3) return true;
        if (n2 == 4) return true;
        if (n2 == 29) return true;
        return false;
    }

    private int getLocalForReg(int n2) {
        if (this.regLocalMapping[n2] != 0) {
            return this.regLocalMapping[n2];
        }
        ++this.nextAvailLocal;
        return this.regLocalMapping[n2];
    }

    private void fixupRegsStart() {
        int n2;
        for (n2 = 0; n2 < 67; ++n2) {
            this.regLocalMapping[n2] = 0;
            this.regLocalWritten[n2] = false;
        }
        this.nextAvailLocal = this.onePage ? 4 : 5;
        this.loadsStart = this.mg.size();
        n2 = 0;
        while (n2 < 12) {
            this.mg.add(0);
            ++n2;
        }
    }

    private void fixupRegsEnd() {
        int n2 = this.loadsStart;
        int n3 = 0;
        while (n3 < 67) {
            if (this.regLocalMapping[n3] != 0) {
                this.mg.set(n2++, 42);
                this.mg.set(n2++, -76, (Object)this.me.field(regField[n3], Type.INT));
                this.mg.set(n2++, 54, this.regLocalMapping[n3]);
                if (this.regLocalWritten[n3]) {
                    this.mg.add(42);
                    this.mg.add(21, this.regLocalMapping[n3]);
                    this.mg.add(-75, (Object)this.me.field(regField[n3], Type.INT));
                }
            }
            ++n3;
        }
    }

    private void restoreChangedRegs() {
        int n2 = 0;
        while (n2 < 67) {
            if (this.regLocalWritten[n2]) {
                this.mg.add(42);
                this.mg.add(21, this.regLocalMapping[n2]);
                this.mg.add(-75, (Object)this.me.field(regField[n2], Type.INT));
            }
            ++n2;
        }
    }

    private int pushRegWZ(int n2) {
        if (n2 != 0) return this.pushRegZ(n2);
        this.warn.println("Warning: Pushing r0!");
        new Exception().printStackTrace(this.warn);
        return this.pushRegZ(n2);
    }

    private int pushRegZ(int n2) {
        if (n2 != 0) return this.pushReg(n2);
        return this.mg.add(3);
    }

    private int pushReg(int n2) {
        int n3 = this.mg.size();
        if (this.doLocal(n2)) {
            this.mg.add(21, this.getLocalForReg(n2));
            return n3;
        }
        if (n2 >= 32 && n2 <= 63 && this.singleFloat) {
            this.mg.add(42);
            this.mg.add(-76, (Object)this.me.field(regField[n2], Type.FLOAT));
            this.mg.add(-72, (Object)Type.FLOAT_OBJECT.method("floatToIntBits", Type.INT, new Type[]{Type.FLOAT}));
            return n3;
        }
        this.mg.add(42);
        this.mg.add(-76, (Object)this.me.field(regField[n2], Type.INT));
        return n3;
    }

    private boolean preSetReg(int n2) {
        this.preSetRegStack[this.preSetRegStackPos] = n2;
        ++this.preSetRegStackPos;
        if (this.doLocal(n2)) {
            return false;
        }
        this.mg.add(42);
        return true;
    }

    private int setReg() {
        if (this.preSetRegStackPos == 0) {
            throw new RuntimeException("didn't do preSetReg");
        }
        --this.preSetRegStackPos;
        int n2 = this.preSetRegStack[this.preSetRegStackPos];
        int n3 = this.mg.size();
        if (this.doLocal(n2)) {
            this.mg.add(54, this.getLocalForReg(n2));
            this.regLocalWritten[n2] = true;
            return n3;
        }
        if (n2 >= 32 && n2 <= 63 && this.singleFloat) {
            this.mg.add(-72, (Object)Type.FLOAT_OBJECT.method("intBitsToFloat", Type.FLOAT, new Type[]{Type.INT}));
            this.mg.add(-75, (Object)this.me.field(regField[n2], Type.FLOAT));
            return n3;
        }
        this.mg.add(-75, (Object)this.me.field(regField[n2], Type.INT));
        return n3;
    }

    private int preSetPC() {
        return this.mg.add(42);
    }

    private int setPC() {
        return this.mg.add(-75, (Object)this.me.field("pc", Type.INT));
    }

    private int pushFloat(int n2) {
        return this.pushDouble(n2, false);
    }

    private int pushDouble(int n2, boolean bl2) {
        if (n2 < 32) throw new IllegalArgumentException(new StringBuffer().append("").append(n2).toString());
        if (n2 >= 64) {
            throw new IllegalArgumentException(new StringBuffer().append("").append(n2).toString());
        }
        int n3 = this.mg.size();
        if (bl2) {
            if (this.singleFloat) {
                throw new Compiler$Exn("Double operations not supported when singleFloat is enabled");
            }
            if (n2 == 63) {
                throw new Compiler$Exn("Tried to use a double in f31");
            }
            this.pushReg(n2 + 1);
            this.mg.add(-123);
            this.mg.add(18, 32);
            this.mg.add(121);
            this.pushReg(n2);
            this.mg.add(-123);
            this.mg.add(18, (Object)FFFFFFFF);
            this.mg.add(127);
            this.mg.add(-127);
            this.mg.add(-72, (Object)Type.DOUBLE_OBJECT.method("longBitsToDouble", Type.DOUBLE, new Type[]{Type.LONG}));
            return n3;
        }
        if (this.singleFloat) {
            this.mg.add(42);
            this.mg.add(-76, (Object)this.me.field(regField[n2], Type.FLOAT));
            return n3;
        }
        this.pushReg(n2);
        this.mg.add(-72, (Object)Type.Class.instance((String)"java.lang.Float").method("intBitsToFloat", Type.FLOAT, new Type[]{Type.INT}));
        return n3;
    }

    private void preSetFloat(int n2) {
        this.preSetDouble(n2, false);
    }

    private void preSetDouble(int n2) {
        this.preSetDouble(n2, true);
    }

    private void preSetDouble(int n2, boolean bl2) {
        this.preSetReg(n2);
    }

    private int setFloat() {
        return this.setDouble(false);
    }

    private int setDouble() {
        return this.setDouble(true);
    }

    private int setDouble(boolean bl2) {
        int n2 = this.preSetRegStack[this.preSetRegStackPos - 1];
        if (n2 < 32) throw new IllegalArgumentException(new StringBuffer().append("").append(n2).toString());
        if (n2 >= 64) {
            throw new IllegalArgumentException(new StringBuffer().append("").append(n2).toString());
        }
        int n3 = this.mg.size();
        if (bl2) {
            if (this.singleFloat) {
                throw new Compiler$Exn("Double operations not supported when singleFloat is enabled");
            }
            if (n2 == 63) {
                throw new Compiler$Exn("Tried to use a double in f31");
            }
            this.mg.add(-72, (Object)Type.DOUBLE_OBJECT.method("doubleToLongBits", Type.LONG, new Type[]{Type.DOUBLE}));
            this.mg.add(92);
            this.mg.add(18, 32);
            this.mg.add(125);
            this.mg.add(-120);
            if (this.preSetReg(n2 + 1)) {
                this.mg.add(95);
            }
            this.setReg();
            this.mg.add(-120);
            this.setReg();
            return n3;
        }
        if (this.singleFloat) {
            --this.preSetRegStackPos;
            this.mg.add(-75, (Object)this.me.field(regField[n2], Type.FLOAT));
            return n3;
        }
        this.mg.add(-72, (Object)Type.FLOAT_OBJECT.method("floatToRawIntBits", Type.INT, new Type[]{Type.FLOAT}));
        this.setReg();
        return n3;
    }

    private void pushTmp() {
        this.mg.add(27);
    }

    private void setTmp() {
        this.mg.add(60);
    }

    private void addiu(int n2, int n3) {
        if (n2 != 0 && n3 != 0) {
            this.pushReg(n2);
            this.mg.add(18, n3);
            this.mg.add(96);
            return;
        }
        if (n2 != 0) {
            this.pushReg(n2);
            return;
        }
        this.mg.add(18, n3);
    }

    private void preMemWrite1() {
        if (this.memWriteStage != 0) {
            throw new Error("pending preMemWrite1/2");
        }
        this.memWriteStage = 1;
        if (this.onePage) {
            this.mg.add(44);
            return;
        }
        if (this.fastMem) {
            this.mg.add(25, 3);
            return;
        }
        this.mg.add(42);
    }

    private void preMemWrite2(int n2, int n3) {
        this.addiu(n2, n3);
        this.preMemWrite2();
    }

    private void preMemWrite2() {
        this.preMemWrite2(false);
    }

    private void preMemWrite2(boolean bl2) {
        if (this.memWriteStage != 1) {
            throw new Error("pending preMemWrite2 or no preMemWrite1");
        }
        this.memWriteStage = 2;
        if (this.nullPointerCheck) {
            this.mg.add(89);
            this.mg.add(42);
            this.mg.add(95);
            this.mg.add(-74, (Object)this.me.method("nullPointerCheck", Type.VOID, new Type[]{Type.INT}));
        }
        if (this.onePage) {
            this.mg.add(5);
            this.mg.add(124);
            return;
        }
        if (!this.fastMem) return;
        if (!bl2) {
            this.mg.add(90);
        }
        this.mg.add(18, this.pageShift);
        this.mg.add(124);
        this.mg.add(50);
        if (bl2) {
            this.pushTmp();
        } else {
            this.mg.add(95);
        }
        this.mg.add(5);
        this.mg.add(124);
        this.mg.add(18, (this.pageSize >> 2) - 1);
        this.mg.add(126);
    }

    private void memWrite() {
        if (this.memWriteStage != 2) {
            throw new Error("didn't do preMemWrite1 or preMemWrite2");
        }
        this.memWriteStage = 0;
        if (this.onePage) {
            this.mg.add(79);
            return;
        }
        if (this.fastMem) {
            this.mg.add(79);
            return;
        }
        this.mg.add(-74, (Object)this.me.method("unsafeMemWrite", Type.VOID, new Type[]{Type.INT, Type.INT}));
    }

    private void memRead(int n2, int n3) {
        this.preMemRead();
        this.addiu(n2, n3);
        this.memRead();
    }

    private void preMemRead() {
        this.preMemRead(false);
    }

    private void preMemRead(boolean bl2) {
        if (this.didPreMemRead) {
            throw new Error("pending preMemRead");
        }
        this.didPreMemRead = true;
        this.preMemReadDoPreWrite = bl2;
        if (this.onePage) {
            this.mg.add(44);
            return;
        }
        if (!this.fastMem) {
            this.mg.add(42);
            return;
        }
        this.mg.add(25, bl2 ? 3 : 2);
    }

    private void memRead() {
        this.memRead(false);
    }

    private void memRead(boolean bl2) {
        if (!this.didPreMemRead) {
            throw new Error("didn't do preMemRead");
        }
        this.didPreMemRead = false;
        if (this.preMemReadDoPreWrite) {
            this.memWriteStage = 2;
        }
        if (this.nullPointerCheck) {
            this.mg.add(89);
            this.mg.add(42);
            this.mg.add(95);
            this.mg.add(-74, (Object)this.me.method("nullPointerCheck", Type.VOID, new Type[]{Type.INT}));
        }
        if (this.onePage) {
            this.mg.add(5);
            this.mg.add(124);
            if (this.preMemReadDoPreWrite) {
                this.mg.add(92);
            }
            this.mg.add(46);
            return;
        }
        if (this.fastMem) {
            if (!bl2) {
                this.mg.add(90);
            }
            this.mg.add(18, this.pageShift);
            this.mg.add(124);
            this.mg.add(50);
            if (bl2) {
                this.pushTmp();
            } else {
                this.mg.add(95);
            }
            this.mg.add(5);
            this.mg.add(124);
            this.mg.add(18, (this.pageSize >> 2) - 1);
            this.mg.add(126);
            if (this.preMemReadDoPreWrite) {
                this.mg.add(92);
            }
            this.mg.add(46);
            return;
        }
        if (this.preMemReadDoPreWrite) {
            this.mg.add(92);
        }
        this.mg.add(-74, (Object)this.me.method("unsafeMemRead", Type.INT, new Type[]{Type.INT}));
    }

    static {
        POINT_5_F = new Float(0.5f);
        POINT_5_D = new Double(0.5);
        FFFFFFFF = new Long(0xFFFFFFFFL);
        regField = new String[]{"r0", "r1", "r2", "r3", "r4", "r5", "r6", "r7", "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "r27", "r28", "r29", "r30", "r31", "f0", "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12", "f13", "f14", "f15", "f16", "f17", "f18", "f19", "f20", "f21", "f22", "f23", "f24", "f25", "f26", "f27", "f28", "f29", "f30", "f31", "hi", "lo", "fcsr"};
    }
}

