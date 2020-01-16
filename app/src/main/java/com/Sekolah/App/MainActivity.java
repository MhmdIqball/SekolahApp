package com.Sekolah.App;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Sekolah.App.ui.BeritaUI;
import com.Sekolah.App.api.Session;
//import com.Sekolah.App.helper.MoreApp;
//import com.Sekolah.App.helper.RateApp;
//import com.Sekolah.App.helper.ShareApp;
import com.Sekolah.App.ui.JadwalUI;
import com.Sekolah.App.ui.NilaiUI;
import com.Sekolah.App.ui.PresensiUI;
import com.Sekolah.App.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        MenuItem home = navigationView.getMenu().getItem(0);
        home.setChecked(true);
        onNavigationItemSelected(home);

        Session session = Session.init(this);
        View header = navigationView.getHeaderView(0);
        ImageView userFoto = header.findViewById(R.id.userFoto);
        TextView userNama = header.findViewById(R.id.userNama);
        userNama.setText(session.getString("nama"));
        TextView userProdi = header.findViewById(R.id.userProdi);
        userProdi.setText(session.getString("prodi"));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the BeritaUI/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class clz = null;
        if (id == R.id.nav_berita) {
            clz = BeritaUI.class;
        } else if (id == R.id.nav_jadwal) {
            clz = JadwalUI.class;
        } else if (id == R.id.nav_presensi) {
           clz = PresensiUI.class;

        } else if (id == R.id.nav_nilai) {
            clz = NilaiUI.class;

        } else if (id == R.id.nav_share) {
       //     ShareApp.share(this);
    //    } else if (id == R.id.nav_rate) {
     //       RateApp.rate(this);
    //    } else if (id == R.id.nav_more) {
     //       MoreApp.more(this);
        }
        if (clz != null) {
            try {
                fragment = (Fragment) clz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fm = getSupportFragmentManager();
            if (fragment != null) {
                fm.beginTransaction().replace(R.id.content_main, fragment).commit();
            } else {
                fm.beginTransaction().remove(fragment).commit();
            }
            toolbar.setSubtitle(item.getTitle());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
