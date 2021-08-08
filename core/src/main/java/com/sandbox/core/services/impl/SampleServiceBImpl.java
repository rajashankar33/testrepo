package com.sandbox.core.services.impl;

import com.sandbox.core.services.SampleService;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.osgi.service.component.propertytypes.ServiceRanking;

@Component(service = SampleService.class,immediate = true,property = {"type=SampleServiceBImpl"})
//Option 2 Binding by using Service Ranking which has highest Ranking
//@ServiceRanking(1001)

//Option 3 Binding by using Service target via component name or Property Type
//@Component(service = SampleService.class,immediate = true,property = {"type=SampleServiceBImpl"})



public class SampleServiceBImpl implements SampleService {
    private static final Logger LOG= LoggerFactory.getLogger(SampleServiceBImpl.class);

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
        return "Inside SampleServiceBImpl";
        
    }

}
