package ch.bbcag.datoria;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by bbetti on 02.05.2017.
 */

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_histroy, container, false);
        // Register events, etc.


        ListView list = (ListView)view.findViewById(R.id.listview_history);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1);

        adapter.add("Test 8");
        adapter.add("Test 2");
        adapter.add("Test 2");
        adapter.add("Test 2");
        adapter.add("Test 2");
        adapter.add("Test 2");
        adapter.add("Test 2");

        list.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
