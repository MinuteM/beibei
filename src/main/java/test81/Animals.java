package test81;

abstract class Animals {

    private char gender;

    private int age;

    protected String color;

    private int animalCount;

    public Animals(char gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public abstract void eat();

}