package com.hlm.basic.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hlm.basic.file.FilePlay;
import com.hlm.basic.file.Index;
import com.hlm.basic.file.StoreGain;

import java.io.File;

public class MyActionBarActivity extends AppCompatActivity {

    private StoreGain sg = null;
    private CharSequence mTitle;

    /**
     * config the default action bar
     * the root view of action bar is LinearLayout{@link layout/deafult_action_bar_view.xml}
     */
    protected void setDefaultActionBar() {
        setCustomByView(R.layout.deafult_action_bar_view);
    }

    /**
     * config the default action bar {@link #setDefaultActionBar()}
     * and set the default action bar with yourself title {@link #setActionBarTitle(int,String)}
     *
     * @param title action bar title
     */
    protected void setDefaultActionBarWithTitle(String title) {
        setDefaultActionBar();
        setActionBarTitle(R.id.title,title);
    }

    /**
     * Config yourself action bar {@link ActionBar#setCustomView(View, ActionBar.LayoutParams)}
     *
     * @param res_id view root of action bar such as{@link android.widget.LinearLayout}
     */
    protected void setSelfActionBar(int res_id) {
        setCustomByView(res_id);
    }

    /**
     * Config yourself action bar {@link ActionBar#setCustomView(View, ActionBar.LayoutParams)}
     * and set your action bar with a View with title {@link #setActionBarTitle(int,String)}
     *
     * @param res_id view root of action bar such as{@link android.widget.LinearLayout}
     */
    protected void setSelfActionBarWithTitle(int res_id, int tv_id, String title) {
        setSelfActionBar(res_id);
        setActionBarTitle(tv_id, title);
    }

    /**
     * set the action bar having a View with title
     *
     * @param title the action bar title,if title = null,then title = {@link #getTitle()}
     */
    private void setActionBarTitle(int tv_id, String title) {
        if (findViewById(tv_id) != null) {
            if (title != null) {
                ((TextView) findViewById(tv_id)).setText(title);
                mTitle = title;
            } else {
                ((TextView) findViewById(tv_id)).setText(getStringTitle());
            }
        }
    }

    /**
     * set the action bar with a layout id
     *
     * @param res_id the layout id which as the action bar
     */
    private void setCustomByView(int res_id) {
        mTitle = getTitle();
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        View actionBarView = LayoutInflater.from(this).inflate(res_id, null);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && actionBarView != null) {
            actionBar.setCustomView(actionBarView, lp);
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        }
    }

    /**
     * set the default help content for default button{@link layout&deafult_action_bar_view.xmltion_bar_view.xml#help}
     *
     * @param help default content to show
     */
    protected void setDefaultHelp(String help) {
        String path = "help/" + getPackageName() + "/Default_Help.x";
        if (!(new File("sdcard/" + path)).exists()) {
            sg = new FilePlay().setGoal(Index.SD).setPath(path);
            sg.storeString(help);
        }
    }

    /**
     * set the listener for default help button,if used my default action bar
     * the help content is private for owner activity
     *
     * @param help private help content
     */
    protected void setHelpListener(String help) {
        String path;
        if (help != null && !help.equals("")) {
            setListener(help);
            path = "help/" + getPackageName() + "/" + getLocalClassName() + "_Help.x";
            if (!(new File("sdcard/" + path)).exists()) {
                sg = new FilePlay().setGoal(Index.SD).setPath(path);
                sg.storeString(help);
                setListener(help);
            }
        } else {
            path = "help/" + getPackageName() + "/Default_Help.x";
            if ((new File("sdcard/" + path)).exists()) {
                sg = new FilePlay().setGoal(Index.SD).setPath(path);
                setListener(sg.gainString());
            }
        }
    }

    private void setListener(final String help) {
        if (findViewById(R.id.help) != null)
            findViewById(R.id.help).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MyActionBarActivity.this, help, Toast.LENGTH_LONG).show();
                }
            });
    }

    /**
     * get the activity generate title to string
     *
     * @return mTitle
     */
    protected String getStringTitle(){
        return String.valueOf(mTitle);
    }

}
