package org.olafneumann.base64online

import kotlinx.browser.document
import kotlinx.browser.window
import org.olafneumann.base64online.base64.Base64
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLPreElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.events.Event
import org.w3c.files.File
import org.w3c.files.FileReader
import org.w3c.files.get
import org.w3c.xhr.ProgressEvent

fun main() {
    window.onload = { initBase64Online() }
}

private fun initBase64Online() {
    val txtPlainInput: HTMLTextAreaElement = document.getElementById("b6-input-plain") as HTMLTextAreaElement
    val txtBase64Input: HTMLTextAreaElement = document.getElementById("b6-input-base64") as HTMLTextAreaElement
    val fileInput: HTMLInputElement = document.getElementById("b6-input-file") as HTMLInputElement
    val fileOutput: HTMLPreElement = document.getElementById("b6-output-file") as HTMLPreElement
    val fileActionEncode: HTMLInputElement = document.getElementById("b6-file-action-encode") as HTMLInputElement
    val fileActionDecode: HTMLInputElement = document.getElementById("b6-file-action-decode") as HTMLInputElement

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
    val fileChangeHandler: (Event) -> dynamic = {
        fileInput.files?.get(0)?.read() { fileOutput.innerText = if (fileActionEncode.checked) {
            Base64.encode(it)
        } else {
            Base64.decode(it)
        } }
        null
    }
    fileInput.onchange = fileChangeHandler
    fileActionEncode.oninput = fileChangeHandler
    fileActionDecode.oninput = fileChangeHandler
}

private fun File.read(callback: (String) -> Unit) {
    val reader = FileReader()
    reader.addEventListener("load", { callback(reader.result as String) })
    reader.readAsBinaryString(this)
}
