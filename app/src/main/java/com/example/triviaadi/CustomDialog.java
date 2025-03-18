package com.example.triviaadi;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button btnYes, btnNo;
    Context context;

    public CustomDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.custom_dialog);
        this.context = context;

        this.btnYes = findViewById(R.id.btnYes);
        this.btnNo = findViewById(R.id.btnNo);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(btnYes == view)
        {
            dismiss(); // eliminate the dialog  מוחק את חלונית הדאילוג
            ((GameActivity)context).reset(); //קורא לפעולה reaet מהגיים אקטיביטי ומעדכן את המשחק
        }

        if(btnNo == view)
        {
            ((GameActivity)context).finish();
        }
    }
}
