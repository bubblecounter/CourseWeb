package okuyucu.sabanciuniv.edu.courseweb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by okuyucu on 5.05.2018.
 */

public class SQLClass extends SQLiteOpenHelper {

    public SQLClass(Context c) {
        super(c, "user", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE users (" +
                "                 username text PRIMARY KEY," +
                "                  password text NOT NULL," +
                "                  usertype text NOT NULL," +
                "                  name text NOT NULL," +
                "                  lastname text NOT NULL" +
                "                ) ";
        db.execSQL(sql);
        String INSERT_USERS = "INSERT INTO users (username, password, usertype, name, lastname) VALUES\n" +
                "('eyupogluselin', 'selin123', 'student', 'Selin', 'Eyupoglu'),\n" +
                "('okara', '123123', 'student', 'Omer', 'Karamanli'),\n" +
                "('senacet', '12345', 'student', 'Sena Necla', 'Cetin'),\n"+
                "('menes', '58', 'instructor', 'M. Enes', 'Simsek'),\n"+
                "('okuyucu', '9745834', 'student', 'A. Furkan', 'Okuyucu'),\n"+
                "('ahmadbeilouni', '7486145', 'student', 'Ahmad', 'Beilouni '),\n"+
                "('sev','57','admin','Sevval','Boylu')";
        db.execSQL(INSERT_USERS);
        String CREATE_COURSE_TABLE ="  CREATE TABLE courses (" +
                "  crn text PRIMARY KEY," +
                "  cname text NOT NULL," +
                "  ccode text DEFAULT NULL," +
                "  subject text NOT NULL," +
                "  semester text NOT NULL," +
                "  time text DEFAULT NULL," +
                "  room text DEFAULT NULL," +
                "  time1 text DEFAULT NULL," +
                "  room1 text DEFAULT NULL," +
                "  credit integer DEFAULT NULL," +
                "  creditreq integer DEFAULT NULL," +
                "  faculty text DEFAULT NULL," +
                "  slevel text DEFAULT NULL," +
                "  instr text NOT NULL," +
                "  capacity integer NOT NULL," +
                "  reg integer NOT NULL," +
                "  cinfo text NOT NULL" +
                ")";
        db.execSQL(CREATE_COURSE_TABLE);
        String INSERT_COURSES = "INSERT INTO courses (crn, cname, ccode, subject, semester, time, room, time1, room1, credit, creditreq, faculty, slevel, instr, capacity, reg, cinfo) VALUES" +
                "('12345', 'Discrete Mathematics', 'MATH204', 'MATH', 'Spring 201718', '13:40-15:30 T', 'FASS G062', '14:30-16:30 W', 'FASS 2094', '3', 32, 'FENS', 'Undergraduate', 'Michel Lawrauw', 300, 0, 'cool')," +
                "('20976', 'Approaches to Film Studies', 'FILM331', 'FILM', 'Spring 201718', '12:40-15:30 T', 'FASS 1099', NULL, NULL, '3', 30, 'FASS', 'Undergraduate', 'Asuman Gok', 30, 15, '')," +
                "('20982', 'Differential Equations', 'MATH202', 'MATH', 'Spring 201718', '12:40-15:30 T', 'FASS G062', NULL, NULL, '3', 33, 'FASS', 'Undergraduate', 'Yasemin Sengul Tezel', 30, 2, 'xxx')," +
                "('30264', 'Humanity and Society 1', 'SPS101-0', 'SPS', 'Fall 201718', '13:40-15:30 F', 'FASS G062', '17:40-18:30 M', 'FASS G062', '3', 32, 'FASS', 'Undergraduate', 'Emre Erol', 300, 100, '')," +
                "('30265', 'Humanity and Society 1-Discussion', 'SPS101D', 'SPS', 'Spring 201718', '13:40-15:30 M', 'FENS G077', '13:40-14:30 F', 'FASS 2094', '3', 30, 'FASS', 'Undergraduate', 'Mehmet Kuru', 150, 50, '')," +
                "('20015', 'Mobile Application Development','CS310','CS','Spring 201718','13:40-16:30 W','FENS L045',NULL,NULL,'3',34,'FENS','Undergaduate','Merhmet Ercan Nergiz',100,95,''),"+
                "('20012', 'Software Engineering','CS308','CS','Spring 201718','11:40-12:30 M','FENS G032','14:40-16:30 T','FASS G022','4',34,'FENS','Undergaduate','Cemal Yilmaz',100,87,'')";
        db.execSQL(INSERT_COURSES);

        String CREATE_STUDENTS_TABLE = "CREATE TABLE students (" +
                "  sid integer PRIMARY KEY," +
                "  username text NOT NULL," +
                "  major text NOT NULL," +
                "  totalcredits integer NOT NULL," +
                "  sname text NOT NULL)";
        db.execSQL(CREATE_STUDENTS_TABLE);

        String INSERT_STUDENTS = "INSERT INTO students (sid, username, major, totalcredits, sname) VALUES" +
                "('12321', 'senacet', 'CS', 30, 'Sena Cetin')," +
                "('20965', 'menes', 'CS', 23, 'Enes Simsek')," +
                "('20489', 'okuyucu',  'CS', 57, 'A. Furkan Okuyucu'),"+
                "('20487', 'ahmadbeilouni', 'CS', 84, 'Ahmad Beilouni '),"+
                "('28687', 'okara', 'CS', 54, 'Omer Karamanli '),"+
                "('28745', 'eyupogluselin', 'CS', 32, 'Selin Eyupoglu')";
        db.execSQL(INSERT_STUDENTS);
        String CREATE_COREQUISITE_TABLE = "  CREATE TABLE corequisite (" +
                "  core1 text NOT NULL," +
                "  core2 text NOT NULL," +
                "  FOREIGN KEY(core1) REFERENCES courses(crn),"+
                "  FOREIGN KEY(core2) REFERENCES courses(crn) "+
                ") ";
        db.execSQL(CREATE_COREQUISITE_TABLE);

        String CREATE_GIVES_TABLE = "CREATE TABLE gives (" +
                "  username text NOT NULL," +
                "  crn integer PRIMARY KEY" +
                ")";
        db.execSQL(CREATE_GIVES_TABLE);

        String INSERT_GIVES = "INSERT INTO gives (username, crn) VALUES" +
                "('menes', '20015')," +
                "('menes', '20012')";
        db.execSQL(INSERT_GIVES);

        String CREATE_INSTRUCTORS_TABLE = "CREATE TABLE instructors (" +
                "  username text PRIMARY KEY," +
                "  fullname text NOT NULL" +
                ")";
        db.execSQL(CREATE_INSTRUCTORS_TABLE);

        String INSERT_INSTRUCTORS = "INSERT INTO instructors (username, fullname) VALUES\n" +
                "('okara', 'Omer Karamanli')";
        db.execSQL(INSERT_INSTRUCTORS);
        String CREATE_TAKES_TABLE = "CREATE TABLE takes (" +
                "  sid integer ," +
                "  crn integer ," +
                "  grade text DEFAULT NULL," +
                "  PRIMARY KEY(sid,crn),"+
                "  FOREIGN KEY(sid) REFERENCES students(sid) "+
                ")";
        db.execSQL(CREATE_TAKES_TABLE);

        String INSERT_TAKES = "INSERT INTO takes (sid, crn, grade) VALUES" +
                "('12321', '20012', NULL)," +
                "('20489', '20012', 'B')," +
                "('20487', '20012', NULL)," +
                "('28687', '20012', 'B-')," +
                "('28745', '20012', 'A-')," +
                "('12321', '20015', NULL)," +
                "('20489', '20015', NULL)," +
                "('20487', '20015', 'A')," +
                "('28687', '20015', 'C+')," +
                "('28687', '12345', NULL)," +
                "('28687', '30264', NULL)," +
                "('12321', '30264', NULL)";
        db.execSQL(INSERT_TAKES);

        //TODO: MATH204 HARİCİ HER DERSİ EN AZ BİR ADAM ALACAK! MATH204 KASTEN BOŞ BIRAKILACAK!
        //TODO: Daha fazla veri girilmesi gerekiyor. Ders/user/student
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists courses");
    }
}
