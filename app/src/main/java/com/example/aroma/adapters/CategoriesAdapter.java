package com.example.aroma.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aroma.R;
import com.example.aroma.models.Article;
import com.example.aroma.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class CategoriesAdapter extends   RecyclerView.Adapter<CategoriesAdapter.ViewHolder>  implements Filterable {
    ArrayList<Category> categoryList;
    Context context;
    ArrayList<Category> filteredItemList;
   //CategoryViewInterface viewInterface;
    OnCategoryClicked listener;
    boolean isHindi=false;

  public   interface  OnCategoryClicked{
        void onCategoryClicked(String cat,String hindiName);
    }


    public CategoriesAdapter(ArrayList<Category> categoryList,Context context,OnCategoryClicked listener,boolean isHindi) {
        this.categoryList =categoryList;
        this.filteredItemList=categoryList;
        this.context=context;
        this.listener=listener;
        this.isHindi=isHindi;


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
        Category categor=filteredItemList.get(position);
        if(isHindi) {
            holder.title.setText(filteredItemList.get(position).hindiName);
        }else {
            holder.title.setText(filteredItemList.get(position).name);
        }
       Picasso.get().load(this.filteredItemList.get(position).getImageUrl()).into(holder.thumbnail);

       holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // viewInterface.oNoteClick(noteList.get(position));
                listener.onCategoryClicked(categor.name,categor.hindiName);
            }
        });


    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String  searchQuery = charSequence.toString();
                if (searchQuery.isEmpty() ) {
                    filteredItemList = categoryList;
                } else {
                    ArrayList<Category> filteredList = new ArrayList<>();
               //     Log.d("COMPARIOSN",searchQuery);
                    for(Category article:categoryList)
                    {
                        if(article.hindiName.toLowerCase(Locale.getDefault()).contains(searchQuery.toLowerCase(Locale.getDefault())) && isHindi)
                        {
                            Log.d("COMPARIOSN","MATCH:-> "+article.hindiName);
                            filteredList.add(article);
                        }
                        if(article.getName().toLowerCase(Locale.getDefault()).contains(searchQuery.toLowerCase(Locale.getDefault())))
                        {
                          //  Log.d("COMPARIOSN","MATCH:-> "+article.getName());
                            filteredList.add(article);
                        }
                    }

                    filteredItemList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredItemList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredItemList = (ArrayList<Category>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return filteredItemList.size();
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
