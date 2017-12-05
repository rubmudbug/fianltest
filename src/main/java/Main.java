import cn.hselfweb.local.Db;
import cn.hselfweb.local.FileIO;
import cn.hselfweb.local.Student;
import com.sun.xml.internal.bind.WhiteSpaceProcessor;

import javax.swing.text.Style;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, ParseException {
        // System.out.println("Hello World!");
        FileIO fileIO1 = new FileIO("D:/fianltest/Student_delete.txt");
        FileIO fileIO2 = new FileIO("D:/fianltest/Student_insert.txt");
        FileIO fileIO3 = new FileIO("D:/fianltest/Student_update.txt");
        Db db = new Db("jdbc:mysql://localhost:3306/student", "root", "");
        db.connect();
        Student[] student;
        student = fileIO2.fileRead();
        System.out.println(student[0].getId());
        ResultSet resultSet = null;
        int i = 0;
        while (student[i] != null) {
            String insertSql = "INSERT INTO student ('id', 'name', 'sex', 'hight', 'birthday', 'native_place') VALUES (" + student[i].getId() + ","+student[i].getName()+
            " , "+student[i].getSex()+","+student[i].getHight()+","+student[i].getBirthday()+","+ student[i].getNative_place()+")";
            db.DbInsert(insertSql);
            i++;
        }

    }
}
