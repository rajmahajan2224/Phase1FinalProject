package com.myfirstproject;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class myProject {
	
	 static String Path;
	    File myFolder;

	    public  myProject() {
	    	Path = System.getProperty("user.dir");
	    	myFolder = new File(Path+"/files");
	        if (!myFolder.exists())
	        	myFolder.mkdirs();
	        System.out.println("MyFilePath : "+ myFolder.getAbsolutePath());
	    }
	    
	   private static final String WELCOME_TO_MY_COMPANY_PROTAL =
	           "\n MyCompany Locker "
	                     + " " +
	           "\n By MyCompany Pvt.Ltd "
	                     + " " +
	           "\n Developed By Rajkumar Mahajan";
	    
	   private static final String The_LOGIC_PART =
	            "\n Main Operation - Select any of the following operations: \n"+
	                    "1 -> List the types of files in directory\n"+
	                    "2 -> Perfotm functions like Add, Delete or Search\n"+
	                    "3 -> Exit Program";

	    private static final String THE_FUNCTIONALITY_PART =
	            "   \nSelect any of the following  operations: \n"+
	                    "   1 -> Add a file\n"+
	                    "   2 -> Delete a file\n"+
	                    "   3 -> Search a file\n"+
	                    "   4 -> GoBack to Logic Part";

	    void firstView() {
	        System.out.println(The_LOGIC_PART);
	        try(Scanner scanner = new Scanner(System.in)){
	            
	        	int option = scanner.nextInt();
	            switch (option){
	                case 1 : {
	                	showListOfFiles();
	                    firstView();
	                }
	                case 2 : {
	                    secondView();
	                }
	                case 3 : {
	                    System.out.println("Thank You");
	                    System.exit(0);
	                }
	                default: firstView();
	            }
	        }
	        catch (Exception e){
	            System.out.println("Please enter 1, 2 or 3");
	            firstView();
	        }
	    }

	    void secondView() {
	        System.out.println(THE_FUNCTIONALITY_PART);
	        try(Scanner scanner = new Scanner(System.in))
	        {
	            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
	            char logic = input[0];

	            switch (logic){
	                case '1' : {
	                    System.out.print("Please Enter a File Name you want to Add : ");
	                    String filename = scanner.next().trim().toLowerCase();
	                    addFileMethod(filename);
	                    break;
	                }
	                case '2' : {
	                    System.out.print("Please Enter a File Name you want to Delete : ");
	                    String filename = scanner.next().trim();
	                    deleteFileMethod(filename);
	                    break;
	                }
	                case '3' : {
	                    System.out.print("Please Enter a File Name you want to Search For : ");
	                    String filename = scanner.next().trim();
	                    searchFileMethod(filename);
	                    break;
	                }
	                case '4' : {
	                    System.out.println("Going back to main logic part");
	                    firstView();
	                    break;
	                }
	                default : System.out.println("Please enter correct values to search the data in list");
	            }
	            secondView();
	        }
	        catch (Exception e){
	            System.out.println("Please enter correct values to search the data in list");
	            secondView();
	        }
	    }

	    void showListOfFiles() {
	        if (myFolder.list().length==0)
	            System.out.println("The folder is empty");
	        else {
	            String[] list = myFolder.list();
	            System.out.println("The files in "+ myFolder +" are :");
	            Arrays.sort(list);
	            for (String str:list) {
	                System.out.println(str);
	            }
	        }
	    }

	    void addFileMethod(String filename) throws IOException {
	        File filepath = new File(myFolder +"/"+filename);
	        String[] list = myFolder.list();
	        for (String file: list) {
	            if (filename.equalsIgnoreCase(file)) {
	                System.out.println("File " + filename + " already exists at " + myFolder);
	                return;
	            }
	        }
	        filepath.createNewFile();
	        System.out.println("File "+filename+" added to "+ myFolder);
	    }

	    void deleteFileMethod(String filename) {
	        File filepath = new File(myFolder +"/"+filename);
	        String[] list = myFolder.list();
	        for (String file: list) {
	            if (filename.equals(file) && filepath.delete()) {
	                System.out.println("File " + filename + " deleted from " + myFolder);
	                return;
	            }
	        }
	        System.out.println("Delete Operation failed. FILE NOT FOUND");
	    }

	    void searchFileMethod(String filename) {
	        String[] list = myFolder.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("FOUND : File " + filename + " exists at " + myFolder);
	                return;
	            }
	        }
	        System.out.println("File Not found (FNF)");
	    }

	    public static void main(String[] args) {
	        System.out.println(WELCOME_TO_MY_COMPANY_PROTAL); 
	        myProject menu = new  myProject();
	        menu.firstView();
	    }
	}
