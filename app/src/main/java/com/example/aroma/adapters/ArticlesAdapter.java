package com.example.aroma.adapters;

import android.content.Context;
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
import java.util.List;
import java.util.Locale;

public class ArticlesAdapter extends   RecyclerView.Adapter<ArticlesAdapter.ViewHolder> implements Filterable {
    ArrayList<Article> articleList;
    ArrayList<Article> filteredItemList;
    Context context;
   //CategoryViewInterface viewInterface;
    OnArticleClicked listener;
    boolean isHindi;

  public   interface  OnArticleClicked{
void onArticleClicked(Article article);
    }


    public ArticlesAdapter(List<Article> categoryList, Context context, OnArticleClicked listener,boolean isHindi) {
        this.articleList =(ArrayList<Article>) categoryList;
        this.context=context;
        this.listener=listener;
        this.filteredItemList=articleList;
        this.isHindi=isHindi;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_article, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       Article article=filteredItemList.get(position);
       if(isHindi)
       {
           holder.title.setText(article.getHindiName());
       }else {
           holder.title.setText(article.getName());
       }
     Picasso.get().load(article.getImageUrl()).into(holder.thumbnail);
       holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // viewInterface.oNoteClick(noteList.get(position));
               // listener.onCategoryClicked(categor.name);
            }
        });


    }

    @Override
    public int getItemCount() {
        return filteredItemList.size();
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
              String  searchQuery = charSequence.toString();
                if (searchQuery.isEmpty() ) {
                    filteredItemList = articleList;
                } else {
                    ArrayList<Article> filteredList = new ArrayList<>();

                      for(Article article:articleList)
                      {
                       if(article.hindiName.toLowerCase(Locale.getDefault()).contains(searchQuery.toLowerCase(Locale.getDefault())) && isHindi)
                       {
                           filteredList.add(article);
                       }
                          if(article.getName().toLowerCase(Locale.getDefault()).contains(searchQuery.toLowerCase(Locale.getDefault())))
                          {
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
                filteredItemList = (ArrayList<Article>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView desc;
        View root;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root=itemView.findViewById(R.id.art_root);
            this.thumbnail=itemView.findViewById(R.id.art_img);
            this.title=itemView.findViewById(R.id.tv_art_title);
          //  this.desc=itemView.findViewById(R.id.notetitle);

        }
    }

}
