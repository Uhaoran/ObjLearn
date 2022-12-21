/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objlearn.dto;

/**
 *
 * @author WU HAORAN
 */
public class UserInfoDto {
    
     private String name;
    
    private String userId;
    
    private int age;
    

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
}
