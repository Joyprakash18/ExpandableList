package com.example.joyprakash.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.joyprakash.expandablelist.adapter.FilterListAdapter;
import com.example.joyprakash.expandablelist.response.FilterListModel;
import com.example.joyprakash.expandablelist.response.FilterResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<FilterListModel> filterGroupLists = new ArrayList<>();
    private FilterListAdapter expandableListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_list_view);
        getFilterListData();
    }

    private void getFilterListData() {
        Service service = APIClient.getClient().create(Service.class);
        service.getFilterList().enqueue(new Callback<FilterResponse>() {
            @Override
            public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {
                if (response.isSuccessful()){
                    if (response.body().getResult().equals("success")){
                        filterGroupLists = response.body().getInvestmentOpportunitiesFilterData();
                        expandableListAdapter = new FilterListAdapter(MainActivity.this,filterGroupLists);
                        expandableListView.setAdapter(expandableListAdapter);
                    }

                }else {
                    Toast.makeText(MainActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FilterResponse> call, Throwable t) {

            }
        });
    }
}
