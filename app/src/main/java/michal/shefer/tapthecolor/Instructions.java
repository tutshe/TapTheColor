package michal.shefer.tapthecolor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class Instructions extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView tvText,tvText1,tvText2,tvText3;
    ImageView ivMenu,ivHand;
    Intent intent;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_instructions);
        initialize();
        setSharedPreferences();
        getSharedPreferences();
        ivMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.app_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.iCover) {
                            //Back to intro activity
                            Intent intent = new Intent(Instructions.this, CoverPage.class);
                            startActivity(intent);
                            return true;
                        }
                        if (id == R.id.iLogin) {
                            //Back to intro activity
                            Intent intent = new Intent(Instructions.this, Login.class);
                            startActivity(intent);
                            return true;
                        }
                        if (id == R.id.iExit) {
                            finishAffinity(); // This will close all activities
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.iCover) {
            //Back to intro activity
            Intent intent = new Intent( Instructions.this , CoverPage.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.iLogin) {
            //Back to intro activity
            Intent intent = new Intent( Instructions.this , Login.class);
            startActivity(intent);
            return true;
        }
        if (id ==R.id.iExit){
            finishAffinity(); // This will close all activities
        }
        return super.onOptionsItemSelected(item);
    }
    // Set the shared preferences
    public void setSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("goal", this.getString(R.string.the_goal_of_the_game));
        editor.putString("text1", "The game displays the name of a color in random text colors.");
        editor.putString("text2", "The player has to tap the button that matches the color name, not the color of the text.");
        editor.putString("text3", "The game keeps track of the score and the time taken to respond.");
        // Commit the changes
        editor.apply();

    }
    // Get the shared preferences
    public SharedPreferences getSharedPreferences() {
        String txt = sharedPreferences.getString("goal", " Error Happened in getSharedPreferences");
        tvText.setText(txt);
        txt = sharedPreferences.getString("text1", " Error Happened in getSharedPreferences");
        tvText1.setText(txt);
        txt = sharedPreferences.getString("text2", " Error Happened in getSharedPreferences");
        tvText2.setText(txt);
        txt = sharedPreferences.getString("text3", " Error Happened in getSharedPreferences");
        tvText3.setText(txt);
        return sharedPreferences;
    }
    public void initialize(){
        tvText = findViewById(R.id.tvText);
        tvText1 = findViewById(R.id.tvText1);
        tvText2 = findViewById(R.id.tvText2);
        tvText3 = findViewById(R.id.tvText3);
        ivMenu = findViewById(R.id.ivMenu);
        ivHand= findViewById(R.id.ivHand);
        context = this;
        sharedPreferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
    }
}