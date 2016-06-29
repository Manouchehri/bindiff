package org.jfree.data.general;

import java.util.*;
import java.io.*;

public class SeriesChangeEvent extends EventObject implements Serializable
{
    private static final long serialVersionUID = 1593866085210089052L;
    
    public SeriesChangeEvent(final Object o) {
        super(o);
    }
}
