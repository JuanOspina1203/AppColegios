package com.backend.routes;

public class Routes {
    public static final String ASSIGN_OR_UNASSIGN_BOOK = "/assign-book";
    public static final String BOOKS_ROUTE = "/book";
    public static final String STUDENTS_ROUTE = "/student";
    public static final String BOOK_ID = "/{bookId}";
    public static final String STUDENT_ID = "/{studentIdentificationNumber}";
    public static final String STUDENTS_WITH_BOOKS = "/with-book";
    public static final String GRADE_GROUPS_ROUTE = "/grade-group";
    public static final String GRADE_GROUP_ID = "/{gradeGroupId}";
    public static final String GRADE_GROUP_ALL_GROUPS_BY_SHIFT = "/all-grades-group-by-shift/{gradeGroupShift}";
    public static final String GRADE_GROUP_ALL_GROUPS_BY_CAMPUS = "/all-grades-group-by-campus/{gradeGroupCampus}";
    public static final String GRADE_GROUP_COUNT_OF_STUDENTS = "/count-of-students";
    public static final String GRADE_GROUP_ASSIGN_TEACHER = "/assign-teacher";
    public static final String TEACHERS_ROUTE = "/teacher";
    public static final String TEACHER_IDENTIFICATION_NUMBER = "/{teacherIdentificationNumber}";
    public static final String TEACHER_ALL_GRADES_ASSIGNED = "/all-grades-assigned-by-a-teacher";
    public static final String ENROLL_STUDENT_IN_GRADE_GROUP = "/enroll-student";
    public static final String DATABASES_ROUTE = "/database";
    public static final String DATABASE_EXPORT = "/export";
    public static final String DATABASE_IMPORT = "/import";
    public static final String DATABASE_FILE = "/{filename}";
    public static final String AUTH_ROUTE = "/auth";
    public static final String AUTH_LOGIN = "/login";
    public static final String AUTH_REGISTER = "/register";
    public static final String AUTH_TEACHERS_IN_CHARGE_OF_A_DIRECTOR = "/teachers";
    public static final String AUTH_FIND_DIRECTOR = "/{directorUsername}";
}