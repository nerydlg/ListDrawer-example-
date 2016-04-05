package com.example.nerydlg.md_app2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by nerydlg on 15/03/16.
 */
public class ActionDrawerActivity extends AppCompatActivity {

    private ListView list;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        setAdapter();
        setClicks();
        setToggle();

    }

    private void setAdapter() {

        DrawerAdapter adapter = new DrawerAdapter(this);
        list.setAdapter(adapter);
    }

    private void setToggle(){
        mDrawerToggle = new ActionBarDrawerToggle(this,
                                                drawer,
                                                R.string.title_activity_settings,
                                                R.string.title_activity_help );
        drawer.setDrawerElevation(0.95f);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    private void initUI() {
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = (ListView)findViewById(R.id.left_drawer);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    }


    private void setClicks(){
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActionDrawerActivity.this, "Menu Item" + DrawerAdapter.menu[position], Toast.LENGTH_SHORT);

                drawer.closeDrawer(Gravity.LEFT);
                drawer.closeDrawers();
                String title = DrawerAdapter.menu[position];

                switch(position) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    default:
                        getSupportActionBar().setSubtitle(title);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }




}
