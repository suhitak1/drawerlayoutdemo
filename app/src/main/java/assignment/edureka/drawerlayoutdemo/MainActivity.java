package assignment.edureka.drawerlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    List<ContentMain> contentMainList;
    List<RecyclerContent> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateContent();
        populateMoviesData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        // automatically handle clicks on the Home/Up button, so long
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
        reset();
        if (id == R.id.nav_listview) {
            ListView listView = (ListView) findViewById(R.id.contentListView);
            listView.setVisibility(View.VISIBLE);
            ContentAdapter contentAdapter = new ContentAdapter(this, R.layout.image_items,
                    contentMainList);
            listView.setAdapter(contentAdapter);
        } else if (id == R.id.nav_gridview) {
            GridView gridView = (GridView) findViewById(R.id.contentGridView);
            gridView.setVisibility(View.VISIBLE);
            GridContentAdapter gridContentAdapter = new GridContentAdapter(this, contentMainList);
            gridView.setAdapter(gridContentAdapter);
        } else if (id == R.id.nav_recyclerview) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.contentRecyclerView);
            recyclerView.setVisibility(View.VISIBLE);
            RecyclerAdapter recyclerAdapter = new RecyclerAdapter(moviesList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                    getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(recyclerAdapter);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * This method sets all the views' visibility to INVISIBLE; hence the main content will be
     * clean on item selection and appropriate view will be visible
     */
    private void reset(){
        ((ListView) findViewById(R.id.contentListView)).setVisibility(View.INVISIBLE);
        ((GridView) findViewById(R.id.contentGridView)).setVisibility(View.INVISIBLE);
        ((RecyclerView) findViewById(R.id.contentRecyclerView)).setVisibility(View.INVISIBLE);
    }

    /**
     * Populates data for RecyclerView
     */
    private void populateMoviesData()
    {
        moviesList = new ArrayList();
        moviesList.add(new RecyclerContent("Mad Max: Fury Road", "Action & Adventure", "2015"));
        moviesList.add(new RecyclerContent("Inside Out", "Animation, Kids & Family", "2015"));
        moviesList.add(new RecyclerContent("Star Wars: Episode VII - The Force Awakens", "Action", "2015"));
        moviesList.add(new RecyclerContent("Shaun the Sheep", "Animation", "2015"));
        moviesList.add(new RecyclerContent("The Martian", "Science Fiction & Fantasy", "2015"));
        moviesList.add(new RecyclerContent("Mission: Impossible Rogue Nation", "Action", "2015"));
        moviesList.add(new RecyclerContent("Up", "Animation", "2009"));
        moviesList.add(new RecyclerContent("Star Trek", "Science Fiction", "2009"));

    }

    /**
     * Populates data for ListView & GridView
     */
    private void populateContent(){
        contentMainList = new ArrayList();

        contentMainList.add(new ContentMain(R.drawable.img1));
        contentMainList.add(new ContentMain(R.drawable.img2));
        contentMainList.add(new ContentMain(R.drawable.img3));
        contentMainList.add(new ContentMain(R.drawable.img4));
        contentMainList.add(new ContentMain(R.drawable.img5));
        contentMainList.add(new ContentMain(R.drawable.img6));
        contentMainList.add(new ContentMain(R.drawable.img7));
        contentMainList.add(new ContentMain(R.drawable.img8));
    }
}
