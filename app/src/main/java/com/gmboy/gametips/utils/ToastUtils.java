package com.gmboy.gametips.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void ShowToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
