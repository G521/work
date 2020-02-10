package lesson.banding;

import java.beans.PropertyChangeSupport;

public class Stu {
    private String name;
    private int age;
    public PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        changeSupport.firePropertyChange("setName_Pro",this.name,name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        changeSupport.firePropertyChange("setAge_Pro",this.age,age);
        this.age = age;


    }
}
