package com.example.ap2_ex3.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;

import com.example.ap2_ex3.R;
import com.example.ap2_ex3.adapters.ChatsListAdapter;
import com.example.ap2_ex3.entities.User;
import com.example.ap2_ex3.view_models.ChatModel;
import com.example.ap2_ex3.entities.Chat;
import com.example.ap2_ex3.view_models.MessageModel;
import com.example.ap2_ex3.view_models.UserModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ChatsActivity extends AppCompatActivity {
    private static final int MENU_SETTINGS = R.id.menu_settings;
    private static final int LOGOUT = R.id.menu_logout;
    private ViewModel chatsViewModel;
    public static final int ADD_CONTACT_REQUEST = 1;
    private ChatModel chatModel;
    private String token;

    private MessageModel messageModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(ChatsActivity.this, AddChatActivity.class);
            startActivity(intent);
        });

        RecyclerView lstChats = findViewById(R.id.lstChats);
        final ChatsListAdapter adapter = new ChatsListAdapter(this);
        lstChats.setAdapter(adapter);
        lstChats.setLayoutManager(new LinearLayoutManager(this));
      
        chatModel = new ViewModelProvider(this).get(ChatModel.class);
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        token = sharedPref.getString("token", "null");
        chatModel.setToken(token);
        chatModel.getChats();
        chatModel.observeChats().observe(this, chats -> adapter.setChats(chats));}

        ImageButton settingsButton = findViewById(R.id.moreBtn);
        settingsButton.setOnClickListener(this::showPopupMenu);

    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.more_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == MENU_SETTINGS) {
                openSettings();
                return true;
            } else if (item.getItemId() == LOGOUT) {
                logout();
                return true;
            }
            return super.onOptionsItemSelected(item);
        });
        popupMenu.show();
    }

    private void openSettings() {
        Intent intent = new Intent(ChatsActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    private void logout() {
        finish();
    }

}