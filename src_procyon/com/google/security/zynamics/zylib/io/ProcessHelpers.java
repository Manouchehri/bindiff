package com.google.security.zynamics.zylib.io;

public class ProcessHelpers
{
    public static void runBatchFile(final String s) {
        Runtime.getRuntime().exec(new String[] { "cmd", "/c", s }).waitFor();
    }
}
