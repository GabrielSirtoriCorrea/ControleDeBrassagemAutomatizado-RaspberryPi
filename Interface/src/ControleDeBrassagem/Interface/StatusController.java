/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControleDeBrassagem.Interface;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Gazebo
 */
public class StatusController {
    private static JSONObject jsonObject;
    private static JSONObject originalJson;
    private static JSONParser jsonParser;
    private static FileWriter writer;
   
    public static JSONObject readStatus(){
        do{
            try {
                jsonParser = new JSONParser();
                jsonObject = new JSONObject(jsonParser.parse(new FileReader("../status.json")).toString());
            } catch (ParseException | IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }while(jsonObject.isEmpty());
            
        return jsonObject;
    }
    
    public static void writeStatus(String  tank, String target, Object value){
        try {
            if(tank != null){
                originalJson = readStatus();
                jsonObject = readStatus().getJSONObject(tank);
                jsonObject.put(target, value);
                originalJson.put(tank, jsonObject);
                System.out.println(jsonObject);
                writer = new FileWriter("../status.json");
                
                writer.write(originalJson.toString());
            }else{
                 jsonObject = readStatus();
                 writer = new FileWriter("../status.json");
                System.out.println(jsonObject);
                jsonObject.put(target, value);
                writer.write(jsonObject.toString());
            }
            
            writer.close();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
    public static void writeStatus(String  tank, String target, JSONArray value){
        try {
            if(tank != null){
                originalJson = readStatus();
                jsonObject = readStatus().getJSONObject(tank);
                jsonObject.put(target, value);
                originalJson.put(tank, jsonObject);
                System.out.println(jsonObject);
                writer = new FileWriter("../status.json");
                
                writer.write(originalJson.toString());
            }else{
                 jsonObject = readStatus();
                 writer = new FileWriter("../status.json");
                System.out.println(jsonObject);
                jsonObject.put(target, value);
                writer.write(jsonObject.toString());
            }
            
            writer.close();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
    public static void resetStatus(){
        try { 
            jsonObject = new JSONObject("{\"BrewStatus\":\"Pausado\",\"Tank3\":{\"Temperature\":0,\"NextProcess\":false,\"Hops\":[0,0,0],\"BoilTime\":0,\"SetPoint\":0,\"Resistence\":false,\"HopAlert\":false},\"Tank2\":{\"ClarificationTime\":0,\"Motor\":false,\"NextProcess\":false},\"BrewMode\":\"Automatic\",\"Tank1\":{\"Ramps\":[[0,0],[0,0]],\"MaltAlert\":false,\"Temperature\":0,\"Motor\":false,\"NextProcess\":false,\"SetPoint\":0,\"ActualRamp\":0,\"Resistence\":false},\"Bomb\":false}");
            writer = new FileWriter("../status.json");
            writer.write(jsonObject.toString());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(StatusController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
