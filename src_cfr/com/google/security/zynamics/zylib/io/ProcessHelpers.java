/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

public class ProcessHelpers {
    public static void runBatchFile(String string) {
        Process process = Runtime.getRuntime().exec(new String[]{"cmd", "/c", string});
        process.waitFor();
    }
}

