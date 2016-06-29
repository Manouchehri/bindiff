/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import org.jfree.ui.about.ProjectInfo;

public class Library
extends org.jfree.base.Library {
    public Library(String string, String string2, String string3, String string4) {
        super(string, string2, string3, string4);
    }

    public Library(ProjectInfo projectInfo) {
        this(projectInfo.getName(), projectInfo.getVersion(), projectInfo.getLicenceName(), projectInfo.getInfo());
    }
}

