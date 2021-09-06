package com.example.groupdisscussion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.groupdisscussion.Adapters.recycler_adapter_category;
import com.example.groupdisscussion.modalClass.Topic;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button bt_logout;
    FirebaseAuth mAuth;
    FirebaseFirestore fstore;
    RecyclerView recyclerView;
    ArrayList<Topic> topicArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindviews();
        initilize();

        if(mAuth.getCurrentUser()==null){
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));

        }
        else{
            fstore.collection("category").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                        topicArrayList.add(new Topic(documentSnapshot.getString("list_of_category")));

                    }
                    recycler_adapter_category adapter_category = new recycler_adapter_category(topicArrayList);
                    recyclerView.setAdapter(adapter_category);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            });
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
            }
        });


        }

    }

    private void bindviews() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
    }


    private void initilize() {
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
    }
}