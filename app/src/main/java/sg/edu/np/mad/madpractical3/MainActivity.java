package sg.edu.np.mad.madpractical3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Initialize a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);
        //Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);
        //Set the TextViews with the User's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        // Set OnClickListener for the button
        btnFollow.setOnClickListener(view -> {
            // Toggle the followed status
            user.toggleFollowStatus();

            // Update the button text accordingly
            btnFollow.setText(user.isFollowed() ? "Unfollow" : "Follow");

            // Show a Toast message indicating the action
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();Toast.makeText(MainActivity.this, user.isFollowed() ? "Followed" : "Unfollowed", Toast.LENGTH_SHORT).show();
        });
    }
}