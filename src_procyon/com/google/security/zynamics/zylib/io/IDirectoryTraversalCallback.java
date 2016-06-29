package com.google.security.zynamics.zylib.io;

import java.io.*;

public interface IDirectoryTraversalCallback
{
    void entering(final File p0);
    
    void leaving(final File p0);
    
    void nextFile(final File p0);
}
