/*
++++++++++++++++++++++++++++++++++++++++++++
title     Parse Exception                  +
project   icecore-json                     +
file      ParseException.java              +
version                                    +
author    Arctic Ice Studio                +
email     development@arcticicestudio.com  +
website   http://arcticicestudio.com       +
copyright Copyright (C) 2016               +
created   2016-05-28 14:12 UTC+0200        +
modified  2016-05-28 14:13 UTC+0200        +
++++++++++++++++++++++++++++++++++++++++++++

[Description]
An unchecked exception to indicate that an input does not qualify as valid JSON.

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

/**
 * An unchecked exception to indicate that an input does not qualify as valid JSON.
 *
 * @author Arctic Ice Studio &lt;development@arcticicestudio.com&gt;
 * @since 0.4.0
 */
public class ParseException extends RuntimeException {}