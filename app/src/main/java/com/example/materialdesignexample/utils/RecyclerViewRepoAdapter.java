package com.example.materialdesignexample.utils;

import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.models.Repo;
import com.example.materialdesignexample.models.Repos;

import java.util.List;

/**
 * Created by Amaury Esparza on 08/02/2015.
 */
public class RecyclerViewRepoAdapter extends RecyclerView.Adapter<RecyclerViewRepoAdapter.ListItemViewHolder> {

    //Holder reference to the design components
    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView label;
        TextView description;
        public ListItemViewHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.tview_name_repo);
            description = (TextView) itemView.findViewById(R.id.tview_description_repo);
        }
    }

    private List<Repos> reposList;
    public RecyclerViewRepoAdapter(List<Repos> repoList){
        if (repoList != null){
            this.reposList = repoList;
        }
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_repo, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        Repos repo = reposList.get(position);
        holder.label.setText(repo.getName());
        if(repo.getDescription().equals("")){
            holder.description.setText("No repo description available");
        }else{
            holder.description.setText(repo.getDescription());
        }


    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }
}
