package com.airsen.button.firebase;

import com.airsen.button.ui.yourfeedback;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedbackadapter {
    private DatabaseReference databaseReference;
    public Feedbackadapter(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(yourfeedback.class.getSimpleName());
    }
    public Task<Void> add (yourfeedback yourfeedback1){
        return databaseReference.push().setValue(yourfeedback1);
    }
}
