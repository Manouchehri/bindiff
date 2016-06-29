/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.scripting;

public class InitStringFactory {
    public static String getInitString(String string, String string2, String string3) {
        if (string == null) {
            return "";
        }
        if (!string.startsWith("python")) return "";
        return String.format("import sys\nsys.stdout = %s\nsys.path.append('%s')\n", string2, string3);
    }
}

