package com.example.gehad.news1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**Defining RecyclerView Adapter to News Class
 * Return Data type is "List"
 * */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<News> news;

    /** Tag for log messages */
    private static final String LOG_TAG = NewsAdapter.class.getName();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //Defining news_list_item.xml views
        public ImageView articleImage;
        private TextView articleTitle, articleAuthor, articleDate,
                articleSummary, articleSection;
        public ProgressBar progressBar;

        private MyViewHolder(View itemView) {
            super(itemView);

            //Finding news_list_item.xml views by their IDs
            articleImage = itemView.findViewById(R.id.newsImage);
            articleTitle = itemView.findViewById(R.id.newsTitle);
            articleAuthor = itemView.findViewById(R.id.newsAuthor);
            articleDate = itemView.findViewById(R.id.newsDate);
            articleSummary = itemView.findViewById(R.id.newsContent);
            articleSection = itemView.findViewById(R.id.newsSection);
            progressBar = itemView.findViewById(R.id.imageProgressBar);
        }
    }

    //Defining NewsAdapter Class Constructor
    public NewsAdapter(List<News> news){
        this.news = news;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        News article = news.get(position);

        /**Using Picasso Library for loading article image from the parsed image URL.
         * "load" takes image URL in String Format.
         * "placeholder" is what being showed while the image is loading, which is replaced
         * with Callback() method to use progress bar during loading the image from the server.
         * "error" is what being showed when the image failed to load, which is replaced with
         * onError() method.
         * */
            Picasso.get().load(article.getImageURL().toString())
                    .into(holder.articleImage, new Callback() {
                        @Override
                        public void onSuccess() {
                            holder.progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError(Exception e) {
                            Log.e(LOG_TAG, "Picasso loading error", e);
                            holder.progressBar.setVisibility(View.GONE);
                            holder.articleImage.setImageResource(R.drawable.broken_image);
                        }
                    });

        //Setting each Text to its TextView.
        holder.articleTitle.setText(article.getTitle());

        if(article.getAuthor() != null) {
            holder.articleAuthor.setVisibility(View.VISIBLE);
            holder.articleAuthor.setText(article.getAuthor());
        }else {
            holder.articleAuthor.setVisibility(View.GONE);
        }

        if(article.getDate() != null) {
            holder.articleDate.setVisibility(View.VISIBLE);
            holder.articleDate.setText(getDateString(article.getDate()));
        }else{
            holder.articleDate.setVisibility(View.GONE);
        }

        holder.articleSummary.setText(article.getContent());
        holder.articleSection.setText(article.getCategory());
    }

    /**
     * @param date is the given date to format
     * @return a string in specified format from given date
     */
    private String getDateString(Date date) {
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT,
                Locale.getDefault()).format(date);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }




}
