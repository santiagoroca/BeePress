package com.press.bee.beepress.base;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.press.bee.beepress.R;
import com.press.bee.beepress.activity.NotificationsActivity_;
import com.press.bee.beepress.config.RestInstance;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.rest.Rest;

import java.util.ArrayList;

@EActivity
public class BaseActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ListView drawerList;

    protected View cView;

    protected int layout;

    protected RestInstance RInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cView = getLayoutInflater().inflate(layout, null);
        cView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        ((LinearLayout)findViewById(R.id.content_frame)).addView(cView);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        drawerList.addHeaderView(getLayoutInflater().inflate(R.layout.drawer_head, null));

        ArrayList<DrawerItem> items = new ArrayList<>();
        items.add(new DrawerItem("Perfil",R.drawable.drawer_item_icon));
        items.add(new DrawerItem("Publicar",R.drawable.drawer_item_icon));
        items.add(new DrawerItem("GPS",R.drawable.drawer_item_icon));
        items.add(new DrawerItem("Definir cobertura",R.drawable.drawer_item_icon));
        items.add(new DrawerItem("Configuracion de cuenta", R.drawable.drawer_item_icon));

        drawerList.setAdapter(new DrawerListAdapter(this, items));

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        RInstance =  new RestInstance ();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetch();
    }

    @Click (R.id.tool_bar_notification_icon)
    public void onNotificationView () {
        startActivity(new Intent(this, NotificationsActivity_.class));
    }

    @Background
    protected void fetch () {}

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}
