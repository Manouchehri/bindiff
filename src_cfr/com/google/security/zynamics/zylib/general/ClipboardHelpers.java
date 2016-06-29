/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.ClipboardHelpers$1;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public final class ClipboardHelpers {
    public static void copyToClipboard(String string) {
        Preconditions.checkNotNull(string, "Error: String argument can not be null");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(string), new ClipboardHelpers$1());
    }

    public static String getClipboardString() {
        boolean bl2;
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipboard.getContents(null);
        if (transferable == null) return null;
        if (!transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) return null;
        boolean bl3 = bl2 = true;
        if (!bl2) {
            return null;
        }
        try {
            return (String)transferable.getTransferData(DataFlavor.stringFlavor);
        }
        catch (UnsupportedFlavorException | IOException var3_3) {
            return null;
        }
    }
}

