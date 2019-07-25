package com.beskilled.profileupdatefirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.beskilled.profileupdatefirebase.databinding.ActivityProfileViewBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProfileViewActivity extends AppCompatActivity {
    private ActivityProfileViewBinding profileViewBinding;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile_view);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        getProfileinfo();
    }

    private void getProfileinfo() {
        DatabaseReference userRef = databaseReference.child("user").child("1");
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    profileViewBinding.nameTv.setText(user.getName());
                    profileViewBinding.emailTv.setText(user.getEmail());
                    Picasso.get().load(user.getImage())
                            .placeholder(R.drawable.ic_image_black_24dp)
                            .into(profileViewBinding.imageCIV);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
