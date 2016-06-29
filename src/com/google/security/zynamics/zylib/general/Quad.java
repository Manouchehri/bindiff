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
package com.google.security.zynamics.zylib.general;

public class Quad<S, T, U, V> {
  private final S m_first;

  private final T m_second;

  private final U m_third;

  private final V m_fourth;

  public Quad(final S first, final T second, final U third, final V fourth) {
    m_first = first;
    m_second = second;
    m_third = third;
    m_fourth = fourth;
  }

  @Override
  public boolean equals(final Object obj) {
    if (!(obj instanceof Quad)) {
      return false;
    }

    final Quad<?, ?, ?, ?> q = (Quad<?, ?, ?, ?>) obj;

    if (!((q.first() == null) && (m_first == null))) {
      if ((q.first() == null) || (m_first == null)) {
        return false;
      } else if (!q.m_first.equals(m_first)) {
        return false;
      }
    }

    if (!((q.second() == null) && (m_second == null))) {
      if ((q.second() == null) || (m_second == null)) {
        return false;
      } else if (!q.m_second.equals(m_second)) {
        return false;
      }
    }

    if (!((q.third() == null) && (m_third == null))) {
      if ((q.third() == null) || (m_third == null)) {
        return false;
      } else if (!q.m_third.equals(m_third)) {
        return false;
      }
    }

    if (!((q.fourth() == null) && (m_fourth == null))) {
      if ((q.fourth() == null) || (m_fourth == null)) {
        return false;
      } else if (!q.m_fourth.equals(m_fourth)) {
        return false;
      }
    }

    return true;
  }

  public S first() {
    return m_first;
  }

  public V fourth() {
    return m_fourth;
  }

  @Override
  public int hashCode() {

    return (m_first == null ? 1 : m_first.hashCode())
        * (m_second == null ? 1 : m_second.hashCode()) * (m_third == null ? 1 : m_third.hashCode())
        * (m_fourth == null ? 1 : m_fourth.hashCode());

  }

  public T second() {
    return m_second;
  }

  public U third() {
    return m_third;
  }

  @Override
  public String toString() {
    return "< " + m_first + ", " + m_second + ", " + m_third + ", " + m_fourth + ">";
  }
}
