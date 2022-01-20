package com.example.lonelymountainnav.view

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.convertToString(): String {
    return this.editText?.text.toString() ?: "No input"
}