/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

final class Utf8 {
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;

    private Utf8() {
    }

    public static boolean isValidUtf8(byte[] arrby) {
        return Utf8.isValidUtf8(arrby, 0, arrby.length);
    }

    public static boolean isValidUtf8(byte[] arrby, int n2, int n3) {
        if (Utf8.partialIsValidUtf8(arrby, n2, n3) != 0) return false;
        return true;
    }

    public static int partialIsValidUtf8(int n2, byte[] arrby, int n3, int n4) {
        if (n2 == 0) return Utf8.partialIsValidUtf8(arrby, n3, n4);
        if (n3 >= n4) {
            return n2;
        }
        byte by2 = (byte)n2;
        if (by2 < -32) {
            if (by2 < -62) return -1;
            if (arrby[n3++] <= -65) return Utf8.partialIsValidUtf8(arrby, n3, n4);
            return -1;
        }
        if (by2 < -16) {
            byte by3 = (byte)(~ (n2 >> 8));
            if (by3 == 0) {
                by3 = arrby[n3++];
                if (n3 >= n4) {
                    return Utf8.incompleteStateFor(by2, by3);
                }
            }
            if (by3 > -65) return -1;
            if (by2 == -32) {
                if (by3 < -96) return -1;
            }
            if (by2 == -19) {
                if (by3 >= -96) return -1;
            }
            if (arrby[n3++] <= -65) return Utf8.partialIsValidUtf8(arrby, n3, n4);
            return -1;
        }
        byte by4 = (byte)(~ (n2 >> 8));
        byte by5 = 0;
        if (by4 == 0) {
            by4 = arrby[n3++];
            if (n3 >= n4) {
                return Utf8.incompleteStateFor(by2, by4);
            }
        } else {
            by5 = (byte)(n2 >> 16);
        }
        if (by5 == 0) {
            by5 = arrby[n3++];
            if (n3 >= n4) {
                return Utf8.incompleteStateFor(by2, (int)by4, (int)by5);
            }
        }
        if (by4 > -65) return -1;
        if ((by2 << 28) + (by4 - -112) >> 30 != 0) return -1;
        if (by5 > -65) return -1;
        if (arrby[n3++] <= -65) return Utf8.partialIsValidUtf8(arrby, n3, n4);
        return -1;
    }

    public static int partialIsValidUtf8(byte[] arrby, int n2, int n3) {
        while (n2 < n3 && arrby[n2] >= 0) {
            ++n2;
        }
        if (n2 >= n3) {
            return 0;
        }
        int n4 = Utf8.partialIsValidUtf8NonAscii(arrby, n2, n3);
        return n4;
    }

    /*
     * Unable to fully structure code
     */
    private static int partialIsValidUtf8NonAscii(byte[] var0, int var1_1, int var2_2) {
        do lbl-1000: // 5 sources:
        {
            if (var1_1 >= var2_2) {
                return 0;
            }
            if ((var3_3 = var0[var1_1++]) >= 0) ** GOTO lbl-1000
            if (var3_3 >= -32) ** GOTO lbl11
            if (var1_1 >= var2_2) {
                return var3_3;
            }
            if (var3_3 < -62) return -1;
            if (var0[var1_1++] <= -65) ** GOTO lbl-1000
            return -1;
lbl11: // 1 sources:
            if (var3_3 >= -16) ** GOTO lbl21
            if (var1_1 >= var2_2 - 1) {
                return Utf8.incompleteStateFor(var0, var1_1, var2_2);
            }
            if ((var4_4 = var0[var1_1++]) > -65) return -1;
            if (var3_3 == -32) {
                if (var4_4 < -96) return -1;
            }
            if (var3_3 == -19) {
                if (var4_4 >= -96) return -1;
            }
            if (var0[var1_1++] <= -65) ** GOTO lbl-1000
            return -1;
lbl21: // 1 sources:
            if (var1_1 >= var2_2 - 2) {
                return Utf8.incompleteStateFor(var0, var1_1, var2_2);
            }
            if ((var4_4 = var0[var1_1++]) > -65) return -1;
            if ((var3_3 << 28) + (var4_4 - -112) >> 30 != 0) return -1;
            if (var0[var1_1++] > -65) return -1;
        } while (var0[var1_1++] <= -65);
        return -1;
    }

    private static int incompleteStateFor(int n2) {
        if (n2 > -12) {
            return -1;
        }
        int n3 = n2;
        return n3;
    }

    private static int incompleteStateFor(int n2, int n3) {
        if (n2 > -12) return -1;
        if (n3 > -65) return -1;
        int n4 = n2 ^ n3 << 8;
        return n4;
    }

    private static int incompleteStateFor(int n2, int n3, int n4) {
        if (n2 > -12) return -1;
        if (n3 > -65) return -1;
        if (n4 > -65) return -1;
        int n5 = n2 ^ n3 << 8 ^ n4 << 16;
        return n5;
    }

    private static int incompleteStateFor(byte[] arrby, int n2, int n3) {
        byte by2 = arrby[n2 - 1];
        switch (n3 - n2) {
            case 0: {
                return Utf8.incompleteStateFor(by2);
            }
            case 1: {
                return Utf8.incompleteStateFor(by2, arrby[n2]);
            }
            case 2: {
                return Utf8.incompleteStateFor(by2, (int)arrby[n2], (int)arrby[n2 + 1]);
            }
        }
        throw new AssertionError();
    }
}

