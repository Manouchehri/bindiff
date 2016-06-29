/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.zylib.gui.zygraph.layouters;


public enum CircularStyle {
  COMPACT, ISOLATED, SINGLE_CIRCLE;

  public static CircularStyle parseInt(final int style) {
    if (style == COMPACT.ordinal()) {
      return COMPACT;
    } else if (style == ISOLATED.ordinal()) {
      return ISOLATED;
    } else if (style == SINGLE_CIRCLE.ordinal()) {
      return SINGLE_CIRCLE;
    } else {
      throw new IllegalStateException("Error: Invalid style");
    }
  }
}
