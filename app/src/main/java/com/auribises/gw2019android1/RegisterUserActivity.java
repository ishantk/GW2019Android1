package com.auribises.gw2019android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.auribises.gw2019android1.viewcontroller.AddCustomerActivity;
import com.auribises.gw2019android1.viewcontroller.TechCrunchNewsActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterUserActivity extends AppCompatActivity {

    EditText eTxtName, eTxtEmail, eTxtPassword;
    Button btnRegister;
    TextView txtLogin;

    User user;

    ProgressDialog progressDialog;

    void initViews(){

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

        eTxtName = findViewById(R.id.editTextName);
        eTxtEmail = findViewById(R.id.editTextEmail);
        eTxtPassword = findViewById(R.id.editTextPassword);
        btnRegister = findViewById(R.id.buttonRegister);
        txtLogin = findViewById(R.id.textViewRegistered);

        user = new User();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user.name = eTxtName.getText().toString();
                user.email = eTxtEmail.getText().toString();
                user.password = eTxtPassword.getText().toString();

                Toast.makeText(RegisterUserActivity.this, user.toString(), Toast.LENGTH_SHORT).show();

                progressDialog.show();
                registerUserInFirebase();

                //loginUserFromFirebase();
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        initViews();
    }

    // registerUserInFirebase -> kuch bhi name ho sakta hai :)
    void registerUserInFirebase(){

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){


                            //Intent intent = new Intent(RegisterUserActivity.this, TechCrunchNewsActivity.class);
                            //startActivity(intent);
                            //finish();

                            saveUserInFirebase();

                        }else{
                            Toast.makeText(RegisterUserActivity.this, "Something Went Wrong !!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    void saveUserInFirebase(){

        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = firebaseUser.getUid(); // This is uid of User which we have just created

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(uid).set(user)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()){
                            progressDialog.dismiss();
                            Intent intent = new Intent(RegisterUserActivity.this, AddCustomerActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(RegisterUserActivity.this, "Something Went Wrong !!", Toast.LENGTH_LONG).show();
                        }
                    }
                });


    }

    void loginUserFromFirebase(){

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.signInWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            Intent intent = new Intent(RegisterUserActivity.this, TechCrunchNewsActivity.class);
                            startActivity(intent);
                            finish();
                            progressDialog.dismiss();
                        }else{
                            progressDialog.dismiss();
                            Toast.makeText(RegisterUserActivity.this, "Something Went Wrong !!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }
}
