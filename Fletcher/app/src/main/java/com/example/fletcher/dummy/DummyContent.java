package com.example.fletcher.dummy;

import com.example.fletcher.Comment;
import com.example.fletcher.Post;
import com.example.fletcher.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Post> ITEMS = new ArrayList<Post>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Post> ITEM_MAP = new HashMap<String, Post>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Post item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Post createDummyItem(int position) {
        Comment[] comments = new Comment[position];
        for (int i = 0; i < comments.length; i++)
        {
            comments[i] = new Comment(String.valueOf(position), "Comment " + position, "https://bfsharingapp.bluefletch.com/profilepic/generic-profile.jpg", "test1");
        }
        return new Post(String.valueOf(position), "Post " + position,"https://bfsharingapp.bluefletch.com/profilepic/generic-profile.jpg", "test1", comments);
    }
}
