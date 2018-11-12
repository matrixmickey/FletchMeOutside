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

import org.json.JSONException;
import org.json.JSONObject;

public class CreateCommentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_comment);

        final Context mContext = this;
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JSONObject json = new JSONObject();
                try {
                    json.put("username", getIntent().getStringExtra(LoginActivity.USERNAME));
                    json.put("postId", getIntent().getStringExtra(ViewCommentsActivity.Post_ID));
                    json.put("commentText", ((TextView)((CreateCommentActivity) mContext).findViewById(R.id.editText)).getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST, getString(R.string.create_cooment_url), json, new Response.Listener<JSONObject>() {

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
        });
    }
}
