package sample;

import java.io.*;

public class IOClass {

    public IOClass() {
    }

    public boolean saveFile(Object object, String filename) {
        boolean result = true;
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.flush();
            oos.writeObject(object);
            oos.close();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            result = false;
        }
        return result;
    }

    public Object readFile(String filename){
        Object object1 = new Object();
        try
        {
            //TODO create a new empty file
//            File file = new File(filename); //throws exception after closing the application creates new file
//            if(!file.exists()) // if file already exists will do nothing
//                file.createNewFile();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            object1 = ois.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());

        }
        return object1;
    }
}
