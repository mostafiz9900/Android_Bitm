package com.beskilled.profileupdatefirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.beskilled.profileupdatefirebase.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;

    private DatabaseReference databaseReference;
    private StorageReference  storageReference;
    private static final int REF_FOR_IMAGE = 1;

    private String imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProfileViewActivity.class);
                startActivity(intent);
            }
        });
        init();
        mainBinding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mainBinding.nameEt.getText().toString().trim();
                String email = mainBinding.emailEt.getText().toString().trim();
                insertUser(name, email);
            }
        });
    }

    private void init() {

        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference= FirebaseStorage.getInstance().getReference();
    }

    private void insertUser(final String name, final String email) {
        DatabaseReference userRef = databaseReference.child("user").child("1");
        User user = new User(imageUri,name,email);
        userRef.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
                mainBinding.nameEt.setText("");
                mainBinding.emailEt.setText("");
                    /*if (name.equals("") || email.equals("")) {
                        Toast.makeText(getApplicationContext(), "Name as Email same", Toast.LENGTH_SHORT).show();

                    } else {
                        insertUser(name, email);
                    }*/
                }
            }
        });
        mainBinding.imageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                startActivityForResult(intent, REF_FOR_IMAGE);

                //startActivity(intent);

            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REF_FOR_IMAGE && requestCode==RESULT_OK){
            if (data!=null){
                Uri uri=data.getData();
                mainBinding.imageSelectCIV.setImageURI(uri);
                uploadImageToStorage(uri);
            }
        }
    }

    private void uploadImageToStorage(Uri uri) {
        final StorageReference uploadRef=storageReference.child(String.valueOf(System.currentTimeMillis()));
        uploadRef.putFile(uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()){
                    uploadRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            imageUri=uri.toString();
                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
