package com.press.bee.beepress.fragment;

import android.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.press.bee.beepress.R;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment (R.layout.notification_item)
public class Notification extends Fragment {

    @ViewById (R.id.publication_publisher_name)
    protected TextView publisherName;

    @ViewById (R.id.publication_publisher_image)
    protected ImageView publisherImage;

    @ViewById (R.id.publication_title)
    protected TextView publicationTitle;

    @ViewById (R.id.publication_time)
    protected TextView publicationTime;

    @ViewById (R.id.publication_icon)
    protected ImageView publicationIcon;

    @Background
    public void fetch () {
        publisherName.setText("Fake Name");
        publicationTitle.setText ("Fake title");
        publicationTime.setText("22:30");
        publisherImage.setImageDrawable(getResources().getDrawable(R.drawable.sample_publication_profile));
        publicationIcon.setImageDrawable(getResources().getDrawable(R.drawable.notification_icon_faces));
    }

    @Override
    public void onResume() {
        super.onResume();
        this.fetch();
    }

}
