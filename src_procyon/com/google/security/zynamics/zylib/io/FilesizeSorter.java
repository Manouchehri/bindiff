package com.google.security.zynamics.zylib.io;

import java.util.*;
import java.io.*;

public class FilesizeSorter implements Serializable, Comparator
{
    private static final long serialVersionUID = 7060651903531011219L;
    
    public int compare(final File file, final File file2) {
        return (int)(file.length() - file2.length());
    }
}
