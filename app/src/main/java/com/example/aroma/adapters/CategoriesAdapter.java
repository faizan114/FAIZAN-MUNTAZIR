package com.example.aroma.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aroma.R;
import com.example.aroma.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoriesAdapter extends   RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    ArrayList<Category> categoryList;
    Context context;
   //CategoryViewInterface viewInterface;
    OnCategoryClicked listener;

  public   interface  OnCategoryClicked{
        void onCategoryClicked(String cat);
    }


    public CategoriesAdapter(ArrayList<Category> categoryList,Context context,OnCategoryClicked listener) {
        this.categoryList =categoryList;
        this.context=context;
        this.listener=listener;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Category categor=categoryList.get(position);
        holder.title.setText(categoryList.get(position).name);
       Picasso.get().load(this.categoryList.get(position).getImageUrl()).into(holder.thumbnail);
       holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // viewInterface.oNoteClick(noteList.get(position));
                listener.onCategoryClicked(categor.name);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView desc;
        View root;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root=itemView.findViewById(R.id.catRoot);
            this.thumbnail=itemView.findViewById(R.id.cat_img);
            this.title=itemView.findViewById(R.id.tv_cat_title);
          //  this.desc=itemView.findViewById(R.id.notetitle);

        }
    }

}
