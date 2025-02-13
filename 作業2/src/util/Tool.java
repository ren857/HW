package util;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Member;



	public class Tool {
		public static void save(Object s,String filename)
		{
			
			try {
				
				FileOutputStream fos=new FileOutputStream(filename);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				
				oos.writeObject(s);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public static Object read(String filename)
		{
			Object o=null;
			
			try {
				FileInputStream fis=new FileInputStream(filename);
				ObjectInputStream ois=new ObjectInputStream(fis);
				o=ois.readObject();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return o;
		}
		public static List<String> readNames(String filename) {
	        List<String> names = new ArrayList<>();
	        Member member = (Member) read(filename);
	        if (member != null) {
	            names.add(member.getName()); // 假設 Member 有一個 getName() 方法
	        }
	        return names;
	    }
		
		
}
