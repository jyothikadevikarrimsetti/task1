package com.example.task1.projection;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class StudentProjection {
    private int studentId;

    private String studentName;

    private String mobileNumber;

    private int branchId;

    private String branchName;

    private int facultyId;

    private String facultyName;

    private String facultyMobile;

    private int departmentId;

    private String departmentName;

    private String hodName;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyMobile() {
        return facultyMobile;
    }

    public void setFacultyMobile(String facultyMobile) {
        this.facultyMobile = facultyMobile;
    }

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

//    @Override
//    public String toString() {
//        return "StudentProjection{" +
//                "studentId=" + studentId +
//                ", studentName='" + studentName + '\'' +
//                ", mobileNumber='" + mobileNumber + '\'' +
//                ", branchId=" + branchId +
//                ", branchName='" + branchName + '\'' +
//                ", facultyId=" + facultyId +
//                ", facultyName='" + facultyName + '\'' +
//                ", facultyMobile='" + facultyMobile + '\'' +
//                ", departmentId=" + departmentId +
//                ", departmentName='" + departmentName + '\'' +
//                ", hodName='" + hodName + '\'' +
//                '}';
//    }
}
