package org.eda1.practica01.ejercicio01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Editor {

     private LinkedList<String> text;
	private ListIterator<String> current;
	private boolean inserting;


     public Editor() {
         text = new LinkedList<String>();
         current = text.listIterator();
         inserting = false;
     }


     public void loadFile(String file) {

         Scanner fileScanner = null;
         PrintWriter printWriter = null;

         try {
 			fileScanner = new Scanner(new File(file));
 			printWriter = new PrintWriter(new FileWriter (file + ".out"));
 		} catch (IOException e) {
 			e.printStackTrace();
 			System.exit(-1);
 		}

         editText(fileScanner, printWriter);

         fileScanner.close();
         printWriter.close();

     }

     /**
      * Creates the output file by performing the input-file commands.
      *
      * @param fileScanner - the Scanner over the input file.
      * @param printWriter - the PrintWriter for the output file.
      *
      */
     private void editText(Scanner fileScanner, PrintWriter printWriter) {
    	    String line = "";
            String result = "";

            while (true) {
                try {
                    line = fileScanner.nextLine();
                    printWriter.println(line);
                    result = interpret(line);
                    if ((result != null) && (!line.equals(Auxiliar.DONE_COMMAND)))
                    	printWriter.println(result);
                 }
                 catch (RuntimeException e) {
                     printWriter.println(e.getMessage());
                 }

                 if (line.equals(Auxiliar.DONE_COMMAND)) {
                     printWriter.println(Auxiliar.FINAL_MESSAGE + result);
                     break;
                 }
              }
     }

     /**
      *  Intreprets whether a specified line is a legal command, an illegal command
      *  or a line of text.
      *
      *  @param s - the specified line to be interpreted.
      *
      *  @return the result of carrying out the command, if s is a legal command, and
      *                return null, if s is a line of text or a command that does
      *                not return a value.
      *
      *  @throws RunTimeException - if s is an illegal command; the argument
      *                 indicates the specific error.
      *
      */
 	protected String interpret(String s) {
 		if(s.isEmpty()){
 			return null;
 		}else if(!s.startsWith("$") && inserting){
 			insert(s);
 		}

 		Scanner sc = new  Scanner(s);
 		sc.useDelimiter(" ");

 		switch(sc.next()){
 		case Auxiliar.INSERT_COMMAND:
 				this.inserting=true;
 				sc.close();
 				return null;
 		case Auxiliar.DONE_COMMAND:
 				this.inserting=false;
 				sc.close();
 				return done();
 		case Auxiliar.DELETE_COMMAND:
 				this.inserting=false;
 				tryToDelete(s);
 				sc.close();
 				return null;
 		case Auxiliar.LINE_COMMAND:
 				this.inserting=false;
 				tryToSetCurrentLineNumber(s);
 				sc.close();
 				return null;
 		case Auxiliar.LAST_COMMAND:
 				this.inserting=false;
 				sc.close();
 				return last();
		case Auxiliar.GETLINES_COMMAND:
 				this.inserting=false;
 				sc.close();
 				return tryToGetLines(s);
 			default:
 				if(s.contains("$")){
 					sc.close();
 					return Auxiliar.BAD_COMMAND_MESSAGE;
 				}else{
 					sc.close();
 					return null;
 				}
 		}

    }

     /**
      *  Deletes the lines specified by the given line numbers, unless what follows
      *  $Delete is something other than two integers in the correct range.
      *
      *  @param sc - the Scanner object that scans the rest of the line after $Delete.
      *
      *  @throws RunTimeException - if what follows $Delete does not consist of two
      *          integers, or if those integers are not in the correct range (namely,
      *          0 <= first integer <= second integer <= last line number in text).
      *
      */
     private void tryToDelete(String s) {
         int m = 0, n = 0;
         Scanner sc = new Scanner(s);
         sc.next();
         try {
             m = sc.nextInt();
             n = sc.nextInt();
         }
         catch (RuntimeException e) {
        	 sc.close();
             throw new RuntimeException(Auxiliar.TWO_INTEGERS_NEEDED);
         } // not enough integer tokens

         delete(m, n);
         sc.close();
     }

     /**
      *  Deletes a specified range of lines from the text, and sets the current line
      *  to be the line after the last line deleted.
      *
      *  @param m - the beginning index of the range of lines to be deleted.
      *  @param n - the ending index of the range of lines to be deleted.
      *
      *  @throws RunTimeException - if m is less than 0 or if n is less than m or if
      *                 n is greater than or equal to the number of lines of text.
      *
      */
     private void delete(int m, int n) {
    	 if( m > n){
    		 throw new RuntimeException(Auxiliar.FIRST_GREATER);
    	 }
    	 if( m < 0){
    		 throw new RuntimeException(Auxiliar.M_LESS_THAN_ZERO);
    	 }
    	 if( n > text.size()){
    		 throw new RuntimeException(Auxiliar.SECOND_TOO_LARGE);
    	 }
    	 if( m%1 != 0 || n%1 != 0 ){
    		 throw new RuntimeException(Auxiliar.INTEGER_NEEDED);
    	 }
    	 setCurrentLineNumber(m);
    	 for(int i = m; i <= n; i++){
    		 current.next();
    		 current.remove();
    	 }
     }

     /**
      *  Sets the current line as specified by the given line number, unless what follows
      *  $Line is something other than an integer in the correct range.
      *
      *  @param sc - the Scanner object that scans the rest of the line after $Line.
      *
      *  @throws RunTimeException - if what follows $Line does not consist of an
      *          integer, or if that integer is not in the correct range (namely,
      *          0 <= integer <= number of lines in text).
      *
      */
     private void tryToSetCurrentLineNumber(String s){
    	 int indice = 0;
		 Scanner sc = new Scanner(s);
         sc.next();
         try {
             indice = sc.nextInt();
         }
         catch (RuntimeException e) {
        	 sc.close();
             throw new RuntimeException(Auxiliar.INTEGER_NEEDED);
         } // not enough integer tokens

    	 setCurrentLineNumber(indice);
    	 sc.close();
     }

     /**
      *  Makes a specified index the index of the current line in the text.
      *
      *  @param m - the specified index of the current line.
      *
      *  @throws RunTimeException - if m is less than 0 or greater than or equal to
      *                 the number of lines of text.
      *
      */
     private void setCurrentLineNumber(int m) {
    	 if(m < 0){
    		 throw new RuntimeException(Auxiliar.M_LESS_THAN_ZERO);
    	 }else if(m >= text.size()){
    		 throw new RuntimeException(Auxiliar.M_TOO_LARGE);
    	 }

    	 current = text.listIterator(m);

     }

     /**
      *  Inserts a specified line in front of the current line.
      *
      *  @param s - the line to be inserted.
      *
      *  @throws RunTimeException - if s has more than MAX_LINE_LENGTH
      *                 characters.
      *
      */
     private void insert(String s) {
    	 if (s.length()>Auxiliar.MAX_LINE_LENGTH){
    		 throw new RuntimeException(Auxiliar.LINE_TOO_LONG+Auxiliar.MAX_LINE_LENGTH+"\n");
    	 }
    	 current.add(s);


     }


     /**
      *  Returns the final version of the text.
      *
      *  @return the final version of the text.
      *
      */
     private String done() {
         String s = "";

         for (String itr: text){
        	 s += itr + '\n';
         }

         return s;
     }

     private String last() {
         return Integer.toString(text.size());
     }

     private String tryToGetLines(String s) {
    	 int m = 0, n = 0;
         Scanner sc = new Scanner(s);
         sc.next();
         try {
             m = sc.nextInt();
             n = sc.nextInt();
         }
         catch (RuntimeException e) {
        	 sc.close();
             throw new RuntimeException(Auxiliar.TWO_INTEGERS_NEEDED);
         } // not enough integer tokens

         sc.close();
         return getLines(m, n);
     }

     private String getLines(int m, int n) {
    	 if( m > n){
    		 throw new RuntimeException(Auxiliar.FIRST_GREATER);
    	 }
    	 if( m < 0){
    		 throw new RuntimeException(Auxiliar.M_LESS_THAN_ZERO);
    	 }
    	 if( n > text.size()){
    		 throw new RuntimeException(Auxiliar.SECOND_TOO_LARGE);
    	 }
    	 if( m%1 != 0 || n%1 != 0 ){
    		 throw new RuntimeException(Auxiliar.INTEGER_NEEDED);
    	 }

    	 String getLineas = "";
    	 for(int i = m; i <= n; i++){
    		 getLineas += i + "\t" + text.get(i) + "\n";
    	 }
    	 return getLineas;
     }
}