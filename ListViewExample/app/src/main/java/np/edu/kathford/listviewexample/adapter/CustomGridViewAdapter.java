package np.edu.kathford.listviewexample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import np.edu.kathford.listviewexample.model.MovieModel;
import np.edu.kathford.listviewexample.R;

public class CustomGridViewAdapter extends ArrayAdapter<MovieModel> {
    private  Context context;
    private ArrayList<MovieModel> movieList;

    public CustomGridViewAdapter(Context context,
                                 ArrayList<MovieModel> movieList) {
        super(context, 0, movieList);
        this.context=context;
        this.movieList=movieList;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_movie,
                    parent,false);
            //find view by id
            ImageView posterImageView= convertView.findViewById(R.id.posterImageView);
            TextView movieNameTextView = convertView.findViewById(R.id.movieNameTextView);
            TextView durationTextView = convertView.findViewById(R.id.durationTextView);

            MovieModel movieModel=movieList.get(position);
            movieNameTextView.setText(movieModel.getName());
            durationTextView.setText(movieModel.getDuration());
            Picasso.get().load(movieModel.getPoster()).into(posterImageView);

        }

        return convertView;

    }
}
