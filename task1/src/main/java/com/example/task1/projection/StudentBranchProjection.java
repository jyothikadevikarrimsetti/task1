package com.example.task1.projection;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface StudentBranchProjection {
    Integer getStudentId();
    String getStudentName();
    String getMobileNumber();
    Integer getBranchId();
    String getBranchName();
    Integer getFacultyId();
    String getFacultyName();
    String getFacultyMobile();
    Integer getDepartmentId();
    String getDepartmentName();
    String getHodName();
    Long getCounts();
    String getFacultySubject();
}


