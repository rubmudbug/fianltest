package cn.hselfweb.local;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileIO {

    protected String url;

    /**
     * 构造函数
     *
     * @param url
     */
    public FileIO(String url) {
        this.url = url;
    }

    /**
     * 读取txt文件
     *
     * @throws IOException
     */
    public Student[] fileRead() throws IOException, ParseException {
        int i = 0;
        int id;
        String name;
        String sex ;
        double hight ;
        Date date ;
        String Native_place;
        Student[] student = new Student[100];
        File file = new File(url);
        InputStreamReader reader =new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line=" ";
        while (line != null) {
            line = bufferedReader.readLine();
            if (line==null)break;
            String[] StrArray = line.split(",");
            id = Integer.parseInt(StrArray[0]);
            name = StrArray[1];
            sex = StrArray[2];
            hight = Double.valueOf(StrArray[3]).doubleValue();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
            date = sdf.parse(StrArray[4]);
            Native_place = StrArray[5];
            student[i] = new Student(id, name, sex, hight, date, Native_place);
            i++;
            System.out.println(line);
        }
        if (student == null)
            return null;
        else
            return student;
    }

    /**
     * 写入txt文件
     *
     * @param buffer 需要写入的字段
     * @throws IOException
     */
    public void fileWrite(String buffer) throws IOException {
        File file = new File(url);
        file.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(file, true));
        out.write(buffer);
        out.flush();
        out.close();
    }
}
