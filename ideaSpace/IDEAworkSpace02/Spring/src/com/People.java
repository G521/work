package com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
    private  int id=0;
    private String name;
    private Set set;
    private List list;
    private int[] strs;
    private Map map;
    private Desk desk;

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", set=" + set +
                ", list=" + list +
                ", strs=" + Arrays.toString(strs) +
                ", map=" + map +
                ", desk=" + desk +
                '}';
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int[] getStrs() {
        return strs;
    }

    public void setStrs(int[] strs) {
        this.strs = strs;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public People(int id, String name) {
        System.out.println("0   id,name");
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("使用setid方法");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public People(String name , int id) {
        this.id = id;
        this.name = name;
    }
//    @Override
//    public String toString() {
//        return "id="+id+"  name:" +name+" set:"+set+" list:"+list+" strs:"+ Arrays.toString(strs);
//    }

}
