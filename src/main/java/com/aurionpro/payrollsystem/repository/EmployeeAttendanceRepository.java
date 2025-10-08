package com.aurionpro.payrollsystem.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aurionpro.payrollsystem.entity.attendance.Attendance;
import com.aurionpro.payrollsystem.entity.attendance.AttendanceId;

@Repository
public interface EmployeeAttendanceRepository extends JpaRepository<Attendance, AttendanceId> {

	@Query("SELECT a FROM Attendance a WHERE a.attendanceId.employeeId = :employeeId")
	List<Attendance> findByEmployeeId(Long employeeId);

	@Query("SELECT a FROM Attendance a WHERE a.attendanceId.employeeId = :employeeId AND a.attendanceId.date IN :dates")
	List<Attendance> findByEmployeeIdAndDateIn(Long employeeId, List<LocalDate> dates);
}
