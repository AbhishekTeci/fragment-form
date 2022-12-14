package com.example.petukji;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.FirebaseDatabase;
import java.lang.Throwable;
public class MainActivity2 extends AppCompatActivity {

    private Button next;
    private TextInputLayout mobile_num,E_mail,ven_Name,pan_Name,adhar_Number;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();

            next = findViewById(R.id.btnNext);


            mobile_num = findViewById(R.id.mdMobNumb);
            E_mail = findViewById(R.id.mdEmail);
            ven_Name = findViewById(R.id.mdVendorName);
            pan_Name = findViewById(R.id.mdPanNumber);
            adhar_Number = findViewById(R.id.mdAdharNumber);


            String mobNum = mobile_num.getEditText().toString();
            String mail = E_mail.getEditText().getText().toString();
            String vendor = ven_Name.getEditText().getText().toString();
            String pan = pan_Name.getEditText().getText().toString();
            String adhar = adhar_Number.getEditText().getText().toString();

            FirebaseDatabase.getInstance().getReference().child("Mobile Number").push().setValue(mobNum);
            FirebaseDatabase.getInstance().getReference().child("E-Mail").push().setValue(mail);
            FirebaseDatabase.getInstance().getReference().child("Vendor Name").push().setValue(vendor);
            FirebaseDatabase.getInstance().getReference().child("Pan Number").push().setValue(pan);
            FirebaseDatabase.getInstance().getReference().child("Adhar Number").push().setValue(adhar);


            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    fragmentManager.beginTransaction()
                            .replace(R.id.frgPresonalInfo1, Financial_Detail.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("name")
                            .commit();
                }
            });






        }
        catch (Exception exception)
        {

        }


    }


    
}