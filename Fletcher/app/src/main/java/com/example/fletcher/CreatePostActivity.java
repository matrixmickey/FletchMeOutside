package com.example.fletcher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class CreatePostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        final Context mContext = this;
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.GET, getString(R.string.user_url), null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    final String username = response.getString("username");
                                    JSONObject json = new JSONObject();
                                    try {
                                        json.put("username", username);
                                        json.put("postText", ((TextView) ((CreatePostActivity) mContext).findViewById(R.id.editText)).getText());
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                                            (Request.Method.POST, getString(R.string.create_post_url), json, new Response.Listener<JSONObject>() {

                                                @Override
                                                public void onResponse(JSONObject response) {
                                                    Intent intent = new Intent(mContext, MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            }, new Response.ErrorListener() {

                                                @Override
                                                public void onErrorResponse(VolleyError error) {
                                                    Intent intent = new Intent(mContext, MainActivity.class);
                                                    startActivity(intent);
                                                }
                                            });
                                    MySingleton.getInstance(mContext).addToRequestQueue(jsonObjectRequest);
                                }
                                catch (JSONException e)
                                {

                                }
                            }
                        }, new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });
                MySingleton.getInstance(mContext).addToRequestQueue(jsonObjectRequest);
            }
        });
    }
}
