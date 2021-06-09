package org.olafneumann.base64online

import kotlinx.browser.document
import kotlinx.browser.window
import org.olafneumann.base64online.base64.Base64
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement

fun main() {
    window.onload = { initBase64Online() }
}

private fun initBase64Online() {
    val txtPlainInput: HTMLTextAreaElement = document.getElementById("b6-input-plain") as HTMLTextAreaElement
    val txtBase64Input: HTMLTextAreaElement = document.getElementById("b6-input-base64") as HTMLTextAreaElement
    val fileInput: HTMLInputElement = document.getElementById("b6-input-file") as HTMLInputElement

    txtPlainInput.oninput = {
        val text = txtPlainInput.value
        txtBase64Input.value = Base64.encode(text)
        null
    }
    txtBase64Input.oninput = {
        val base64 = txtBase64Input.value
        txtPlainInput.value = Base64.decode(base64)
        null
    }
    fileInput.onchange = {
        console.log(fileInput.value)
        null
    }
}
