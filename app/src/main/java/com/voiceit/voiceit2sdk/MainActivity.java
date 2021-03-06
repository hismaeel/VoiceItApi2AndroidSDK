package com.voiceit.voiceit2sdk;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.loopj.android.http.JsonHttpResponseHandler;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

import com.voiceit.voiceit2.VoiceItAPI2;


public class MainActivity extends AppCompatActivity {

    public VoiceItAPI2 myVoiceIt2;
    public String userId = "USER_ID";
    public Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVoiceIt2 = new VoiceItAPI2("API_KEY","API_TOK");
        mActivity = this;
    }

    public void encapsulatedVideoEnrollment(View view) {
        myVoiceIt2.encapsulatedVideoEnrollment(mActivity, userId, "en-US", "My face and voice identify me", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("encapsulatedVideoEnrollment Result : " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    System.out.println("encapsulatedVideoEnrollment Result : " + errorResponse.toString());
                }
            }
        });
    }

    public void encapsulatedVideoVerification(View view) {
        myVoiceIt2.encapsulatedVideoVerification(this, userId, "en-US", "My face and voice identify me", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                System.out.println("encapsulatedVideoVerification Result : " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    System.out.println("encapsulatedVideoVerification Result : " + errorResponse.toString());
                }
            }
        });
    }

}
