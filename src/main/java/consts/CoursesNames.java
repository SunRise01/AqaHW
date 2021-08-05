package consts;

public enum CoursesNames {
    JAVA("Java"), RUBY("Ruby");
    private String courseName;

    CoursesNames(String courseName){
        this.courseName=courseName;
    }

    public String getCourseName(){
        return courseName;
    }
}
