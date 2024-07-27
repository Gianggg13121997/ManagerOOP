package Manager;
import object.School;
import java.util.ArrayList;

public class SchoolManager  implements IManager<School>{
    ArrayList<School> schools = new ArrayList<>();
    @Override
    public void add(School school) {
        schools.add(school);

    }

    @Override
    public void remove(int id) {
        int index = findById(id);
        schools.remove(index);

    }

    @Override
    public int findById(int id) {
       for(int i = 0; i < schools.size(); i++){
           if(schools.get(i).getId() == id){
               return i;
           }
       }
       return -1;
    }

    @Override
    public void edit(int id, School school) {
        int index = findById(id);
        schools.set(index, school);

    }

    @Override
    public ArrayList<School> findAll() {
        return new ArrayList<>(schools);
    }
}
