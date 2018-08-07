package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Button btnUpdate;
    Spinner spn2;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1=findViewById(R.id.spinner1);
        btnUpdate=findViewById(R.id.buttonUpdate);
        spn2=findViewById(R.id.spinner2);


        alNumbers=new ArrayList<>();
        //alNumbers.add("2");
       // alNumbers.add("4");
       // alNumbers.add("6");

        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        alNumbers.addAll(Arrays.asList(strNumbers));


        aaNumbers=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn2.setAdapter(aaNumbers);



        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int pos=spn1.getSelectedItemPosition();
                alNumbers.clear();

                if(pos==0){
                    String[]strNumbers=getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));

                }
                else{
                    String[]strNumbers=getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));

                }
                aaNumbers.notifyDataSetChanged();
            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] strNumbers;
                int pos=spn1.getSelectedItemPosition();
                alNumbers.clear();

                switch(i){
                    case 0:
                        strNumbers=getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(0);

                    case 1:
                        strNumbers=getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setSelection(0);
                }
                aaNumbers.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
