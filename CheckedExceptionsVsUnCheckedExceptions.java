package interviewQuestions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckedExceptionsVsUnCheckedExceptions {
	
	public static void main(String[] args) throws IOException {
		// Checked Exceptions are to be surrounded with Try catch before even execution
		// starts, Java Force programmer to handle.it is precaution to programmer to handle when resource/object not
		// available Ex: FileNotFoundException,I/O exception
		//Can be handled by using throws declaration or try/catch block
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("C:\\Users\\Krishna Keerthi\\Desktop\\BGC.pdf");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object object = fis.read();
		System.out.println(object.toString());
		System.out.println();
		
		// UnCecked Exceptions are to be handled by programmer by using throwable or by
		// surrounding by try/catch. JVm doesn't force user to handle this
		// NPE, Arithmetic exception etc..
		//int x= 10/0; // we know it will throw NPE, but still compiler not forcing programmer to handle 
		//handling unchecked exceptions with try/catch as below
		try {
			int x = 10/0;
		}
		catch(Exception ae) {
			System.out.println("Please check the divided by zero exception");
			//ae.printStackTrace();
		}
		finally {
			System.out.println("it will execute always");
		}
		
		
	}

}
