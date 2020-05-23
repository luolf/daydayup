package org.llf.sofaboot.demo.service;


import org.llf.sofaboot.demo.facade.SampleService;

public class SampleServiceImpl implements SampleService {

    @Override
    public String message() {
        return "Hello, Service slitecore";
    }
}
