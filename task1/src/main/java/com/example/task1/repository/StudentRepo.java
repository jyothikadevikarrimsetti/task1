package com.example.task1.repository;

import com.example.task1.model.Students;
import com.example.task1.projection.StudentBranchProjection;
import com.example.task1.projection.StudentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Students,Integer> {
    @Query(value = "SELECT student_name,branch_name FROM students join branch on students.branch_id = branch.branch_id WHERE student_id = :id", nativeQuery = true)
    StudentBranchProjection findStudentBranch(@Param("id") int id);

    @Query(value = "SELECT student_name,branch_name FROM students join branch on students.branch_id = branch.branch_id ", nativeQuery = true)
    <T> List<T> findStudentBranch(Class<T> type);

    @Query(value = "SELECT * FROM students join branch on students.branch_id = branch.branch_id join departments on departments.branch_id = students.branch_id",nativeQuery = true)
    List<StudentBranchProjection> findAllTables();

    @Modifying
    @Query(value = "update students set student_marks = :marks where student_id = :id",nativeQuery = true)
    int setStudentMarks(@Param("marks") Double marks , @Param("id") int id);

    @Query(value = "select * from students as s join branch as b on s.branch_id = b.branch_id join faculty as f on b.branch_id = f.branch_id join departments as d on b.branch_id = d.branch_id",nativeQuery = true)
    List<StudentBranchProjection> findTotalDetails();

    @Query(value = "select d.department_name,s.student_name from students as s join departments as d on s.branch_id = d.branch_id where department_name=:name",nativeQuery = true)
    List<StudentBranchProjection> findSpecificBranch(@Param("name") String name);

    @Query(value = "select f.faculty_name,b.branch_name from faculty as f join branch as b on f.branch_id = b.branch_id where b.branch_name = :name",nativeQuery = true)
    List<StudentBranchProjection> findFacultyBranch(@Param("name") String name);

    @Query(value = "SELECT AVG(s.student_marks) AS average, b.branch_name FROM students AS s JOIN branch AS b ON s.branch_id = b.branch_id WHERE b.branch_name = :name GROUP BY b.branch_name",nativeQuery = true)
    List<StudentBranchProjection> findAvgMarks(@Param("name") String name);

    @Query(value = "select b.branch_name,count(s.student_name) as total from students as s join branch as b on s.branch_id = b.branch_id group by b. branch_name",nativeQuery = true)
    List<StudentBranchProjection> totalStudentsBranch(@Param("name") String name);

    @Query(value = "select s.student_name,f.faculty_name from students as s join faculty as f on s.branch_id = f.branch_id where f.faculty_name=:name",nativeQuery = true)
    List<StudentBranchProjection> subFaculty(@Param("name") String name);

    @Query(value = "select b.branch_name,d.department_name from students as s join branch as b on s.branch_id = b.branch_id join departments as d on d.branch_id = s.branch_id where s.student_id=8",nativeQuery = true)
    List<StudentBranchProjection> branchDetails(@Param("name") String name);


}
