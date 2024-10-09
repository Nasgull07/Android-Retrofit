package com.example.github;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private Button searchButton;
    private TextView userInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        searchButton = findViewById(R.id.searchButton);
        userInfoTextView = findViewById(R.id.userInfoTextView);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                if (!username.isEmpty()) {
                    fetchUserData(username);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingresa un nombre de usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchUserData(String username) {
        GitHub_Service service = GitHub_Client.getGitHubService();
        Call<GitHub_User> call = service.getUser(username);

        call.enqueue(new Callback<GitHub_User>() {
            @Override
            public void onResponse(Call<GitHub_User> call, Response<GitHub_User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    GitHub_User user = response.body();
                    String userInfo = "Login: " + user.getLogin() +
                            "\nNombre: " + user.getName() +
                            "\nRepositorios públicos: " + user.getPublic_repos() +
                            "\nSeguidores: " + user.getFollowers();
                    userInfoTextView.setText(userInfo);
                } else {
                    userInfoTextView.setText("Usuario no encontrado.");
                }
            }

            @Override
            public void onFailure(Call<GitHub_User> call, Throwable t) {
                userInfoTextView.setText("Error al realizar la consulta: " + t.getMessage());
            }
        });
    }
}
