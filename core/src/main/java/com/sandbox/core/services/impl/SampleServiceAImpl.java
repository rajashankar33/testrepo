package com.sandbox.core.services.impl;
import com.sandbox.core.services.SampleService;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Option 2 Binding by using Service Ranking which has highest Ranking
//@ServiceRanking(1000)
//Option 3 Binding by using Service target via component name or Property Type
//@Component(service = SampleService.class,immediate = true,property = {"type=SampleServiceAImpl"})

public class SampleServiceAImpl implements SampleService {
    private static final Logger LOG= LoggerFactory.getLogger(SampleServiceAImpl.class);

    @Activate
    public void activate(ComponentContext componentContext){
        LOG.info("\n ==============INSIDE ACTIVATE================");
        LOG.info("\n {} = {} ",componentContext.getBundleContext().getBundle().getBundleId(),componentContext.getBundleContext().getBundle().getSymbolicName());

    }

    @Deactivate
    public void deactivate(ComponentContext componentContext){
        LOG.info("\n ==============INSIDE DEACTIVATE================");
    }

    @Modified
    public void modified(ComponentContext componentContext){
        LOG.info("\n ==============INSIDE MODIFIED================");
    }

    @Override
    public String getMessage(){
        return "Inside SampleServiceAImpl";
    }

}
