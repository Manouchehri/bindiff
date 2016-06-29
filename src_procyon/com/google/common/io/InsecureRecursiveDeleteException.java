package com.google.common.io;

import java.nio.file.*;
import com.google.common.annotations.*;
import javax.annotation.*;

@GoogleInternal
public final class InsecureRecursiveDeleteException extends FileSystemException
{
    public InsecureRecursiveDeleteException(@Nullable final String s) {
        super(s, null, "unable to guarantee security of recursive delete");
    }
}
