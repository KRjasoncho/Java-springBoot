package spring_practice.spring_practice.controller;

import org.springframework.stereotype.Controller;


@Controller
public class MemberForm {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
