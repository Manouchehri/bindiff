package com.google.security.zynamics.zylib.general;

import com.google.common.base.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public final class ClipboardHelpers
{
    public static void copyToClipboard(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: String argument can not be null");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(s), new ClipboardHelpers$1());
    }
    
    public static String getClipboardString() {
        final Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        if (contents == null || !contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return null;
        }
        try {
            return (String)contents.getTransferData(DataFlavor.stringFlavor);
        }
        catch (UnsupportedFlavorException | IOException ex) {
            return null;
        }
    }
}
