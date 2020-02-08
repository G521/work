package Annotation;

@sexTable(table_name = "school")
public class table {
    @sxtField(sname = "name",type = "varchar",length = 3)
    private String name;
    @sxtField(sname = "index",type = "int",length = 10)
    private String index;
    @sxtField(sname = "age",type = "int",length = 3)
    private int age;
    public table(){

    }
}
