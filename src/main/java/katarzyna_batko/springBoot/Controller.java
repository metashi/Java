package katarzyna_batko.springBoot;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    public static List<Student> Students = new LinkedList<Student>();
    public ClassContainer = new ClassContainer();
    public static List<Class> ClassStudent = new LinkedList<>();
    public static int studentId = 1;

    // Endpoint 1: Dodawanie studenta
    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.id = studentId;
        studentId++;
        Students.add(student);
        // Logika dodawania studenta
        return ResponseEntity.ok(student);
    }

    @GetMapping("/student/{id}")
    public Object getStudent(@PathVariable int id) {
        // Logika usuwania studenta o podanym id
        for(int i = 0; i <= Students.size(); i++)
        {
            if(Students.get(i).id == id){
                return ResponseEntity.ok(Students.get(i));
            }
        }
        return ResponseEntity.notFound();
    }

    // Endpoint 2: Usuwanie studenta
    @DeleteMapping("/student/{id}")
    public Object deleteStudent(@PathVariable int id) {
        for(int i = 0; i <= Students.size(); i++)
        {
            if(Students.get(i).id == id){
                Students.remove(i);
                return ResponseEntity.ok("Usunięto studenta o ID: " + id);
            }
        }
        // Logika usuwania studenta o podanym id
        return ResponseEntity.ok("Nie ma studenta o ID: " + id);
    }

    // Endpoint 3: Zwracanie średniej oceny lub wszystkich ocen z przedmiotu dla studenta
    @GetMapping("/student/{id}/grade")
    public ResponseEntity<String> getGrade(@PathVariable int id) {
        for(int i = 0; i <= Students.size(); i++)
        {
            if(Students.get(i).id == id){
                Students.get(i).getIloscPunktow();
                return ResponseEntity.ok("Ilosc punktow studenta o ID: " + id + "wynosi: " + Students.get(i).getIloscPunktow());
            }
        }
        // Logika zwracania średniej oceny lub wszystkich ocen z przedmiotu dla studenta o podanym id // ilsoc / max ilosc * 100%
        return ResponseEntity.ok("Nie ma studenta o ID " + id);
    }

    // Endpoint 4: Zwracanie wszystkich studentów w formie pliku CSV
//    @GetMapping(value = "/student/csv", produces = "text/csv")
//    public ResponseEntity<byte[]> getStudentsCSV() {
//        List<Student> students = Students; // Pobierz listę wszystkich studentów
//
//        // Tworzenie zawartości pliku CSV
//        String csvContent = students.stream()
//                .map(Student::toCsvString)
//                .collect(Collectors.joining("\n"));
//
//        // Konwertowanie zawartości na tablicę bajtów
//        byte[] csvBytes = csvContent.getBytes(StandardCharsets.UTF_8);
//
//        // Ustawienie nagłówków odpowiedzi
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("text/csv"));
//        headers.setContentLength(csvBytes.length);
//        headers.setContentDispositionFormData("attachment", "students.csv");
//
//        // Zwrócenie odpowiedzi HTTP z zawartością pliku CSV
//        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
//    }
    // Endpoint 5: Zwracanie wszystkich przedmiotów/grup
    @GetMapping("/course")
    public ResponseEntity<StringBuilder> getCourses() {
        for(int i = 0; i <= Groups.size(); i++)
        {
            return ResponseEntity.ok(Groups.get(i).getAllClassNames());
        }
        // Logika zwracania wszystkich przedmiotów/grup // jeden kurs moze miec wielu  studentow
      //  return ResponseEntity.ok("Nie ma grupy");
    }


    // Endpoint 6: Dodawanie nowego przedmiotu/grupy
    @PostMapping("/course")
    public ResponseEntity<String> addCourse() {
        // Logika dodawania nowego przedmiotu/grupy
        return ResponseEntity.ok("Dodano przedmiot/grupę");
    }

    // Endpoint 7: Usuwanie przedmiotu/grupy
    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {
        // Logika usuwania przedmiotu/grupy o podanym id
        return ResponseEntity.ok("Usunięto przedmiot/grupę o ID: " + id);
    }

    // Endpoint 8: Zwracanie wszystkich studentów w grupie
    @GetMapping("/course/{id}/students")
    public ResponseEntity<String> getCourseStudents(@PathVariable String id) {
        // Logika zwracania wszystkich studentów w grupie o podanym id
        return ResponseEntity.ok("Studenci w grupie o ID " + id);
    }

    // Endpoint 9: Zwracanie zapełnienia procentowego grupy
    @GetMapping("/course/{id}/fill")
    public ResponseEntity<String> getCourseFill(@PathVariable String id) {
        // Logika zwracania zapełnienia procentowego grupy o podanym id
        return ResponseEntity.ok("Zapełnienie grupy o ID " + id);
    }

    // Endpoint 10: Dodawanie oceny dla przedmiotu/grupy
    @PostMapping("/rating")
    public ResponseEntity<String> addRating() {
        // Logika dodawania oceny dla przedmiotu/grupy
        return ResponseEntity.ok("Dodano ocenę dla przedmiotu/grupy");
    }
}


