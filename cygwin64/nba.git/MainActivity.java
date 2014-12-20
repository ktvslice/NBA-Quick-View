package com.example.kieran.nbaquickview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ListView teamStandings;
    private ArrayList<String> teamNames;
    private ArrayList<String> teamRecord;
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamStandings = (ListView) findViewById(R.id.teamStandings);
        teamNames = new ArrayList<String>();
        teamNames.add("EAST");
        teamNames.add("WEST");

        adapter = new CustomAdapter(this, R.layout.team_list_item, teamNames);
        teamStandings.setAdapter(adapter);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends ArrayAdapter<String> {
        Context context;
        int resourceId;
        ArrayList<String> teamName;
        ArrayList<String> teamRecord;

        public CustomAdapter(Context context, int resourceId, ArrayList<String> teamName){
            super(context, resourceId, teamName);
            this.context = context;
            this.resourceId = resourceId;
            this.teamName = teamName;
            //this.teamRecord = teamRecord;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            View v = convertView;
            if(v == null){
                LayoutInflater vi = getLayoutInflater();
                v = vi.inflate(resourceId, null);
            }

            String str = teamName.get(position);
            //String str2 = teamRecord.get(position);

            TextView teamName = (TextView) v.findViewById(R.id.teamName);
            //TextView teamRecord = (TextView) v.findViewById(R.id.teamRecord);

            teamName.setText(str);
            //teamRecord.setText(str2);


            return v;
        }
    }
}
