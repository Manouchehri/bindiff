package com.google.security.zynamics.zylib.io;

import com.google.security.zynamics.zylib.gui.*;
import java.io.*;

public class DirectoryChooser extends CFileChooser
{
    private static final long serialVersionUID = 5354437749644373707L;
    
    public DirectoryChooser(final String dialogTitle) {
        this.setCurrentDirectory(new File("."));
        this.setDialogTitle(dialogTitle);
        this.setFileSelectionMode(1);
        this.setAcceptAllFileFilterUsed(false);
    }
}
