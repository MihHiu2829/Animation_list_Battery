package com.example.project_52;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.project_52.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
      private   ActivityMainBinding binding ;
    private  AnimationDrawable anim ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()) ;
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.lvlPlayerButton.setOnClickListener(this);
         anim = (AnimationDrawable) binding.icBaterryAnim.getDrawable() ;
      anim.start();
        binding.lvlPlayerButton.setImageLevel(1);
    }

    @Override
    public void onClick(View view) {
        binding.lvlPlayerButton.startAnimation(AnimationUtils.loadAnimation(this, androidx.appcompat.R.anim.abc_fade_in));
            if(view.getId() == R.id.lvl_player_button)
            {
                if(anim.isRunning())
                {
                    anim.stop();
                    binding.lvlPlayerButton.setImageLevel(0);
                }else {
                    anim.start();
                    binding.lvlPlayerButton.setImageLevel(1);
                }
            }
    }
}