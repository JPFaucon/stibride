/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58990.stibride.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author jp
 */
public class ConfigManager {
    
    private ConfigManager() {
        prop = new Properties();
        url = getClass().getClassLoader().getResource(FILE).getFile();
    }
    
    private static final String FILE = "./config/config.properties";
    
    private final Properties prop;
    
    private final String url;
    
    public void load() throws IOException {
        try (InputStream input = new FileInputStream(url)) {
            prop.load(input);
        } catch (IOException ex) {
            throw new IOException("Chargement configuration impossible ", ex);
        }
    }
    
    public String getProperties(String name) {
        return prop.getProperty(name);
    }
    
    public static ConfigManager getInstance() {
        return ConfigManagerHolder.INSTANCE;
    }
    
    /**
     * Propre à java, attribut dans classe ConfigManager aussi ok
     */
    private static class ConfigManagerHolder {
        
        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}
