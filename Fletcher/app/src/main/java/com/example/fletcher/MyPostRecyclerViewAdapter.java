package com.example.fletcher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Post}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyPostRecyclerViewAdapter extends RecyclerView.Adapter<MyPostRecyclerViewAdapter.ViewHolder> {

    public static final String POST = "com.example.fletcher.POST";

    private final List<Post> mValues;

    public MyPostRecyclerViewAdapter(List<Post> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mUsernameView.setText(mValues.get(position).username);
        holder.mContentView.setText(mValues.get(position).content);
        Picasso.with(holder.mContext).load(holder.mContext.getString(R.string.base_url) + holder.mItem.image).into(holder.mImageView);
        holder.mCommentsButton.setText(holder.mItem.comments.length + " Comment" + (holder.mItem.comments.length == 1 ? "" : "s"));
        holder.mCommentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.mContext, ViewCommentsActivity.class);
                intent.putExtra(POST, holder.mItem);
                holder.mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mUsernameView;
        public final TextView mContentView;
        public final ImageView mImageView;
        public final Button mCommentsButton;
        public final Context mContext;
        public Post mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mUsernameView = (TextView) view.findViewById(R.id.username);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = view.findViewById(R.id.imageView);
            mCommentsButton = view.findViewById(R.id.commentButton);
            mContext = view.getContext();
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
