package utils;

public class APIPayloadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayload="{\\n\" +\n" +
                "        \"  \\\"emp_firstname\\\": \\\"Aaliyah\\\",\\n\" +\n" +
                "        \"  \\\"emp_lastname\\\": \\\"Smith\\\",\\n\" +\n" +
                "        \"  \\\"emp_middle_name\\\": \\\"Andrea\\\",\\n\" +\n" +
                "        \"  \\\"emp_gender\\\": \\\"F\\\",\\n\" +\n" +
                "        \"  \\\"emp_birthday\\\": \\\"1989-09-11\\\",\\n\" +\n" +
                "        \"  \\\"emp_status\\\": \\\"Employee\\\",\\n\" +\n" +
                "        \"  \\\"emp_job_title\\\": \\\"API Tester\\\"\\n\" +\n" +
                "        \"}";
        return createEmployeePayload;
    }
}
