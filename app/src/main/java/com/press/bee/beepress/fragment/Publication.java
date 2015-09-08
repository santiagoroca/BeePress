package com.press.bee.beepress.fragment;

import android.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.press.bee.beepress.Class.Post;
import com.press.bee.beepress.R;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment (R.layout.notification_item)
public class Publication extends Fragment {

    private int id;

    @ViewById (R.id.publication_image)
    protected ImageView publicationImage;

    @ViewById (R.id.publication_publisher_name)
    protected TextView publisherName;

    @ViewById (R.id.publication_publisher_image)
    protected ImageView publisherImage;

    public Publication (Post post) {
        publisherName.setText(post.getUser_name());

        publicationImage.setImageDrawable(getResources().getDrawable(R.drawable.sample_publication));
        publisherImage.setImageDrawable(getResources().getDrawable(R.drawable.sample_publication_profile));
    }

}
