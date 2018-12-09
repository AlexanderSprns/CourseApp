package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOClass {

    public boolean saveObject(Object object, String filename) {
        boolean result = true;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
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

    public Object readObject (String filename){

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            Object object1 =((Object)ois.readObject());
            return object1;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
