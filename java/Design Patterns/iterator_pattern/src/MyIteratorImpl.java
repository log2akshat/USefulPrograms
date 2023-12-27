import java.util.List;

public class MyIteratorImpl implements MyIterator {
    
    private List<Employee> empList;
    private int length;
    private int position = 0;
    
    public MyIteratorImpl(List<Employee> empList) {
        this.empList = empList;
        this.length = empList.size();
    }
    
    @Override
    public boolean hasNext() {
        if (position >= length) {
            return false;
        }
        return true;
    }
    
    @Override
    public Object next() {
        Employee employee = empList.get(position);
        position += 1;
        return employee;
    }
    
}
