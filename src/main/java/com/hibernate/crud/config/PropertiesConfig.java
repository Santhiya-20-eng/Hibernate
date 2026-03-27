package com.hibernate.crud.config;

import com.hibernate.crud.exceptions.InternalServerException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;


public class PropertiesConfig {

    private static final Properties PROPERTIES=new Properties();
    private static final PropertiesConfig instance=new PropertiesConfig();

    private PropertiesConfig()
    {
        List<String> filesToLoad=List.of("hibernate.properties","message.properties");
        filesToLoad.forEach(files->{
            InputStream inputStream=getClass()
                    .getClassLoader()
                    .getResourceAsStream(files);
            try{
                if(inputStream!=null)
                    try{
                        PROPERTIES.load(inputStream);
                    }catch(IOException e){
                        System.out.println(e.getMessage());

                    }
            } catch( InternalServerException e){
                throw new InternalServerException("Failed to Load");

            }
        });
    }

    public static PropertiesConfig getInstance()
    {
        return instance;

    }

    public static String  getProperties(String key){
        return PROPERTIES.getProperty(key);
    }
}