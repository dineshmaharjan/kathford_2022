package np.edu.kathford.listviewexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    //data source
    private String[] datas = {"Ram", "Shyam", "Abhi",
            "Gita", "Sita", "Hari", "Hari Maya"};

    private ArrayList<MovieModel> movieList;
    private  CustomListViewAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        ///array adapter for simple listview
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, datas);
//        //setting adapter to the listview
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                String name = datas[position];
//
//                Toast.makeText(MainActivity.this,
//                        name,
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });

        //2. Custom Adapter with listview
        movieDataSource();
        adapter= new CustomListViewAdapter(this, movieList);
        listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                MovieModel movieModel = movieList.get(position);

                Toast.makeText(MainActivity.this,
                        movieModel.getName(),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void movieDataSource(){
        movieList = new ArrayList<>();
        MovieModel movieModel = new MovieModel(
                1,"DhuranDhar", "3h:00",
                "Dhurandhar is a star-studded saga inspired by " +
                        "incredible true events set in the gritty " +
                        "criminal vein of underworld with a backdrop of " +
                        "Indian patriotism, featuring action sequences, " +
                        "Shakespearean betrayals, and tradecrafts of " +
                        "espionage","https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1762252847591-dhurandharposter2.jpg"
        );
        movieList.add(movieModel);

        movieModel = new MovieModel(2, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1763034313454-fireandashposter.jpg");
        movieList.add(movieModel);

        movieModel = new MovieModel(3, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1765344976433-akhanda_2_500x715_pixels.jpg");
        movieList.add(movieModel);

        movieModel = new MovieModel(4, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1763034313454-fireandashposter.jpg");
        movieList.add(movieModel);

        movieModel = new MovieModel(
                5,"Sholay", "3h:00",
                "Dhurandhar is a star-studded saga inspired by " +
                        "incredible true events set in the gritty " +
                        "criminal vein of underworld with a backdrop of " +
                        "Indian patriotism, featuring action sequences, " +
                        "Shakespearean betrayals, and tradecrafts of " +
                        "espionage","https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1765714621202-sholayposter.jpg"
        );
        movieList.add(movieModel);

        movieModel = new MovieModel(
                6,"Paran", "3h:00",
                "Paran is a heartfelt family drama about Dharmanath (Neer Shah), who treasures his children as his “essence of life” and dreams of growing old in their love.","https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1760524175925-paranposter.jpg"
        );
        movieList.add(movieModel);


        movieModel = new MovieModel(7, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1763034313454-fireandashposter.jpg");
        movieList.add(movieModel);

        movieModel = new MovieModel(8, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1763034313454-fireandashposter.jpg");
        movieList.add(movieModel);


        movieModel = new MovieModel(9, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1763034313454-fireandashposter.jpg");
        movieList.add(movieModel);

        movieModel = new MovieModel(10, "Avatar: Fire and Ash",
                "3h:00", "Jake and Neytiri's family grapples with grief after Neteyam's death, encountering a new, aggressive",
                "https://d346azgjfhsciq.cloudfront.net/S3/uploads/gallery/1763034313454-fireandashposter.jpg");
        movieList.add(movieModel);

    }


}
