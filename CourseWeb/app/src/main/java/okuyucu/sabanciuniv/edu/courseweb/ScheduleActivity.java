package okuyucu.sabanciuniv.edu.courseweb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    Button monday;
    Button tuesday;
    Button wednesday;
    Button thursday;
    Button friday;
    Database db ;
    String username ;
    public final static String BILGI = "BILGI";
    public final static String GUN   = "GUN" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        //these two lines for database communication
        db = new Database(this);
        db.open();
        //these two lines for getting the usernmae of the user who logged in
        SharedPreferences sharedPreferences = getSharedPreferences(LoginActivity.globalPreferenceName,MODE_PRIVATE);
        username = sharedPreferences.getString("username",null);
        monday=(Button)findViewById(R.id.mondayButton);
        tuesday=(Button)findViewById(R.id.tuesdayButton);
        wednesday=(Button)findViewById(R.id.wednesdayButton);
        thursday=(Button)findViewById(R.id.thursdayButton);
        friday=(Button)findViewById(R.id.fridayButton);

        //Since day infos are embedded in time variables of courses i didn't finish thi part yet but you will get a COURSE(class) List so you can implement according to that
        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDayM();
            }
        });

        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDayT();
            }
        });

        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDayW();
            }
        });

        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDayR();
            }
        });

        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickDayF();
            }
        });

    }

    public void clickDayM() {
        Intent dayIntent = new Intent(this, DayActivity.class);
        //Intent dayIntent1 = new Intent(this, DayActivity.class);
        List<CourseTaken> a = db.getArrayCoursesTaken(username);
        String w1 = "Monday";
        dayIntent.putExtra(GUN,w1) ;
        //startActivity(dayIntent);
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) // loop to store the time of the classes
        {
            CourseTaken b = a.get(i);
            String q = b.time;
            String x = b.time1;
            String Maddee = b.cname ;

    if (q != null) {
        if (q.substring(q.length() - 1, q.length()).equals("M")) // as the day of the class is defined to be the last charecter of the time
        {

            String w;

            w = b.cname;
            w = w + "   " + b.time.substring(0, b.time.length() - 1);
            w = w + "  " + b.room ;
            array.add(w);
            //dayIntent.putExtra(BILGI,w) ;
            ///startActivity(dayIntent);

        }
    }
    if (x != null) {
        if (x.substring(x.length() - 1, x.length()).equals("M")) // as the day of the class is defined to be the last charecter of the time
        {
            String w;

            w = b.cname;
            w = w + "   " + b.time1.substring(0, b.time1.length() - 1);
            w = w +"  "+  b.room1 ;
            array.add(w);
        }
    }
        }
        dayIntent.putExtra(BILGI,array) ;
        startActivity(dayIntent);
    }
    public void clickDayT() {
        Intent dayIntent = new Intent(this, DayActivity.class);
       // Intent dayIntent1 = new Intent(this, DayActivity.class);
        List<CourseTaken> a = db.getArrayCoursesTaken(username);
        String w1 = "Tuesday";
        dayIntent.putExtra(GUN,w1) ;
       // startActivity(dayIntent);
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) // loop to store the time of the classes
        {
            CourseTaken b = a.get(i);
            String q = b.time;
            String x = b.time1;
            if (q != null) {
                if (q.substring(q.length() - 1, q.length()).equals("T")) // as the day of the class is defined to be the last charecter of the time
                {

                    String w;

                    w = b.cname;
                    w = w + "   " + b.time.substring(0, b.time.length() - 1);
                    w = w + "  " + b.room ;
                    array.add(w);
                    //dayIntent.putExtra(BILGI,w) ;
                    ///startActivity(dayIntent);

                }
            }
            if (x != null) {
                if (x.substring(x.length() - 1, x.length()).equals("T")) // as the day of the class is defined to be the last charecter of the time
                {
                    String w;

                    w = b.cname;
                    w = w + "   " + b.time1.substring(0, b.time1.length() - 1);
                    w = w +"  "+  b.room1 ;
                    array.add(w);
                }
            }
        }
        //array = Sorter(array) ;
        dayIntent.putExtra(BILGI,array) ;
        startActivity(dayIntent);
       // finish();
    }
    public void clickDayW() {
        Intent dayIntent = new Intent(this, DayActivity.class);
        //Intent dayIntent1 = new Intent(this, DayActivity.class);
        List<CourseTaken> a = db.getArrayCoursesTaken(username);
        String w1 = "Wedensday";
        dayIntent.putExtra(GUN,w1) ;
        //startActivity(dayIntent1);
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) // loop to store the time of the classes
        {
            CourseTaken b = a.get(i);
            String q = b.time;
            String x = b.time1;
            if (q != null) {
                if (q.substring(q.length() - 1, q.length()).equals("W")) // as the day of the class is defined to be the last charecter of the time
                {

                    String w;

                    w = b.cname;
                    w = w + "   " + b.time.substring(0, b.time.length() - 1);
                    w = w + "  " + b.room ;
                    array.add(w);
                    //dayIntent.putExtra(BILGI,w) ;
                    ///startActivity(dayIntent);

                }
            }
            if (x != null) {
                if (x.substring(x.length() - 1, x.length()).equals("W")) // as the day of the class is defined to be the last charecter of the time
                {
                    String w;

                    w = b.cname;
                    w = w + "   " + b.time1.substring(0, b.time1.length() - 1);
                    w = w +"  "+  b.room1 ;
                    array.add(w);
                }
            }
        }
        dayIntent.putExtra(BILGI,array) ;
        startActivity(dayIntent);
    }
    public void clickDayR() {
        Intent dayIntent = new Intent(this, DayActivity.class);
        Intent dayIntent1 = new Intent(this, DayActivity.class);
        List<CourseTaken> a = db.getArrayCoursesTaken(username);
        String w1 = "Thursday";
        dayIntent.putExtra(GUN,w1) ;
        //startActivity(dayIntent1);
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) // loop to store the time of the classes
        {
            CourseTaken b = a.get(i);
            String q = b.time;
            String x = b.time1;
            if (q != null) {
                if (q.substring(q.length() - 1, q.length()).equals("R")) // as the day of the class is defined to be the last charecter of the time
                {

                    String w;

                    w = b.cname;
                    w = w + "   " + b.time.substring(0, b.time.length() - 1);
                    w = w + "  " + b.room ;
                    array.add(w);
                    //dayIntent.putExtra(BILGI,w) ;
                    ///startActivity(dayIntent);

                }
            }
            if (x != null) {
                if (x.substring(x.length() - 1, x.length()).equals("R")) // as the day of the class is defined to be the last charecter of the time
                {
                    String w;

                    w = b.cname;
                    w = w + "   " + b.time1.substring(0, b.time1.length() - 1);
                    w = w +"  "+  b.room1 ;
                    array.add(w);
                }
            }
        }

        dayIntent.putExtra(BILGI,array) ;
        startActivity(dayIntent);
    }
    public void clickDayF() {
        Intent dayIntent = new Intent(this, DayActivity.class);
        //Intent dayIntent1 = new Intent(this, DayActivity.class);
        List<CourseTaken> a = db.getArrayCoursesTaken(username);
        String w1 = "Friday";
        dayIntent.putExtra(GUN,w1) ;
        //startActivity(dayIntent1);
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < a.size(); i++) // loop to store the time of the classes
        {
            CourseTaken b = a.get(i);
            String q = b.time;
            String x = b.time1;
            if (q != null) {
                if (q.substring(q.length() - 1, q.length()).equals("F")) // as the day of the class is defined to be the last charecter of the time
                {

                    String w;

                    w = b.cname;
                    w = w + "   " + b.time.substring(0, b.time.length() - 1);
                    w = w + "  " + b.room ;
                    array.add(w);
                    //dayIntent.putExtra(BILGI,w) ;
                    ///startActivity(dayIntent);

                }
            }
            if (x != null) {
                if (x.substring(x.length() - 1, x.length()).equals("F")) // as the day of the class is defined to be the last charecter of the time
                {
                    String w;

                    w = b.cname;
                    w = w + "   " + b.time1.substring(0, b.time1.length() - 1);
                    w = w +"  "+  b.room1 ;
                    array.add(w);
                }
            }
        }
        dayIntent.putExtra(BILGI,array) ;
        startActivity(dayIntent);
    }
    public ArrayList Sorter(ArrayList<String> a)
    {
        ArrayList<String> b = new ArrayList<String>() ;

        for (int i = 0 ; i < a.size() ; i++)
        {
            String [] tahseen =  a.get(i).split(" ");
            int size = tahseen.length ;
            b.add(tahseen[size-3]) ;

        }
        Collections.sort(b);
        return b ;
    }
    @Override
    protected void onResume() {
        db.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        db.close();
        super.onPause();
    }
}
