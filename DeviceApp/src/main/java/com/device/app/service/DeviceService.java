package com.device.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.device.app.model.Device;
import com.device.app.repository.DeviceRepositoy;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;


@Service
public class DeviceService {   
    
    @Autowired
    private DeviceRepositoy deviceRepository;  

    public static UserAgentStringParser parser = UADetectorServiceFactory.getResourceModuleParser();
 
    public Device matchDevice(String userAgentString) {
    	if(userAgentString == null)
    		return null;
    	
    	ReadableUserAgent agent = parser.parse(userAgentString);    
        String browserName =  agent.getName();
        String browserVersion = agent.getVersionNumber().toVersionString();   
        net.sf.uadetector.OperatingSystem os = agent.getOperatingSystem();
        String osName = os.getName();
        String  osVersion = os.getVersionNumber().toVersionString();
       
        Device device =  deviceRepository.findByOsNameAndOsVersionAndBrowserNameAndBrowserVersion
        		                          (osName,osVersion,browserName,browserVersion);       
        
        if (device != null) {          
            device.setHitCount(device.getHitCount() + 1);
        } else {           
            device = new Device();           
            device.setOsName(osName);
            device.setOsVersion(osVersion);
            device.setBrowserName(browserName);
            device.setBrowserVersion(browserVersion);
            device.setHitCount(1);
        }     
      
        device = deviceRepository.save(device);        
        return device;
    }

    public Device getDeviceById(String deviceId) { 
    	if(deviceId == null)
    		return null;
       return deviceRepository.findByDeviceId(Integer.valueOf(deviceId));
          
    }
    
    public  List<Device> getByOsName(String osName) {
        return deviceRepository.findByosName(osName);
     }    
    
    public boolean deleteDevice(String deviceId) {    	
    	if(deviceId == null)
    		return false;    	
    	deviceRepository.deleteById(Integer.valueOf(deviceId));
    	if(getDeviceById(deviceId)== null)
    	  return true;	
    	else
    	  return false;
    }
}
