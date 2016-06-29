package com.google.protobuf;

final class Utf8
{
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    
    public static boolean isValidUtf8(final byte[] array) {
        return isValidUtf8(array, 0, array.length);
    }
    
    public static boolean isValidUtf8(final byte[] array, final int n, final int n2) {
        return partialIsValidUtf8(array, n, n2) == 0;
    }
    
    public static int partialIsValidUtf8(final int n, final byte[] array, int n2, final int n3) {
        if (n != 0) {
            if (n2 >= n3) {
                return n;
            }
            final byte b = (byte)n;
            if (b < -32) {
                if (b < -62 || array[n2++] > -65) {
                    return -1;
                }
            }
            else if (b < -16) {
                byte b2 = (byte)~(n >> 8);
                if (b2 == 0) {
                    b2 = array[n2++];
                    if (n2 >= n3) {
                        return incompleteStateFor(b, b2);
                    }
                }
                if (b2 > -65 || (b == -32 && b2 < -96) || (b == -19 && b2 >= -96) || array[n2++] > -65) {
                    return -1;
                }
            }
            else {
                byte b3 = (byte)~(n >> 8);
                int n4 = 0;
                if (b3 == 0) {
                    b3 = array[n2++];
                    if (n2 >= n3) {
                        return incompleteStateFor(b, b3);
                    }
                }
                else {
                    n4 = (byte)(n >> 16);
                }
                if (n4 == 0) {
                    n4 = array[n2++];
                    if (n2 >= n3) {
                        return incompleteStateFor(b, b3, n4);
                    }
                }
                if (b3 > -65 || (b << 28) + (b3 + 112) >> 30 != 0 || n4 > -65 || array[n2++] > -65) {
                    return -1;
                }
            }
        }
        return partialIsValidUtf8(array, n2, n3);
    }
    
    public static int partialIsValidUtf8(final byte[] array, int n, final int n2) {
        while (n < n2 && array[n] >= 0) {
            ++n;
        }
        return (n >= n2) ? 0 : partialIsValidUtf8NonAscii(array, n, n2);
    }
    
    private static int partialIsValidUtf8NonAscii(final byte[] array, int i, final int n) {
        while (i < n) {
            final byte b;
            if ((b = array[i++]) < 0) {
                if (b < -32) {
                    if (i >= n) {
                        return b;
                    }
                    if (b < -62 || array[i++] > -65) {
                        return -1;
                    }
                    continue;
                }
                else if (b < -16) {
                    if (i >= n - 1) {
                        return incompleteStateFor(array, i, n);
                    }
                    final byte b2;
                    if ((b2 = array[i++]) > -65 || (b == -32 && b2 < -96) || (b == -19 && b2 >= -96) || array[i++] > -65) {
                        return -1;
                    }
                    continue;
                }
                else {
                    if (i >= n - 2) {
                        return incompleteStateFor(array, i, n);
                    }
                    final byte b3;
                    if ((b3 = array[i++]) > -65 || (b << 28) + (b3 + 112) >> 30 != 0 || array[i++] > -65 || array[i++] > -65) {
                        return -1;
                    }
                    continue;
                }
            }
        }
        return 0;
    }
    
    private static int incompleteStateFor(final int n) {
        return (n > -12) ? -1 : n;
    }
    
    private static int incompleteStateFor(final int n, final int n2) {
        return (n > -12 || n2 > -65) ? -1 : (n ^ n2 << 8);
    }
    
    private static int incompleteStateFor(final int n, final int n2, final int n3) {
        return (n > -12 || n2 > -65 || n3 > -65) ? -1 : (n ^ n2 << 8 ^ n3 << 16);
    }
    
    private static int incompleteStateFor(final byte[] array, final int n, final int n2) {
        final byte b = array[n - 1];
        switch (n2 - n) {
            case 0: {
                return incompleteStateFor(b);
            }
            case 1: {
                return incompleteStateFor(b, array[n]);
            }
            case 2: {
                return incompleteStateFor(b, array[n], array[n + 1]);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
}
