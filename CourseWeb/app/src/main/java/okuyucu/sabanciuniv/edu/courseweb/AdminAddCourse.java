package okuyucu.sabanciuniv.edu.courseweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdminAddCourse extends AppCompatActivity {
    Database db ;
    Button addCourse ;

    EditText Ecrn, Eccode, Ecname, Einstructor;

    EditText Eroom1,Eday1, Etime1;

    EditText Eroom2,Eday2, Etime2;

    EditText Ecredit,EcReq, Efaculty, Ecapacity,Einfo;
    SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
    public static String globalPreferenceName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_course);
        db = new Database(this);
        db.open();
        ArrayList<String> timestart = new ArrayList<String>(){
            {
                add("");
                add("08:40");
                add("09:40");
                add("10:40");
                add("12:40");
                add("13:40");
                add("14:40");
                add("15:40");
                add("16:40");
                add("17:40");
                add("18:40");
            }
        };
        ArrayList<String> timeend = new ArrayList<String>(){
            {   add("");
                add("09:30");
                add("10:30");
                add("12:30");
                add("13:30");
                add("14:30");
                add("15:30");
                add("16:30");
                add("17:30");
                add("18:30");
                add("19:30");
            }
        };
        ArrayList<String> days = new ArrayList<String>(){
            {
                add("");
                add("M");
                add("T");
                add("W");
                add("R");
                add("F");
            }
        };

        final String[] time1start = new String[1];
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timestart);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner cItems = (Spinner) findViewById(R.id.Time1StartSelectSpinner);
        cItems.setAdapter(adapter);
        cItems.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                time1start[0] =selectedItem;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                time1start[0]="";

            }
        });

        final String[] time1end = new String[1];
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeend);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner c1Items = (Spinner) findViewById(R.id.Time1EndSelectSpinner);
        c1Items.setAdapter(adapter1);
        c1Items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                time1end[0] =selectedItem;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                time1end[0]="";
            }
        });

        final String[] time2start = new String[1];
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timestart);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner c3Items = (Spinner) findViewById(R.id.Time2StartSelectSpinner);
        c3Items.setAdapter(adapter3);
        c3Items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                time2start[0] =selectedItem;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                time2start[0]="";

            }
        });

        final String[] time2end = new String[1];
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeend);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner c4Items = (Spinner) findViewById(R.id.Time2EndSelectSpinner);
        c4Items.setAdapter(adapter4);
        c4Items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                time2end[0] =selectedItem;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                time2end[0]="";
            }
        });

        final String[] days1 = new String[1];
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner c5Items = (Spinner) findViewById(R.id.adminDayEditText);
        c5Items.setAdapter(adapter5);
        c5Items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                    days1[0] =selectedItem;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                days1[0]="";
            }
        });

        final String[] days2 = new String[1];
        ArrayAdapter<String> adapter6 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner c6Items = (Spinner) findViewById(R.id.adminDay1EditText);
        c6Items.setAdapter(adapter6);
        c6Items.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();

                days2[0] =selectedItem;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                days2[0]="";
            }
        });
        addCourse= findViewById(R.id.createCourseButton);

        Ecrn= findViewById(R.id.adminCRNEditExt);
        Ecname= findViewById(R.id.adminCNameDitText);
        Eccode=findViewById(R.id.adminCCodeEditText);
        Einstructor = findViewById( R.id.adminInstructor );

        Eroom1=findViewById(R.id.adminRoomEditText);
        //Eday1=findViewById(R.id.adminDayEditText);
/*        Etime1=findViewById( R.id.adminTimeEditText );*/

        Eroom2=findViewById(R.id.adminRoom1EditText);
       // Eday2=findViewById(R.id.adminDay1EditText);
/*        Etime2=findViewById( R.id.AdminTime1EditText );*/

        Ecredit = findViewById( R.id.adminCreditEditText );
        EcReq= findViewById( R.id.adminCreditReqEditText);
        Efaculty = findViewById( R.id.adminFacultyEditText);
        Ecapacity = findViewById( R.id.adminCapacityEditText);
        Einfo = findViewById( R.id.adminCInfoEditText);


        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String crn = Ecrn.getText().toString();
                if(crn.equals(""))
                {
                    Toast.makeText( AdminAddCourse.this, "Crn cannot be blank!", Toast.LENGTH_SHORT ).show();
                }
                else{
                    String ccode = Eccode.getText().toString();
                    if (ccode.equals("")){
                        Toast.makeText( AdminAddCourse.this, "Course Code cannot be blank!", Toast.LENGTH_SHORT ).show();
                    }
                    else{
                        String cname = Ecname.getText().toString();
                        if(cname.equals("")){
                            Toast.makeText( AdminAddCourse.this, "Course Name cannot be blank!", Toast.LENGTH_SHORT ).show();
                        }
                        else{
                            String room1 = Eroom1.getText().toString();
                            if(room1.equals(""))
                            {
                                Toast.makeText( AdminAddCourse.this, "Room1 cannot be blank!", Toast.LENGTH_SHORT ).show();
                            }
                            else{
                                if(days1[0].equals(""))
                                {
                                    Toast.makeText( AdminAddCourse.this, "Day1 cannot be blank!", Toast.LENGTH_SHORT ).show();
                                }
                                else if(time1start[0]=="" || time1end[0]=="")
                                {
                                    Toast.makeText( AdminAddCourse.this, "Please select a start and end time!", Toast.LENGTH_SHORT ).show();
                                }
                                else{
                                    String time1 = time1start[0] + "-" + time1end[0]+" "+ days1[0];
                                    Date time1s = null;
                                    Date time1e = null;
                                    try {
                                            time1s   = parser.parse(time1start[0]);
                                            time1e     = parser.parse(time1end[0]);

                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                    if(time1s.after(time1e))
                                    {
                                        Toast.makeText( AdminAddCourse.this, "Start time of cannot be after end time!", Toast.LENGTH_SHORT ).show();
                                    }
                                    else{
                                        String instr = Einstructor.getText().toString();
                                        String faculty = Efaculty.getText().toString();
                                        String info = Einfo.getText().toString();
                                        String room2 = Eroom2.getText().toString();
                                        String day2 = days2[0];
                                        String time2 = time2start[0] + "-" + time2end[0];
                                        time2 += " " + day2;
                                        if(time2start[0]=="" || time2end[0]=="" || day2 =="") {
                                            time2 = "";
                                        }
                                        else{
                                        if(Ecredit.getText().toString().equals("") || EcReq.getText().toString().equals("") || Ecapacity.getText().toString().equals("")){
                                            Toast.makeText( AdminAddCourse.this, "Credit, creditReq and capacity cannot be blank", Toast.LENGTH_SHORT ).show();
                                        }
                                        else{
                                            try {
                                                int credit = Integer.parseInt( Ecredit.getText().toString() );
                                                int creditReq = Integer.parseInt( EcReq.getText().toString() );
                                                int capacity = Integer.parseInt( Ecapacity.getText().toString() );

                                                Course temp = new Course( crn, cname, ccode, " ", "2017-2018", time1, room1, time2, room2, credit, creditReq, faculty, "undergrad", instr, capacity, 0, info );
                                                db.insertCourse(temp);
                                                Toast.makeText( AdminAddCourse.this, "Course added successfully!", Toast.LENGTH_SHORT ).show();
                                            }
                                            catch (Exception e) {
                                                Toast.makeText( AdminAddCourse.this, "Credit/Credit Req/Capacity must be integer!", Toast.LENGTH_SHORT ).show();
                                            }
                                        }
                                    }



                                }

                            }
                        }
                    }
                }


               /* if(crn.equals( "" ))
                    Toast.makeText( AdminAddCourse.this, "Crn cannot be blank!", Toast.LENGTH_SHORT ).show();
                if(ccode.equals( "" ))
                    Toast.makeText( AdminAddCourse.this, "Course code cannot be blank!", Toast.LENGTH_SHORT ).show();
                if(cname.equals( "" ))
                    Toast.makeText( AdminAddCourse.this, "Course name cannot be blank!", Toast.LENGTH_SHORT ).show();
                if(room1.equals( "" ))
                    Toast.makeText( AdminAddCourse.this, "Room cannot be blank!", Toast.LENGTH_SHORT ).show();
                if(day1.equals( "" ))
                    Toast.makeText( AdminAddCourse.this, "Day code cannot be blank!", Toast.LENGTH_SHORT ).show();
                if(time1.equals( "" ))
                    Toast.makeText( AdminAddCourse.this, "Time code cannot be blank!", Toast.LENGTH_SHORT ).show(); */

/*                int index= ccode.indexOf( " " );
                String subject = ccode.substring(0, index);*/



            }
            }

        });
    }
    @Override
    public void onResume()
    {
        db.open();
        super.onResume();
    }
    @Override
    protected void onPause() {
        db.close();
        super.onPause();
    }
}
