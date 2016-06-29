package com.google.protobuf;

import com.google.protobuf.Message;
import java.util.Map;

interface MapField$Converter {
   Message convertKeyAndValueToMessage(Object var1, Object var2);

   void convertMessageToKeyAndValue(Message var1, Map var2);

   Message getMessageDefaultInstance();
}
