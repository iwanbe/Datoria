package ch.bbcag.datoria.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import ch.bbcag.datoria.Debt;
import ch.bbcag.datoria.R;

/**
 * Created by bbetti on 02.05.2017.
 */

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_histroy, container, false);
        // Register events, etc.


        ListView list = (ListView)view.findViewById(R.id.listview_history);

        ArrayList<Debt> debts = new ArrayList<Debt>();

        debts.add(new Debt("Martin Hodler", 2500));
        debts.add(new Debt("Martin Hodler", 3500));
        debts.add(new Debt("Martin Hodler", 6500));
        debts.add(new Debt("Martin Hodler", 500));

        Debt[] data = (Debt[]) debts.toArray(new Debt[0]);

        DebtAdapter adapter = new DebtAdapter(getContext(), R.layout.item_debt, data);
        list.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
}
