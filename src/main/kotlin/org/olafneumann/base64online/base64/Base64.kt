@file:JsModule("js-base64")
package org.olafneumann.base64online.base64

external class Base64 {
    companion object {
        fun encode(rawString: String): String
        fun decode(base64String: String): String
    }
}
