package com.google.common.cache;

import com.google.common.cache.LocalCache$ValueReference;
import javax.annotation.Nullable;

interface LocalCache$ReferenceEntry {
   LocalCache$ValueReference getValueReference();

   void setValueReference(LocalCache$ValueReference var1);

   @Nullable
   LocalCache$ReferenceEntry getNext();

   int getHash();

   @Nullable
   Object getKey();

   long getAccessTime();

   void setAccessTime(long var1);

   LocalCache$ReferenceEntry getNextInAccessQueue();

   void setNextInAccessQueue(LocalCache$ReferenceEntry var1);

   LocalCache$ReferenceEntry getPreviousInAccessQueue();

   void setPreviousInAccessQueue(LocalCache$ReferenceEntry var1);

   long getWriteTime();

   void setWriteTime(long var1);

   LocalCache$ReferenceEntry getNextInWriteQueue();

   void setNextInWriteQueue(LocalCache$ReferenceEntry var1);

   LocalCache$ReferenceEntry getPreviousInWriteQueue();

   void setPreviousInWriteQueue(LocalCache$ReferenceEntry var1);
}
