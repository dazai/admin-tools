package tn.monjislim.office.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.monjislim.office.dto.GradeDto;
import tn.monjislim.office.entities.Grade;
import tn.monjislim.office.models.RestResponse;
import tn.monjislim.office.services.IGradeService;

@RestController
@RequestMapping("/class")
public class GradeController {

    @Autowired
    private IGradeService iGradeService;

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(200).body(iGradeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.status(200).body(iGradeService.findById(id));
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<?> findByLeve(@PathVariable Integer level) {
        return ResponseEntity.ok(iGradeService.findByLevel(level));
    }

    @PostMapping("")
    public ResponseEntity<?> addGrade(@RequestBody GradeDto gradeDto) {
        Grade grade = new Grade();
        grade.setId(gradeDto.getLevel() + "أ" + gradeDto.getSubClass());
        grade.setLevel(gradeDto.getLevel());
        grade.setSubClass(gradeDto.getSubClass());
        iGradeService.addGrade(grade);
        return ResponseEntity.status(200).body(new RestResponse(true, "Grade created successfully"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable String id) {
        iGradeService.deleteById(id);
        return ResponseEntity.ok(new RestResponse(true, "Grade deleted successfully"));
    }

}
