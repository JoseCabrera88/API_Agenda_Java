package Controllers;

import Entities.Agenda;
import Services.AgendaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Agenda")
public class AgendaController {

    @Autowired
    AgendaServices agendaServices;

    @GetMapping
    public List<Agenda> GetAll(){
        return agendaServices.findAll();
    }

    @GetMapping(value="/{id}")
    public Agenda GetById(@PathVariable Long id){
        return agendaServices.findById(id);
    }

    @PostMapping
    public void create(@Valid @RequestBody Agenda agenda){

        agendaServices.create(agenda);
    }

    @PutMapping(value="/{id}")
    public void update (@PathVariable Long id,
                        @RequestBody Agenda agenda){
        agendaServices.update(id, agenda);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable Long id){

        agendaServices.delate(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExeption(
            MethodArgumentNotValidException ex
    ){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
