package com.airsen.button.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.airsen.button.R;
import com.airsen.button.firebase.Feedbackadapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedBackActivity extends Fragment {
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_feed_back,container,false);
        EditText edit_name = view.findViewById(R.id.name1);
        EditText edit_mail = view.findViewById(R.id.gmail1);
        EditText edit_phone = view.findViewById(R.id.phone1);
        EditText edit_address = view.findViewById(R.id.address1);
        EditText edit_yourfeedback = view.findViewById(R.id.feedback1);
        Button submit1 = view.findViewById(R.id.submit1);
        Feedbackadapter feedbackadapter = new Feedbackadapter();
        firebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = firebaseDatabase.getReference();
        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                yourfeedback yourfeedback1 = new yourfeedback(
//                        edit_name.getText().toString(),edit_phone.getText().toString(),edit_address.getText().toString(),
//                        edit_mail.getText().toString(),edit_yourfeedback.getText().toString()
//                );
//                feedbackadapter.add(yourfeedback1).addOnSuccessListener(suc->{
//                    Toast.makeText(getContext(),"abc",Toast.LENGTH_SHORT).show();
//
//                }).addOnFailureListener(er->{
//                    Toast.makeText(getContext(),"abcd",Toast.LENGTH_SHORT).show();
//                });
//

// ...

                mDatabase.child("ImforUrl").child("paper4").child("time").setValue("dsdfsd");

            }
        });

        return view;
    }
}
