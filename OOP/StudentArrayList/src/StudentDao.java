import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public static final String STUDENT_FILE_NAME = "Student.txt";
    public void write(List<Student> studentList){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(new File("Student.txt"));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        }catch(FileNotFoundException e){
            System.out.println("Loi: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Loi: " + e.getMessage());
        }finally{
            closeStream(fos);
            closeStream(oos);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Student> read(){
        List<Student> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(new File("Student.txt"));
            ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
        }catch(FileNotFoundException e){
            System.out.println("Loi: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Loi: " + e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("Loi: " + e.getMessage());
        }finally{
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }
    private void closeStream(InputStream is){
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
    }

    private void closeStream(OutputStream os){
        if (os != null){
            try{
                os.close();
            }catch(IOException e){
                System.out.println("Loi: " + e.getMessage());
            }
        }
    }
}
