import kotlinx.browser.document
import org.w3c.dom.HTMLTextAreaElement

fun main() {
    document.write("Hello, world!")

    val txtPlainInput: HTMLTextAreaElement = document.getElementById("b6-input-plain") as HTMLTextAreaElement
    val txtBase64Input: HTMLTextAreaElement = document.getElementById("b6-input-base64") as HTMLTextAreaElement

    txtPlainInput.addEventListener("CHANGE", { txtBase64Input.innerText = txtPlainInput.innerText })
}