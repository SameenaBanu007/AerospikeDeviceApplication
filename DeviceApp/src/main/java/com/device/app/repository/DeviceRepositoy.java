package com.device.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.device.app.model.Device;

@Repository
public interface DeviceRepositoy extends JpaRepository<Device, Integer> {
	
    List<Device> findByosName(String osName);
    
    Device findByDeviceId(Integer deviceId);    
    
    Device findByOsNameAndOsVersionAndBrowserNameAndBrowserVersion
            (String osName, String osVersion,String browserName,String browserVersion);

}
	