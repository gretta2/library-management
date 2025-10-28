package org.example.LAB3;

public class Member {
    private int id;
    private String name;
    private String type;

    public Member() {}

    public Member(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Member(int i, String alice) {
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Type: " + type;
    }
}