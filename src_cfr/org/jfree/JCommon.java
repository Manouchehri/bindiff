/*
 * Decompiled with CFR 0_115.
 */
package org.jfree;

import java.io.PrintStream;
import org.jfree.JCommonInfo;
import org.jfree.ui.about.ProjectInfo;

public final class JCommon {
    public static final ProjectInfo INFO = JCommonInfo.getInstance();

    private JCommon() {
    }

    public static void main(String[] arrstring) {
        System.out.println(INFO.toString());
    }
}

