/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath$1;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated=1)
public final class DoubleMath {
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18;
    private static final double LN_2 = Math.log(2.0);
    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    @VisibleForTesting
    static final double[] everySixteenthFactorial = new double[]{1.0, 2.0922789888E13, 2.631308369336935E35, 1.2413915592536073E61, 1.2688693218588417E89, 7.156945704626381E118, 9.916779348709496E149, 1.974506857221074E182, 3.856204823625804E215, 5.5502938327393044E249, 4.7147236359920616E284};

    @GwtIncompatible(value="#isMathematicalInteger, com.google.common.math.DoubleUtils")
    static double roundIntermediate(double d2, RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(d2)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (DoubleMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(DoubleMath.isMathematicalInteger(d2));
                return d2;
            }
            case 2: {
                if (d2 >= 0.0) return d2;
                if (!DoubleMath.isMathematicalInteger(d2)) return d2 - 1.0;
                return d2;
            }
            case 3: {
                if (d2 <= 0.0) return d2;
                if (!DoubleMath.isMathematicalInteger(d2)) return d2 + 1.0;
                return d2;
            }
            case 4: {
                return d2;
            }
            case 5: {
                if (!DoubleMath.isMathematicalInteger(d2)) return d2 + Math.copySign(1.0, d2);
                return d2;
            }
            case 6: {
                return Math.rint(d2);
            }
            case 7: {
                double d3 = Math.rint(d2);
                if (Math.abs(d2 - d3) != 0.5) return d3;
                return d2 + Math.copySign(0.5, d2);
            }
            case 8: {
                double d4 = Math.rint(d2);
                if (Math.abs(d2 - d4) != 0.5) return d4;
                return d2;
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="#roundIntermediate")
    public static int roundToInt(double d2, RoundingMode roundingMode) {
        double d3 = DoubleMath.roundIntermediate(d2, roundingMode);
        MathPreconditions.checkInRange(d3 > -2.147483649E9 & d3 < 2.147483648E9);
        return (int)d3;
    }

    @GwtIncompatible(value="#roundIntermediate")
    public static long roundToLong(double d2, RoundingMode roundingMode) {
        double d3 = DoubleMath.roundIntermediate(d2, roundingMode);
        MathPreconditions.checkInRange(-9.223372036854776E18 - d3 < 1.0 & d3 < 9.223372036854776E18);
        return (long)d3;
    }

    @GwtIncompatible(value="#roundIntermediate, java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static BigInteger roundToBigInteger(double d2, RoundingMode roundingMode) {
        BigInteger bigInteger;
        if (-9.223372036854776E18 - (d2 = DoubleMath.roundIntermediate(d2, roundingMode)) < 1.0 & d2 < 9.223372036854776E18) {
            return BigInteger.valueOf((long)d2);
        }
        int n2 = Math.getExponent(d2);
        long l2 = DoubleUtils.getSignificand(d2);
        BigInteger bigInteger2 = BigInteger.valueOf(l2).shiftLeft(n2 - 52);
        if (d2 < 0.0) {
            bigInteger = bigInteger2.negate();
            return bigInteger;
        }
        bigInteger = bigInteger2;
        return bigInteger;
    }

    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    public static boolean isPowerOfTwo(double d2) {
        if (d2 <= 0.0) return false;
        if (!DoubleUtils.isFinite(d2)) return false;
        if (!LongMath.isPowerOfTwo(DoubleUtils.getSignificand(d2))) return false;
        return true;
    }

    public static double log2(double d2) {
        return Math.log(d2) / LN_2;
    }

    /*
     * Unable to fully structure code
     */
    @GwtIncompatible(value="java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static int log2(double var0, RoundingMode var2_1) {
        Preconditions.checkArgument(var0 > 0.0 && DoubleUtils.isFinite(var0) != false, "x must be positive and finite");
        var3_2 = Math.getExponent(var0);
        if (!DoubleUtils.isNormal(var0)) {
            return DoubleMath.log2(var0 * 4.503599627370496E15, var2_1) - 52;
        }
        switch (DoubleMath$1.$SwitchMap$java$math$RoundingMode[var2_1.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(DoubleMath.isPowerOfTwo(var0));
            }
            case 2: {
                var4_3 = false;
                ** break;
            }
            case 3: {
                var4_3 = DoubleMath.isPowerOfTwo(var0) == false;
                ** break;
            }
            case 4: {
                var4_3 = var3_2 < 0 & DoubleMath.isPowerOfTwo(var0) == false;
                ** break;
            }
            case 5: {
                var4_3 = var3_2 >= 0 & DoubleMath.isPowerOfTwo(var0) == false;
                ** break;
            }
            case 6: 
            case 7: 
            case 8: {
                var5_4 = DoubleUtils.scaleNormalize(var0);
                var4_3 = var5_4 * var5_4 > 2.0;
                ** break;
            }
        }
        throw new AssertionError();
lbl25: // 5 sources:
        if (var4_3) {
            v0 = var3_2 + 1;
            return v0;
        }
        v0 = var3_2;
        return v0;
    }

    @GwtIncompatible(value="java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static boolean isMathematicalInteger(double d2) {
        if (!DoubleUtils.isFinite(d2)) return false;
        if (d2 == 0.0) return true;
        if (52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d2)) > Math.getExponent(d2)) return false;
        return true;
    }

    public static double factorial(int n2) {
        MathPreconditions.checkNonNegative("n", n2);
        if (n2 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d2 = 1.0;
        int n3 = 1 + (n2 & -16);
        while (n3 <= n2) {
            d2 *= (double)n3;
            ++n3;
        }
        return d2 * everySixteenthFactorial[n2 >> 4];
    }

    public static boolean fuzzyEquals(double d2, double d3, double d4) {
        MathPreconditions.checkNonNegative("tolerance", d4);
        if (Math.copySign(d2 - d3, 1.0) <= d4) return true;
        if (d2 == d3) return true;
        if (!Double.isNaN(d2)) return false;
        if (!Double.isNaN(d3)) return false;
        return true;
    }

    public static int fuzzyCompare(double d2, double d3, double d4) {
        if (DoubleMath.fuzzyEquals(d2, d3, d4)) {
            return 0;
        }
        if (d2 < d3) {
            return -1;
        }
        if (d2 <= d3) return Booleans.compare(Double.isNaN(d2), Double.isNaN(d3));
        return 1;
    }

    /*
     * Exception decompiling
     */
    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    public static /* varargs */ double mean(double ... var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.NullPointerException
        // org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueAssignmentAndAliasCondenser$ExpressionStatement.access$200(LValueAssignmentAndAliasCondenser.java:237)
        // org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueAssignmentAndAliasCondenser$MutationRewriterSecondPass.getLValueReplacement(LValueAssignmentAndAliasCondenser.java:480)
        // org.benf.cfr.reader.bytecode.analysis.parse.expression.LValueExpression.replaceSingleUsageLValues(LValueExpression.java:59)
        // org.benf.cfr.reader.bytecode.analysis.parse.statement.ReturnValueStatement.replaceSingleUsageLValues(ReturnValueStatement.java:50)
        // org.benf.cfr.reader.bytecode.analysis.parse.statement.IfExitingStatement.replaceSingleUsageLValues(IfExitingStatement.java:40)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.condense(Op03SimpleStatement.java:434)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LValueProp.condenseLValues(LValueProp.java:47)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:582)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    public static /* varargs */ double mean(int ... arrn) {
        Preconditions.checkArgument(arrn.length > 0, "Cannot take mean of 0 values");
        long l2 = 0;
        int n2 = 0;
        while (n2 < arrn.length) {
            l2 += (long)arrn[n2];
            ++n2;
        }
        return (double)l2 / (double)arrn.length;
    }

    /*
     * Exception decompiling
     */
    public static /* varargs */ double mean(long ... var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.NullPointerException
        // org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueAssignmentAndAliasCondenser$ExpressionStatement.access$200(LValueAssignmentAndAliasCondenser.java:237)
        // org.benf.cfr.reader.bytecode.analysis.parse.utils.LValueAssignmentAndAliasCondenser$MutationRewriterSecondPass.getLValueReplacement(LValueAssignmentAndAliasCondenser.java:480)
        // org.benf.cfr.reader.bytecode.analysis.parse.expression.LValueExpression.replaceSingleUsageLValues(LValueExpression.java:59)
        // org.benf.cfr.reader.bytecode.analysis.parse.statement.ReturnValueStatement.replaceSingleUsageLValues(ReturnValueStatement.java:50)
        // org.benf.cfr.reader.bytecode.analysis.parse.statement.IfExitingStatement.replaceSingleUsageLValues(IfExitingStatement.java:40)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.condense(Op03SimpleStatement.java:434)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.LValueProp.condenseLValues(LValueProp.java:47)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:582)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    public static double mean(Iterable iterable) {
        return DoubleMath.mean(iterable.iterator());
    }

    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    public static double mean(Iterator iterator) {
        Preconditions.checkArgument(iterator.hasNext(), "Cannot take mean of 0 values");
        long l2 = 1;
        double d2 = DoubleMath.checkFinite(((Number)iterator.next()).doubleValue());
        while (iterator.hasNext()) {
            double d3 = DoubleMath.checkFinite(((Number)iterator.next()).doubleValue());
            d2 += (d3 - d2) / (double)(++l2);
        }
        return d2;
    }

    @GwtIncompatible(value="com.google.common.math.DoubleUtils")
    private static double checkFinite(double d2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d2));
        return d2;
    }

    private DoubleMath() {
    }
}

