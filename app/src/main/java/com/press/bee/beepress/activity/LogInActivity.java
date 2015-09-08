package com.press.bee.beepress.activity;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.press.bee.beepress.Class.Request;
import com.press.bee.beepress.Class.User;
import com.press.bee.beepress.R;
import com.press.bee.beepress.config.RestInstance;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

@EActivity
public class LogInActivity extends Activity {

    @ViewById (R.id.login_username)
    public EditText username;

    @ViewById (R.id.login_password)
    public EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    @Click(R.id.log_in_form_submit)
    void log_in () {
        if (isOnline ()) {
            RestInstance.rInterface.logIn(username.getText().toString(), password.getText().toString(), new Callback <Request> () {
                @Override
                public void success(Request request, Response response) {
                    if (request.getStatus ().equals("success")) {
                        User user = request.getParsed(User.class);
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Error al iniciar sesion, intente de nuevo.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });
        } else {
            Context context = getApplicationContext();
            CharSequence text = "No hay conexion a internet.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public boolean isOnline () {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

}

