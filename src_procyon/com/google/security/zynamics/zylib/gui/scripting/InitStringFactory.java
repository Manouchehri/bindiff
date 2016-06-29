package com.google.security.zynamics.zylib.gui.scripting;

public class InitStringFactory
{
    public static String getInitString(final String s, final String s2, final String s3) {
        if (s == null) {
            return "";
        }
        if (s.startsWith("python")) {
            return String.format("import sys\nsys.stdout = %s\nsys.path.append('%s')\n", s2, s3);
        }
        return "";
    }
}
