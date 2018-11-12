package com.example.fletcher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fletcher.dummy.DummyContent;
import com.squareup.picasso.Picasso;

public class ViewCommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);

        Intent intent = getIntent();
        Post post = (Post)intent.getSerializableExtra(MyPostRecyclerViewAdapter.POST);

        Picasso.with(this).load(post.image).into((ImageView)findViewById(R.id.linearLayout).findViewById(R.id.imageView3));
        ((TextView)findViewById(R.id.linearLayout).findViewById(R.id.usernameText)).setText(post.username);
        ((TextView)findViewById(R.id.linearLayout).findViewById(R.id.postText)).setText(post.content);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter (see also next example)
        recyclerView.setAdapter(new MyCommentRecyclerViewAdapter(post.comments));

        final Context mContext = this;

        findViewById(R.id.addComment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CreateCommentActivity.class);
                startActivity(intent);
            }
        });
    }
}
