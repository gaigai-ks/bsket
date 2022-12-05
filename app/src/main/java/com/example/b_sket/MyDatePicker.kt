package com.example.b_sket

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Build
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// ────────────────────────────────────────────────────────────────
// ドラム式 日付入力ダイアログ
// ────────────────────────────────────────────────────────────────
@RequiresApi(Build.VERSION_CODES.O)
object MyDatePicker {

    fun showDatePicker (eText : EditText) {

        // 日付入力フィールドが空白など日付ではないときの初期値として、「今日」を設定
        val defaultDate = LocalDate.now()
        var year = defaultDate.year
        var monthValue = defaultDate.monthValue
        var dayOfMonth = defaultDate.dayOfMonth

        // 日付入力フィールドの値が日付の場合はその値を設定
        val ldt = toLocaleDate(eText.text.toString())
        if (ldt != null) {
            year = ldt.year
            monthValue = ldt.monthValue
            dayOfMonth = ldt.dayOfMonth
        }

        // ドラム式DatePicker表示
        val picker = DatePickerDialog(
            eText.rootView.context,
            AlertDialog.THEME_HOLO_LIGHT,   // テーマ：ドラム式 背景白

            // ダイアログでOKをクリックされたときの処理 日付入力フィールドへ値を設定
            { _, getYear, getMonthOfYear, getDayOfMonth
                -> eText.setText(String.format("%d/%02d/%02d",
                getYear,
                getMonthOfYear + 1,     // 月はZEROオリジン
                getDayOfMonth))
            },

            // DatePickerが初期表示する日付
            year,
            monthValue - 1, // 月はZEROオリジン
            dayOfMonth
        )
        picker.show()

    }

    private const val DATE_FORMAT = "yyyy/MM/dd"

    fun toLocaleDate(stringDate : String) : LocalDate? {
        val df = DateTimeFormatter.ofPattern(DATE_FORMAT)
        return try { LocalDate.parse(stringDate, df) } catch (t: Throwable) { null }
    }

}