package com.gmboy.gametips;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;

import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.gmboy.gametips.utils.ToastUtils;



public class SplashActivity extends AppCompatActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initFbWidget();
    }

    private void initFbWidget() {
        callbackManager = CallbackManager.Factory.create();
    }

    public void onShareDialog(View view) {
        ShareDialog shareDialog = new ShareDialog(this);
        shareDialog.registerCallback(callbackManager, new FacebookCallback(){

            @Override
            public void onSuccess(Object o) {
                ToastUtils.ShowToast(getApplicationContext(), "onShareDialog-onSuccess");
            }

            @Override
            public void onError(@NonNull FacebookException e) {
                ToastUtils.ShowToast(getApplicationContext(), "onShareDialog-onError");
            }

            @Override
            public void onCancel() {
                ToastUtils.ShowToast(getApplicationContext(), "onShareDialog-onCancel");
            }
        });

        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                    .build();
            shareDialog.show(linkContent);

            ToastUtils.ShowToast(getApplicationContext(), "onShareDialog");
        } else {
            ToastUtils.ShowToast(getApplicationContext(), "onShareDialog - not");
        }

    }

    public void onMessageDialog(View view) {

        MessageDialog messageDialog = new MessageDialog(this);
        messageDialog.registerCallback(callbackManager, new FacebookCallback(){

            @Override
            public void onSuccess(Object o) {
                ToastUtils.ShowToast(getApplicationContext(), "onMessageDialog-onSuccess");
            }

            @Override
            public void onError(@NonNull FacebookException e) {
                ToastUtils.ShowToast(getApplicationContext(), "onMessageDialog-onError");
            }

            @Override
            public void onCancel() {
                ToastUtils.ShowToast(getApplicationContext(), "onMessageDialog-onCancel");
            }
        });

        if (MessageDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                    .build();

            messageDialog.show(linkContent);

            ToastUtils.ShowToast(getApplicationContext(), "onMessageDialog");
        } else {
            ToastUtils.ShowToast(getApplicationContext(), "onMessageDialog - not");
        }

    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}