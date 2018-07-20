package com.iam_sid.festivalerp.activity;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.iam_sid.festivalerp.R;
import com.iam_sid.festivalerp.adapter.MyRecyclerViewAdapter;
import com.iam_sid.festivalerp.model.Title;
import com.iam_sid.festivalerp.utils.TitleCollector;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<TitleCollector> content = new ArrayList<TitleCollector>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getRecycler();
    }

    public void getRecycler ()
    {
        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setHasFixedSize(true);

        content=new ArrayList<>();

        content.add(new TitleCollector(this,"History", R.drawable.icons8_happy_100));
        content.add(new TitleCollector(this,"Expenditure", R.drawable.icons8_rupee_100));
        content.add(new TitleCollector(this,"Notice", R.drawable.icons8_notifications_100));
        content.add(new TitleCollector(this,"Photos", R.drawable.icons8_images_100));
        content.add(new TitleCollector(this,"Videos", R.drawable.icons8_video_100));
        content.add(new TitleCollector(this,"Feedback", R.drawable.icons8_heart_100));

        MyRecyclerViewAdapter adapter= new MyRecyclerViewAdapter(content,this);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            exitApp();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
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

        switch(id){

            case R.id.nav_dashboard:
                break;
            case R.id.nav_youtube:
                openYoutube();
                break;
            case R.id.nav_rateus:
                rateApp();
                break;
            case R.id.nav_feedback:
                Intent feedbackIntent=new Intent(Dashboard.this,Feedback.class);
                startActivity(feedbackIntent);
                break;
            case R.id.nav_share:
                share();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void exitApp(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.app_logo);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage("Do You Want To Exit App");
        builder.setCancelable(false);

        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create();
        builder.show();
    }

    private void openYoutube(){
        String videoId="5Jhdg0d0vCY";
        Intent appIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"+videoId));
        appIntent.putExtra("VIDEO_ID",videoId);
        startActivity(appIntent);
      /*
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=5Jhdg0d0vCY"));
        try{
            startActivity(appIntent);
        }catch (ActivityNotFoundException e){
            startActivity(browserIntent);
        }*/
    }

    private void rateApp(){

    }

    private void share(){
        try{
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
            String sAux = getString(R.string.share_content);
      //      sAux = sAux + "app play store chi link or drive containing apk link"+getPackageName()+"\n\n";
            intent.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(intent,"Choose one"));
        }catch(Exception e){
           // e.toString();
        }
    }

    @Override
    public void onItemClick(View view, int position) {
        int id= (int) adapter.getItemId(position);
        switch (id){
            case 0:
                Intent historyIntent=new Intent(Dashboard.this,History.class);
                startActivity(historyIntent);
                break;
            case 1:
                Toast.makeText(this,"Selected on"+adapter.getItemId(position),Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this,"Selected on"+adapter.getItemId(position),Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this,"Selected on"+adapter.getItemId(position),Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(this,"Selected on"+adapter.getItemId(position),Toast.LENGTH_LONG).show();
                break;
            case 5:
                Intent feedbackIntent=new Intent(Dashboard.this,Feedback.class);
                startActivity(feedbackIntent);
                break;
        }
    }
}
