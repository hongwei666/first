package com.ghw.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


//@Scope("prototype")
@Service
public class GhwService {

    @Autowired
    @Qualifier("ms")
    People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }


    public void say() {
        people.say();
    }
}
