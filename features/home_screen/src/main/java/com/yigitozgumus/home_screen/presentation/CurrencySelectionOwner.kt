/*
 * Created by yigitozgumus on 4/2/22, 1:10 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 4/2/22, 1:10 PM
 */

package com.yigitozgumus.home_screen.presentation

import android.view.View
import android.widget.AdapterView

interface CurrencySelectionOwner : AdapterView.OnItemSelectedListener {

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, index: Int, p3: Long) {
        onCurrencySelected(adapterView?.adapter?.getItem(index).toString())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // no-op
    }

    fun onCurrencySelected(currency: String)
}
