package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160}; // original array

        int newCourse = 2170;
        int[] updatedCourses = new int[registeredCourses.length + 1];
        for(int i=0; i < registeredCourses.length; i++){
            updatedCourses[i] = registeredCourses[i]; // loop to copy elements from original array to new array
        }
        updatedCourses[registeredCourses.length] = newCourse; // add the new course number

        //print the content of the new array
        System.out.println("Content of the updatedCourse: ");
        for(int i=0; i < updatedCourses.length; i++){
            System.out.println(updatedCourses[i] + " "); //loop to write each element
        }

        //check if a values exist in the array
        int searchValue = 2079;
        int found = 0;  //if found is not set to 1 then we didn't find the searchValue
        for(int i=0; i < updatedCourses.length; i++){
            if(updatedCourses[i] == searchValue) {
                System.out.println(searchValue + " exists in the updatedCourse");
                found = 1;
                break;
            }
        }
        if(found == 0){ //searchValue is not found
            System.out.println(searchValue + " does NOT exists in the updatedCourse");
        }


    }
}
