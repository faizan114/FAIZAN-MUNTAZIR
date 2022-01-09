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
import com.example.aroma.models.Article;
import com.example.aroma.models.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ArticlesAdapter extends   RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {
    ArrayList<Article> articleList;
    Context context;
   //CategoryViewInterface viewInterface;
    OnArticleClicked listener;

  public   interface  OnArticleClicked{
void onArticleClicked(Article article);
    }


    public ArticlesAdapter(List<Article> categoryList, Context context, OnArticleClicked listener) {
        this.articleList =(ArrayList<Article>) categoryList;
        this.context=context;
        this.listener=listener;


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
       Article article=articleList.get(position);
       holder.title.setText(article.getName());
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
        return articleList.size();
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
