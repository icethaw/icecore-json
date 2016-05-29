/*
+++++++++++++++++++++++++++++++++++++++++++
title     JSON Parser Test                +
project   icecore-json                    +
file      JsonParserTest.java             +
version                                   +
author    Arctic Ice Studio               +
email     development@arcticicestudio.com +
website   http://arcticicestudio.com      +
copyright Copyright (C) 2016              +
created   2016-05-29 18:06 UTC+0200       +
modified  2016-05-29 18:07 UTC+0200       +
+++++++++++++++++++++++++++++++++++++++++++

[Description]
Tests the JSON parser class "JsonParser".

[Copyright]
Copyright (C) 2016 Arctic Ice Studio <development@arcticicestudio.com>

[References]
JSON
  (http://json.org)
ECMA-404 1st Edition (October 2013)
  (http://www.ecma-international.org/publications/files/ECMA-ST/ECMA-404.pdf)
Java 8 API Documentation
  (https://docs.oracle.com/javase/8/docs/api/)
JUnit
  (http://junit.org)
Mockito
  (http://mockito.org)
Arctic Versioning Specification (ArcVer)
  (http://specs.arcticicestudio.com/arcver)
*/

package com.arcticicestudio.icecore.json;

import org.hamcrest.core.StringStartsWith;
import org.junit.Test;

import static com.arcticicestudio.icecore.json.TestUtil.assertException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.StringReader;

import com.arcticicestudio.icecore.json.TestUtil.RunnableEx;

/**
 * Tests the JSON parser class {@link JsonParser}.
 *
 * @author Arctic Ice Studio &lt;development@arcticicestudio.com&gt;
 * @since 0.7.0
 */
public class JsonParserTest {

  @Test
  public void parseRejectsEmptyString() {
    assertParseException(0, "Unexpected end of input", "");
  }

  @Test
  public void parseRejectsEmptyReader() {
    ParseException exception = assertException(ParseException.class, new RunnableEx() {
      public void run() throws IOException {
        new JsonParser(new StringReader("")).parse();
      }
    });
    assertEquals(0, exception.getOffset());
    assertThat(exception.getMessage(), StringStartsWith.startsWith("Unexpected end of input at"));
  }

  @Test
  public void parseAcceptsArrays() {
    assertEquals(new JsonArray(), parse("[]"));
  }

  @Test
  public void parseAcceptsObjects() {
    assertEquals(new JsonObject(), parse("{}"));
  }

  @Test
  public void parseAcceptsStrings() {
    assertEquals(new JsonString(""), parse("\"\""));
  }

  private static void assertParseException(int offset, String message, final String json) {
    ParseException exception = assertException(ParseException.class, new Runnable() {
      public void run() {
        parse(json);
      }
    });
    assertEquals(offset, exception.getOffset());
    assertThat(exception.getMessage(), StringStartsWith.startsWith(message + " at"));
  }

  private static void assertParseException(int offset, int line, int column, final String json) {
    ParseException exception = assertException(ParseException.class, new Runnable() {
      public void run() {
        parse(json);
      }
    });
    assertEquals("offset", offset, exception.getOffset());
    assertEquals("line", line, exception.getLine());
    assertEquals("column", column, exception.getColumn());
  }

  private static JsonValue parse(String json) {
    try {
      return new JsonParser(json).parse();
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
