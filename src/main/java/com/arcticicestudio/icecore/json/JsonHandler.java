/*
+++++++++++++++++++++++++++++++++++++++++++
title     JSON Handler                    +
project   icecore-json                    +
file      JsonHandler.java                +
version                                   +
author    Arctic Ice Studio               +
email     development@arcticicestudio.com +
website   http://arcticicestudio.com      +
copyright Copyright (C) 2016              +
created   2016-05-30 21:44 UTC+0200       +
modified  2016-05-30 21:45 UTC+0200       +
+++++++++++++++++++++++++++++++++++++++++++

[Description]
A handler for parser events.

[Copyright]
Copyright (C) 2016 Arctic Ice Studio <development@arcticicestudio.com>

[References]
JSON
  (http://json.org)
ECMA-404 1st Edition (October 2013)
  (http://www.ecma-international.org/publications/files/ECMA-ST/ECMA-404.pdf)
Java 8 API Documentation
  (https://docs.oracle.com/javase/8/docs/api/)
Arctic Versioning Specification (ArcVer)
  (http://specs.arcticicestudio.com/arcver)
*/
package com.arcticicestudio.icecore.json;

import com.arcticicestudio.icecore.json.JsonParser.Location;

/**
 * A handler for parser events.
 *
 * @param <A> The type of handlers used for JSON arrays
 * @param <O> The type of handlers used for JSON objects
 *
 * @author Arctic Ice Studio &lt;development@arcticicestudio.com&gt;
 * @see JsonParser
 * @since 0.8.0
 */
public abstract class JsonHandler<A, O> {

  JsonParser parser;

  /**
   * Returns the current parser location.
   *
   * @return the current parser location
   */
  protected Location getLocation() {
    return parser.getLocation();
  }

  /**
   * Indicates the beginning of a JSON {@code null} literal in the input.
   * This method will be called when reading the first character of the literal.
   */
  public void startNull() {}

  /**
   * Indicates the end of a JSON {@code null} literal in the input.
   * This method will be called when reading the last character of the literal.
   */
  public void endNull() {}

  /**
   * Indicates the beginning of a JSON {@code true} literal in the input.
   * This method will be called when reading the first character of the literal.
   */
  public void startTrue() {}

  /**
   * Indicates the end of a JSON {@code true} literal in the input.
   * This method will be called when reading the last character of the literal.
   */
  public void endTrue() {}

  /**
   * Indicates the beginning of a JSON {@code false} literal in the input.
   * This method will be called when reading the first character of the literal.
   */
  public void startFalse() {}

  /**
   * Indicates the end of a JSON {@code false} literal in the input.
   * This method will be called when reading the last character of the literal.
   */
  public void endFalse() {}

  /**
   * Indicates the beginning of a JSON string in the input.
   * This method will be called when reading the opening double quote character ({@code '"'}).
   */
  public void startString() {}

  /**
   * Indicates the end of a JSON string in the input.
   * This method will be called when reading the closing double quote character ({@code '"'}).
   *
   * @param string The parsed string
   */
  public void endString(String string) {}

  /**
   * Indicates the beginning of a JSON number in the input.
   * This method will be called when reading the first character of the number.
   */
  public void startNumber() {}

  /**
   * Indicates the end of a JSON number in the input.
   * This method will be called when reading the last character of the number.
   *
   * @param string The parsed number string
   */
  public void endNumber(String string) {}

  /**
   * Indicates the beginning of a JSON array in the input.
   * This method will be called when reading the opening square bracket character ({@code '['}).
   *
   * <p>
   * This method may return an object to handle subsequent parser events for this array.
   * This array handler will then be provided in all calls to {@link #startArrayValue(Object)},
   * {@link #startArrayValue()}, {@link #endArrayValue(Object)}, {@link #endArrayValue()},
   * {@link #endArray(Object)}, and {@link #endArray()} for this array.
   * </p>
   *
   * @return a handler for this array, or {@code null} if not needed
   */
  public A startArray() {
    return null;
  }
}
