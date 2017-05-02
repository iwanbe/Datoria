package ch.bbcag.datoira;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

/**
 * Created by bbetti on 02.05.2017.
 */

public class DashboardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        // Register events, etc.


        ListView list = (ListView)view.findViewById(R.id.listview_dashboard);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1);

        adapter.add("Dashboard");
        adapter.add("Dashboard 2");
        adapter.add("Dashboard 3");
        adapter.add("Dashboard 4");
        adapter.add("Dashboard 5");
        adapter.add("Dashboard 6");
        adapter.add("Dashboard 7");

        list.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
