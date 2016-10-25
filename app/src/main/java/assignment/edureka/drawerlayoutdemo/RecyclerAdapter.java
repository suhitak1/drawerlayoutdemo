package assignment.edureka.drawerlayoutdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by suhit_000 on 7/21/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieHolder> {

    private List<RecyclerContent> movieList;

    public class MovieHolder extends RecyclerView.ViewHolder {

        public TextView textTitle, textGenre, textYear;

        public MovieHolder(View view) {
            super(view);

            textTitle = (TextView) view.findViewById(R.id.recyclerTextTitle);
            textGenre = (TextView) view.findViewById(R.id.recyclerTextGenre);
            textYear = (TextView) view.findViewById(R.id.recyclerTextYear);
        }
    }

    public RecyclerAdapter(List<RecyclerContent> movieList){
        this.movieList = movieList;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items,
                parent, false);
        return new MovieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        RecyclerContent movie = movieList.get(position);
        holder.textTitle.setText(movie.getTitle());
        holder.textGenre.setText(movie.getGenre());
        holder.textYear.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
