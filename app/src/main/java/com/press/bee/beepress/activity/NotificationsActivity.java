package com.press.bee.beepress.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.press.bee.beepress.R;

import com.press.bee.beepress.base.BaseActivity;
import com.press.bee.beepress.fragment.Notification;

import org.androidannotations.annotations.EActivity;

@EActivity
public class NotificationsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.layout = R.layout.activity_notifications;
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.publications_container, new Notification());
        fragmentTransaction.add(R.id.publications_container, new Notification());
        fragmentTransaction.add(R.id.publications_container, new Notification());

        fragmentTransaction.commit();
    }

}
