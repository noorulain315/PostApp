package com.example.core.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.text.Html
import androidx.annotation.ArrayRes
import androidx.annotation.StyleRes
import com.example.core.R


object DialogUtil {

    private val emptyListener = DialogInterface.OnClickListener { _, _ -> }

    fun getAlertDialog(
        context: Context,
        @ArrayRes resourceId: Int,
        positiveButtonListener: DialogInterface.OnClickListener = emptyListener,
        neutralButtonListener: DialogInterface.OnClickListener = emptyListener,
        negativeButtonListener: DialogInterface.OnClickListener = emptyListener,
        @StyleRes themeResourceId: Int = R.style.dialog_style
    ): AlertDialog.Builder {
        val resource = context.resources.getStringArray(resourceId)

        val dialog = AlertDialog.Builder(context, themeResourceId)


        resource.forEachIndexed { index, value ->
            if (!value.isNullOrEmpty()) {
                when (index) {
                    TITLE -> dialog.setTitle(value)
                    MESSAGE -> dialog.setMessage(Html.fromHtml(value))
                    POSITIVE_TEXT -> dialog.setPositiveButton(value, positiveButtonListener)
                    NEUTRAL_TEXT -> dialog.setNeutralButton(value, neutralButtonListener)
                    NEGATIVE_TEXT -> dialog.setNegativeButton(value, negativeButtonListener)
                }
            }
        }

        return dialog
    }

    private const val TITLE = 0
    private const val MESSAGE = 1
    private const val POSITIVE_TEXT = 2
    private const val NEUTRAL_TEXT = 3
    private const val NEGATIVE_TEXT = 4

}