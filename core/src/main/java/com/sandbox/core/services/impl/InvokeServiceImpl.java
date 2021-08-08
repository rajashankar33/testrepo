package com.sandbox.core.services.impl;



import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.service.component.annotations.*;

import com.sandbox.core.services.SampleService;
import com.sandbox.core.services.InvokeService;
@Component(service = InvokeService.class,immediate = true)
public class InvokeServiceImpl implements InvokeService {
    private static final Logger LOG= LoggerFactory.getLogger(InvokeServiceImpl.class);
   
    //Option 2 Binding by using Service Ranking which has highest Ranking
   // @Reference(target = "(type=DemoServiceAImpl)")
   //Option 3 Binding by using Service target via component name or Property Type
   // @Reference(target = "(component.name=com.sandbox.core.services.impl.DemoServiceAImpl)")
    //in case of sling model @OSGiService(filter = "(component.name=com.sandbox.core.services.impl.DemoServiceAImpl)")
   
    @Reference
    SampleService sampleService;
 
    @Activate
    public void activate(){
        
        LOG.info("\n ==============INSIDE ACTIVATE InvokeServiceImpl================");
        LOG.info("\n ==============INSIDE ACTIVATE after InvokeServiceImpl================"+sampleService.getMessage());
       
    }

    


}
