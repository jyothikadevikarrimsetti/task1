package com.example.task1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

import java.util.Arrays;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;
    private String departmentName;
    private String hodName;

    public byte[] getHodImage() {
        return hodImage;
    }

    public void setHodImage(byte[] hodImage) {
        this.hodImage = hodImage;
    }

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] hodImage;

    @ManyToOne
    @JoinColumn(name ="branch_id")
    private Branch branch;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Departments{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", hodName='" + hodName + '\'' +
                ", hodImage=" + Arrays.toString(hodImage) +
                ", branch=" + branch +
                '}';
    }
}
