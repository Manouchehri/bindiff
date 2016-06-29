/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

import com.google.security.zynamics.zylib.gui.CFileChooser;
import java.io.File;

public class DirectoryChooser
extends CFileChooser {
    private static final long serialVersionUID = 5354437749644373707L;

    public DirectoryChooser(String string) {
        this.setCurrentDirectory(new File("."));
        this.setDialogTitle(string);
        this.setFileSelectionMode(1);
        this.setAcceptAllFileFilterUsed(false);
    }
}

