package Manager;

import object.Student;

import java.util.ArrayList;

public class StudentManager implements IManager<Student> {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);

    }

    @Override
    public void remove(int id) {
        int index = findById(id);
        students.remove(index);

    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void edit(int id, Student student) {
        for (Student students : students) {
            if (students.getId() == id) {
                students.setName(student.getName());
                students.setAge(student.getAge());
                students.setScore(new ArrayList<>(student.getScore()));
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên !");
    }
    public ArrayList<Student> searchByName(String partialName) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(partialName.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }
    public ArrayList<Student> searchByAge(int minage , int maxage) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getAge() >= minage && student.getAge() <= maxage) {
                result.add(student);
            }
        }return result;
    }

    @Override
    public ArrayList<Student> findAll() {
        return new ArrayList<>(students);
    }
}
