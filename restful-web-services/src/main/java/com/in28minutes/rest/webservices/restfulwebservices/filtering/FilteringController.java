package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    private final FilteringManager filteringManager;

    @Autowired
    public FilteringController(FilteringManager filteringManager) {
        this.filteringManager = filteringManager;
    }

    @GetMapping(path = "/filtering") //field2
    public MappingJacksonValue filtering() {
        //dynamic filtering
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return this.filteringManager.dynamicFilter(someBean, "field1", "field3");
    }

    @GetMapping(path = "/filtering-list")
    public MappingJacksonValue filteringList() {

        List<SomeBean> someBean =
                new ArrayList<>(Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6")));

        return this.filteringManager.dynamicFilter(someBean, "field2", "field3");

    }
}
