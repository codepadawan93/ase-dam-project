package comcodepadawan93ase_dam_project.httpsgithub.ase_dam_project;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {

    ArrayList<DataModelSettings> dataModels;
    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        listView = (ListView)findViewById(R.id.settings_list);

        dataModels = new ArrayList<>();

        dataModels.add(new DataModelSettings("Sound Effects:", "Surround", "Can't change Sound Effects"));
        dataModels.add(new DataModelSettings("In-Game Music:", "ON", "Default mode"));
        dataModels.add(new DataModelSettings("Profile:", "Student", "This is your student profile"));
        dataModels.add(new DataModelSettings("Privacy:","Terms&Conditions","September 15, 2009"));

        adapter = new CustomAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModelSettings dataModel= dataModels.get(position);
            }
        });
    }

}

