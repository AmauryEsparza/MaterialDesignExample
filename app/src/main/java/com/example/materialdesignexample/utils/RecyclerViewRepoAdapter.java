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

    //Holder class for reference the view components
    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView label;
        TextView description;
        public ListItemViewHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.info_text);
            //description = (TextView) itemView.findViewById(R.id.tview_description_repo);
        }
    }

    private List<Repos> reposList;
    public RecyclerViewRepoAdapter(List<Repos> repoList){
        if (repoList != null){
            this.reposList = repoList;
        }
    }

    //Invoked by the LayoutManager
    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the corresponding layout
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_repositories, parent, false);
        //Here modify the view like margins, paddings, view size and layout parameters
        //return the ViewHolder
        return new ListItemViewHolder(itemView);
    }

    //Invoked by the LayoutManager
    @Override
    public void onBindViewHolder(ListItemViewHolder holder, int position) {
        //Get element from your data set at this position
        Repos repo = reposList.get(position);
        //Replace the contents of the view with that element
        holder.label.setText(repo.getName());
        /*if(repo.getDescription().equals("")){
            holder.description.setText("No repo description available");
        }else{
            holder.description.setText(repo.getDescription());
        }*/
    }

    //Invoked by the LayoutManager
    @Override
    public int getItemCount() {
        return reposList.size();
    }
}
