package locations;

import fileRW.FileReaderWriter;

import java.io.IOException;
import java.util.Scanner;

public class Office implements Storage {

    boolean success;
    String barcode;
    String location;
    FileReaderWriter fileData;
    Scanner textInput = new Scanner(System.in);

    //Format of spots: x-coordinate, y-coordinate, z-coordinate
    public void store(){
        System.out.println("Please enter the barcode of the item");
        barcode = textInput.nextLine();

        System.out.println("Please enter the name of the storage space");
        location = textInput.nextLine();

        fileData = new FileReaderWriter();
        String s = barcode + " " + location;
        System.out.println("Data {" + s + "} will now be added to file");
        try {
            fileData.storeIntoInventory("Office", s);
        } catch (IOException e) {
            System.out.println("Failed to write data to file.");
        }

    }

    public void take(String s){

        System.out.println("Item " + barcode + " is at [" + location + "]");
    }

    public boolean find(String l, String s){
        fileData = new FileReaderWriter();
        try {
            success = fileData.findInInventory(l, s);
        } catch (IOException e) {
            System.out.println("Failed to use finder method");
        }
        return success;
    }

    public void locate(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            fileData.locateInInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use locator method");
        }
    }
}