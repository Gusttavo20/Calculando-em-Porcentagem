package com.meuprimeiro.calculandoporcentagem

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


fun EditText.mask(textMask: String) {
    addTextChangedListener(object : TextWatcher {
        var isUpdating: Boolean = false
        override fun afterTextChanged(s: Editable) {
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val str = unmask(s.toString())
            var mask = ""

            if (isUpdating) {
                isUpdating = false
                return
            }

            var i = 0
            for (m in textMask.toCharArray()) {
                if (m != '#' && count > before) {
                    mask += m
                    continue
                }
                try {
                    mask += str[i]
                } catch (e: Exception) {
                    break
                }
                i++
            }

            isUpdating = true
            setText(mask)
            setSelection(mask.length)
        }

        private fun unmask(text: String): String {
            return text.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
                    .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "").replace("[ ]".toRegex(), "")
                    .replace("[:]".toRegex(), "").replace("[)]".toRegex(), "")
        }
    })
}
fun EditText.enzo() {
    addTextChangedListener(object : TextWatcher {
        var isUpdating: Boolean = false
        override fun afterTextChanged(s: Editable) {
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            if (isUpdating) {
                isUpdating = false
                return
            }

            val str = s.toString().replace(",", "").replace(".", "")
            if (str.length > 2) {
                val valores = str.substring(0, str.length - 2) + "," + str.substring(str.length - 2, str.length)
                isUpdating = true
                setText(valores)
                setSelection(valores.length)
            }

        }

    })

}

