package np.edu.kathford.menuexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button subjectButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        subjectButton = findViewById(R.id.subjectButton);

        registerForContextMenu(textView);
        subjectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               PopupMenu popupMenu =new PopupMenu(MainActivity.this,
                       subjectButton);
               MenuInflater menuInflater=popupMenu.getMenuInflater();
               menuInflater.inflate(R.menu.popup_menu,
                       popupMenu.getMenu());
               popupMenu.show();


               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       //do it by yourself
//                       if(item.getItemId()== R.id.javaItem){
//
//                       }
                       return false;
                   }
               });

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater layoutInflater = getMenuInflater();
        layoutInflater.inflate(R.menu.option_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.notificationMenu) {
            //action
            Toast.makeText(this, "Notification menu clicked",
                    Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.settingMenu) {
            //action
            Toast.makeText(this, "Setting Menu clicked",
                    Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.logoutMenu) {
            //action
            Toast.makeText(this, "Logout Menu clicked",
                    Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.selectAllMenu){
            Toast.makeText(this,"Select All Menu Clicked",
                    Toast.LENGTH_LONG).show();;
        }else if (item.getItemId() == R.id.copyMenu){
            Toast.makeText(this,"Copy Menu Clicked",
                    Toast.LENGTH_LONG).show();;
        }else if(item.getItemId() == R.id.cutMenu){
            Toast.makeText(this,"Cut Menu Clicked",
                    Toast.LENGTH_LONG).show();;
        }
        return super.onContextItemSelected(item);
    }
}
