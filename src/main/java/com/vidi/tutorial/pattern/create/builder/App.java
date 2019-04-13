package com.vidi.tutorial.pattern.create.builder;

/**
 * @author vidi
 * @date 2018-08-11
 */
public class App {
    public static void main(String[] args) {
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setAge("16");
        baseInfo.setName("Tom");
        baseInfo.setSex("man");
        EducationBackground educationBackground = new EducationBackground();
        educationBackground.setFinalDegree("Doctor");
        educationBackground.setScore("99");

        Person person = new Person.Builder(baseInfo)
                .setEducationBackground(educationBackground)
                .build();
        person.showBaseInfo();
        person.showEducationBackground();
    }
}
