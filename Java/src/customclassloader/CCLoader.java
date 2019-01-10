package customclassloader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Class CustomClassLoader
 * Created by wajahat
 */
public class CCLoader extends ClassLoader {

    public CCLoader(ClassLoader parent) {
        super(parent);
    }

    private Class getClass(String name) throws ClassNotFoundException {
        String file = name.replace('.', File.separatorChar) + ".class";
        byte []b = null;
        try {
            b = loadClassFileData(file);

            Class c = defineClass(name, b, 0, b.length);
            resolveClass(c);
            return c;
        } catch (IOException e) {
            System.out.println("Unable to load class: " + file);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("Loading class: " + name);
        if (name.startsWith("customclassloader")) {
            System.out.println("Loading class with CCLoader !!!");
            return getClass(name);
        }
        return super.loadClass(name, resolve);
    }

    /**
     * This can be changed if class needs to be loaded from n/w or FTP server
     * @param name
     * @return
     * @throws IOException
     */
    private byte[] loadClassFileData(String name) throws IOException {
        InputStream ip = getClass().getClassLoader().getResourceAsStream(name);
        int size =  ip.available();
        byte []buff =   new byte[size];
        DataInputStream dis = new DataInputStream(ip);
        dis.readFully(buff);
        dis.close();
        return buff;
    }
}
