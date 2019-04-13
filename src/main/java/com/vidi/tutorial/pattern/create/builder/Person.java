package com.vidi.tutorial.pattern.create.builder;

/**
 * @author vidi
 * @date 2018-08-11
 */
public class Person {

    private BaseInfo baseInfo;
    private EducationBackground educationBackground;

    private Person() {

    }

    private Person(BaseInfo baseInfo, EducationBackground educationBackground) {
        this.baseInfo = baseInfo;
        this.educationBackground = educationBackground;
    }

    public static class Builder {

        private final BaseInfo baseInfo;
        private EducationBackground educationBackground;

        public Builder(BaseInfo baseInfo) {
            this.baseInfo = baseInfo;
        }

        public Person build() {
            return new Person(baseInfo, educationBackground);
        }

        public Builder setEducationBackground(EducationBackground educationBackground) {
            this.educationBackground = educationBackground;
            return this;
        }
    }

    public void showBaseInfo() {
        System.out.println(baseInfo);
    }

    public void showEducationBackground() {
        System.out.println(educationBackground);
    }
}
