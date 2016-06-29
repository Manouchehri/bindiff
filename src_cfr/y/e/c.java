/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.io.FileOutputStream;
import java.io.OutputStream;
import y.h.bu;

public abstract class c {
    public static int a;

    public abstract void a(bu var1, OutputStream var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(bu bu2, String string) {
        FileOutputStream fileOutputStream = new FileOutputStream(string);
        try {
            this.a(bu2, fileOutputStream);
            Object var5_4 = null;
            if (fileOutputStream == null) return;
            fileOutputStream.flush();
            fileOutputStream.close();
            return;
        }
        catch (Throwable var4_6) {
            Object var5_5 = null;
            if (fileOutputStream == null) throw var4_6;
            fileOutputStream.flush();
            fileOutputStream.close();
            throw var4_6;
        }
    }
}

