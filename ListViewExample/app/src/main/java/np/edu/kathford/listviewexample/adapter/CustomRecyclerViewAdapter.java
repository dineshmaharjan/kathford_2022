package np.edu.kathford.listviewexample.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import np.edu.kathford.listviewexample.R;
import np.edu.kathford.listviewexample.model.MovieModel;

public class CustomRecyclerViewAdapter extends
        RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder>{

    private ArrayList<MovieModel> movieModels;

    private CustomOnItemClickLister onItemClickLister;

    public CustomRecyclerViewAdapter(ArrayList<MovieModel> movieModels,
                                     CustomOnItemClickLister onItemClickLister) {
        this.movieModels = movieModels;
        this.onItemClickLister = onItemClickLister;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent,false);
        return new CustomViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        MovieModel movieModel=movieModels.get(position);

        Picasso.get().load(movieModel.getPoster()).into(holder.posterImageView);
        holder.movieNameTextView.setText(movieModel.getName());
        holder.durationTextView.setText(movieModel.getDuration());
        holder.descriptionTextView.setText(movieModel.getDescription());

        holder.posterImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickLister.onMovieClick(movieModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieModels.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView posterImageView;
        private TextView movieNameTextView;
        private TextView durationTextView;
        private TextView descriptionTextView;


        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImageView=itemView.findViewById(R.id.posterImageView);
            movieNameTextView=itemView.findViewById(R.id.nameTextView);
            durationTextView=itemView.findViewById(R.id.durationTextView);
            descriptionTextView=itemView.findViewById(R.id.descriptionTextView);
        }
    }


    public interface CustomOnItemClickLister{

        void onMovieClick(MovieModel movieModel);

    }



}
