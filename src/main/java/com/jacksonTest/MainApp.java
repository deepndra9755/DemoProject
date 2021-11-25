
package com.jacksonTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;


public class MainApp {
    public static void main(String[] args) {
        try {


            ObjectMapper objectMapper = new ObjectMapper();

            //to write java object data to json file
            //StudentApp studentApp = new StudentApp(1, "dipendra", "AN142230D11");
            //objectMapper.writeValue(new File("src/test/stud.json"), studentApp);

            // to get java object from the the given json
           // String jsondata="{\"id\":1,\"name\":\"dipendra\",\"enrollment\":\"AN142230D11\"}";
            //StudentApp studentApp=objectMapper.readValue(jsondata,StudentApp.class);
            //System.out.println(studentApp.toString());


            //to read json data from the given file and write into java object
            //   StudentApp studentApp=objectMapper.readValue(new File("src/test/stud.json"),StudentApp.class);
            //System.out.println(studentApp);



           JsonNode jsonNode=objectMapper.readTree(new File("src/test/stud.json"));
           String studentName=jsonNode.get("name").asText();
            System.out.println(studentName);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
