package serkan.com.basitveritabaniders;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase veritabanim=this.openOrCreateDatabase("Unluler",MODE_PRIVATE,null);
            veritabanim.execSQL("CREATE TABLE IF NOT EXISTS Yazilimcilar (adi VARCHAR,yas INT(2))");

            //veritabanim.execSQL("INSERT INTO Yazilimcilar(adi,yas) VALUES ('Bill GATES',64)");
           //veritabanim.execSQL("INSERT INTO Yazilimcilar(adi,yas) VALUES ('Mark ZUKERBERG',35)");
           //veritabanim.execSQL("INSERT INTO Yazilimcilar(adi,yas) VALUES ('Elon MUSK',47)");
           //veritabanim.execSQL("INSERT INTO Yazilimcilar(adi,yas) VALUES ('Larry PAGE',46)");
           //veritabanim.execSQL("INSERT INTO Yazilimcilar(adi,yas) VALUES ('Jeff BESOZ',55)");

            //veritabanim.execSQL("UPDATE Yazilimcilar SET yas=48 WHERE adi='Elon MUSK'");

            //veritabanim.execSQL("DELETE FROM Yazilimcilar WHERE adi LIKE 'E%'");

            Cursor cursor=veritabanim.rawQuery("SELECT * FROM Yazilimcilar WHERE yas<50",null);

            int adIndex=cursor.getColumnIndex("adi");
            int yasIndex=cursor.getColumnIndex("yas");

            cursor.moveToFirst();
            while(cursor!=null){

                System.out.println("Adı : "+cursor.getString(adIndex));
                System.out.println("Yaşı : "+cursor.getInt(yasIndex));
                cursor.moveToNext();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
